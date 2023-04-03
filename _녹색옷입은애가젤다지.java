import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _녹색옷입은애가젤다지 {

	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	static int min = Integer.MAX_VALUE;
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int visit[][];
	static int n, cnt;
	static int cave[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			n = Integer.parseInt(br.readLine());
			cnt++;

			if (n == 0)
				break;

			cave = new int[n][n];
			visit = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < visit.length; i++) {
				Arrays.fill(visit[i], Integer.MAX_VALUE);
			}

			bfs(0, 0);
			sb.append("Problem" + " " + cnt + ":" + " " + visit[n - 1][n - 1] + "\n");

		}
		System.out.println(sb);
	}

	public static void bfs(int i, int j) {

		Queue<node> que = new LinkedList<>();

		visit[i][j] = cave[i][j];

		que.offer(new node(i, j));

		while (!que.isEmpty()) {

			node no = que.poll();

			for (int c = 0; c < 4; c++) {
				int nexti = no.x + di[c];
				int nextj = no.y + dj[c];

				if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n) {
					if (visit[nexti][nextj] > cave[nexti][nextj] + visit[no.x][no.y]) {
						visit[nexti][nextj] = cave[nexti][nextj] + visit[no.x][no.y];
						que.offer(new node(nexti, nextj));
					}

				}

			}
		}

	}
}
