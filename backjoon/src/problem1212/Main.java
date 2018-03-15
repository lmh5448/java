package problem1212;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] chg = {"000","001","010","011","100","101","110","111"};
		String[] chgFirst = {"","1","10","11","100","101","110","111"};
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		if(temp.length()==1&&temp.charAt(0)=='0')System.out.print("0");
		for(int i=0;i<temp.length();i++){
			if(i==0){
				System.out.print(chgFirst[temp.charAt(i)-'0']);
			}else{
				System.out.print(chg[temp.charAt(i)-'0']);
			}
		}System.out.println();
	}

}
