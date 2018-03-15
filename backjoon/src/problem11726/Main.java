package problem11726;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] array = new int[len+1];
		array[1]=1;
		if(len>1)array[2]=2;
		for(int i=3;i<len+1;i++){
			array[i] = array[i-1] + array[i-2];
			array[i] %= 10007;
		}
		System.out.println(array[len]);
	}
}
