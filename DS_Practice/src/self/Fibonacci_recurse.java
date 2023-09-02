//前兩項相加等於後面一項的數列：費比數列
package self;

import java.util.Scanner;

public class Fibonacci_recurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println("result = " + fb(input));
	}
	public static int fb(int n) {
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			return fb(n-1) + fb(n-2);
		}
	}
}
