package com.py.sheet.potd.gfg.Month03;

public class POTD_03_10 {

	static
	Long maxTripletProduct(Long arr[], int n){
        // Complete the function
        long max=Long.MIN_VALUE,secMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        long min = Long.MAX_VALUE, secMin = Long.MAX_VALUE;
        
        // itereating over values
        for(Long ele:arr){
            // for highest positive values
            if(ele>max){
                thirdMax = secMax;
                secMax = max;
                max=ele;
            }else if(ele>secMax){
                thirdMax = secMax;
                secMax=ele;
            }else if(ele>thirdMax){
                thirdMax = ele;
            }
            
            // for negative values
            if(min>ele){
                secMin = min;
                min = ele;
            }else if(secMin>ele){
                secMin = ele;
            }
        }
//        System.out.println(max+ " " + secMax+ " "+ thirdMax+ " = "+max*secMax*thirdMax+ " | "+secMax*thirdMax);
//        System.out.println((min)+ " "+ secMin+ " | "+min*secMin);
//        System.out.println(secMax*min*secMin);
        // now all the elements are set lets multiply and chech which gives the maximum values
        return Math.max((secMax*thirdMax*max),(max*min*secMin));        
    }
	
	public static void main(String[] args) {
		Long arr[] = {-89l,-75l,-10l,-20l};
		System.out.println(maxTripletProduct(arr, arr.length));
	}

}
