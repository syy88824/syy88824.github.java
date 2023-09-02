package hw1;
//橫 直 斜的每條線中的數字皆為定值

import java.util.Scanner;

public class Practice1 {
	
	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); //須為奇數
		int numSq = (int) Math.pow(num, 2);
		int[][] numList = new int[num][num];
		numList[0][(num-1)/2] = 1;  //先訂下 1 的位置
		//再將2~numSq的數字一一填入對應位置中
		for(int i = 2; i <= numSq; i++) {
			int rowFront = 0;
			int colFront = 0;
			int row = 0;
			int col = 0;
			boolean exist = false;
			boolean br = false; //loopM要break時變成true
			for(int m = 0; m < num; m++) {
				for(int n = 0; n < num; n++) {
					if((i-1) == numList[m][n]) {
						rowFront = m;
						colFront = n;
						m -= 1;
						n -= 1;
						if(m < 0) {
							m += num;
						}
						if(n < 0) {
							n += num;
						}
						row = m;
						col = n;
						br = true;
						break;
					}
				}
				if(br) {
					break;
				}
			}
			if(numList[row][col] != 0) {
				exist = true;
			}
			if(!exist) {
				numList[row][col] = i;
			}else {
				numList[rowFront+1][colFront] = i;
			}
		}
		for(int r = 0; r < num; r++) {
			for(int c = 0; c < num; c++) {
				System.out.print(numList[r][c] + "  ");
			}
			System.out.println(" ");
		}
	}
}
