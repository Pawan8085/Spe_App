package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakerController {
	
	private SpeakerService speakerService;
	
	@Autowired
	public SpeakerController(SpeakerService speakerService) {
		this.speakerService=speakerService;
	}
	
	@GetMapping
	public String hello() {
		return "hello there!";
	}

	@PostMapping("/add/{key}")
	public ResponseEntity<Speaker> addProductHandler(@RequestBody Speaker speaker, @PathVariable String key){
		
		Speaker speaker_ = speakerService.addSpeaker(speaker, key);
		
		return new ResponseEntity<Speaker>(speaker_, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/speakers")
	public ResponseEntity<List<Speaker>> getAllSpeakersHandler(){
		List<Speaker> speakers = speakerService.getAllSpeaker();
		
		return new ResponseEntity<List<Speaker>>(speakers, HttpStatus.OK);
	}
	
	@GetMapping("/speakers/{field}")
	public ResponseEntity<List<Speaker>> getAllSortedSpeakersHandler(@PathVariable String field, @RequestParam(value = "order") String order){
		List<Speaker> speakers = speakerService.getAllSortedSpeakers(field, order);
		
		return new ResponseEntity<List<Speaker>>(speakers, HttpStatus.OK);
	}
	
	
	
	
}
