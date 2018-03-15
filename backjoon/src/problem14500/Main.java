package problem14500;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(i+3<n){
					//가로 1자
					int temp = a[i][j]+a[i+1][j]+a[i+2][j]+a[i+3][j];
					if(temp>ans)ans=temp;
				}
				if(j+3<m){
					//세로 1자
					int temp = a[i][j]+a[i][j+1]+a[i][j+2]+a[i][j+3];
					if(temp>ans)ans=temp;
				}
				if(i+1<n&&j+1<m){
					//정사각형
					int temp = a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1];
					if(temp>ans)ans=temp;
				}
				if(i+2<n&&j+1<m){
					int temp = a[i][j]+a[i][j+1]+a[i+1][j+1]+a[i+2][j+1];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i+1][j]+a[i+2][j]+a[i][j+1];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i+1][j]+a[i+2][j]+a[i+2][j+1];
					if(temp>ans)ans=temp;
					temp = a[i][j+1]+a[i+1][j+1]+a[i+2][j+1]+a[i+2][j];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i+1][j]+a[i+1][j+1]+a[i+2][j+1];
					if(temp>ans)ans=temp;
					temp = a[i][j+1]+a[i+1][j+1]+a[i+1][j]+a[i+2][j];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i+1][j]+a[i+2][j]+a[i+1][j+1];
					if(temp>ans)ans=temp;
					temp = a[i][j+1]+a[i+1][j+1]+a[i+2][j+1]+a[i+1][j];
					if(temp>ans)ans=temp;
				}
				if(i+1<n&&j+2<m){
					int temp = a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+2];
					if(temp>ans)ans=temp;
					temp = a[i+1][j]+a[i+1][j+1]+a[i+1][j+2]+a[i][j+2];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i+1][j]+a[i+1][j+1]+a[i+1][j+2];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i][j+1]+a[i+1][j+1]+a[i+1][j+2];
					if(temp>ans)ans=temp;
					temp = a[i+1][j]+a[i+1][j+1]+a[i][j+1]+a[i][j+2];
					if(temp>ans)ans=temp;
					temp = a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1];
					if(temp>ans)ans=temp;
					temp = a[i+1][j]+a[i+1][j+1]+a[i+1][j+2]+a[i][j+1];
					if(temp>ans)ans=temp;
				}
			}
		}
		System.out.println(ans);
	}
}
