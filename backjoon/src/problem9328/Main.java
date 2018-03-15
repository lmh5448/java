package problem9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x : "+x+", y : "+y;
	}
}

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0){
			String[] ss = br.readLine().split(" ");
			int h = Integer.parseInt(ss[0]);
			int w = Integer.parseInt(ss[1]);
			char[][] a = new char[h+2][w+2];
			for(int i=0;i<h+2;i++){
				for(int j=0;j<w+2;j++){
					a[i][j]='.';
				}
			}
			HashMap<Character, Integer> keys = new HashMap<>();
			for(int i=1;i<=h;i++){
				String s = br.readLine();
				for(int j=1;j<=w;j++){
					a[i][j]=s.charAt(j-1);
				}
			}
			String key = br.readLine();
			for(int i=0;i<key.length();i++){
				keys.put(key.charAt(i), 0);
			}
			boolean check = true;
			int ans=0;
			while(check){
				check=false;
				Queue<Pair> q = new LinkedList<>();
				boolean[][] visit = new boolean[h+2][w+2];
				q.add(new Pair(0,0));
				visit[0][0]=true;
				while(!q.isEmpty()){
					Pair p = q.remove();
					int x = p.x;
					int y = p.y;
					for(int i=0;i<4;i++){
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(nx<0 || nx>h+1 || ny<0 || ny>w+1)continue;
						if(!visit[nx][ny]){
							visit[nx][ny]=true;
							if(a[nx][ny]=='.'){
								q.add(new Pair(nx,ny));
							}else if(a[nx][ny]=='$'){
								a[nx][ny]='.';
								ans++;
								q.add(new Pair(nx,ny));
								check=true;
							}else if(a[nx][ny]>='A' && a[nx][ny]<='Z'){
//								if(a[nx][ny]=='C'){
//									System.out.println(keys.containsKey((char)(a[nx][ny]-'A'+'a')));
//									System.out.println((char)(a[nx][ny]-'A'+'a'));
//								}
								if(keys.containsKey((char)(a[nx][ny]-'A'+'a'))){
									a[nx][ny]='.';
									q.add(new Pair(nx,ny));
									check=true;
								}
							}else if(a[nx][ny]>='a' && a[nx][ny]<='z'){
								keys.put(a[nx][ny], 0);
								a[nx][ny]='.';
								q.add(new Pair(nx,ny));
								check=true;
							}
						}
					}
				}
//				System.out.println("a array");
//				for(int i=0;i<h+2;i++){
//					for(int j=0;j<w+2;j++){
//						System.out.print(a[i][j]+" ");
//					}System.out.println();
//				}System.out.println();
//				System.out.println();
//				System.out.println("keys");
//				for(char c:keys.keySet()){
//					System.out.print(c+" ");
//				}
			}
			System.out.println(ans);
		}
	}
}
