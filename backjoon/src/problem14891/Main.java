package problem14891;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	public int n;
	public int d;
	public Pair(int n, int d){
		this.n = n;
		this.d = d;
	}
}

public class Main {
	static int[] dx = {-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = new String[4];
		String[] s1 = new String[4];
		for(int i=0;i<4;i++){
			s[i] = sc.nextLine();
			s1[i]="";
		}
		//////////////
		//µ¿ÀÛ
		int k = sc.nextInt();
		Queue<Pair> q = new LinkedList<>();
		while(k-- >0){
			int n = sc.nextInt()-1;
			int d = sc.nextInt();
			q.add(new Pair(n,d));
			boolean[] check = new boolean[4];
			while(!q.isEmpty()){
				Pair p = q.remove();
				int n1 = p.n;
				int d1 = p.d;
				if(!check[n1]){
					check[n1] = true;
					if(d1==1){
						s1[n1] = s[n1].charAt(7)+s[n1].substring(0,7);
					}else if(d1==-1){
						s1[n1] = s[n1].substring(1, 8)+s[n1].charAt(0);
					}
					for(int i=0;i<dx.length;i++){
						int nn = n1 + dx[i];
						int nd = d1*-1;
						if(nn>=0 && nn <4){
							if(i==0 && s[n1].charAt(6)!=s[nn].charAt(2)){
								q.add(new Pair(nn,nd));
							}
							if(i==1 && s[n1].charAt(2)!=s[nn].charAt(6)){
								q.add(new Pair(nn,nd));
							}
						}
					}
				}
			}
			for(int i=0;i<4;i++){
				if(!s1[i].equals("")){
					s[i] = s1[i];
					s1[i] = "";
				}
			}
		}
		//////////////
		System.out.println((s[0].charAt(0)-'0')*1+(s[1].charAt(0)-'0')*2+(s[2].charAt(0)-'0')*4+(s[3].charAt(0)-'0')*8);
	}
}
