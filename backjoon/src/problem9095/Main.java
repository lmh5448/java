package problem9095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] array = new int[12];
		array[1]=1;
		array[2]=2;
		array[3]=4;
		for(int i=4;i<12;i++){
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		while(count-- >0){
			int temp = sc.nextInt();
			System.out.println(array[temp]);
		}
	}
}
