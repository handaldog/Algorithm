package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _연구소2 {

	static class node {
		int x;
		int y;
		int t;

		node(int x, int y) {
			this.x = x;
			this.y = y;

		}

		node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;

		}
	}

	static ArrayList<node> list = new ArrayList<>();
	static Queue<node> que = new LinkedList<>();

	static node resultcom[];
	static boolean visitcom[][];
	static int m, n, time;
	static boolean visitarea[][];
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int area[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 조합 + bfs

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visitcom = new boolean[n][n];
		area = new int[n][n];
		resultcom = new node[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 2) {
					list.add(new node(i, j));

				}
			}
		}

//		for (node l : list) {
//			System.out.println(l.x + " " + l.y);
//		}
		comb(0, 0);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	public static void comb(int idx, int start) {
		if (idx == m) {
			visitarea = new boolean[n][n];
			for (int i = 0; i < idx; i++) {
				// System.out.print(resultcom[i].x);
				// System.out.println(resultcom[i].y);
				visitarea[resultcom[i].x][resultcom[i].y] = true;
				que.offer(new node(resultcom[i].x, resultcom[i].y, 0));

			}

			bfs();
			if (check() == 1) {
				min = Math.min(min, time);
			}

			return;
		}

		for (int i = start; i < list.size(); i++) {
			int gx = list.get(i).x;
			int gy = list.get(i).y;
			if (visitcom[gx][gy])
				continue;
			visitcom[gx][gy] = true;
			resultcom[idx] = new node(gx, gy);
			comb(idx + 1, start + 1);
			visitcom[gx][gy] = false;

		}
	}

	public static void bfs() {

		while (!que.isEmpty()) {
			node no = que.poll();
			visitarea[no.x][no.y] = true;
			// System.out.println(no.x);
			// System.out.println(no.y);
			time = no.t;
			for (int c = 0; c < 4; c++) {
				int nexti = no.x + di[c];
				int nextj = no.y + dj[c];

				if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && !visitarea[nexti][nextj]
						&& area[nexti][nextj] != 1) {
					visitarea[nexti][nextj] = true;
					que.offer(new node(nexti, nextj, no.t + 1));
				}
			}
		}
	}

	public static int check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (area[i][j] == 0 && !visitarea[i][j]) {
					return 0;
				}
			}
		}
		return 1;
	}

}
