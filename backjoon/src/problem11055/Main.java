package problem11055;

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
			d[i] = a[i];
			for(int j=1;j<i;j++){
				if(a[j]<a[i]&&d[i]<d[j]+a[i]){
					d[i] = d[j] + a[i];
				}
			}
		}
		int result = 0;
		for(int i=1;i<=len;i++){
			if(result<d[i]){
				result = d[i];
			}
		}
		System.out.println(result);
	}
}
