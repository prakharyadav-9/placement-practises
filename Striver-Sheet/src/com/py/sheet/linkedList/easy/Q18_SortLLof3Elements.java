package com.py.sheet.linkedList.easy;

public class Q18_SortLLof3Elements {

	static class LL{
		Node head,last;
		LL(Node head){
			this.head= head;
			if(this.head!=null) {
				last= this.head;
				while(last.next!=null) {
					last=last.next;
				}
			}
		}
		
		@Override
		public String toString() {
			return "["+this.head+"]";
		}
	}
	
	//Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head){
        // add your code here
        LL ones=new LL(null);
        LL twos=new LL(null);
        LL zeros=new LL(null);
        LL givenList  = new LL(head);
        while(givenList.head!=null) {
        	if(givenList.head.data == 0) {
        		addLastAndRemoveFirst(givenList,zeros);
        	}else if(givenList.head.data==1) {
        		addLastAndRemoveFirst(givenList,ones);
       
        	}else {
        		addLastAndRemoveFirst(givenList,twos);
        	}
        }
        if(zeros.last!=null ) {
        	zeros.last.next=ones.head;
        }
        if(ones.head==null) {
        	if(zeros.last!=null )
        		zeros.last.next=twos.head;
        }else if(ones.last!=null) {
        	ones.last.next=twos.head;
        }
        head=(zeros.head!=null)?zeros.head:(ones.head!=null?ones.head:twos.head);
    	return head;
    }
    
	private static void addLastAndRemoveFirst(LL givenList, LL toList) {
		if(toList.head==null) {
			toList.head = toList.last=givenList.head;
		}
		else {
			toList.last.next=givenList.head;
			toList.last=toList.last.next;
		}
		givenList.head= givenList.head.next;
		toList.last.next=null;
	}

	public static void main(String[] args) {
		int arr[] ={2,2};//{1,2,2,1,2,0,2,2};
		Node head = constructLL(arr);
		System.out.println(segregate(head));
	}

	static Node constructLL(int arr[]){
        // code here
        Node head=null;
        Node last=null;
        for(int i=0; i<arr.length; i++){
            if(head==null){
                head=new Node(arr[i]);
                last=head;
            }else{
                last.next=new Node(arr[i]);
                last=last.next;
            }
        }
        return head;
    }
}
