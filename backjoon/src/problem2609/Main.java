package problem2609;

import java.util.Scanner;

//최소공배수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0;i<count;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int greatcd = gcd(a,b);
			//System.out.println(greatcd);
			System.out.println(a*b/greatcd);
		}
	}
	public static int gcd(int num1,int num2){
		if(num2 == 0)return num1;
		return gcd(num2,num1%num2);
	}
}
