package problem11057;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 10007;
		int len = sc.nextInt();
		
		int[][] d = new int[len+1][10];
		for(int i=0;i<10;i++){
			d[1][i]=1;
		}
		for(int i=2;i<=len;i++){
			for(int j=0;j<10;j++){
				for(int k=0;k<=j;k++){
					d[i][j] += d[i-1][k];
					d[i][j] %= mod;
				}
			}
		}
		int result = 0;
		for(int i=0;i<10;i++){
			result += d[len][i];
			result%=mod;
		}
		System.out.println(result);
	}
}
