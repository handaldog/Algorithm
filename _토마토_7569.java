package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _토마토_7569 {
	static class node {
		int x;
		int y;
		int z;
		int t;

		node(int x, int y, int z, int t) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.t = t;

		}
	}

	static Queue<node> que = new LinkedList<node>();
	static int box[][][];
	static int h, n, m;
	static boolean visit[][][];
	static int time;
	static int di[] = { 1, -1, 0, 0, 0, 0 };
	static int dj[] = { 0, 0, -1, 1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m][h];
		box = new int[n][m][h];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1)
						que.offer(new node(i, j, k, 0));
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
			visit[no.x][no.y][no.z] = true;
			time = no.t;

			for (int c = 0; c < 6; c++) {
				int nexti = no.x + di[c];
				int nextj = no.y + dj[c];
				int nextz = no.z + dz[c];

				if (nexti >= 0 && nextj >= 0 && nextz >= 0 && nexti < n && nextj < m && nextz < h
						&& box[nexti][nextj][nextz] == 0 && !visit[nexti][nextj][nextz]) {
					visit[nexti][nextj][nextz] = true;
					box[nexti][nextj][nextz] = 1;
					que.offer(new node(nexti, nextj, nextz, no.t + 1));
				}
			}
		}
	}

	public static void check() {
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (box[i][j][k] == 0)
						time = -1;
				}
			}
		}
	}
}
