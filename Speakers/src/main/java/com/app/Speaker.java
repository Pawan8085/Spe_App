package com.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer speakerId;
	private String name;
	private String specs;
	private String image;
	private Integer price;

}
