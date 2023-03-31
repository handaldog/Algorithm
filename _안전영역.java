package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _안전영역 {

	static int max = Integer.MIN_VALUE;
	static int resm = Integer.MIN_VALUE;
	static boolean visit[][];
	static int area[][];
	static int n, res;
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		area = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, area[i][j]);
			}
		}

		for (int h = 0; h <= max; h++) {
			visit = new boolean[n][n];
			res = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (area[i][j] <= h) {
						visit[i][j] = true;
					}

				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {

						dfs(i, j);
						res++;
					}
				}
			}
			resm = Math.max(resm, res);

		}
		System.out.println(resm);

	}

	public static void dfs(int i, int j) {
		visit[i][j] = true;

		for (int c = 0; c < 4; c++) {
			int nexti = i + di[c];
			int nextj = j + dj[c];

			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && !visit[nexti][nextj]) {
				visit[nexti][nextj] = true;
				dfs(nexti, nextj);
			}
		}

	}
}
