package self;

public class Times_recurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		times(1, 1);
	}
	public static void times(int num1, int num2) {
		System.out.println(num1 + " * " + num2 + " = " + num1*num2);
		if(num2 < 9) {
			times(num1, num2+1);
		}else if(num1 < 9 && num2 == 9){
			times(num1+1, 1);
		}
	}
}
