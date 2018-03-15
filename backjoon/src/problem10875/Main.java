package problem10875;

/*
 * ���ǻ��� ���� integer�� ���� �� �ִ�.
 * Long�����
 * ������ ���ؼ� ���� �ȿ� �ִ��� �ۿ��ִ��� �Ǻ��Ҷ��� �����÷ο�� ����� �� ����� �ȳ�����
 * �׷��� 0�� �ƴϸ� ���밪���� ����� ��ȣ�� Ȯ��ó��
 * ��ġ�� ���� Ȯ���ϴ� �Լ����� ������ �κ� ó���ϴٰ� ���� Ʋ����
 * ����Ǯ�̰� �ִ��� Ȯ������
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
				//l1�� y�࿡ ����, l2�� y�࿡ ����
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
				//y�������� ������ ���� �� x�������� ������ ����
				//return -1;���� �ص� ����
			}else{
				//l1�� y�࿡ ����, l2�� x�࿡ ����
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
				//l1�� x�࿡ ����, l2�� y�࿡ ����
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
				//l1�� x�࿡ ����, l2�� x�࿡ ����
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
				//x�� ���൵ return -1���� �ص� ���������� ���ۼ��п��� �񱳵� ����� ����ó��
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int d = 0;
		//���� ��������
		ArrayList<Line> lines = new ArrayList<Line>();
		//�׵θ�
		lines.add(new Line(-1-l,-1-l,1+l,-1-l));
		lines.add(new Line(-1-l,-1-l,-1-l,1+l));
		lines.add(new Line(1+l,1+l,1+l,-1-l));
		lines.add(new Line(1+l,1+l,-1-l,1+l));
		//������
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
//���� ����� �迭�� ���� ���� �� Ȯ���ϴ� ��� ������ �޸𸮰� �ʹ� Ŀ�� ���� �� ����.
//�ٸ� ����� ã�ƺ���
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
