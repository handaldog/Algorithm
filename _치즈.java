package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _치즈 {

	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int arr[][];
	static int n, m;
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);

	}

	public static void dfs(int i, int j) {
		
		arr[i][j] = flag;

		for (int c = 0; c < 4; c++) {
			int nexti = i + di[c];
			int nextj = j + dj[c];

			if (nexti > 0 && nextj > 0 && nexti < n && nextj < m && arr[nexti][nextj] == 0) {
				arr[nexti][nextj] = flag;

			}

		}
	}

	public static void dfs2(int i, int j) {

		for (int c = 0; c < 4; c++) {
			int nexti = i + di[c];
			int nextj = j + dj[c];

			if (nexti > 0 && nextj > 0 && nexti < n && nextj < m && arr[nexti][nextj] == 1) {
				arr[nexti][nextj] = flag;

			}

		}
	}

}
