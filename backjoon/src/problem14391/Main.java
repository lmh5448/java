package problem14391;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++){
			String s = sc.next();
			for(int j=0;j<m;j++){
				a[i][j] = s.charAt(j)-'0';
			}
		}
		int ans = 0;
		for(int s=0;s<(1<<n*m);s++){
			int sum=0;
			for(int i=0;i<n;i++){
				int temp = 0;
				for(int j=0;j<m;j++){
					int k = i*m+j;
					if((s&(1<<k))==0){
						temp = temp*10 + a[i][j];
					}
					else{
						sum += temp;
						temp = 0;
					}
				}
				sum += temp;
			}
			for(int j=0;j<m;j++){
				int temp = 0;
				for(int i=0;i<n;i++){
					int k = i*m+j;
					if((s&(1<<k))!=0){
						temp = temp*10 + a[i][j];
					}
					else{
						sum += temp;
						temp = 0;
					}
				}
				sum += temp;
			}
			if(ans<sum)ans=sum;
		}
		System.out.println(ans);
	}
}
