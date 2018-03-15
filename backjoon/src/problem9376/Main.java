package problem9376;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class XY{
	int x;
	int y;
	XY(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x : "+x+", y : "+y;
	}
}

class Pair{
	int x;
	int y;
	int z;
	int count;
	Pair(int x,int y,int z,int count){
		this.x = x;
		this.y = y;
		this.z = z;
		this.count = count;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x : "+x+", y : "+y+", z : "+z+", count : "+count;
	}
}

public class Main{
	static int h;
	static int w;
	static char[][] a;
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	static int[][][] dist;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static void bfs(){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x1,y1,0,0));
		q.add(new Pair(x2,y2,1,0));
		q.add(new Pair(0,0,2,0));
		
		while(!q.isEmpty()){
			Pair p = q.remove();
			for(int i=0;i<4;i++){
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0 || nx>h+1 || ny<0 || ny>w+1)continue;
				if(dist[nx][ny][p.z]==-1){
					if(a[nx][ny]=='.'||a[nx][ny]=='$'){
						dist[nx][ny][p.z] = p.count;
						q.add(new Pair(nx,ny,p.z,p.count));
					}else if(a[nx][ny]=='#'){
						dist[nx][ny][p.z] = p.count+1;
						q.add(new Pair(nx,ny,p.z,p.count+1));
					}
				}else{
					if(a[nx][ny]=='.'||a[nx][ny]=='$'){
						if(dist[nx][ny][p.z]>p.count){
							dist[nx][ny][p.z]=p.count;
							q.add(new Pair(nx,ny,p.z,p.count));
						}
					}else if(a[nx][ny]=='#'){
						if(dist[nx][ny][p.z]>p.count+1){
							dist[nx][ny][p.z]=p.count+1;
							q.add(new Pair(nx,ny,p.z,p.count+1));
						}
					}
				}
			}
		}
//		for(int k=0;k<3;k++){
//			System.out.println(" k : "+k+"dist");
//			for(int i=0;i<h+2;i++){
//				for(int j=0;j<w+2;j++){
//					System.out.print(dist[i][j][k]+"\t");
//				}System.out.println();
//			}System.out.println();
//			System.out.println();
//		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			h = sc.nextInt();
			w = sc.nextInt();
			sc.nextLine();
			a = new char[h+2][w+2];
			for(int i=0;i<h+2;i++){
				for(int j=0;j<w+2;j++){
					a[i][j] = '.';
				}
			}
			boolean bool = false;
			for(int i=1;i<=h;i++){
				String temp = sc.nextLine();
				for(int j=1;j<=w;j++){
					a[i][j] = temp.charAt(j-1);
					if(a[i][j]=='$'){
						if(!bool){
							x1 = i;
							y1 = j;
							bool = true;
						}else{
							x2 = i;
							y2 = j;
						}
					}
				}
			}
			dist = new int[h+2][w+2][3];
			for(int i=0;i<h+2;i++){
				for(int j=0;j<w+2;j++){
					Arrays.fill(dist[i][j], -1);
				}
			}
			
			bfs();
			
			int[][] sum = new int[h+2][w+2];
			for(int i=1;i<=h;i++){
				for(int j=1;j<=w;j++){
					if(a[i][j]=='*'){
						sum[i][j]=Integer.MAX_VALUE;
						continue;
					}
					for(int k=0;k<3;k++){
						sum[i][j]+=dist[i][j][k];
					}
					if(a[i][j]=='#'){
						sum[i][j] -=2;
					}
				}
			}
//			System.out.println("sum");
//			for(int i=1;i<=h;i++){
//				for(int j=1;j<=w;j++){
//					System.out.print(sum[i][j]+"\t\t");
//				}System.out.println();
//			}System.out.println();
//			System.out.println();
			int ans = Integer.MAX_VALUE;
			for(int i=1;i<=h;i++){
				for(int j=1;j<=w;j++){
					ans = Math.min(ans, sum[i][j]);
				}
			}
			System.out.println(ans);
		}
	}
}

