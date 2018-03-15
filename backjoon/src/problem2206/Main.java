package problem2206;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y,z,count;
	Pair(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static int m;
	static int[][] a;
	static int[][][] check;
	static void dfs(){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(1,1,0));
		check[1][1][0] = 1;
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
//			System.out.println("x : "+x+", y: "+y+", z : "+z+", count : "+count);
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<=0 || nx>n || ny<=0 || ny>m)continue;
				if(a[nx][ny]==0){
					if(check[nx][ny][z]==-1){
						q.add(new Pair(nx,ny,z));
						check[nx][ny][z] = check[x][y][z]+1;
					}
//					if(check[nx][ny][1]==-1){
//						q.add(new Pair(nx,ny,1));
//						check[nx][ny][1] = check[x][y][1]+1;
//					}
				}else{
					if(z==0&&check[nx][ny][1]==-1){
						q.add(new Pair(nx,ny,1));
						check[nx][ny][1]=check[x][y][0]+1;
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
		check = new int[n+1][m+1][2];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				Arrays.fill(check[i][j], -1);
			}
		}
		sc.nextLine();
		for(int i=1;i<=n;i++){
			String temp = sc.nextLine();
			for(int j=0;j<m;j++){
				a[i][j+1] = temp.charAt(j)-'0';
			}
		}
		dfs();
		
//		for(int i=1;i<=n;i++){
//			for(int j=1;j<=m;j++){
//				System.out.print(a[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
//		System.out.println();
//		for(int k=0;k<2;k++){
//			for(int i=1;i<=n;i++){
//				for(int j=1;j<=m;j++){
//					System.out.print(check[i][j][k]+" ");
//				}System.out.println();
//			}System.out.println();
//			System.out.println();
//		}
		
		int ans = -1;
		for(int i=0;i<2;i++){
			if(ans==-1 && check[n][m][i]!=-1){
				ans = check[n][m][i];
			}else if(ans!=-1 && check[n][m][i]!=-1){
				ans = Math.min(ans, check[n][m][i]);
			}
		}
		System.out.println(ans);
	}
}
