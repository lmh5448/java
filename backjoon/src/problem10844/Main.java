package problem10844;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000000;
		int len = sc.nextInt();
		int[][] array = new int[len+1][10];
		array[1][0]=0;
		for(int i=1;i<10;i++){
			array[1][i]=1;
		}
		for(int i=2;i<=len;i++){
			for(int j=0;j<10;j++){
				if(j<9){
					array[i][j] += array[i-1][j+1];
				}
				if(j>0){
					array[i][j] += array[i-1][j-1];
				}
				array[i][j]%=mod;
			}
		}
		long result = 0;
		for(int i=0;i<10;i++){
			result += array[len][i];
		}
		System.out.println(result%mod);
	}
}
