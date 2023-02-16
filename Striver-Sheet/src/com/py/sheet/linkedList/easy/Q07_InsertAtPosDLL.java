package com.py.sheet.linkedList.easy;

class Q07_InsertAtPosDLL {

	static NodeD t=null;
	static
	void addNode(NodeD head_ref, int pos, int data){
		// Your code here
		/*
		 * Below thing is not possible in java because reference would change
		 * null will be overriddden but not refelected in callee method
		 */
//		if(head_ref==null)
//			head_ref= new NodeD(data); 
		
		pos--;
		while(head_ref.next!=null && pos>=0) {
			head_ref = head_ref.next;
			pos--;
		}
		NodeD newNode = new NodeD(data);
		newNode.prev = head_ref;
		newNode.next = head_ref.next;
		head_ref.next = newNode;
//		t= newNode;
	}
	
	static 
	NodeD addFirst(NodeD head,int data) {
		NodeD newNode = new NodeD(data);
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		return head;
	}
	
	public static void main(String[] args) {
		int arr[] = {1};//{1,2,3,4,5};
		NodeD head = constructDLL(arr);
		int pos=3;
		int data = 27;
		System.out.println(head=addFirst(head,100));
		addNode(head,pos,data);
		System.out.println(head);
//		while(t.prev!=null) {
//			System.out.print(t.data+ "->");
//			t = t.prev;
//		}
//		System.out.println(t.data+"->null");
	}
	
	static
	NodeD constructDLL(int arr[]) {
        // Code here
		NodeD  head = null;
		NodeD  last = head;
		for(int i=0;i<arr.length;i++) {
			NodeD newNode = new NodeD(arr[i]);
			if(head==null) {
				last=head=newNode;
			}else {
				while(last.next!=null) {
					last = last.next;
				}
				newNode.prev = last;
				last.next = newNode;
			}
		}
        return head;
    }

}
