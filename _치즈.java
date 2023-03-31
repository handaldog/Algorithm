package two_week;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _치즈 {

	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int arr[][];
	static int n, m, one, melt, res;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (check() != 0) {

			if (check() > 0) {
				res = check();
				melt++;
				visit = new boolean[n][m];
				dfs(0, 0);

			} else {
				break;
			}
		}
		System.out.println(melt);
		System.out.println(res);

	}

	public static void dfs(int i, int j) {

		visit[i][j] = true;

		for (int c = 0; c < 4; c++) {
			int nexti = i + di[c];
			int nextj = j + dj[c];

			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && !visit[nexti][nextj]) {
				if (arr[nexti][nextj] == 0) {
					visit[nexti][nextj] = true;
					dfs(nexti, nextj);
				} else if (arr[nexti][nextj] == 1) {
					arr[nexti][nextj] = 0;
					visit[nexti][nextj] = true;
				}

			}

		}
	}

	public static int check() {
		one = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					one++;
			}
		}
		return one;
	}
}
