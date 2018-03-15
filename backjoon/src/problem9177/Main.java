package problem9177;

import java.util.Scanner;

public class Main {
	static String a;
	static String b;
	static String c;
	static int[][] d = new int[201][201];
	
	public static int go(int i,int j){
		if(d[i][j]!=-1)return d[i][j];
		if(a.length()==i && b.length()==j)return 1;
		d[i][j]=0;
		if(a.length()!=i && a.charAt(i)==c.charAt(i+j)){
			if(go(i+1,j)==1)d[i][j]=1;
		}
		if(b.length()!=j && b.charAt(j)==c.charAt(i+j)){
			if(go(i,j+1)==1)d[i][j]=1;
		}
		return d[i][j];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++){
			a = sc.next();
			b = sc.next();
			c = sc.next();
			for(int i=0;i<201;i++){
				for(int j=0;j<201;j++){
					d[i][j] = -1;
				}
			}
			System.out.printf("Data set %d: %s\n",tc,(go(0,0)==1 ? "yes" : "no"));
		}
	}
}
