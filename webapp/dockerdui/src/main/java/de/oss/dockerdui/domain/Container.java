package de.oss.dockerdui.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Container POJO for rest mappings.
 * 
 * @author mr
 *
 */
public class Container extends HashMap<Object, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the current status of the container.
	 * 
	 * @return The container status.
	 */
	public String getStatus() {
		return (String) this.get("Status");
	}

	/**
	 * Gets the names of the container.
	 * 
	 * @return The name of the container.
	 */
	@SuppressWarnings("unchecked")
	public List<String> getNames() {
		@SuppressWarnings("rawtypes")
		List names = (List) Arrays.asList(this.get("Names"));
		@SuppressWarnings("rawtypes")
		List cleanedNames = new ArrayList<String>();
		for (Object name : names) {
			cleanedNames.add(name.toString().replace("[", "").replace("]", "").replace("/", ""));
		}
		return cleanedNames;
	}

	/**
	 * Gets the image name of the image the container is based on.
	 * 
	 * @return The container image.
	 */
	public String getImage() {
		return (String) this.get("Image");
	}

	/**
	 * Gets the current state of the container.
	 * 
	 * @return The state of the container.
	 */
	public String getState() {
		return (String) this.get("State");
	}
}
