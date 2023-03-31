package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _경로찾기 {

	static ArrayList<Integer>[] list;
	static int area[][];
	static int res[][];
	static int flag;
	static boolean visit[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		area = new int[n][n];
		list = new ArrayList[n];
		res = new int[n][n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 1) {
					list[i].add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit = new boolean[n];
				flag = 0;
				dfs(i, j);
				if (flag == 1) {
					res[i][j] = 1;
				} else {
					res[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void dfs(int i, int j) {

		for (int k = 0; k < list[i].size(); k++) {
			int num = list[i].get(k);
			if (visit[num])
				continue;
			visit[num] = true;
			if (num == j) {
				flag = 1;
				return;
			} else {
				dfs(num, j);
			}
		}

	}
}
