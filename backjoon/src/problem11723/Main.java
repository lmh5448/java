package problem11723;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		int n=20;
		int s = 0;
		StringBuilder sb = new StringBuilder();
		while(t-- >0){
			String[] co = sc.nextLine().split(" ");
			if(co[0].equals("add")){
				int x = Integer.parseInt(co[1]);
				x--;
				s = (s | (1<<x));
			}else if(co[0].equals("remove")){
				int x = Integer.parseInt(co[1]);
				x--;
				s = (s & ~(1<<x));
			}else if(co[0].equals("check")){
				int x = Integer.parseInt(co[1]);
				x--;
				int res = (s & (1<<x));
				if(res == 0){
					sb.append("0\n");
				}else{
					sb.append("1\n");
				}
			}else if(co[0].equals("toggle")){
				int x = Integer.parseInt(co[1]);
				x--;
				s = (s^(1<<x));
			}else if(co[0].equals("all")){
				s = (1<<n) -1 ;
			}else if(co[0].equals("empty")){
				s=0;
			}
		}
		System.out.print(sb);
	}
}
