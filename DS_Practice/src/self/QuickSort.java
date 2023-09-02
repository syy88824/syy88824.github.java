//將一串數列依大小排序
package self;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<>();
		System.out.println("Enter 0 to end input ：");
		boolean key = true;
		while(key) {
			int input = sc.nextInt();  //不可將下面的input換成sc.nextInt()  因為每輸入一次 就會再跳下一個數字
			if(input == 0) {
				key = false;				
			}else {
				numList.add(input);
			}						
		}
		sort(numList);
	}
	
	public static void sort(ArrayList<Integer> list) {
		boolean contin = false;
		ArrayList<Integer> rsList = new ArrayList<>();
		ArrayList<Integer> tempList = new ArrayList<>();  //存放比keyNum大的數字
		int index = Math.round((float)Math.random()*(list.size()-1));
		int keyNum = list.get(index);
		for(int n : list) {
			if(n < keyNum){
				rsList.add(n);
			}else if(n > keyNum) {
				tempList.add(n);
			}
		}
		rsList.add(keyNum);
		rsList.addAll(tempList);
		//檢查數列是否完全由小至大排列
		for(int i = 0; i < rsList.size()-1; i++) {
			if(rsList.get(i) > rsList.get(i+1)) {
				contin = true;
			}
		}
		if(contin) {
			sort(rsList);  //如果還沒排序好 再排序一次(遞迴)
		}else {
			for(int l : rsList) {
				System.out.print(l + " ");
			}
		}		
	}
}