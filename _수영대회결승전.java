import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _수영대회결승전 {

	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int sea[][];
	static int fullsea[][];
	static StringTokenizer st;
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int n, s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			sea = new int[n][n];
			fullsea = new int[n][n];

			for (int i = 0; i < fullsea.length; i++) {
				Arrays.fill(fullsea[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sea[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			node start = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			node end = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			
			bfs(start.x, start.y);
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(fullsea[i][j] + " ");
				}
				System.out.println();
			}

			sb.append("#" + t + " " + fullsea[end.x][end.y]);
			
		}
		System.out.println(sb);
	}

	public static void bfs(int i, int j) {
		Queue<node> que = new LinkedList<>();

		fullsea[i][j] = sea[i][j] +1 ;

		que.offer(new node(i, j));

		while (!que.isEmpty()) {
			node no = que.poll();

			for (int c = 0; c < 4; c++) {
				int nexti = no.x + di[c];
				int nextj = no.y + dj[c];

				if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && sea[nexti][nextj] != 1 ) {
					if (sea[nexti][nextj] == 0) {
						s = 1;
					} else if (sea[nexti][nextj] == 2){
						s = 2;
					}
					if (fullsea[nexti][nextj] > fullsea[no.x][no.y] + s) {
						
						fullsea[nexti][nextj] = fullsea[no.x][no.y] + s;
						
						que.offer(new node(nexti, nextj));
					}

				}
			}
		}

	}
}
