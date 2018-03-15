package nhn;

import java.util.*;

public class Main {
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
	
	public static int chk(int[][] a,int x,int y,int t,int n){
		int[] d = new int[4];
		for(int i=0;i<4;i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n){
				if(a[x][y] == a[nx][ny]){
					d[i]=1;
				}
			}
		}
		if(d[0]==0 && d[1]==0 && d[2]==0 && d[3]==0){
			return 0 + 16*t;
		}else if(d[0]==1 && d[1]==0 && d[2]==0 && d[3]==0){
			return 1 + 16*t;
		}else if(d[0]==0 && d[1]==0 && d[2]==0 && d[3]==1){
			return 2 + 16*t;
		}else if(d[0]==1 && d[1]==0 && d[2]==0 && d[3]==1){
			return 3 + 16*t;
		}else if(d[0]==0 && d[1]==1 && d[2]==0 && d[3]==0){
			return 4 + 16*t;
		}else if(d[0]==1 && d[1]==1 && d[2]==0 && d[3]==0){
			return 5 + 16*t;
		}else if(d[0]==0 && d[1]==1 && d[2]==0 && d[3]==1){
			return 6 + 16*t;
		}else if(d[0]==1 && d[1]==1 && d[2]==0 && d[3]==1){
			return 7 + 16*t;
		}else if(d[0]==0 && d[1]==0 && d[2]==1 && d[3]==0){
			return 8 + 16*t;
		}else if(d[0]==1 && d[1]==0 && d[2]==1 && d[3]==0){
			return 9 + 16*t;
		}else if(d[0]==0 && d[1]==0 && d[2]==1 && d[3]==1){
			return 10 + 16*t;
		}else if(d[0]==1 && d[1]==0 && d[2]==1 && d[3]==1){
			return 11 + 16*t;
		}else if(d[0]==0 && d[1]==1 && d[2]==1 && d[3]==0){
			return 12 + 16*t;
		}else if(d[0]==1 && d[1]==1 && d[2]==1 && d[3]==0){
			return 13 + 16*t;
		}else if(d[0]==0 && d[1]==1 && d[2]==1 && d[3]==1){
			return 14 + 16*t;
		}else{
			return 15 + 16*t;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[][] result = new int[len][len];
		int[][] a = new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				a[i][j] = sc.next().charAt(0)-'A';
				if(a[i][j]==-17){
					a[i][j]=-1;
					result[i][j]=-1;
				}
			}
		}
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(a[i][j]!=-1){
					result[i][j] = chk(a,i,j,a[i][j],len);
				}
			}
		}
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				System.out.print(result[i][j]);
				if(j<len-1){
					System.out.print(" ");
				}
			}System.out.println();
		}
	}
}
