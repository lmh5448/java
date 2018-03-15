package problem9465;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0){
			int len = sc.nextInt();
			int[][] a = new int[len+1][2];
			int[][] d = new int[len+1][3];
			for(int i=0;i<2;i++){
				for(int j=1;j<=len;j++){
					a[j][i]=sc.nextInt();
				}
			}
			d[1][0]=0;
			d[1][1]=a[1][0];
			d[1][2]=a[1][1];
			for(int i=2;i<=len;i++){
				d[i][0] = d[i-1][1] > d[i-1][2] ? d[i-1][1] : d[i-1][2];
				d[i][1] = (d[i-1][2] > d[i-1][0] ? d[i-1][2] : d[i-1][0]) + a[i][0];
				d[i][2] = (d[i-1][1] > d[i-1][0] ? d[i-1][1] : d[i-1][0]) + a[i][1];
			}
			int result = 0;
			for(int i=0;i<3;i++){
				if(result < d[len][i]){
					result = d[len][i];
				}
			}
			System.out.println(result);
		}
	}
}
