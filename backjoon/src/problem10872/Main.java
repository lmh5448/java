package problem10872;

import java.util.Scanner;

//10872, 1676
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;
		count += (int)a/5;
		count += (int)a/25;
		count += (int)a/125;
		System.out.println(count);
	}
}
