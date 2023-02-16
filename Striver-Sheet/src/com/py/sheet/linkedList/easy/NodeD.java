package com.py.sheet.linkedList.easy;

class NodeD {
	int data;
	NodeD prev;
	NodeD next;
	NodeD(int data){
		this.data = data;
	}
	
	@Override
	public String toString() {
		return +this.data+"->"+this.next;
	}

}