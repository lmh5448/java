package problem2011;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//잘못된 알고리즘 예외가있는데 무슨예외인지 못찾겠다....
		/*Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] cstr = str.toCharArray();
		int mod = 1000000;
		int len = cstr.length;
		int[] d = new int[len];
		d[0]=1;
		for(int i=1;i<len;i++){
			if(cstr[i]-'0'==0){
				if(i>=2)d[i] = d[i-2];
				else d[1]=1;
			}else if(cstr[i-1]-'0'==1){
				if(i>=2)d[i] = d[i-1]+d[i-2];
				else d[1]=2;
			}else if((cstr[i-1]-'0'==2)&&(cstr[i]-'0'>=1)&&(cstr[i]-'0'<=6)){
				if(i>=2)d[i] = d[i-1]+d[i-2];
				else d[1]=2;
			}else{
				d[i] = d[i-1];
			}
			d[i]%=mod;
		}
		System.out.println(d[len-1]);*/
		/////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		int mod = 1000000;
		String s = sc.nextLine();
		int len = s.length();
		s = " " + s;
		int[] d = new int[len+1];
		d[0] = 1;
		for(int i=1;i<=len;i++){
			int x = s.charAt(i)-'0';
			if(x>=1 && x<=9){
				d[i] += d[i-1];
				d[i] %= mod;
			}
			if(i==1)continue;
			if(s.charAt(i-1)=='0')continue;
			x = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
			if(x>=10 && x<=26){
				d[i] += d[i-2];
				d[i] %= mod;
			}
		}
		System.out.println(d[len]);
	}
}
