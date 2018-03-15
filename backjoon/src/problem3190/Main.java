package problem3190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] a = new boolean[n+1][n+1];
		int k = sc.nextInt();
		while(k-- >0){
			a[sc.nextInt()][sc.nextInt()]=true;
		}
		int l = sc.nextInt();
		int ans = 0;
		int d = 0;
		Queue<Pair> snake = new LinkedList<Pair>();
		snake.add(new Pair(1,1));
		int x=1;
		int y=1;
		sc.nextLine();
		Queue<String> q = new LinkedList<String>();
		while(l-- >0){
			q.add(sc.nextLine());
		}
		while(!q.isEmpty()){
			String[] s = q.remove().split(" ");
			int t = Integer.parseInt(s[0])-ans;
			char c = s[1].charAt(0);
			while(t-- >0){
//				////////////////
//				int[][] map = new int[n+1][n+1];
//				for(int i=1;i<=n;i++){
//					for(int j=1;j<=n;j++){
//						if(a[i][j]){
//							map[i][j] = 2;
//						}
//					}
//				}
//				for(Pair pair:snake){
//					map[pair.x][pair.y]=1;
//				}
//				for(int i=1;i<=n;i++){
//					for(int j=1;j<=n;j++){
//						System.out.print(map[i][j]+"\t");
//					}System.out.println();
//				}System.out.println();
//				////////////////
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx<1 || nx>n || ny<1 || ny>n){
					System.out.println(ans+1);
					return;
				}
				for(Pair pair:snake){
					if(pair.x==nx && pair.y==ny){
						System.out.println(ans+1);
						return;
					}
				}
				ans++;
				x = nx;
				y = ny;
				if(a[x][y]){
					snake.add(new Pair(x,y));
					a[x][y] = false;
				}else{
					snake.add(new Pair(x,y));
					snake.poll();
				}
			}
			if(c=='D'){
				d = (d+1)%4;
			}else if(c=='L'){
				d = (d+3)%4;
			}
		}
		while(true){
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx<1 || nx>n || ny<1 || ny>n){
				System.out.println(ans+1);
				return;
			}
			x = nx;
			y = ny;
		}
	}
}
