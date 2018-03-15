package problem14501;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[21];
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++){
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++){
			d[i+t[i]-1] = Math.max(d[i+t[i]-1], d[i-1]+p[i]);
			d[i] = Math.max(d[i], d[i-1]);
		}
		int ans = d[1];
		for(int i=2;i<=n;i++){
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}
}
