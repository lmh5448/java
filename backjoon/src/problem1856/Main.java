package problem1856;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = " " + sc.next();
		String[] a = new String[n];
		for(int i=0;i<n;i++){
			a[i] = sc.next();
		}
		int[] d = new int[m+1];
		for(int i=1;i<=m;i++){
			d[i] = d[i-1]+1;
			for(int j=0;j<n;j++){
				if(i<a[j].length())continue;
				int p = a[j].length() -1;
				int cnt = 0;
				for(int k=i;k>=1;k--){
					if(s.charAt(k)==a[j].charAt(p)){
						p--;
					}else{
						cnt++;
					}
					if(p == -1){
						if(d[i] > d[k-1] + cnt){
							d[i] = d[k-1] + cnt;
						}
						break;
					}
				}
			}
		}
		System.out.println(d[m]);
	}
}