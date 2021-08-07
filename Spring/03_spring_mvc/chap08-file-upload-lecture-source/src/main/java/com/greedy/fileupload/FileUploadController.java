package com.greedy.fileupload;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@PostMapping("single-file")
	public String singleFileUpload(@RequestParam MultipartFile singleFile, HttpServletRequest request, Model model) {

		/* MultipartFile 타입의 변수인 매개변수로 선언하면 파일에 대한 처리를 할 수 있다. */
		String singleFileDescription = request.getParameter("singleFileDescription");
		
		/*
		 * multipart로 전송된 request에 대한 인코딩 처리를 해주어야 하는데 일반 인코딩 필터보다 구현하기 힘들다.
		 * 스프링에서 인코딩 필터를 제공한다. --> web.xml에 필터를 등록
		 */
		System.out.println("singleFile : " + singleFile);
		System.out.println("singleFileDescription : " + singleFileDescription);
		
		/* 파일을 저장할 경로 설정 */
		String root = request.getSession().getServletContext().getRealPath("resources");
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		/* 파일명 변경 처리 */
		String originFileName = singleFile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
		
		/* 파일을 저장한다. */
		try {
			
			singleFile.transferTo(new File(filePath + "\\" + saveName));
			model.addAttribute("message", "파일 업로드 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			/* 실패시 파일 삭제 */
			new File(filePath + "\\" + saveName).delete();
			model.addAttribute("message","파일 업로드 실패");
		}
		
		return "result";
		
	}
	
	@PostMapping("multi-file")
	public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles, HttpServletRequest request, Model model) {
		
		String multiFileDescription = request.getParameter("multiFileDescription");
		
		System.out.println("multiFiles : " + multiFiles);
		System.out.println("multiFileDescription : " + multiFileDescription);
		
		/* 파일을 저장할 경로 설정 */
		String root = request.getSession().getServletContext().getRealPath("resources");
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		List<Map<String,String>> files = new ArrayList<>();
		for(int i = 0; i < multiFiles.size(); i++) {
			
			/* 파일명 변경 처리 */
			String originFileName = multiFiles.get(i).getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
			
			/* 파일에 관한 정보 추출 후 보관 */
			Map<String,String> file = new HashMap<String, String>();
			file.put("orginFileName", originFileName);
			file.put("saveName", saveName);
			file.put("filePath", filePath);
			
			files.add(file);
		}
		
		/* 파일을 저장한다. */
		try {
			for(int i = 0; i < multiFiles.size(); i++) {
				
				Map<String, String> file = files.get(i);
				
				multiFiles.get(i).transferTo(new File(filePath + "\\" + file.get("saveName")));
			}
			
			model.addAttribute("message", "파일 업로드 성공");
		} catch(Exception e) {
			e.printStackTrace();
			
			/* 실패시 파일 삭제 */
			for(int i = 0; i < multiFiles.size(); i++) {
				
				Map<String, String> file = files.get(i);
				
				new File(filePath + "\\" + file.get("saveName")).delete();
			}
			
			model.addAttribute("message", "파일 업로드 실패");
			
		}
		
		return "result";
	}
	
	
}
