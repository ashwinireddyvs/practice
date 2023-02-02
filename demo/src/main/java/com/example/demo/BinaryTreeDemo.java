package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree bt=new BinarySearchTree();
		bt.root=new Node(20);
		bt.insert(10);
		bt.insert(25);
		bt.insert(14);
		bt.insert(26);
		bt.insert(1);
		bt.insert(21);
		bt.insert(19);
		bt.insert(2);
		bt.insert(22);
		bt.insert(5);
		
		bt.readInOrder();
		System.out.println("----------------------end Inorder---------------------------------");
		bt.readPreOrder();
		System.out.println("----------------------end preorder---------------------------------");
		bt.readPostOrder();
		System.out.println("----------------------end postorder---------------------------------");

		bt.search(10);
		bt.search(50);
		
	}
	
	
}

class Node{
	int data;
	Node left;
	Node right;
	
	public Node() {
		super();
		
	}
	
	public Node(int data) {
		this.data=data;
	}
}

class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		super();
	}
	
	

	public BinarySearchTree(Node node) {
		root=node;
	}
	
	
	
	public void insert(int data) {
		Node temp=root;
		Node rt=null;
		while(temp!=null) {
			rt=temp;
			if(data<temp.data) {
				temp=temp.left;
			}
			else {
				temp=temp.right;
			}
				
		}
		if(data<rt.data)
		rt.left=new Node(data);
		else
		rt.right=new Node(data);
		
	}
	
	public void readInOrder() {
		readInoder(this.root);
	}
	
	public void readInoder(Node node) {
		if(node!=null) {
			readInoder(node.left);
			System.out.println(node.data);
			readInoder(node.right);
		}
		
	}
	
	public void readPostOrder() {
		readPostOrder(root);
	}
	
	public void readPostOrder(Node node) {
		// TODO Auto-generated method stub
		if(node!=null) {
			readInoder(node.left);
			readInoder(node.right);
			System.out.println(node.data);
		
		}
	
	}

	public void readPreOrder() {
		readPreOrder(root);
	}
	public void readPreOrder(Node node) {
		// TODO Auto-generated method stub
		
		if(node!=null) {
			
			System.out.println(node.data);
			readInoder(node.left);
			readInoder(node.right);
		}
	}
	
	boolean flag=false;
	public void search(int data) {
		flag=false;
		flag=search(root,data);
		if(flag==true)
			System.out.println(data+" found");
		else
			System.out.println(data+" not found");
		
	}
	
	public boolean search(Node node,int data) {
		
		if(node!=null && flag!=true) 
		if(node.data==data) {
			flag=true;
			return flag;
		}else
		{
			
			search(node.left,data);
			if(flag!=true)
			search(node.right,data);
			
		}
		
		
		return flag;
	}
	
	
}


