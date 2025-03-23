package edu.springboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	
	@RequestMapping(value="/file/upload01.do", method = RequestMethod.GET)
	public String upload01() {
		return "upload/file01";
	}
	
	/*
	 spring framework에서는 multipart resolver 객체를 사용하여 파일을 업로드 합니다.
	 이때 업로드되는 위치는 우리가 알수 없어 현재 업로드된 파일을 얻어와 지정 경로로 옮기게 됩니다. 
	 */
	@RequestMapping(value="/file/upload01.do",method=RequestMethod.POST)
	public String upload01(MultipartFile file01,HttpServletRequest request
			,String title,String content) throws IllegalStateException, IOException {
		
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		
		
		/*
		 <절대경로 사용시 문제점>
		 1.개발도구를 사용하여 업로드를 진행시 업로드 위치를 워크스페이스의
		    프로젝트 절대경로로 잡게 되면 이미지등 업로드 파일이 실시간 반영 되지 않는다.
		  (복제하여 사용하는 가상의 위치까지 업로드 파일을 복사하는 시간차 때문에)
		 2.개발서버의 업로드 위치와 운영서버의 업로드 위치가 다르게 되면 배포마다 경로를
		    수정하여 반영해야하는 문제가 발생한다.
		 
		 <상대경로 사용시 문제점>
		 1.개발서버 작업시 개발도구가 복제하여 사용하는 프로젝트 위치로 바로 업로드 되기 때문에
		     실제 워크스페이스의 업로드 위치로는 파일이 저장되지 않는다.(별로도 파일을 복사하여
		     워크스페이스에 추가하는 과정이 발생한다.)
		 */
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		//String path = "D:\\ohm\\springworkspace\\springBoard\\src\\main\\webapp\\resources\\upload";
		System.out.println("upload path :: "+path);
		
		File dir = new File(path);
		//dir.exists() true이면 경로 있음
		//dir.exists() false이면 경로 없음
		
		if(!dir.exists()) { //경로가 없을시 해당 폴더 생성
			dir.mkdirs(); //없은 상위 폴더부터 전부 생성
		}
		
		if(!file01.getOriginalFilename().isEmpty()){
			
			UUID uuid = UUID.randomUUID();
			
			String fileRealName = uuid.toString()+file01.getOriginalFilename();
			
			file01.transferTo(new File(path,fileRealName));
		}
		
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/file/upload02.do",method=RequestMethod.GET)
	public String upload02() {
		return "upload/file02";
	}
	
	@RequestMapping(value="/file/upload02.do",method=RequestMethod.POST)
	public String upload02(MultipartFile file01
			,MultipartFile file02,MultipartFile file03
			,HttpServletRequest request) throws IllegalStateException, IOException {
	
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println("upload path ->"+path);
		
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		if(!file01.getOriginalFilename().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String fileRealPath = uuid+file01.getOriginalFilename();
			
			file01.transferTo(new File(path,fileRealPath));
		}
		
		if(!file02.getOriginalFilename().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String fileRealPath = uuid+file02.getOriginalFilename();
			
			file02.transferTo(new File(path,fileRealPath));
		}
		
		if(!file03.getOriginalFilename().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String fileRealPath = uuid+file03.getOriginalFilename();
			
			file03.transferTo(new File(path,fileRealPath));
		}
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/file/upload03.do",method=RequestMethod.POST)
	public String uploade03(@RequestParam(value="multiFile")List<MultipartFile> multiFile
							,HttpServletRequest request) throws IllegalStateException, IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println("upload path ->"+path);
		
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		for(MultipartFile file : multiFile) {
			if(!file.getOriginalFilename().isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String fileRealName = uuid.toString()+file.getOriginalFilename();
				
				file.transferTo(new File(path,fileRealName));
			}
		}
		
		return "redirect:/";
	}
	
	
	
}






