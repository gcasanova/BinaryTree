package com.dchoc.dag;

import static org.junit.Assert.assertEquals;

import junit.framework.Assert;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testAddChild() {
		Node footballNode = new Node("footballNode");
		Node laLigaNode = new Node("laLigaNode");

		footballNode.addChild(laLigaNode);
		int numberOfChildren = footballNode.getNumberOfChildren();
		assertEquals(1, numberOfChildren);
	}

	@Test
	public void testAddMultipleChildren() {
		Node footballNode = new Node("footballNode");
		Node laLigaNode = new Node("laLigaNode");
		Node premiershipNode = new Node("premiershipNode");

		footballNode.addChild(laLigaNode);
		footballNode.addChild(premiershipNode);
		int numberOfChildren = footballNode.getNumberOfChildren();
		assertEquals(2, numberOfChildren);
	}

	@Test
	public void testAddParent() {
		Node footballNode = new Node("footballNode");
		Node premiershipNode = new Node("premiershipNode");

		footballNode.addChild(premiershipNode);
		int numberOfParents = premiershipNode.getNumberOfParents();
		assertEquals(1, numberOfParents);
	}

	@Test
	public void testGetName() {
		Node footballNode = new Node("footballNode");
		footballNode.getName();
		assertEquals("footballNode", footballNode.getName());
	}

	@Test
	public void testAddChildAlsoSetParent() {
		Node footballNode = new Node("footballNode");
		Node premiershipNode = new Node("premiershipNode");

		footballNode.addChild(premiershipNode);

		Assert.assertTrue(premiershipNode.hasParent("footballNode"));
	}

	@Test
	public void testNumberOfDescendents() {
		Node footballNode = new Node("footballNode");
		Node laLigaNode = new Node("laLigaNode");
		Node premiershipNode = new Node("premiershipNode");
		Node barcaNode = new Node("barcaNode");
		Node realMadridNode = new Node("realMadridNode");
		Node ronaldoNode = new Node("ronaldoNode");

		footballNode.addChild(laLigaNode);
		footballNode.addChild(premiershipNode);
		laLigaNode.addChild(barcaNode);
		laLigaNode.addChild(realMadridNode);
		realMadridNode.addChild(ronaldoNode);

		assertEquals(5, footballNode.getNumberOfDescendents());
	}

	@Test
	public void testGetDescendents() {
		Node footballNode = new Node("footballNode");
		Node laLigaNode = new Node("laLigaNode");
		Node premiershipNode = new Node("premiershipNode");
		Node barcaNode = new Node("barcaNode");
		Node realMadridNode = new Node("realMadridNode");
		Node ronaldoNode = new Node("ronaldoNode");
		Node figoNode = new Node("FigoNode");

		footballNode.addChild(laLigaNode);
		footballNode.addChild(premiershipNode);
		laLigaNode.addChild(barcaNode);
		laLigaNode.addChild(realMadridNode);
		realMadridNode.addChild(ronaldoNode);
		realMadridNode.addChild(figoNode);
		barcaNode.addChild(figoNode);

		assertEquals(6, footballNode.getDescendents().size());
	}
}
