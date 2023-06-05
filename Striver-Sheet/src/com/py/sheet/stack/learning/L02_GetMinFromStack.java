package com.py.sheet.stack.learning;
import java.util.*;
/*
 * this implementation doesnt work properly
 */
public class L02_GetMinFromStack {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}

    static
    class GfG{
        int minEle;
        Stack<Integer> s;
        
        // Constructor    
        GfG(){
            s  = new Stack<>();
        }
        
        /*returns min element from stack*/
        int getMin(){
            // Your code here
            this.minEle = s.isEmpty() ? -1 : s.peek();
            return this.minEle;
        }
        
        /*returns poped element from stack*/
        int pop(){
            // Your code here
            if(this.s.isEmpty())
                return -1;
            int y =this.s.pop();
            if(y<this.minEle){
                this.minEle = 2*this.minEle -y;
                return this.minEle;
            }
            return y;
        }
    
        /*push element x into the stack*/
        void push(int x){
            // Your code here
            if(s.isEmpty()){
                this.minEle = x;
                this.s.push(x);
            }
            else{
                if(x<minEle){
                    this.s.push(2*x-minEle);
                    this.minEle=x;
                }
                else{
                    this.s.push(x);
                }
            }
        }	
    }


}
