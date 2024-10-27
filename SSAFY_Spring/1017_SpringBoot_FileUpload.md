## SpringBoot FileUpload, Download

내가 생각하는 흐름

1. pom.xml / application.properties  설정
2. static / index.html 
   `<a href = "/singleFileUpload">` 단일 파일 업로드`</a>`
   `<a href = "/multiFileUpload">` 다중 파일 업로드`</a>`
3. webapp/WEB-INF/views 폴더 생성
4. views 폴더 안에 singleFileUploadForm.jsp와 multiFileUploadForm.jsp 생성
    ```
    singleFileUploadForm.jsp

    <form action = "/singleFileUpload" method = "post" enctype="multipart/form-data">
	<input type = "file" name = "file">
	<button>업로드</button>
    </form>

    multiFileUploadForm.jsp

    <form action = "/multiFileUpload" method = "post" enctype="multipart/form-data">
	<input type = "file" name = "file" multiple="multiple">
	<button>업로드</button>
    </form>
    ```
5. Controller 생성 (MainController / FileController)
   ```
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
			file.transferTo(new File(resource.getFile(), fileName));
			model.addAttribute("fileName", fileName);

		}
		return "/regist";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("file") MultipartFile[] files, Model model) throws IllegalStateException, IOException {
		
		if(files.length > 0) {
			List<String> fileNames = new ArrayList<>();
			for (int i = 0; i < files.length; i++) {
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
    }
6. views/regist.jsp 생성

### 1회차

`FileController` 
**"/singleFileUpload"** 요청을 PostMapping 하는 과정 중
`file.transferTo(new File(resource.getFile(), fileName));` 
에서 막혔다.
1. `Resource resource = resourceLoader.getResource("classpath:/static/img")` <br> static/img 폴더를 가져와 resource 객체를 반환
   
2. `file.transferTo(new File(resource.getFile(), fileName));` 

`resource.getFile()` 를 통해 img 폴더 경로를 반환.
`new File(resource.getFile(), fileName)` 
새로운 File 객체를  `fileName` 의 이름으로 `resource.getFile()` 경로에 저장한다.
`file.transferTo()`를 통해 업로드된 MultipartFile 형태인 file의 메타데이터들을 새로운 File 객체에 전송하여 File 객체를 완성시킨다.

### 2회차

1회차에서 틀린 부분을 조금 더 이해하기 쉽게 코드를 풀어써보았다.
```
 @PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {

		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			Resource resource = resourceLoader.getResource("classpath:/static/img");
		    // System.out.println(resource.getFile());
		    // System.out.println(file.getResource());
						
			// 새로운 File 객체인 tmpFile 을 만들고, 이 File은 fileName의 이름으로 저장되며, 경로는 resource.getFile()이다.
			File tmpFile = new File(resource.getFile(), fileName); 
			
			//업로드된 파일의 메타데이터들을 tmpFile에 전송하여 채워준다.
			file.transferTo(tmpFile);
			model.addAttribute("fileName", fileName);

		}
		return "/regist";
    }
```

**multiFileUpload**
```@PostMapping("/multiFileUpload")
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
```
regist.jsp 에서 img 출력, img의 fileName만 출력하면 되기 때문에 String 타입을 담는
ArrayList를 만들고, add 한 후에 model에 담아주었더니 잘 됐다. 뿌듯 ^^ 