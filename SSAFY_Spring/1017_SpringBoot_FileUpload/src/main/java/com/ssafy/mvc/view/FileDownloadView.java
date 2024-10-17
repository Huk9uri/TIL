package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {
	private ResourceLoader resourceLoader;

	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = (String) model.get("fileName");
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName);
		///// 사전 준비
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1"); // 한글 같은게 다른 브라우저에게 ㄲ ㅐ질 수 있기에 안전하게 처리
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";"); // 약속 임
		response.setHeader("Content-Transfer-Encoding", "binary");

		///////////////////////////////////////////////////

		try (FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
			FileCopyUtils.copy(fis, os);

		}
	}

}
