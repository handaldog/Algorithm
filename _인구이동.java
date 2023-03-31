package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _인구이동 {

	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int area[][];
	static boolean visit[][];
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int n, l, r, sum, cnt, dif, res;
	static ArrayList<node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		area = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			dif = 0;
			res++;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						list = new ArrayList<>();
						cnt = 1;
						sum = area[i][j];
						list.add(new node(i, j));
						visit[i][j] = true;
						dfs(i, j);
						// System.out.println(sum);
						sum = sum / cnt;
						// System.out.println(sum);
						// System.out.println(cnt);
						for (node l : list) {
							area[l.x][l.y] = sum;
						}
//						for (int h = 0; h < n; h++) {
//							for (int b = 0; b < n; b++) {
//								System.out.print(area[h][b] + " ");
//							}
//							System.out.println();
//					}
//					System.out.println("-----------");
					}
				}
			}
			if (dif == 0)
				break;
		}

		System.out.println(res - 1);

	}

	public static void dfs(int i, int j) {

		visit[i][j] = true;

		for (int c = 0; c < 4; c++) {
			int nexti = i + di[c];
			int nextj = j + dj[c];

			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && !visit[nexti][nextj]) {
				int diff = Math.abs((area[i][j]) - (area[nexti][nextj]));
				if (diff >= l && diff <= r) {
					dif++;
					cnt++;
					sum += area[nexti][nextj];
					list.add(new node(nexti, nextj));
					dfs(nexti, nextj);
				}
			}
		}
	}
}
