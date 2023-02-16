package com.py.sheet.linkedList.easy;

class Q06_ArrayToDoublyLL {

	static NodeD t=null;
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
		t= last.next;
        return head;
    }
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		System.out.println(constructDLL(arr));
		
		while(t.prev!=null) {
			System.out.print(t.data+ "->");
			t = t.prev;
		}
		System.out.println(t.data+"->null");
	}

}
