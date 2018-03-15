package problem1373;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int tempLen = temp.length();
		int a = tempLen%3;
		if(a==0){
		}else if(a==1){
			System.out.print(temp.charAt(0)-'0'==1 ? 1:(tempLen==1?"0":""));
		}else if(a==2){
			int b=0;
			for(int j=0;j<2;j++){
				b = b*2 + (int)(temp.charAt(j)-'0');
			}
			System.out.print(b);
		}
		for(int i=a;i<tempLen;i+=3){
			int b=0;
			for(int j=0;j<3;j++){
				b = b*2 + (int)(temp.charAt(j+i)-'0');
			}
			System.out.print(b);
		}
		System.out.println();
	}

}
