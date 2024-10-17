package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	@GetMapping("/singleFileUpload")
	public String singleFileUploadForm() {
		return "/singleFileUploadForm";
	}
	
	@GetMapping("/multiFileUpload")
	public String multiFileUploadForm() {
		return "/multiFileUploadForm";
	}
	
}
