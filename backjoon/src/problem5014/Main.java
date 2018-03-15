package problem5014;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();//������
		int s = sc.nextInt();//�����ִ� ����
		int g = sc.nextInt();//���ߵǴ� ����
		int u = sc.nextInt();//���ΰ����ִ� ��
		int d = sc.nextInt();//���������ִ� ��
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean[] check = new boolean[f+1];
		map.put(s, 0);
		check[s] = true;
		q.add(s);
		while(!q.isEmpty()){
			int now = q.remove();
			int down_next = now-d;
			int up_next = now+u;
			if(down_next>0 && !check[down_next]){
				check[down_next] = true;
				map.put(down_next, map.get(now)+1);
				q.add(down_next);
			}
			if(up_next<=f && !check[up_next]){
				check[up_next] = true;
				map.put(up_next, map.get(now)+1);
				q.add(up_next);
			}
		}
		if(check[g]){
			System.out.println(map.get(g));
		}else{
			System.out.println("use the stairs");
		}
	}
}
