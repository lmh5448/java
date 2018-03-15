package problem11052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ea = sc.nextInt();
		int[] array = new int[ea+1];
		int[] result = new int[ea+1];
		for(int i=1;i<=ea;i++){
			array[i] = sc.nextInt();
		}
		for(int i=1;i<=ea;i++){
			for(int j=1;j<=i;j++){
				if(result[i]<result[i-j]+array[j]){
					result[i] = result[i-j]+array[j];
				}
			}
		}
		System.out.println(result[ea]);
	}
}
