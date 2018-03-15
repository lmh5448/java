package problem12100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int ans = Integer.MIN_VALUE;
	//d값에 따라서 다른 방향으로 이동시키기
	//d==0 아래쪽으로
	//d==1 오른쪽으로
	//d==2 위쪽으로
	//d==3 왼쪽으로
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int n;
	
	static int[][] a;
	static int[][] temp;
	
	static void go(int count, String s){
		if(count>5)return;
		if(count==5){
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i=0;i<5;i++){
				q.add(s.charAt(i)-'0');
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					temp[i][j] = a[i][j];
				}
			}
//			System.out.println("s : "+s);
//			
//			////////////////////////////////////////
//			for(int i=0;i<n;i++){
//				for(int j=0;j<n;j++){
//					System.out.print(temp[i][j]+" ");
//				}System.out.println();
//			}System.out.println();
//			//////////////////////////////////////////
			
			while(!q.isEmpty()){
				int d = q.remove();
				move(d);
//				System.out.println(" d1 : "+d);
//				////////////////////////////////////////
//				for(int i=0;i<n;i++){
//				for(int j=0;j<n;j++){
//				System.out.print(temp[i][j]+" ");
//				}System.out.println();
//				}System.out.println();
//				//////////////////////////////////////////
				sum(d);
//				System.out.println(" d2 : "+d);
//				////////////////////////////////////////
//				for(int i=0;i<n;i++){
//				for(int j=0;j<n;j++){
//				System.out.print(temp[i][j]+" ");
//				}System.out.println();
//				}System.out.println();
//				//////////////////////////////////////////
				move(d);
//				System.out.println(" d3 : "+d);
//				////////////////////////////////////////
//				for(int i=0;i<n;i++){
//				for(int j=0;j<n;j++){
//				System.out.print(temp[i][j]+" ");
//				}System.out.println();
//				}System.out.println();
//				//////////////////////////////////////////
			}
			return;
		}
		go(count+1,s+"0");
		go(count+1,s+"1");
		go(count+1,s+"2");
		go(count+1,s+"3");
	}
	
	static void move(int d){
		while(true){
			boolean check = true;
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(temp[i][j]==0)continue;
					int ni = i +dx[d];
					int nj = j +dy[d];
					if(ni<0 || ni>=n || nj<0 || nj>=n)continue;
					if(temp[ni][nj]==0){
						check = false;
						temp[ni][nj] = temp[i][j];
						temp[i][j]=0;
					}
				}
			}
			
			if(check)break;
		}
	}
	
	static void sum(int d){
		if(d==2 || d==3){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(temp[i][j]==0)continue;
					int ni = i +dx[d];
					int nj = j +dy[d];
					if(ni<0 || ni>=n || nj<0 || nj>=n)continue;
					if(temp[i][j]==temp[ni][nj]){
						if(temp[i][j]==ans)ans*=2;
						temp[ni][nj] = temp[i][j]*2;
						temp[i][j]=0;
					}
				}
			}
		}else{
			for(int i=n-1;i>=0;i--){
				for(int j=n-1;j>=0;j--){
					if(temp[i][j]==0)continue;
					int ni = i +dx[d];
					int nj = j +dy[d];
					if(ni<0 || ni>=n || nj<0 || nj>=n)continue;
					if(temp[i][j]==temp[ni][nj]){
						if(temp[i][j]==ans)ans*=2;
						temp[ni][nj] = temp[i][j]*2;
						temp[i][j]=0;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		temp = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j] = sc.nextInt();
				ans = Math.max(ans, a[i][j]);
			}
		}
		go(0,"");
		
		System.out.println(ans);
	}
}
