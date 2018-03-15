package problem11653;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int i=2;
		while(temp!=1){
			if(temp%i==0){
				System.out.println(i);
				temp/=i;
			}else{
				i++;
			}
		}
	}
}
