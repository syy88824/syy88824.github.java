package self;

import java.util.Scanner;

public class Practice1 {
	static int change = 0;
	static int num = 0;
	static int len = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		len = input.length() - 1;
		recur(input, input.length()-1);
	}
	public static String recur(String input, int n, int c) {   // len = length-1		
		String[] list = new String[input.length()];
		for(int i = 0; i < input.length(); i++) {
			list[i] = input.substring(i, i+1);
		}
		if(change < len) {
			return recur();
		}
		/*while() {
			if() {
				
			}else if() {
				
			}
		}*/
		/*do {
			System.out.print("list before = ");
			for(String str : list) {
				System.out.print(str);
			}
			System.out.println();
			System.out.println("j = " + j + "   list[j] = " + list[j] + "   num = " + num +  "   list[num] = " + list[num]);
			String indexJ = list[j];
			list[j] = list[num];
			list[num] = indexJ;
			String rs = "";
			for(String str : list) {
				System.out.print(str);
				rs += str;
			}
			System.out.println();
			num--;
		}while(num != -1);
		if(len >= 0) {
			
			for(int j = len-1; j >= 0; j--) {	
				System.out.print("list before = ");
				for(String str : list) {
					System.out.print(str);
				}
				System.out.println();
				System.out.println("j = " + j + "   list[j] = " + list[j] + "   len = " + len +  "   list[len] = " + list[len]);
				String indexJ = list[j];
				list[j] = list[len];
				list[len] = indexJ;
				String rs = "";
				for(String str : list) {
					System.out.print(str);
					rs += str;
				}
				System.out.println();
				recur(rs, len-1);
				/*if(j == 0) {
					recur(input, len);
				}else{
					
				}
					
			}
		}*/
		return input;
		
	}
}
