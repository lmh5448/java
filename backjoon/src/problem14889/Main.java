package problem14889;

import java.util.Scanner;

public class Main{
	static int n,ans=Integer.MAX_VALUE;
	static int[][] a;
	public static void go(String s,int start, int link){
		if(s.length()==n){
			int[] team1 = new int[(n/2)];
			int[] team2 = new int[(n/2)];
			int index1=0;
			int index2=0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='1'){
					team1[index1++] = i+1;
				}else{
					team2[index2++] = i+1;
				}
			}
			int sum1=0,sum2=0;
			for(int i=0;i<team1.length-1;i++){
				for(int j=i+1;j<team1.length;j++){
					sum1 += a[team1[i]][team1[j]];
					sum1 += a[team1[j]][team1[i]];
					sum2 += a[team2[i]][team2[j]];
					sum2 += a[team2[j]][team2[i]];
				}
			}
			ans = Math.min(ans, Math.abs(sum1-sum2));
		}
		if(start<(n/2))go(s+"1",start+1,link);
		if(link<(n/2))go(s+"2",start,link+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				a[i][j] = sc.nextInt();
			}
		}
		go("",0,0);
		System.out.println(ans);
	}
}



/*
 
안되는 이유 스트링으로 처리해서 1자리만 가능

import java.util.Scanner;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static void go(int[][] a,String team1,String team2,int n,int m,int num){
		if(num>n+1)return;
		if(num==n+1 && team1.length()==m+1 && team2.length()==m+1){
			int sum1=0;
			int sum2=0;
			int indexi;
			int indexj;
			
			System.out.println("team1 : "+team1);
			System.out.println("team2 : "+team2);
			
			for(int i=1;i<team1.length()-1;i++){
				for(int j=i+1;j<team1.length();j++){
					indexi = team1.charAt(i)-'0';
					indexj = team1.charAt(j)-'0';
					sum1 += a[indexi][indexj];
					sum1 += a[indexj][indexi];
				}
			}
			
			for(int i=1;i<team2.length()-1;i++){
				for(int j=i+1;j<team2.length();j++){
					indexi = team2.charAt(i)-'0';
					indexj = team2.charAt(j)-'0';
					sum2 += a[indexi][indexj];
					sum2 += a[indexj][indexi];
				}
			}
			
			System.out.println("sum1 : "+sum1);
			System.out.println("sum2 : "+sum2);
			if(sum1>sum2)ans = Math.min(ans, sum1-sum2);
			else if(sum2>sum1)ans = Math.min(ans, sum2-sum1);
			else ans = 0;
		}
		else{
			go(a,team1+(num+""),team2,n,m,num+1);
			go(a,team1,team2+(num+""),n,m,num+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n/2;
		int[][] a = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				a[i][j] = sc.nextInt();
			}
		}
		go(a," "," ",n,m,1);
		System.out.println(ans);
	}
}
*/