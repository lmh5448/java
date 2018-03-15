package problem1261;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x, y, count;
	Pair(int x,int y,int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Main {
	static int n;
	static int m;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][] a;
	static int[][] check;
	static void dfs(){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(1,1,0));
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			//System.out.println("x : "+x+", y : "+y);
			int count = p.count;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<=0 || nx>n || ny<=0 || ny>m)continue;
				if(check[nx][ny]==-1){
					if(a[nx][ny]==1){
						check[nx][ny] = count+1;
						q.add(new Pair(nx,ny,count+1));
					}else{
						check[nx][ny] = count;
						q.add(new Pair(nx,ny,count));
					}
				}else if(a[nx][ny]==1){
					if(check[nx][ny]>count+1){
						check[nx][ny] = count+1;
						q.add(new Pair(nx,ny,count+1));
					}
				}else if(a[nx][ny]==0){
					if(check[nx][ny]>count){
						check[nx][ny] = count;
						q.add(new Pair(nx,ny,count));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n+1][m+1];
		check = new int[n+1][m+1];
		check[1][1] = 0;
		for(int i=0;i<=n;i++){
			Arrays.fill(check[i], -1);			
		}
		sc.nextLine();
		for(int i=1;i<=m;i++){
			String temp = sc.nextLine();
			for(int j=1;j<=n;j++){
				a[j][i] = temp.charAt(j-1)-'0';
			}
		}
		dfs();
//		for(int i=0;i<=n;i++){
//			for(int j=0;j<=m;j++){
//				System.out.print(a[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
//		System.out.println();
//		for(int i=0;i<=n;i++){
//			for(int j=0;j<=m;j++){
//				System.out.print(check[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
		if(check[n][m]==-1)System.out.println(0);
		else System.out.println(check[n][m]);
	}
}
