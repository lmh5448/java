package problem6588;

import java.util.ArrayList;
import java.util.Scanner;
//소수문제
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[1000001];
		prime[0]=true;
		prime[1]=true;
		ArrayList<Integer> p = new ArrayList<>();
		p.clear();
		for(int i=2;i*i<=1000000;i++){
			if(prime[i]==false){
				p.add(i);
				for(int j=2;i*j<=1000000;j++){
					prime[i*j] = true;
				}
			}
		}
		while(true){
			int a = sc.nextInt();
			if(a==0)break;
			int p1=0;
			for(int i=1;i<p.size();i++){
				if(prime[a-p.get(i)]==false){
					p1=p.get(i);
					break;
				}
			}
			if(p1==0){
				System.out.println("Goldbach's conjecture is wrong.");
			}else{
				System.out.println(a+" = "+p1+" + "+(a-p1));
			}
		}
	}
}