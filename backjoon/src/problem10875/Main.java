package problem10875;

/*
 * 유의사항 답이 integer를 넘을 수 있다.
 * Long형사용
 * 곱셈을 통해서 점이 안에 있는지 밖에있는지 판별할때에 오버플로우로 제대로 된 결과가 안나왔음
 * 그래서 0이 아니면 절대값으로 나누어서 부호만 확인처리
 * 겹치는 것을 확인하는 함수에서 평행인 부분 처리하다가 많이 틀렸음
 * 쉬운풀이가 있는지 확인하자
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Line{
	int s_x,s_y,e_x,e_y;
	Line(int s_x,int s_y,int e_x,int e_y){
		this.s_x = s_x;
		this.s_y = s_y;
		this.e_x = e_x;
		this.e_y = e_y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "s_x : "+this.s_x+", "+"s_y : "+this.s_y+", "+"e_x : "+this.e_x+", "+"e_y : "+this.e_y;
	}
}

public class Main {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	static int iscross(Line l1,Line l2){
		int temp1,temp2;
		if(l1.s_x==l1.e_x){
			if(l2.s_x==l2.e_x){
				//l1이 y축에 평행, l2가 y축에 평행
				if(l1.s_x==l2.s_x){
					temp1 = (l2.e_y-l1.s_y);
					if(temp1!=0)temp1 /= Math.abs(l2.e_y-l1.s_y);
					temp2 = (l2.e_y-l1.e_y);
					if(temp2!=0)temp2 /=Math.abs(l2.e_y-l1.e_y);
					if(temp1*temp2<=0){
						//System.out.println(" 1");
						return Math.min(Math.abs(l2.s_y-l1.s_y),Math.abs(l2.s_y-l1.e_y));
					}else{
						return -1;
					}
				}else{
					return -1;
				}
				//y축평행은 무조건 양쪽 끝 x축평행인 선분이 존재
				//return -1;으로 해도 무방
			}else{
				//l1이 y축에 평행, l2가 x축에 평행
				temp1 = (l2.e_y-l1.s_y);
				if(temp1!=0)temp1 /= Math.abs(l2.e_y-l1.s_y);
				temp2 = (l2.e_y-l1.e_y);
				if(temp2!=0)temp2 /= Math.abs(l2.e_y-l1.e_y);
				if(temp1*temp2<=0){
					temp1 = (l1.s_x-l2.s_x);
					if(temp1!=0)temp1/=Math.abs(l1.s_x-l2.s_x);
					temp2 = (l1.s_x-l2.e_x);
					if(temp2!=0)temp2/=Math.abs(l1.s_x-l2.e_x);
					if((l2.e_x==l1.s_x)||(temp1*temp2<0)){
						//System.out.println("  2");
						return Math.abs(l2.s_x-l1.s_x);
					}else{
						return -1;
					}
				}else{
					return -1;
				}
			}
		}else{
			if(l2.s_x==l2.e_x){
				//l1이 x축에 평행, l2가 y축에 평행
				temp1 = (l2.e_x-l1.s_x);
				if(temp1!=0)temp1/=Math.abs(l2.e_x-l1.s_x);
				temp2 = (l2.e_x-l1.e_x);
				if(temp2!=0)temp2/=Math.abs(l2.e_x-l1.e_x);
				if(temp1*temp2<=0){
					temp1 = (l1.s_y-l2.s_y);
					if(temp1!=0)temp1/=Math.abs(l1.s_y-l2.s_y);
					temp2 = (l1.s_y-l2.e_y);
					if(temp2!=0)temp2/=Math.abs(l1.s_y-l2.e_y);
					if((l2.e_y==l1.s_y)||(temp1*temp2<0)){
						//System.out.println(" 3");
						return Math.abs(l2.s_y-l1.s_y);
					}else{
						return -1;
					}
				}else{
					return -1;
				}
			}else{
				//l1이 x축에 평행, l2가 x축에 평행
				if(l1.s_y==l2.s_y){
					temp1 = (l2.e_x-l1.s_x);
					if(temp1!=0)temp1/=Math.abs(l2.e_x-l1.s_x);
					temp2 = (l2.e_x-l1.e_x);
					if(temp2!=0)temp2/=Math.abs(l2.e_x-l1.e_x);
					if(temp1*temp2<=0||((l1.s_x==0)&&(l1.s_y==0)&&(l2.e_x>l1.s_x)&&(l2.e_x>l1.e_x)&&(l2.s_x<l1.s_x))){
						//System.out.println(" 4");
						return Math.min(Math.abs(l2.s_x-l1.s_x), Math.abs(l2.s_x-l1.e_x));
					}else{
						return -1;
					}
				}else{
					return -1;
				}
				//x축 평행도 return -1으로 해도 무방하지만 시작선분에서 비교될 경우의 예외처리
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int d = 0;
		//이전 선분저장
		ArrayList<Line> lines = new ArrayList<Line>();
		//테두리
		lines.add(new Line(-1-l,-1-l,1+l,-1-l));
		lines.add(new Line(-1-l,-1-l,-1-l,1+l));
		lines.add(new Line(1+l,1+l,1+l,-1-l));
		lines.add(new Line(1+l,1+l,-1-l,1+l));
		//시작점
		Line line = new Line(0,0,0,0);
		//long ans = 0;
		BigInteger ans = BigInteger.ZERO;
		Queue<String> q = new LinkedList<>();
		while(n-- >0){
			q.add(sc.nextLine());
		}
		if(q.isEmpty()){
			q.add((2*l+1)+" L");
		}
		while(!q.isEmpty()){
			String[] s = q.remove().split(" ");
			int len = Integer.parseInt(s[0]);
			line.e_x = line.e_x + len*dx[d];
			line.e_y = line.e_y + len*dy[d];
			int count = Integer.MAX_VALUE;
			for(Line temp : lines){
				int v = iscross(temp,line);
				if(v!=-1){
					count = Math.min(count, v);
				}
			}
			
//			System.out.println("n :"+q.size());
//			for(int i=0;i<lines.size();i++){
//				Line line1 = lines.get(i);
//				System.out.println("i : "+i);
//				System.out.println("sx sy ex ey : "+line1.s_x+" "+line1.s_y+" "+line1.e_x+" "+line1.e_y);
//			}
			
			if(count == Integer.MAX_VALUE){
				//ans+=len;
				ans = ans.add(BigInteger.valueOf((long)len));
				//System.out.println("len : "+len);
				lines.add(new Line(line.s_x,line.s_y,line.e_x,line.e_y));
				if(q.isEmpty()){
					q.add((2*l+2)+" L");
				}
			}else{
				//System.out.println("count : "+count);
				//ans+=count;
				ans = ans.add(BigInteger.valueOf((long)count));
				break;
			}
			if(s[1].charAt(0)=='L'){
				d = (d+3)%4;
			}else{
				d = (d+1)%4;				
			}
			line.s_x = line.e_x;
			line.s_y = line.e_y;
			
			
		}
		System.out.println(ans.toString());
	}
}
//밑의 방법은 배열을 전부 선언 후 확인하는 방법 하지만 메모리가 너무 커서 잡을 수 없다.
//다른 방법을 찾아보자
/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

class Direction{
	int t;
	char d;
	Direction(int t,char d){
		this.t = t;
		this.d = d;
	}
}

public class Main {
	static Queue<Direction> q;
	static boolean[][] a;
	
	static int ans = 0;
	static int count=0;
	static char lr;
	static int l;
	static int l2;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static void dfs(int x,int y,int d){
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(nx>=0 && nx<l2 && ny>=0 && ny<l2){
			if(a[nx][ny]){
				ans++;
				return;
			}else{
				a[nx][ny]=true;
				ans++;
				count--;
				if(count==0){
					if(lr=='R'){
						d = (d+1)%4;
					}else{
						d = (d+3)%4;
					}
					if(!q.isEmpty()){
						Direction di = q.remove();
						count = di.t;
						lr = di.d;
					}else{
						count = Integer.MAX_VALUE;
					}
				}
				dfs(nx,ny,d);
			}
		}else{
			ans++;
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		l2 = 2*l+1;
		int n = sc.nextInt();
		sc.nextLine();
		a = new boolean[l2][l2];
		q = new LinkedList<Direction>();
		while(n-- >0){
			String temp = sc.nextLine();
			String[] s = temp.split(" ");
			q.add(new Direction(Integer.parseInt(s[0]),s[1].charAt(0)));
		}
		if(!q.isEmpty()){
			Direction d = q.remove();
			count = d.t;
			lr = d.d;
		}else{
			count=Integer.MAX_VALUE;
		}
		a[l][l] = true;
		dfs(l,l,0);
//		for(int i=0;i<l2;i++){
//			for(int j=0;j<l2;j++){
//				System.out.print(a[i][j]+"\t");
//			}System.out.println();
//		}
//		System.out.println();
		System.out.println(ans);
	}
}*/
