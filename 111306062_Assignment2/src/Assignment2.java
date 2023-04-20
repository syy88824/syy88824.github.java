import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);
	//第一題
	int output = 0;
	int input = scan.nextInt();
	while (output!=495) {
		int num3rd = input%10;
		int num2nd = (input%100-num3rd)/10;
		int num1st = (input-input%100)/100;
		
		if (num1st>num2nd&&num2nd>=num3rd) {	
			int max = num1st*100+num2nd*10+num3rd;
			int min = num3rd*100+num2nd*10+num1st;
			output = output+max-min;
			if(output != 495) { 
				System.out.print(output+",");
				input = output; //將此output變為下個input重新計算
				output = 0; //將output歸零
			}
			if(output==495) {
				System.out.print(output);
				break;
			}
		}
		
		if (num1st>num3rd&&num2nd<=num3rd) {	
			int max = num1st*100+num3rd*10+num2nd;
			int min = num2nd*100+num3rd*10+num1st;
			output = output+max-min;
			if(output != 495) {
				System.out.print(output+",");
				input = output;
				output = 0;
			}
			if(output==495) {
				System.out.print(output);
				break;
			}
		}
		
		if (num1st<num2nd&&num1st>=num3rd) {	
			int max = num2nd*100+num1st*10+num3rd;
			int min = num3rd*100+num1st*10+num2nd;
			output = output+max-min;
			if(output != 495) {
				System.out.print(output+",");
				input = output;
				output = 0;
			}
			if(output==495) {
				System.out.print(output);
				break;
			}
		}
		
		if (num3rd<=num2nd&&num1st<num3rd) {	
			int max = num2nd*100+num3rd*10+num1st;
			int min = num1st*100+num3rd*10+num2nd;
			output = output+max-min;
			if(output != 495) {
				System.out.print(output+",");
				input = output;
				output = 0;
			}
			if(output==495) {
				System.out.print(output);
				break;
			}
		}
		
		if (num1st>num2nd&&num1st<=num3rd) {	
			int max = num3rd*100+num1st*10+num2nd;
			int min = num2nd*100+num1st*10+num3rd;
			output = output+max-min;
			if(output != 495) {
				System.out.print(output+",");
				input = output;
				output = 0;
			}
			if(output==495) {
				System.out.print(output);
				break;
			}
		}
		
		if (num1st<=num2nd&&num2nd<num3rd) {	
			int max = num3rd*100+num2nd*10+num1st;
			int min = num1st*100+num2nd*10+num3rd;
			output = output+max-min;
			if(output != 495) {
				System.out.print(output+",");
				input = output;
				output = 0;
			}
			if(output==495) {
				System.out.print(output);
				break;
			}
		}
	}
	//第二題
	int input_1 = scan.nextInt();
	int weight = scan.nextInt();
	int weight_1 = 0;
	int price = 0;
	int output_1 = 0;	
	int weight_0 = 0;

	for(int i = 0; i<=2*(input_1+=1);i++) {
		weight_1 = scan.nextInt();
		if(weight>=weight_1) { //當輸入的級距公斤數小於要採買的總公斤數
			price = scan.nextInt();
			output_1 = output_1 + price*(weight_1-weight_0); //總金額=級距*該級距的價錢
			weight_0 = weight_1; //weight_0是前一個輸入的級距公斤數
		}
		else {	//當輸入的級距公斤數大於要採買的公斤數
			price = scan.nextInt();
			output_1 = output_1 + price*(weight-weight_0); //總金額=上面的總金額+該級距的價錢*(總公斤數-級距)
			System.out.print(output_1);
			break; //因為級距公斤數大於要採買的公斤數，當次結束後價錢計算就結束了，即可跳出迴圈
		}
}
	}
}
