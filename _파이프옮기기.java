import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _파이프옮기기 {

	static int n, res;

	static int area[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		area = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);
		System.out.println(res);

	}

	public static void dfs(int i, int j, int dir) {
		// 가로 : 0, 세로 : 1, 대각선 2
		if (i == n - 1 && j == n - 1) {
			res++;
			return;
		}
		// 가로방향
		if (dir == 0) {
			if (j + 1 < n && area[i][j + 1] == 0)
				dfs(i, j + 1, 0);
		}

		// 세로방향
		if (dir == 1) {
			if (i + 1 < n && area[i + 1][j] == 0)
				dfs(i + 1, j, 1);
		}

		// 대각선방향
		if (dir == 2) {
			if (j + 1 < n && area[i][j + 1] == 0)
				dfs(i, j + 1, 0);

			if (i + 1 < n && area[i + 1][j] == 0)
				dfs(i + 1, j, 1);

		}

		if (i + 1 < n && j + 1 < n && area[i + 1][j + 1] == 0 && area[i + 1][j] == 0 && area[i][j + 1] == 0) {
			dfs(i + 1, j + 1, 2);
		}

	}

}
