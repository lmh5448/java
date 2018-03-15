package problem11054;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] a = new int[len+1];
		int[] d = new int[len+1];
		int[] d2 = new int[len+1];
		for(int i=1;i<=len;i++){
			a[i] = sc.nextInt();
		}
		for(int i=1;i<=len;i++){
			d[i] = 1;
			for(int j=1;j<i;j++){
				if(a[j]<a[i]&&d[i]<d[j]+1){
					d[i] = d[j] + 1;
				}
			}
		}
		for(int i=len;i>0;i--){
			d2[i] = 1;
			for(int j=len;j>i;j--){
				if(a[j]<a[i]&&d2[i]<d2[j]+1){
					d2[i] = d2[j] + 1;
				}
			}
		}
		int result = 0;
		for(int i=1;i<=len;i++){
			result = Math.max(result, d[i]+d2[i]-1);
		}
		System.out.println(result);
	}
}