//시간 초과
//class Pair{
//	char[][] a;
//	int x;
//	int y;
//	int count;
//	boolean[][] check;
//	Pair(char[][] a,int x,int y,int count,boolean[][] check){
//		this.a = a;
//		this.x = x;
//		this.y = y;
//		this.count = count;
//		this.check = check;
//	}
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "x: "+x+", y: "+y+", count: "+count;
//	}
//}
//
//class XY{
//	int x;
//	int y;
//	XY(int x,int y){
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class Main{
//	static int x1;
//	static int y1;
//	static int x2;
//	static int y2;
//	static int h;
//	static int w;
//	static char[][] a1;
//	static char[][] a2;
//	static boolean[][] check1;
//	static boolean[][] check2;
//	static ArrayList<Pair> array1;
//	static ArrayList<Pair> array2;
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {1,-1,0,0};
//	static ArrayList<XY> wall;
//	
//	static void bfs1(){
//		Queue<Pair> q = new LinkedList<>();
//		char[][] c = copy(a1);
//		boolean[][] c1 = copy(check1);
//		q.add(new Pair(c,x1,y1,0,c1));
//		while(!q.isEmpty()){
//			Pair p = q.remove();
//			if(p.x==0 || p.x==h-1 || p.y==0 || p.y==w-1){
//				p.a[p.x][p.y]='.';
//				array1.add(new Pair(p.a,p.x,p.y,p.count,p.check));
//				continue;
//			}
//			for(int i=0;i<4;i++){
//				int nx = p.x + dx[i];
//				int ny = p.y + dy[i];
//				if(nx<0 || nx>=h || ny<0 || ny>=w)continue;
//				if(!p.check[nx][ny]){
//					c = copy(p.a);
//					c1 = copy(p.check);
//					c1[nx][ny]=true;
//					if(c[nx][ny]=='.'){
//						c[nx][ny] = '$';
//						c[p.x][p.y]='.';
//						q.add(new Pair(c,nx,ny,p.count,c1));
//					}else if(c[nx][ny]=='#'){
//						c[nx][ny] = '$';
//						c[p.x][p.y]='.';
//						q.add(new Pair(c,nx,ny,p.count+1,c1));
//					}
//				}
//			}
//		}
//	}
//	
//	static void bfs2(){
//		Queue<Pair> q = new LinkedList<>();
//		char[][] c = copy(a2);
//		boolean[][] c1 = copy(check2);
//		q.add(new Pair(c,x2,y2,0,c1));
//		while(!q.isEmpty()){
//			Pair p = q.remove();
//			if(p.x==0 || p.x==h-1 || p.y==0 || p.y==w-1){
//				p.a[p.x][p.y]='.';
//				array2.add(new Pair(p.a,p.x,p.y,p.count,p.check));
//				continue;
//			}
//			for(int i=0;i<4;i++){
//				int nx = p.x + dx[i];
//				int ny = p.y + dy[i];
//				if(nx<0 || nx>=h || ny<0 || ny>=w)continue;
//				if(!p.check[nx][ny]){
//					c = copy(p.a);
//					c1 = copy(p.check);
//					c1[nx][ny]=true;
//					if(c[nx][ny]=='.'){
//						c[nx][ny] = '$';
//						c[p.x][p.y]='.';
//						q.add(new Pair(c,nx,ny,p.count,c1));
//					}else if(c[nx][ny]=='#'){
//						c[nx][ny] = '$';
//						c[p.x][p.y]='.';
//						q.add(new Pair(c,nx,ny,p.count+1,c1));
//					}
//				}
//			}
//		}
//	}
//	
//	static char[][] copy(char[][] a){
//		char[][] c = new char[h][w];
//		for(int i=0;i<h;i++){
//			for(int j=0;j<w;j++){
//				c[i][j] = a[i][j];
//			}
//		}
//		return c;
//	}
//	static boolean[][] copy(boolean[][] a){
//		boolean[][] c = new boolean[h][w];
//		for(int i=0;i<h;i++){
//			for(int j=0;j<w;j++){
//				c[i][j] = a[i][j];
//			}
//		}
//		return c;
//	}
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int t = Integer.parseInt(br.readLine());
//		while(t-- >0){
//			String[] s = br.readLine().split(" ");
//			h = Integer.parseInt(s[0]);
//			w = Integer.parseInt(s[1]);
//			a1 = new char[h][w];
//			a2 = new char[h][w];
//			check1 = new boolean[h][w];
//			check2 = new boolean[h][w];
//			array1 = new ArrayList<>();
//			array2 = new ArrayList<>();
//			wall = new ArrayList<>();
//			boolean bool = false;
//			for(int i=0;i<h;i++){
//				String temp = br.readLine();
//				for(int j=0;j<w;j++){
//					a1[i][j] = temp.charAt(j);
//					a2[i][j] = a1[i][j];
//					if(a1[i][j]=='$'){
//						if(!bool){
//							x1=i;
//							y1=j;
//							a2[i][j]='.';
//							check1[i][j]=true;
//							bool = true;
//						}else{
//							x2=i;
//							y2=j;
//							a1[i][j]='.';
//							check2[i][j]=true;
//						}
//					}
//					if(a1[i][j]=='*'){
//						check1[i][j]=true;
//						check2[i][j]=true;
//					}
//					if(a1[i][j]=='#'){
//						wall.add(new XY(i,j));
//					}
//				}
//			}
//			bfs1();
//			bfs2();
//			int ans = Integer.MAX_VALUE;
//			for(Pair p1 : array1){
//				for(Pair p2 : array2){
//					int temp = p1.count + p2.count;
//					for(XY xy : wall){
//						if(p1.a[xy.x][xy.y]=='.' && p2.a[xy.x][xy.y]=='.'){
//							temp--;
//						}
//					}
//					ans = Math.min(ans, temp);
//				}
//			}
//			System.out.println(ans);
////			for(Pair p : array1){
////				System.out.println(p.toString());
////			}
////			for(Pair p : array2){
////				System.out.println(p.toString());
////			}
//		}
//	}
//}





//너무너무너무너무 오래걸린다.
//시간초과
//class Pair{
//	char[][] a;
//	int x1;
//	int y1;
//	int x2;
//	int y2;
//	int count;
//	boolean[][] check1;
//	boolean[][] check2;
//	Pair(char[][] a,int x1,int y1,int x2,int y2,int count,boolean[][] check1,boolean[][] check2){
//		this.a = a;
//		this.x1 = x1;
//		this.y1 = y1;
//		this.x2 = x2;
//		this.y2 = y2;
//		this.count = count;
//		this.check1 = check1;
//		this.check2 = check2;
//	}
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "x1 : "+x1+", y1 : "+y1+", x2 : "+x2+", y2 : "+y2+", count : "+count;
//	}
//}
//
//public class Main {
//	static int h;
//	static int w;
//	static char[][] a;
//	static boolean[][] check1;
//	static boolean[][] check2;
//	static int x1;
//	static int y1;
//	static int x2;
//	static int y2;
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {1,-1,0,0};
//	static int ans;
//	static void bfs(){
//		Queue<Pair> q = new LinkedList<>();
//		char[][] c = copy(a);
//		check1[x1][y1]=true;
//		check2[x2][y2]=true;
//		boolean[][] c1 = copy(check1);
//		boolean[][] c2 = copy(check2);
//		q.add(new Pair(c,x1,y1,x2,y2,0,c1,c2));
//		while(!q.isEmpty()){
//			Pair p = q.remove();
//			if(ans!=Integer.MAX_VALUE && p.count>=ans)continue;
//			if((p.x1==0 || p.x1==h-1 || p.y1==0 || p.y1==w-1)){
//				p.a[p.x1][p.y1]='.';
//				p.x1 = -1;
//				p.y1 = -1;
//			}
//			if((p.x2==0 || p.x2==h-1 || p.y2==0 || p.y2==w-1)){
//				p.a[p.x2][p.y2]='.';
//				p.x2 = -1;
//				p.y2 = -1;
//			}
//			if(p.x1==-1 && p.y1==-1 && p.x2==-1 && p.y2==-1){
//				ans = Math.min(ans, p.count);
//			}
//			
////			System.out.println(p.toString());
////			for(int i=0;i<h;i++){
////				for(int j=0;j<w;j++){
////					System.out.print(p.a[i][j]+" ");
////				}System.out.println();
////			}System.out.println();
////			System.out.println("check1");
////			for(int i=0;i<h;i++){
////				for(int j=0;j<w;j++){
////					System.out.print(p.check1[i][j]?"1 ":"0 ");
////				}System.out.println();
////			}System.out.println();
////			System.out.println("check2");
////			for(int i=0;i<h;i++){
////				for(int j=0;j<w;j++){
////					System.out.print(p.check2[i][j]?"1 ":"0 ");
////				}System.out.println();
////			}System.out.println();
//			
//			if(p.x1!=-1){
//				for(int i=0;i<4;i++){
//					int nx = p.x1 + dx[i];
//					int ny = p.y1 + dy[i];
//					if(nx<0 || nx>=h || ny<0 || ny>=w)continue;
//					if(!p.check1[nx][ny]){
//						if(p.a[nx][ny]=='.'){
//							c=copy(p.a);
//							c[nx][ny]='$';
//							c[p.x1][p.y1]='.';
//							c1 = copy(p.check1);
//							c1[nx][ny] = true;
//							q.add(new Pair(c,nx,ny,p.x2,p.y2,p.count,c1,p.check2));
//						}
//						if(p.a[nx][ny]=='#'){
//							c=copy(p.a);
//							c[nx][ny]='$';
//							c[p.x1][p.y1]='.';
//							c1 = copy(p.check1);
//							c1[nx][ny] = true;
//							q.add(new Pair(c,nx,ny,p.x2,p.y2,p.count+1,c1,p.check2));
//						}
//					}
//				}
//			}
//			if(p.x2!=-1){
//				for(int i=0;i<4;i++){
//					int nx = p.x2 + dx[i];
//					int ny = p.y2 + dy[i];
//					if(nx<0 || nx>=h || ny<0 || ny>=w)continue;
//					if(!p.check2[nx][ny]){
//						if(p.a[nx][ny]=='.'){
//							c=copy(p.a);
//							c[nx][ny]='$';
//							c[p.x2][p.y2]='.';
//							c2 = copy(p.check2);
//							c2[nx][ny]=true;
//							q.add(new Pair(c,p.x1,p.y1,nx,ny,p.count,p.check1,c2));
//						}
//						if(p.a[nx][ny]=='#'){
//							c=copy(p.a);
//							c[nx][ny]='$';
//							c[p.x2][p.y2]='.';
//							c2 = copy(p.check2);
//							c2[nx][ny]=true;
//							q.add(new Pair(c,p.x1,p.y1,nx,ny,p.count+1,p.check1,c2));
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	static char[][] copy(char[][] a){
//		char[][] c = new char[h][w];
//		for(int i=0;i<h;i++){
//			for(int j=0;j<w;j++){
//				c[i][j] = a[i][j];
//			}
//		}
//		return c;
//	}
//	static boolean[][] copy(boolean[][] a){
//		boolean[][] c = new boolean[h][w];
//		for(int i=0;i<h;i++){
//			for(int j=0;j<w;j++){
//				c[i][j] = a[i][j];
//			}
//		}
//		return c;
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		while(t-- >0){
//			h = sc.nextInt();
//			w = sc.nextInt();
//			a = new char[h][w];
//			check1 = new boolean[h][w];
//			check2 = new boolean[h][w];
//			sc.nextLine();
//			boolean check=false;
//			for(int i=0;i<h;i++){
//				String temp = sc.nextLine();
//				for(int j=0;j<w;j++){
//					a[i][j] = temp.charAt(j);
//					if(a[i][j]=='$'){
//						if(!check){
//							x1 = i;
//							y1 = j;
//							check = true;
//						}else{
//							x2 = i;
//							y2 = j;
//						}
//					}
//					if(a[i][j]=='*'){
//						check1[i][j]=true;
//						check2[i][j]=true;
//					}
//				}
//			}
////			System.out.println("x1 : "+x1+", y1 : "+y1+", x2 : "+x2+", y2 : "+y2);
////			for(int i=0;i<h;i++){
////				for(int j=0;j<w;j++){
////					System.out.print(a[i][j]+" ");
////				}System.out.println();
////			}System.out.println();
//			
//			ans = Integer.MAX_VALUE;
//			bfs();
//			System.out.println(ans);
//		}
//	}
//}
