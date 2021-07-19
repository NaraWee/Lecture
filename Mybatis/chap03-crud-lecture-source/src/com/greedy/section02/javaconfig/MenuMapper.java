package com.greedy.section02.javaconfig;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {
	@Results(id="menuResultMap", value= {
			@Result(id = true, property = "code", column = "MENU_CODE"),
			@Result(property = "name", column = "MENU_NAME"),
			@Result(property = "price", column = "MENU_PRICE"),
			@Result(property = "categoryCode", column = "CATEGORY_CODE"),
			@Result(property = "orderableStatus", column = "ORDERABLE_STATUS"),
	})
	@Select("SELECT\r\n"
		  + "       A.MENU_CODE\r\n"
		  + "     , A.MENU_NAME\r\n"
		  + "     , A.MENU_PRICE\r\n"
		  + "     , A.CATEGORY_CODE\r\n"
		  + "     , A.ORDERABLE_STATUS\r\n"
		  + "  FROM TBL_MENU A\r\n"
	      + " WHERE A.ORDERABLE_STATUS = 'Y'\r\n"
		  + " ORDER BY A.MENU_CODE")
	List<MenuDTO> selectAllMenu();
	
	@Select("SELECT\r\n"
		  + "       A.MENU_CODE\r\n"
		  + "     , A.MENU_NAME\r\n"
		  + "     , A.MENU_PRICE\r\n"
		  + "     , A.CATEGORY_CODE\r\n"
		  + "     , A.ORDERABLE_STATUS\r\n"
		  + "  FROM TBL_MENU A\r\n"
		  + " WHERE A.ORDERABLE_STATUS = 'Y'\r\n"
		  + "   AND A.MENU_CODE = #{ code }")
	@ResultMap("menuResultMap") 	// 위에 사용한 resultMap을 재사용할 수 있다.
	MenuDTO selectMenuByCode(int code);
	
	@Insert("INSERT\r\n"
		  + "  INTO TBL_MENU A\r\n"
		  + "( \r\n"
		  + "  A.MENU_CODE\r\n"
		  + ", A.MENU_NAME\r\n"
		  + ", A.MENU_PRICE\r\n"
		  + ", A.CATEGORY_CODE\r\n"
		  + ", A.ORDERABLE_STATUS\r\n"
		  + ")\r\n"
		  + "VALUES\r\n"
		  + "(\r\n"
		  + "  SEQ_MENU_CODE.NEXTVAL\r\n"
		  + ", #{ name }\r\n"
		  + ", #{ price }\r\n"
		  + ", #{ categoryCode }\r\n"
		  + ", 'Y'\r\n"
		  + ")")
	int registMenu(MenuDTO menu);
	
	@Update("UPDATE TBL_MENU A\r\n"
		  + "	SET A.MENU_NAME = #{ name }\r\n"
		  + "	  , A.MENU_PRICE = #{ price }\r\n"
		  + "	  , A.CATEGORY_CODE = #{ categoryCode }\r\n"
		  + "	  , A.ORDERABLE_STATUS = 'Y'\r\n"
		  + " WHERE A.MENU_CODE = #{ code }")
	int modifyMenu(MenuDTO menu);
	
	@Delete("DELETE\r\n"
		  + "  FROM TBL_MENU A\r\n"
		  + " WHERE A.MENU_CODE = #{ code }")
	int deleteMenu(MenuDTO menu);

}
