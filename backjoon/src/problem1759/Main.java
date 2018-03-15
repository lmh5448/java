package problem1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int l;
	public static int c;
	public static void go(int n, char[] array, String password,int i){
		if(password.length()==l){
			if(check(password)){
				System.out.println(password);
			}
			return;
		}
		if(i>=c) return;
		go(n,array,password+array[i],i+1);
		go(n,array,password,i+1);
	}
	
	public static boolean check(String s){
		int ja = 0;
		int mo = 0;
		for(int i=0;i<s.length();i++){
			char temp = s.charAt(i);
			if(temp=='a' || temp =='e' || temp=='i' || temp=='o' || temp=='u'){
				mo++;
			}else{
				ja++;
			}
		}
		if(ja>=2 && mo>=1){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		char[] array = new char[c];
		for(int i=0;i<c;i++){
			array[i] = sc.next().charAt(0);
		}
		Arrays.sort(array);
		go(l,array,"",0);
	}
}
