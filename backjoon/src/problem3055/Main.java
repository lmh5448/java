package problem3055;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y,z;
	Pair(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main{
	static int r;
	static int c;
	static char[][] a;
	static int[][] check;
	static int cx;
	static int cy;
	static int sx;
	static int sy;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static String dfs(){
		Queue<Pair> q = new LinkedList<>();
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(a[i][j]=='*'){
					q.add(new Pair(i,j,1));
				}
			}
		}
		q.add(new Pair(sx,sy,0));
		while(!q.isEmpty()){
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			for(int i=0;i<4;i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=r || ny<0 || ny>=c)continue;
				if(check[nx][ny]==-1){
					if(a[nx][ny]=='D' && z==0)return (check[x][y]+1)+"";
					if(a[nx][ny]=='.'){
						check[nx][ny] = check[x][y]+1;
						q.add(new Pair(nx,ny,z));
					}
				}
			}
		}
		return "KAKTUS";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		a = new char[r][c];
		check = new int[r][c];
		for(int i=0;i<r;i++){
			Arrays.fill(check[i], -1);
		}
		sc.nextLine();
		for(int i=0;i<r;i++){
			String temp = sc.nextLine();
			for(int j=0;j<c;j++){
				a[i][j] = temp.charAt(j);
				if(a[i][j]=='D'){
					cx = i;
					cy = j;
				}
				if(a[i][j]=='S'){
					sx = i;
					sy = j;
					check[i][j]=0;
				}
				if(a[i][j]=='*'){
					check[i][j]=0;
				}
			}
		}
		System.out.println(dfs());
	}
}


//시간초과
//class Pair{
//	char[][] a;
//	int x;
//	int y;
//	int z;
//	Pair(char[][] a,int x,int y,int z){
//		this.a = a;
//		this.x = x;
//		this.y = y;
//		this.z = z;
//	}
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "x:"+x+",y:"+y+",z:"+z;
//	}
//}
//
//class XY{
//	int x,y;
//	XY(int x,int y){
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class Main {
//	static int r;
//	static int c;
//	static char[][] a;
//	static int cx;
//	static int cy;
//	static int sx;
//	static int sy;
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {1,-1,0,0};
//	
//	static String dfs(){
//		Queue<Pair> q = new LinkedList<Pair>();
//		char[][] array = new char[r][c];
//		for(int i=0;i<r;i++){
//			for(int j=0;j<c;j++){
//				array[i][j] = a[i][j];
//			}
//		}
//		q.add(new Pair(array,sx,sy,0));
//		while(!q.isEmpty()){
//			Pair p = q.remove();
////			System.out.println(p.toString());
////			for(int i=0;i<r;i++){
////				for(int j=0;j<c;j++){
////					System.out.print(p.a[i][j]);
////				}System.out.println();
////			}System.out.println();
////			System.out.println();
//			for(int i=0;i<4;i++){
//				int nsx = p.x + dx[i];
//				int nsy = p.y + dy[i];
//				if(nsx<0 || nsx>=r || nsy<0 || nsy>=c)continue;
//				if(nsx==cx && nsy==cy)return (p.z+1)+"";
//				char[][] ca = copy(p.a);
//				ca[nsx][nsy]='S';
//				ca[p.x][p.y]='.';
//				if(!water(ca))continue;
//				q.add(new Pair(ca,nsx,nsy,p.z+1));
//			}
//		}
//		return "KAKTUS";
//	}
//	
//	static char[][] copy(char[][] a){
//		char[][] copy = new char[r][c];
//		for(int i=0;i<r;i++){
//			for(int j=0;j<c;j++){
//				copy[i][j] = a[i][j];
//			}
//		}
//		return copy;
//	}
//	
//	static boolean water(char[][] a){
//		Queue<XY> q = new LinkedList<>();
//		for(int i=0;i<r;i++){
//			for(int j=0;j<c;j++){
//				if(a[i][j]=='*'){
//					q.add(new XY(i,j));
//				}
//			}
//		}
//		while(!q.isEmpty()){
//			XY xy = q.remove();
//			for(int i=0;i<4;i++){
//				int nx = xy.x + dx[i];
//				int ny = xy.y + dy[i];
//				if(nx<0 || nx>=r || ny<0 || ny>=c)continue;
//				if(a[nx][ny]=='.'){
//					a[nx][ny] = '*';
//				}
//				if(a[nx][ny]=='S'){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		r = sc.nextInt();
//		c = sc.nextInt();
//		a = new char[r][c];
//		sc.nextLine();
//		for(int i=0;i<r;i++){
//			String temp = sc.nextLine();
//			for(int j=0;j<c;j++){
//				a[i][j] = temp.charAt(j);
//				if(a[i][j]=='D'){
//					cx = i;
//					cy = j;
//				}
//				if(a[i][j]=='S'){
//					sx = i;
//					sy = j;
//				}
//			}
//		}
//		System.out.println(dfs());
//	}
//}
