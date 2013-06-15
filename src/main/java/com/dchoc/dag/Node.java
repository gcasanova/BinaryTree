package com.dchoc.dag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Node {

	private List<Node> children;
	private List<Node> parents;
	private String name;

	public Node(String name) {
		this.name = name;
		this.children = new ArrayList<Node>();
		this.parents = new ArrayList<Node>();
	}

	public void addChild(Node node) {
		this.children.add(node);
		node.parents.add(this);
	}

	public void addParent(Node node) {
		this.parents.add(node);
		node.children.add(this);
	}

	public void removeChild(Node node) {
		this.children.remove(node);
		node.parents.remove(this);
	}

	public void removeParent(Node node) {
		this.parents.remove(node);
		node.parents.remove(this);
	}

	public int getNumberOfChildren() {
		return this.children.size();
	}

	public int getNumberOfParents() {
		return this.parents.size();
	}

	public String getName() {
		return this.name;
	}

	public List<Node> getParents() {
		return parents;
	}

	public boolean hasParent(String name) {
		for (Node node : this.parents) {
			if (node.getName() == name) {
				return true;
			}
		}
		return false;
	}

	public int getNumberOfDescendents() {
		int numberOfDescendents = 0;
		for (Node node : this.children) {
			numberOfDescendents += 1;
			numberOfDescendents += node.getNumberOfDescendents();
		}
		return numberOfDescendents;
	}

	public HashSet<Node> getDescendents() {
		HashSet<Node> descendents = new HashSet<Node>(); 
		for (Node node : this.children){
				descendents.add(node);
				descendents.addAll(node.getDescendents());
		}
		return descendents;
	}
}
