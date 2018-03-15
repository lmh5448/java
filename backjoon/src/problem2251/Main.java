package problem2251;

import java.util.*;

class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		boolean[][] check = new boolean[a+1][b+1];
		boolean[] ans = new boolean[c+1];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
		check[0][0] = true;
		ans[c] = true;
		while(!q.isEmpty()){
			Pair pair = q.remove();
			int x = pair.x;
			int y = pair.y;
			int z = c-x-y;
			// x->y
			y += x;
			x = 0;
			if(y>b){
				x = y-b;
				y = b;
			}
			if(!check[x][y]){
				check[x][y] = true;
				q.add(new Pair(x,y));
				if(x==0){
					ans[z] = true;
				}
			}
			// x->z
			x = pair.x;
			y = pair.y;
			z = c-x-y;
			z += x;
			x = 0;
			if(z>c){
				x = z-c;
				z = c;
			}
			if(!check[x][y]){
				check[x][y] = true;
				q.add(new Pair(x,y));
				if(x==0){
					ans[z] = true;
				}
			}
			// y->x
			x = pair.x;
			y = pair.y;
			z = c-x-y;
			x += y;
			y = 0;
			if(x>a){
				y = x-a;
				x = a;
			}
			if(!check[x][y]){
				check[x][y] = true;
				q.add(new Pair(x,y));
				if(x==0){
					ans[z] = true;
				}
			}
			// y->z
			x = pair.x;
			y = pair.y;
			z = c-x-y;
			z += y;
			y = 0;
			if(z>c){
				y = z-c;
				z = c;
			}
			if(!check[x][y]){
				check[x][y] = true;
				q.add(new Pair(x,y));
				if(x==0){
					ans[z] = true;
				}
			}
			// z->x
			x = pair.x;
			y = pair.y;
			z = c-x-y;
			x += z;
			z = 0;
			if(x>a){
				z = x-a;
				x = a;
			}
			if(!check[x][y]){
				check[x][y] = true;
				q.add(new Pair(x,y));
				if(x==0){
					ans[z] = true;
				}
			}
			// z->y
			x = pair.x;
			y = pair.y;
			z = c-x-y;
			y += z;
			z = 0;
			if(y>b){
				z = y-b;
				y = b;
			}
			if(!check[x][y]){
				check[x][y] = true;
				q.add(new Pair(x,y));
				if(x==0){
					ans[z] = true;
				}
			}
		}
		for(int i=0;i<c+1;i++){
			if(ans[i]){
				System.out.print(i+" ");
			}
		}
	}
}
