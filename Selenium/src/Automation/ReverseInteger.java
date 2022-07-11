package Automation;



public class ReverseInteger {

	public static void main(String[] args) {
		int num = 12345678, rev = 0;
	
//		while(num!=0) {
//			int remainder = num%10;
//			rev = rev*10+remainder;
//			num = num/10;
//		}
		
		for(;num!=0;num=num/10) {
			int remainder1 = num%10;
			rev = rev*10+remainder1;
		}
		System.out.println(rev);
		

	}

}
