package problem2225;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000000;
		int len = sc.nextInt();
		int each = sc.nextInt();
		
		int[][] d = new int[len+1][each+1];
		for(int i=1;i<=len;i++){
			for(int k=1;k<=each;k++){
				for(int j=0;j<=i;j++){
					d[i][k] += d[i-j][k-1];
					d[i][k]%=mod;
				}
				d[i][k]++;
				d[i][k]%=mod;
			}
		}
		System.out.println(d[len][each]);
	}
}
