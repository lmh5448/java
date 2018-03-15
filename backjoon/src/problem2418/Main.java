package problem2418;

import java.util.*;

class Pair{
	int x;
	int y;
	int z;
	Pair(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	/*static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static int[] dy = {1,1,1,0,0,-1,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int l = sc.nextInt();
		sc.nextLine();
		char[][] array = new char[h][w];
		for(int i=0;i<h;i++){
			String temp = sc.nextLine();
			for(int j=0;j<w;j++){
				array[i][j] = temp.charAt(j);
			}
		}
		String word = sc.nextLine();
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				if(array[i][j]==word.charAt(0)){
					q.add(new Pair(i,j,0));
				}
			}
		}
		int ans = 0;
		while(!q.isEmpty()){
			Pair pair = q.remove();
			int x = pair.x;
			int y = pair.y;
			int z = pair.z;
			for(int i=0;i<8;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + 1;
				if(nx>=0 && nx<h && ny>=0 && ny<w && nz<l){
					if(array[nx][ny]==word.charAt(nz)){
						if(nz+1 == word.length()){
							ans++;
						}else{
							q.add(new Pair(nx,ny,nz));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}*/
	///////////////////////////////////////////////////////////////////
	//다이나믹문제 전수 조사는 경우의 수가 많아서 시간초과
	///////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		String[] a = new String[n];
		for(int i=0;i<n;i++){
			a[i] = sc.next();
		}
		String s = sc.next();
		long[][][] d = new long[l][n][m];
		int[] dx = {-1,0,1,-1,1,-1,0,1};
		int[] dy = {1,1,1,0,0,-1,-1,-1};
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(s.charAt(0)==a[i].charAt(j)){
					d[0][i][j] = 1;
				}
			}
		}
		for(int t=1;t<l;t++){
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(s.charAt(t)!=a[i].charAt(j)){
						continue;
					}
					for(int k=0;k<8;k++){
						int x = i+dx[k];
						int y = j+dy[k];
						if(x<0 || x>=n || y<0 || y>=m)continue;
						d[t][i][j] += d[t-1][x][y];
					}
				}
			}
		}
		long ans = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				ans += d[l-1][i][j];
			}
		}
		System.out.println(ans);
	}
}
