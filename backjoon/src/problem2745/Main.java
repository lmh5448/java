package problem2745;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.next();
		int num = sc.nextInt();
		
		char[] temp1 = temp.toCharArray();
		int tempSize = temp1.length;
		int[] temp2 = new int[tempSize];
		int result = 0;
		for(int i=0;i<tempSize;i++){
			if(temp1[i]>=65&&temp1[i]<=90){
				temp1[i]-=55;
			}else{
				temp1[i]-=48;
			}
			temp2[i] = (int)temp1[i];
			result += (int)Math.pow(num, tempSize-i-1)*temp2[i];
		}
		System.out.println(result);
	}

}
