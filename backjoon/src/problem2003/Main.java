package problem2003;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			if(i!=0){
				a[i] += a[i-1];
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(i==0){
					if(a[j]==m)ans++;
				}else{
					if(a[j]-a[i-1]==m)ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
