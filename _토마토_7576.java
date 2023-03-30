package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _토마토_7576 {
	static class node {
		int x;
		int y;
		int t;

		node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static boolean visit[][];
	static int box[][];
	static Queue<node> que = new LinkedList<>();
	static int n, m, time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					que.offer(new node(i, j, 0));
				}
			}

		}

		bfs();
		check();
		System.out.println(time);

	}

	public static void bfs() {

		while (!que.isEmpty()) {
			node no = que.poll();
			time = no.t;
			visit[no.x][no.y] = true;

			for (int c = 0; c < 4; c++) {

				int nexti = no.x + di[c];
				int nextj = no.y + dj[c];

				if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && !visit[nexti][nextj]
						&& box[nexti][nextj] == 0) {
					visit[nexti][nextj] = true;
					que.offer(new node(nexti, nextj, no.t + 1));

				}
			}
		}

	}

	public static void check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0 && !visit[i][j])
					time = -1;
			}
		}
	}
}
