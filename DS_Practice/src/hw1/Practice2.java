package hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		ArrayList<Integer> inputList = new ArrayList<>();
		int[] numArray = new int[1];
		while(run) {
			int num = sc.nextInt();
			inputList.add(num);
			if (num == 0) {
				break;
			}
		}
		for(int n : inputList) {
			if(n > 0 && n <= 50) {
				for(int i = 1; i <= n; i++) {
					System.out.print(i + "! = ");
					if(i == 1) {
						numArray[0] = 1;
						System.out.print(1);
					}else {
						numArray = simple(numArray, i);
						for(int k = numArray.length-1; k >= 0; k--) {
							System.out.print(numArray[k]);
						}
					}
					System.out.println();
				}
				System.out.println(" ");
				numArray = new int[1];
			}
		}
	}
	
	public static int[] simple(int[] list, int times) {
		for(int i = 0; i < list.length; i++) {
			list[i] *= times;
		}
		for(int j = 0; j < list.length-1; j++) {
			if(list[j] >= 10) {
				list[j+1] += (list[j]/10);
				list[j] %= 10;
			}
		}
		int l = list.length;
		if(list[l-1] >= 10) {
			list = Arrays.copyOf(list, l+1);
			list[l] += (list[l-1]/10);
			list[l-1] %= 10;
		}
		return list;
	}
}
