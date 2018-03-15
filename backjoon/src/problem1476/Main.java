package problem1476;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int e1 = 1;
		int s1 = 1;
		int m1 = 1;
		int cnt = 1;
		while(!(e==e1 && s==s1 && m==m1)){
			e1++;
			s1++;
			m1++;
			cnt++;
			if(e1==16)e1-=15;
			if(s1==29)s1-=28;
			if(m1==20)m1-=19;
		}
		System.out.println(cnt);
	}
}
