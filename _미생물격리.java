package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _미생물격리 {

	static class Mic {
		int cnt;
		int dir;

		Mic(int cnt, int dir) {
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	static int n;
	static Mic mic[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			mic = new Mic[n][n];

			for (int kk = 0; kk < k; kk++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				mic[i][j] = new Mic(cnt, dir);
			}

			for (int i = 0; i < m; i++) {

			}

		}
	}


	public static void check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int nexti = i + di[mic[i][j].dir];
				int nextj = j + dj[mic[i][j].dir];

				if (nexti == 0 || nextj == n - 1) {

					if (mic[nexti][nextj].cnt == 0) {
						mic[i][j].cnt = mic[nexti][nextj].cnt;
						mic[i][j].cnt = 0;
					} else {
						mic[nexti][nextj].cnt += mic[i][j].cnt;
						mic[i][j].cnt = 0;
						Math.max(mic[i][j].cnt, mic[nexti][nextj].cnt);
					}
				}
			}
		}
	}

}
