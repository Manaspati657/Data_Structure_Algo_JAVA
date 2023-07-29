package com.mkp.interviewProb;

public class PallindromNo {
	
	public static void main(String[] args) {
		
		System.out.println("is Pallindrom : 1221 - "+isPallindrom(1221));
		
	}
	
	public static boolean isPallindrom(int no) {
		int temp = no ,rev = 0, rem = 0;
		
		while (no >0 ) {
			rem = no % 10;
			rev = rev *10 +rem;
			no = no /10;
		}
		
		if(temp ==rev) return true;
		return false;
	}

}
