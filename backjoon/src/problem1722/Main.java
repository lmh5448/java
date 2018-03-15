package problem1722;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		long[] f = new long[21];
		boolean[] c = new boolean[21];
		f[0]=1;
		for(int i=1;i<=20;i++){
			f[i] = f[i-1] * i;
		}
		if(p==1){
			long th = sc.nextLong();
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				for(int j=1;j<=n;j++){
					if(c[j] == true)continue;
					if(f[n-i-1] < th){
						th -= f[n-i-1];
					}else{
						a[i] = j;
						c[j] = true;
						break;
					}
				}
			}
			for(int i=0;i<n;i++){
				System.out.print(a[i]);
				if(i<n-1){
					System.out.print(" ");
				}
			}System.out.println();
		}else if(p==2){
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			long ans = 0;
			for(int i=0;i<n;i++){
				for(int j=1;j<a[i];j++){
					if(c[j] == false){
						ans += f[n-i-1];
					}
				}
				c[a[i]] = true;
			}
			System.out.println(ans+1);
		}
	}
}
