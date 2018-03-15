package problem2156;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] a = new int[len+1];
		int[][] d = new int[len+1][3];
		for(int i=1;i<=len;i++){
			a[i] = sc.nextInt();
		}
		d[1][0]=0;
		d[1][1]=a[1];
		d[1][2]=0;
		for(int i=2;i<=len;i++){
			d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
			d[i][1] = d[i-1][0] + a[i];
			d[i][2] = d[i-1][1] + a[i];
		}
		int result = Math.max(d[len][0], Math.max(d[len][1], d[len][2]));
		System.out.println(result);
	}
}
