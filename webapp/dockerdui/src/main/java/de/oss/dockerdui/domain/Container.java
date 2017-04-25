package de.oss.dockerdui.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//@JsonInclude(Include.NON_NULL)
public class Container extends HashMap<Object, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getStatus() {
		return (String) this.get("Status");
	}

	public List<String> getNames() {
		return (List)Arrays.asList(this.get("Names"));
	}

	public String getImage() {
		return (String) this.get("Image");
	}

}
