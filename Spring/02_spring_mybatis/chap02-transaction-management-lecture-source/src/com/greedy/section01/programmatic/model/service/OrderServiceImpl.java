package com.greedy.section01.programmatic.model.service;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.greedy.section01.programmatic.model.dao.OrderMapper;
import com.greedy.section01.programmatic.model.dto.OrderDTO;
import com.greedy.section01.programmatic.model.dto.OrderMenuDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private SqlSessionTemplate sqlSession;
	
	private DataSourceTransactionManager transactionManager;
	
	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession, DataSourceTransactionManager transactionManager) {
		this.sqlSession = sqlSession;
		this.transactionManager = transactionManager;
	}
	
	@Override
	public int registOrder(OrderDTO order) {
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		int orderResult = orderMapper.insertOrder(order);
		
		List<OrderMenuDTO> orderMenuList = order.getMenuList();
		int orderMenuResult = 0;
		
		for(OrderMenuDTO orderMenu : orderMenuList) {
			orderMenuResult += orderMapper.insertOrderMenu(orderMenu);
		}
		
		int result = 0;
		if(orderResult > 0 && orderMenuResult == orderMenuList.size()) {
			result = 1;
			
			sqlSession.commit();
		}
		
		return result;
	}

	@Override
	public int registOrder2(OrderDTO order) {

		/*
		 * 트랜잭션을 처리하는 트랜잭션 매니저를 bean에 등록
		 */
		
		/* 트랜잭션에 대한 설정 정보를 담고 있는 객체 */
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		
		/*
		 * 전파행위옵션
		 * REQUIRED : 진행중인 트랜잭션이 있으면 현재 메소드를 그 트랜잭션에서 실행하되 그렇지 않은 경우 새 트랜잭션을 신작해서 실행한다.
		 * REQUIRED_NEW : 항상 새 트랜잭션을 시작해 메소드를 실행하고 진행중인 트랜잭션이 있으면 잠시 중단시킨다.
		 * SUPPORTS : 진행중이 트랜잭션이 있으면 현재 메소드를 그 트랜잭션 내에서 실행하되, 그렇지 않을 경우 트랜잭션 없이 실행된다.
		 * NOT_SUPPORTED : 트랜잭션 없이 현재 메소드를 실행하고 진행중인 트랜잭션이 있으면 잠시 중단한다.
		 * MANDATORY : 반드시 트랜잭션을 걸로 현재 메소드를 실행하되 진행중인 트랜잭션이 없으면 예외를 던진다.
		 * NEVER : 반드시 트랜잭션 없이 현재 메소드를 실행하되 진행중인 트랜잭션이 있으면 예외를 던진다.
		 * NESTED : 진행중인 트랜잭션이 있으면 현재 메소드를 이 틀랜잭션의 중첩트랜잭션 내에서 실행한다. 진행중인 트랜잭션이 없으면 새 트랜잭션을 실행한다.
		 *          배치 실행 도중 처리할 업무가 백만개라고 하면 10만개씩 끊어서 커밋하는 경우 중간에 잘못되어도 중첩트랜잭션을 롤백하면 전체가 아닌
		 *          10만개만 롤백된다. 세이브포인트를 이용하는 방식이다. 따라서 세이브포인트를 지원하지 않는 경우 사용 불가능한다.
		 */
		
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		/* 격리 레벨(동시성 고려)
		 * 
		 * DEFAULT : DB의 기본 격리 수준을 사용한다. 대다수는 READ_COMMITTED가 기본 격리 수준이다.
		 * READ_UNCOMMITED : 다른 트랜잭션이 아직 커밋하지 않은 값을 한 트랜잭션을 읽을 수 있다.
		 *                   따라서 오염된 값을 읽거나, 재현 불가능한 읽기, 허상 읽기 등의 문제가 발생할 수 있다.
		 * READ_COMITTED : 트랜잭션이 다른 트랜잭션에서 커밋한 값만 읽을 수 있따.
		 *                 오염된 값읽기 문제는 해경되지만 재현 불가능한 읽기 및 허상읽기는 여전히 발생한다.
		 * REPEATABLE_READ : 트랜잭션이 어떤 필드를 여러변 읽어도 동일한 값을 읽도록 보장한다.
		 *                   트랜잭션이 지속되는 동안에는 다른 트랜잭션이 해당 필드를 변경할 수 없다.
		 *                   오염된 값 읽기, 재현불가능한 읽기는 해결되지만 허상읽기는 여전히 발생할 수 있다.
		 * SERIALIZABLE : 트랜잭션이 테이블을 여러번 읽어도 정확히 동일한 로우를 읽도록 보장한다. 트랜잭션이 지속되는 동안에는
		 *                다른 트랜잭션이 해당 테이블에 삽입, 수정, 삭제를 할 수 없다.
		 *                동시성 문제는 모두 해소되지만 성능은 현저하게 떨어진다.
		 *                
		 * 오염된 값 : 하나의 트랜잭션이 데이터를 변경 후 잠시 기다리는 동안 다른 트랜잭션이 데이터를 읽게되면, 격리레벨이
		 *         READ_UNCOMMITTED인 경우 아직 변경 후 커밋하지 않은 재고값을 그대로 읽게 된다.
		 *         그러나 처음 트랜잭션이 데이터를 롤백하게 되면 다른 트랜잭션이 읽은 값은 더이상 유효하지 않은 일시적인 값이된다.
		 *         이것이 오염된 값이라 한다.
		 * 재현 불가능한 읽기 : 처음 트랜잭션이 데이터를 수정하면 수정이 되고 아직 커밋되지 않은 로우에 수정 잠금을 걸어둔 상태이다.
		 *               결국 다른 트랜잭션은 이 트랜잭션이 커밋 혹은 롤백되고 수정잠금이 풀릴때까지 기다렸다가 읽을 수 밖에 없게 된다.
		 *               하지만 다른 로우에 대해서는 또 다른 트랜잭션이 데이터를 수정하고 커밋을 하게 되면 가장 처음 동작한 트랜잭션이 데이터를 커밋하고 다시 조회를 한 경우
		 *               처음 읽은 그 값이 아니게 된다.
		 *               이것이 재현 불가능한 읽기이다.
		 * 허상 읽기 : 처음 트랜잭션이 테이블에 여러 로우를 읽은 후 이후 트랜잭션이 같은 테이블의 로우를 추가하는 경우
		 *         처음 트랜잭션이 같은 테이블을 다시 읽으면 자신이 처음 읽었을 떄와 달리 새로 추가된 로우가 있을 것이다.
		 *         이것을 허상읽기라고 한다. (재현 불가능한 읽기와 유사하지만 허상 읽기는 여러 로우가 추가되는 경우를 말한다.)
		 */
		
		def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
		
		/* 트랜잭션에 대한 실행을 제어하거나, 트랜잭션 상태들을 조회할 수 있다. */
		TransactionStatus status = transactionManager.getTransaction(def);
		
		/* 트랜잭션을 수동으로 할 수 있도록 설정한다. */
		try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		int orderResult = orderMapper.insertOrder(order);
		
		List<OrderMenuDTO> orderMenuList = order.getMenuList();
		int orderMenuResult = 0;
		for(OrderMenuDTO orderMenu : orderMenuList) {
			orderMenuResult += orderMapper.insertOrderMenu(orderMenu);
		}
		
		int result = 0;
		if(orderResult > 0 && orderMenuResult == orderMenuList.size()) {
			result = 1;
			transactionManager.commit(status);
		} else {
			transactionManager.rollback(status);
		}
		
		return result;
	}

}
