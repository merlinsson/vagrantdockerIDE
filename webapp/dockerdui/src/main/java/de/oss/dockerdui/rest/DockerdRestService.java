package de.oss.dockerdui.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import de.oss.dockerdui.domain.Container;

/**
 * Rest-Service for requesting information from the docker service.
 * 
 * @author mr
 *
 */
public class DockerdRestService {
	private static final String DOCKERD_URL = System.getProperty("DOCKERD_HOST");
	private static final String DOCKERD_RUNNING_CONTAINER_URL = DOCKERD_URL + "/containers/json";

	/**
	 * Requests the dockerd and returns all currently running container.
	 * 
	 * @return All running containers.
	 */
	public List<Container> getRunningContainer() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		Container[] library = restTemplate.getForObject(DOCKERD_RUNNING_CONTAINER_URL, Container[].class);
		return Arrays.asList(library);

	}
}
