package self;

import java.util.Scanner;

public class PW_recurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] rs = new int[input];
		for(int i = 0; i < input; i++) {
			rs[i] = 1;
		}
		paizu(rs, 3);
	}

	public static void paizu(int[] list, int range) {
		int sz = list.length;
		for(int m = 1; m <= sz; m++) {
			printList(list);
			System.out.println("m = " + m + "   sz-m = " + (sz-m));
			for(int )
			if(list[sz-m] < range) {
				list[sz-m]++;
			}else if(m != sz){				
				list[sz-m-1]++;
				list[sz-m] = 1;
			}
			paizu(list, range);
		}
	}
	
	public static void printList(int[] l) {
		for(int num : l) {
			System.out.print(num);
		}
		System.out.println();
	}
}
