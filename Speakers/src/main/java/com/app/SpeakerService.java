package com.app;

import java.util.List;

public interface SpeakerService {
	
	
	List<Speaker> getAllSpeaker();
	
	List<Speaker> getAllSortedSpeakers(String field, String order)throws SpeakerException;
	
	Speaker addSpeaker(Speaker speaker, String key);

}
