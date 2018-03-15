package problem1699;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int num = sc.nextInt();
		int[] d = new int[num+1];
		
		for(int i=1;i<=num;i++){
			d[i] = d[i-1];
			for(int j=2;j*j<=i;j++){
				d[i] = Math.min(d[i], d[i-j*j]);
			}
			d[i] += 1;
		}
		System.out.println(d[num]);
	}
}
