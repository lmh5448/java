package problem13398;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		
		int[] a = new int[len+1];
		int[] dl = new int[len+1];
		int[] dr = new int[len+1];
		
		for(int i=1;i<=len;i++){
			a[i] = sc.nextInt();
		}
		for(int i=1;i<=len;i++){
			dl[i] = Math.max(dl[i-1] + a[i], a[i]);
		}
		dr[len] = a[len];
		for(int i=len;i>1;i--){
			dr[i-1] = Math.max(dr[i]+a[i-1], a[i-1]);
		}
		int result = dl[1];
		for(int i=1;i<len;i++){
			if(result<dl[i-1]+dr[i+1]){
				result = dl[i-1] + dr[i+1];
			}
		}
		for(int i=1;i<=len;i++){
			if(result < dl[i]){
				result = dl[i];
			}
		}
		System.out.println(result);
	}
}
