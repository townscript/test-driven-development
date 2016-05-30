package com.townscript.workshop;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkshopTest {

	/*@Test
    public void testEvenOddNumber(){
		EvenOdd meo = new EvenOdd();
        assertEquals("10 is a even number", true, meo.isEvenNumber(10));
    }*/
	
	@Test
	public void testShouldReturnValue() {
		Node node = new Node(5);
		assertEquals("Node returned some value", 5, node.getValue());
	}
	
	@Test
	public void isSelfConnected() {
		Node node = new Node(5);
		assertTrue("Node is self connected", node.isConnectedTo(node));		
	}
	
	@Test
	public void isConnectedToNode() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.addAdjucentNode(node2);
		assertTrue("Nodes are connected", node1.isConnectedTo(node2));
	}
	
	@Test
	public void checkNotConnectedNode() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		assertFalse("Nodes are not connected", node1.isConnectedTo(node2));	
	}
	
	@Test
	public void checkNodesConnected() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node1.addAdjucentNode(node2);
		node1.addAdjucentNode(node3);

		assertTrue("Nodes are connected", node1.isConnectedTo(node2));
		assertTrue("Nodes are connected", node1.isConnectedTo(node3));
	}
	
	@Test
	public void checkSecondLevelConnection() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.addAdjucentNode(node2);
		node1.addAdjucentNode(node3);
		node3.addAdjucentNode(node4);

		assertTrue("Node1 is connected to node4 through node3", node1.isConnectedTo(node4));
		
	}
	
	@Test
	public void checkComplexLevelConnection() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		Node node10 = new Node(10);
		
		node1.addAdjucentNode(node2);
		node1.addAdjucentNode(node4);
		
		node2.addAdjucentNode(node6);
		node2.addAdjucentNode(node3);
		
		node3.addAdjucentNode(node5);
		node3.addAdjucentNode(node7);
		
		assertFalse("Node4 is not connected to node3", node4.isConnectedTo(node3));
		assertTrue("Node1 is connected to node7", node1.isConnectedTo(node7));
		assertTrue("Node2 is connected to node5", node2.isConnectedTo(node5));
		assertTrue("Node2 is connected to node6", node2.isConnectedTo(node6));
		
		assertFalse("Node1 is not connected to node10", node1.isConnectedTo(node10));
	}
	
	@Test
	public void checkSelfDistance() {
		Node node = new Node(1);
		
		assertEquals("Self distance is zero", 0, node.distanceOf(node));
	}
	
	@Test 
	public void checkAdjucentNodeDistance() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
		node1.addAdjucentNode(node2);
		
		assertEquals("Node1 is 1 unit far from node 2", 1, node1.distanceOf(node2));
	}
	
	@Test
	public void checkNotConnectedDistance() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
		assertEquals("Node1 is not connect to node2", -1, node1.distanceOf(node2));
	}
	
	@Test 
	public void checkFirstLevelDistance() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node1.addAdjucentNode(node2);
		node1.addAdjucentNode(node3);
		
		assertEquals("Node1 is 1 unit far from node 2", 1, node1.distanceOf(node2));
		assertEquals("Node1 is 1 unit far from node 3", 1, node1.distanceOf(node3));
	}
	
	@Test 
	public void checkSecondLevelDistance() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node1.addAdjucentNode(node2);
		node2.addAdjucentNode(node3);
		
		assertEquals("Node1 is 1 unit far from node 3", 2, node1.distanceOf(node3));
	}
	
	@Test 
	public void checkComplexLevelDistance() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node1.addAdjucentNode(node2);
		node2.addAdjucentNode(node3);
		
		node1.addAdjucentNode(node4);
		node2.addAdjucentNode(node5);
		node4.addAdjucentNode(node6);
		
		assertEquals("Node1 is 1 unit far from node 3", 2, node1.distanceOf(node3));
	}
}
