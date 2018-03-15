package problem2579;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] a = new int[len+1];
		int[][] d = new int[len+1][2];
		for(int i=1;i<=len;i++){
			a[i] = sc.nextInt();
		}
		d[1][0] = a[1];
		for(int i=2;i<=len;i++){
			d[i][0] = Math.max(d[i-2][0], d[i-2][1])+a[i];
			d[i][1] = d[i-1][0] + a[i];
		}
		System.out.println(Math.max(d[len][0], d[len][1]));
	}
}
