package problem2580;

import java.util.Scanner;

public class Main {
	public static boolean go(int[][] a,boolean[][][] c,int z){
		if(z==81){
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}
		int x = z/9;
		int y = z%9;
		if(a[x][y]!=0){
			return go(a,c,z+1);
		}
		else{
			for(int i=1;i<=9;i++){
				if(!c[0][x][i] && !c[1][y][i] && !c[2][(x/3)*3+y/3][i]){
					c[0][x][i] = c[1][y][i] = c[2][(x/3)*3+y/3][i] = true;
					a[x][y] = i;
					if(go(a,c,z+1)){
						return true;
					}
					a[x][y] = 0;
					c[0][x][i] = c[1][y][i] = c[2][(x/3)*3+y/3][i] = false;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[9][9];
		boolean[][][] c = new boolean[3][9][10];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				a[i][j] = sc.nextInt();
				c[0][i][a[i][j]] = true;
				c[1][j][a[i][j]] = true;
				c[2][(i/3)*3+j/3][a[i][j]] = true;
			}
		}
		go(a,c,0);
	}
}
