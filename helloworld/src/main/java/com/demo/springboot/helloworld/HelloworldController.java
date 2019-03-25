package com.demo.springboot.helloworld;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloworldController {

	@Autowired
	Helloworldcomponent hellocomponent;
	
	
	@GetMapping("/hello")
	public String getHelloworld() {
		
		return "Simple Spring Boot Application";
	}
	
	@GetMapping("/images")
	public List<Image> getImages() {
		List<Image> images = Arrays.asList(
			new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
			new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
			new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
		return images;
	}
	
	
	//Youtube data api key AIzaSyCvTcvu7I6qbOoIVwWmUxbqjYn50siLFYs
	@GetMapping("/reqrestcall")
	public String getExternalRestCall() {
		
		String outputcall;
		
		outputcall=hellocomponent.getExternalCall();
		System.out.println("Calling the get External rest call");
		
		return "External REST API call Using feign client" + outputcall;
	}
	
}
