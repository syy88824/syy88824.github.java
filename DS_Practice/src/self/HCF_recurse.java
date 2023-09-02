//用遞迴做最大公因數的輾轉相除法
package self;

import java.util.Scanner;

public class HCF_recurse {
	public static void main(String[] args) {
		boolean again = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("Enter two numbers : ");
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if(num1 > num2) {
				again = false;
				recur(num1, num2);
				System.out.println(num1 + " 和 " + num2 + " 的最大公因數為 " + result);
			}else if(num1 < num2) {
				again = false;
				recur(num2, num1);
				System.out.println(num2 + " 和 " + num1 + " 的最大公因數為 " + result);
			}else {
				again = true;
				System.out.println("enter two different numbers. ");
			}
		}while(again);
		
	}
	static int result = 0;
	public static void recur(int big, int small) {	
		int quo = big/small;  //商
		int rem = big%small;  //餘數
		System.out.println(big + " / " + small + " = " + quo + " ... " + rem);
		if (rem == 0) {					
			result = small;
		}else {
			recur(small, rem);
		}
	}
}
