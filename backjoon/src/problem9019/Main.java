package problem9019;

import java.util.*;

public class Main {
	static int max = 10000;
	static int d(int n){
		return (n*2)%max;
	}
	static int s(int n){
		if(n==0){
			return 9999;
		}else{
			return n-1;
		}
	}
	static int l(int n){
		return (n%1000)*10 + n/1000;
	}
	static int r(int n){
		return n/10 + (n%10)*1000;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			int[] from = new int[10001];
			Arrays.fill(from,-1);
			char[] how = new char[10001];
			Queue<Integer> q = new LinkedList<Integer>();
			int a = sc.nextInt();
			int b = sc.nextInt();
			q.add(a);
			while(!q.isEmpty()){
				int temp = q.remove();
				if(temp == b) break;
				if(from[d(temp)]==-1){
					q.add(d(temp));
					from[d(temp)] = temp;
					how[d(temp)] = 'D';
				}
				if(from[s(temp)]==-1){
					q.add(s(temp));
					from[s(temp)] = temp;
					how[s(temp)] = 'S';
				}
				if(from[l(temp)]==-1){
					q.add(l(temp));
					from[l(temp)] = temp;
					how[l(temp)] = 'L';
				}
				if(from[r(temp)]==-1){
					q.add(r(temp));
					from[r(temp)] = temp;
					how[r(temp)] = 'R';
				}
			}
			Stack<Character> s = new Stack<Character>();
			while(b!=a){
				s.push(how[b]);
				b = from[b];
			}
			while(!s.isEmpty()){
				System.out.print(s.pop());
			}
			System.out.println();
		}	
	}
}