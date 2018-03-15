package problem1912;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		
		int[] a = new int[len+1];
		int[] d = new int[len+1];
		
		for(int i=1;i<=len;i++){
			a[i] = sc.nextInt();
		}
		for(int i=1;i<=len;i++){
			d[i] = Math.max(d[i-1]+a[i], a[i]);
		}
		int result = d[1];
		for(int i=2;i<=len;i++){
			if(result<d[i]){
				result = d[i];
			}
		}
		System.out.println(result);
	}
}
