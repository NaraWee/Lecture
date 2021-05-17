package com.greedy.section02.commonsio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class CommonsFileUploadServlet
 */
@WebServlet("/commons/single")
public class CommonsFileUploadServlet extends HttpServlet {
	
	private String rootLocation;
	private int maxFileSize;
	private String encodingType;

	@Override
	public void init() throws ServletException {
		
		ServletContext context = getServletContext();
		// web.xml context-param 속성에 지정한 값들은 getInitParameter() 메소드를 이용해서 꺼내어 쓸 수 있다.
		rootLocation = context.getInitParameter("upload-location");
		maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
		encodingType = context.getInitParameter("encoding-type");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(ServletFileUpload.isMultipartContent(request)) {
			
			System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);
			
			// C:\\upload-files/commons
			String fileUploadDirectory = rootLocation + "/commons";		
		
			File directory = new File(fileUploadDirectory);
			
			// exists() : 파일이 있는지 여부를 판단해서 있으면 true, 없으면 false
			// 파일 지정경로가 존재하지 않는 경우 디렉토리를 생성하자
			if(!directory.exists()) {
				/* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하라는 의미로 mkdirs를 이용 */
				System.out.println("폴더 생성 : " + directory.mkdirs());
			}
			
			/*
			 * 최종적으로 request를 parasing하고 파일을 저장한 뒤 필요한 내용을 담을 리스트와 맵이다.
			 * 파일에 대한 정보는 리스트(fileList)에 다른 파라미터의 정보는 모두 맵에 담을 것이다.
			 */
			Map<String,String> parameter = new HashMap<>();
			List<Map<String,String>> fileList = new ArrayList<>();
			
			/* 파일을 업로드 할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스 */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
			/* 서블릿에서 기본 재공하는 인스턴스 말고 꼭 commons fileUpload 라이브러리에 있는 클래스로 임포트 해야 한다. */
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
			
			
			
			try {
				
				/* request를 파싱하여 데이터 하나하나를 FileItem 인스턴스로 반환한다. */
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					// isFormField=false form태그 타입 file, isFormField=true form태그 타입 일반
					/* 폼 데이터는 isFormField 속성이 true이고, 파일은 isFormField 속성이 false */
					System.out.println(item);
				}
				
				for(int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);	// 참고, 배열은 배열명[index]로 리스트는 인덱스를 get()메소드로 찾아온다.
					
					if(!item.isFormField()) {
						// 파일 데이터인 경우
						if(item.getSize() > 0) {
							/*
							 * 파일의 사이즈가 0보다 커야 전송된 파일이 있다는 의미
							 * 전송된 파일이 있는 경우에만 처리하고, 0인 경우에는 무시하도록 로직을 작성하겠다.
							 */
							String filedName = item.getFieldName();
							String originFileName = item.getName();
							
							/* 
							 * 업로드되는 파일명을 변경 작업
							 * 1. 동일한 파일명이 들어왔을 때를 대비
							 * 2. 특수문자 또는 입력받기 힘든 문자를 받았을 때를 대비
							 */
							
//							System.out.println("fileName : " + filedName);
//							System.out.println("originFileName : " + originFileName);
							
							// 잠만보.jpg
							int dot = originFileName.lastIndexOf(".");
							System.out.println("dot : " + dot);
							String ext = originFileName.substring(dot);  // -> .jpg
							System.out.println("ext : " + ext);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							/* 저장할 파일 정보를 담은 인스턴스를 생성하고 */
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							// 삭제테스트를 위해서 강제로 에러를 발생 시킴
//							String str = "";
//							System.out.println(str.charAt(1));
							
							/* 저장한다. */
							item.write(storeFile);
							
							/* 필요한 정보를 Map에 담는다. */
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fileName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("saveFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							fileList.add(fileMap);
						}
						
					} else {
						// 폼 데이터인 경우
						/*
						 * 전송된 폼의 name은 getFieldName()으로 받아오고,
						 * 해당 필드의 value는 getString()으로 받아온다.
						 * 인코딩 설정을 하더라도 전송되는 파라미터는 ISO-8859-1로 처리된다.
						 * 별도로 ISO-8859-1로 해서된 한글을 UTF-8로 변경해 주어야 한다.
						 */
//						parameter.put(item.getFieldName(), item.getString());
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						
					}
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				
			} catch(Exception e) {
				/* 어떤 종류의 Exception이 발생해서 실패를 하더라도 파일을 삭제해야 한다. */
				int cnt = 0;
				for(int i = 0; i < fileList.size(); i++) {
					Map<String,String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();
				
					if(isDeleted) {
						cnt++;
					}
				}
				
				if(cnt == fileList.size()) {
					System.out.println("업로드에 실패한 모든 사진 삭제완료!");
				} else {
					e.printStackTrace();
				}
				
			}
		}
	}

}
