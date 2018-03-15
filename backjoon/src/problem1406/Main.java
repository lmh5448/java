package problem1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> ls = new Stack<Character>();
		Stack<Character> rs = new Stack<Character>();
		String temp = br.readLine();
		for(int i=0;i<temp.length();i++){
			ls.push(temp.charAt(i));
		}
		int t = Integer.parseInt(br.readLine());
		while(t-- >0){
			String[] temp2 = br.readLine().split(" ");
			if(temp2[0].equals("L")){
				if(!ls.isEmpty())rs.push(ls.pop());
			}else if(temp2[0].equals("D")){
				if(!rs.isEmpty())ls.push(rs.pop());
			}else if(temp2[0].equals("B")){
				if(!ls.isEmpty())ls.pop();
			}else if(temp2[0].equals("P")){
				ls.push(temp2[1].charAt(0));
			}
		}
		while(!ls.isEmpty()){
			rs.push(ls.pop());
		}
		StringBuilder sb = new StringBuilder();
		while(!rs.isEmpty()){
			sb.append(rs.pop());
		}
		System.out.println(sb);
	}
}
