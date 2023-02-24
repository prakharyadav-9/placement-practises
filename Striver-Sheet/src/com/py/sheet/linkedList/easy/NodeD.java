package com.py.sheet.linkedList.easy;

 public class NodeD {
	public int data;
	public NodeD prev;
	public NodeD next;
	public NodeD(int data){
		this.data = data;
	}
	
	@Override
	public String toString() {
		return +this.data+"->"+this.next;
	}

}