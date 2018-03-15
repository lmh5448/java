package problem2331;

import java.util.Scanner;

public class Main {
	static int[] d = new int[1000001];
	static int len(int num,int count,int p){
		if(d[num]==0){
			d[num]=count;
			return len(f(num,p),count+1,p);
		}else{
			return d[num]-1;
		}
	}
	
	static int f(int num,int p){
		int result = 0;
		while(num>0){
			result += (int)Math.pow(num%10, p);
			num/=10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int p = sc.nextInt();
		System.out.println(len(a,1,p));
	}
}
