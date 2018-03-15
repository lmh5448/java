package problem1987;

import java.util.Scanner;

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int r;
	static int c;
	public static int go(String[] s,boolean[] check,int row,int col){
		int ans = 0;
		for(int k=0;k<4;k++){
			int nx = row+dx[k];
			int ny = col+dy[k];
			if(nx>=0 && nx<r && ny>=0 && ny<c){
				if(check[s[nx].charAt(ny)-'A']==false){
					check[s[nx].charAt(ny)-'A']=true;
					int next = go(s,check,nx,ny);
					if(ans<next) ans = next;
					check[s[nx].charAt(ny)-'A']=false;
				}
			}
		}
		return ans + 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();
		String[] s = new String[r];
		boolean[] check = new boolean[26];
		for(int i=0;i<r;i++){
			s[i] = sc.nextLine();
		}
		check[s[0].charAt(0)-'A']=true;
		System.out.println(go(s,check,0,0));
	}
}
