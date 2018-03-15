package problem2146;

import java.util.*;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[][] a = new int[len][len];
		int[][] d = new int[len][len];
		int[][] g = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (a[i][j] == 1 && g[i][j] == 0) {
					Queue<Pair> q = new LinkedList<Pair>();
					cnt++;
					g[i][j] = cnt;
					q.add(new Pair(i, j));
					while (!q.isEmpty()) {
						Pair p = q.remove();
						int x = p.x;
						int y = p.y;
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (nx >= 0 && nx < len && ny >= 0 && ny < len) {
								if (a[nx][ny] == 1 && g[nx][ny] == 0) {
									q.add(new Pair(nx, ny));
									g[nx][ny] = cnt;
								}
							}
						}
					}
				}
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				d[i][j] = -1;
				if (a[i][j] != 0) {
					q.add(new Pair(i, j));
					d[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<len && ny>=0 && ny<len){
					if(d[nx][ny]==-1){
						d[nx][ny]=d[x][y]+1;
						g[nx][ny] = g[x][y];
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		
		int ans = -1;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				for(int k=0;k<4;k++){
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx>=0 && nx<len && ny>=0 && ny<len){
						if(g[i][j] != g[nx][ny] && (ans==-1||ans>d[i][j]+d[nx][ny])){
							ans = d[i][j] + d[nx][ny];
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
