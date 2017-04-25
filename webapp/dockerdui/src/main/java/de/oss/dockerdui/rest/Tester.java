package de.oss.dockerdui.rest;

import java.util.ArrayList;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import de.oss.dockerdui.domain.Container;

public class Tester {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String fooResourceUrl = "http://localhost:2375/v1.28/containers/json";
		
		String strlibrary = restTemplate.getForObject(fooResourceUrl, String.class);
		System.out.println(strlibrary);

		Container [] library = restTemplate.getForObject(fooResourceUrl, Container[].class);

		for (int i = 0; i < library.length; i++) {

			System.out.println(library[i].getNames());	

			
			
		}
		// ActiveContainers library = restTemplate.getForObject(fooResourceUrl,
		// ActiveContainers.class);
		// System.out.println(library.getRunningContainers());
	}

}
