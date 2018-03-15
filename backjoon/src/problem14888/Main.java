package problem14888;

import java.util.Scanner;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void go(String s,int[] a,int[] op,int n,int plus,int minus,int multi,int divid){
		if(s.length()==n){
			int result = a[0];
			for(int i=1;i<n;i++){
				if(s.charAt(i)=='1'){
					result += a[i];
				}else if(s.charAt(i)=='2'){
					result -= a[i];
				}else if(s.charAt(i)=='3'){
					result *= a[i];
				}else if(s.charAt(i)=='4'){
					result /= a[i];
				}
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		if(op[0]>plus)go(s+"1",a,op,n,plus+1,minus,multi,divid);
		if(op[1]>minus)go(s+"2",a,op,n,plus,minus+1,multi,divid);
		if(op[2]>multi)go(s+"3",a,op,n,plus,minus,multi+1,divid);
		if(op[3]>divid)go(s+"4",a,op,n,plus,minus,multi,divid+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int[] op = new int[4];
		//0:+, 1:-, 2:*, 3:/
		for(int i=0;i<4;i++){
			op[i] = sc.nextInt();
		}
		go(" ",a,op,n,0,0,0,0);
		System.out.println(max);
		System.out.println(min);
	}
}
