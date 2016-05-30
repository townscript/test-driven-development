package com.townscript.workshop;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int value;
	private List<Node> adjucentNodes = new ArrayList<Node>();

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public List<Node> getAdjucentNodes() {
		return adjucentNodes;
	}

	public boolean isConnectedTo(Node node) {
		// check self connected
		if(getValue() == node.getValue()) {
			return true;
		}
		// check adjucent node 
		for (Node checkNode : getAdjucentNodes()) {
			
			if(checkNode.getValue() == node.getValue() || // check 1st level connection
					checkNode.isConnectedTo(node)){ // use recursive method to check n-th level connection
				return true;
			}
		}
		return false;
	}

	public void addAdjucentNode(Node node) {
		getAdjucentNodes().add(node);
	}

	public int distanceOf(Node node) {
		
		int distance = -1;
		
		// check self connected
		if(getValue() == node.getValue()) {
			distance = 0;
		}
		
		// check adjucent node 
		for (Node checkNode : getAdjucentNodes()) {
			if(!checkNode.isConnectedTo(node)) {
				continue;
			}
			
			if(checkNode.getValue() == node.getValue()) { 
				distance = 1;
			} else {
				distance = checkNode.distanceOf(node)+1;
			}
			
		}
		return distance;

	}

}
