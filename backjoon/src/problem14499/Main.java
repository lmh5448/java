package problem14499;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		int[] dice = new int[6];
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			q.add(sc.nextInt());
		}
		while(!q.isEmpty()){
			int temp = q.remove();
			if(temp==1){
				y++;
				if(x>=0 && x<n && y>=0 && y<m){
					int num = dice[1];
					dice[1] = dice[2];
					dice[2] = dice[3];
					dice[3] = dice[5];
					dice[5] = num;
					if(a[x][y]==0){
						a[x][y] = dice[2];
					}else{
						dice[2] = a[x][y];
						a[x][y] = 0;
					}
					System.out.println(dice[5]);
				}else{
					y--;
				}
			}else if(temp==2){
				y--;
				if(x>=0 && x<n && y>=0 && y<m){
					int num = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[3];
					dice[3] = dice[2];
					dice[2] = num;
					if(a[x][y]==0){
						a[x][y] = dice[2];
					}else{
						dice[2] = a[x][y];
						a[x][y] = 0;
					}
					System.out.println(dice[5]);
				}else{
					y++;
				}
			}else if(temp==3){
				x--;
				if(x>=0 && x<n && y>=0 && y<m){
					int num = dice[0];
					dice[0] = dice[5];
					dice[5] = dice[4];
					dice[4] = dice[2];
					dice[2] = num;
					if(a[x][y]==0){
						a[x][y] = dice[2];
					}else{
						dice[2] = a[x][y];
						a[x][y] = 0;
					}
					System.out.println(dice[5]);
				}else{
					x++;
				}
			}else if(temp==4){
				x++;
				if(x>=0 && x<n && y>=0 && y<m){
					int num = dice[0];
					dice[0] = dice[2];
					dice[2] = dice[4];
					dice[4] = dice[5];
					dice[5] = num;
					if(a[x][y]==0){
						a[x][y] = dice[2];
					}else{
						dice[2] = a[x][y];
						a[x][y] = 0;
					}
					System.out.println(dice[5]);
				}else{
					x--;
				}
			}
		}
	}
}
