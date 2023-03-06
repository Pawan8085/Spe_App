package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class SpeakerServceImpl implements SpeakerService{
	
	private SpeakerRepository speakerRepository;
	
	@Autowired
	public SpeakerServceImpl(SpeakerRepository speakerRepository) {
		this.speakerRepository = speakerRepository;
	}

	@Override
	public List<Speaker> getAllSpeaker() {
		
		return speakerRepository.findAll();
	}

	@Override
	public List<Speaker> getAllSortedSpeakers(String field, String order)throws SpeakerException {
		
		if(field.equals("name") || field.equals("price")) {
			
			if(order.equals("asc") || order.equals("desc")) {
				return speakerRepository.findAll(order.equals("asc")? Sort.by(field).ascending() : Sort.by(field).descending());
			}
			throw new SpeakerException("Invalid order!");
		}
		throw new SpeakerException("Invalid field!");
		
		
		
		
	}

	@Override
	public Speaker addSpeaker(Speaker speaker, String key) {
		Speaker savedSpeaker = null;
		if(key.equals("tribitstrombox")) {
			savedSpeaker= speakerRepository.save(speaker);
		}
		
		return savedSpeaker;
		
	}

}
