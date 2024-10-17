package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	private ResourceLoader resourceLoader;

	public FileController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {

		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			System.out.println(resource.getFile());
			System.out.println(file.getResource());
						
			// 새로운 File 객체인 tmpFile 을 만들고, 이 File은 fileName의 이름으로 저장되며, 경로는 resource.getFile()이다.
			File tmpFile = new File(resource.getFile(), fileName); 
			
			//업로드된 파일의 메타데이터들을 tmpFile에 전송하여 채워준다.
			file.transferTo(tmpFile);
			model.addAttribute("fileName", fileName);

		}
		return "/regist";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("file") MultipartFile[] files, Model model) throws IllegalStateException, IOException {
		
		if(files.length > 0) {
			List<String> fileNames = new ArrayList<>();
			for (int i = files.length-1; i >= 0; i--) {
				String fileName = files[i].getOriginalFilename();
				Resource resource = resourceLoader.getResource("classpath:/static/img");
				files[i].transferTo(new File(resource.getFile(), fileName));
				fileNames.add(fileName);
			}
			model.addAttribute("fileNames", fileNames);
		}
		
		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		return "/regist";
	}
	
	@GetMapping("/download")
	public String download(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName",fileName);
		return "fileDownloadView";
	}
	
	

}
