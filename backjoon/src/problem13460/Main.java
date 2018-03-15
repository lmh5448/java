package problem13460;

import java.util.Scanner;

public class Main {
	static int ans = 11;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static void go(char[][] a, int d, int cnt,int rx,int ry, int bx, int by){
		//d(direction) 0:, 1:, 2:, 3:
		if(cnt==11)return;
		char[][] temp = new char[a.length][a[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				temp[i][j] = a[i][j];
			}
		}
		boolean rcheck = false;
		boolean bcheck = false;
		while(true){
			boolean bmove=false;
			boolean rmove=false;
			
			if(!rcheck){
				int nrx = rx+dx[d];
				int nry = ry+dy[d];
				if(temp[nrx][nry]=='.'){
					temp[nrx][nry]='R';
					temp[rx][ry]='.';
					rx = nrx;
					ry = nry;
					rmove = true;
				}else if(temp[nrx][nry]=='O'){
					temp[rx][ry]='.';
					rcheck = true;
					rmove = true;
				}
			}
			
			if(!bcheck){
				int nbx = bx+dx[d];
				int nby = by+dy[d];
				if(temp[nbx][nby]=='.'){
					temp[nbx][nby]='B';
					temp[bx][by]='.';
					bx = nbx;
					by = nby;
					bmove = true;
				}else if(temp[nbx][nby]=='O'){
					temp[bx][by]='.';
					bcheck = true;
					bmove = true;
				}
			}
			if(!bmove&&!rmove){
				break;
			}	
		}
		if(bcheck){
			return;
		}else{
			if(rcheck){
				ans = Math.min(ans, cnt);
				return;
			}
		}
		for(int i=1;i<4;i++){
			go(temp,(d+i)%4,cnt+1,rx,ry,bx,by);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char[][] a = new char[n][m];
		for(int i=0;i<n;i++){
			String temp = sc.nextLine();
			for(int j=0;j<m;j++){
				a[i][j] = temp.charAt(j);
			}
		}
		int rx=0;
		int ry=0;
		int bx=0;
		int by=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]=='R'){
					rx=i;
					ry=j;
				}else if(a[i][j]=='B'){
					bx=i;
					by=j;
				}
			}
		}
		ans=11;
		for(int i=0;i<4;i++){
			go(a,i,1,rx,ry,bx,by);
		}
		if(ans == 11)ans=-1;
		System.out.println(ans);
	}
}
