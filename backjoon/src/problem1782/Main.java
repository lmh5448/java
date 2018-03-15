package problem1782;

import java.util.Scanner;

//´äÀº µÌ´Ù.
public class Main {
	static int ans = 0;
	static long a;
	static long b;
	static void go(String s){
		if(s.length()>=20)return;
		long temp  = Long.parseLong(s);
		if(temp>=a && temp<=b)ans++;
		if(temp>b)return;
		if(s.length()%2==0){
			int index = s.length()/2;
			String front = s.substring(0, index);
			String back = s.substring(index, s.length());
			go(front+"0"+back);
			go(front+"1"+back);
			go(front+"8"+back);
			go(front+"00"+back);
			go(front+"11"+back);
			go(front+"88"+back);
			go(front+"25"+back);
			go(front+"52"+back);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		go("0");
		go("1");
		go("8");
		go("11");
		go("88");
		go("25");
		go("52");
		System.out.println(ans);
	}
}
