package de.oss.dockerdui.domain;

import java.util.ArrayList;

public class ActiveContainers {
	private ArrayList <Container> runningContainers;

	public ArrayList<Container> getRunningContainers() {
		return runningContainers;
	}

	public void setRunningContainers(ArrayList<Container> runningContainers) {
		this.runningContainers = runningContainers;
	}


}
