package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _바이러스 {
	static ArrayList<Integer>[] graph;
	static boolean visit[];
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[h].add(b);
			graph[b].add(h);

		}
		visit[1] = true;
		dfs(1);
		System.out.println(cnt - 1);

	}

	public static void dfs(int i) {
		cnt++;

		for (int j = 0; j < graph[i].size(); j++) {

			if (!visit[graph[i].get(j)]) {
				visit[graph[i].get(j)] = true;
				dfs(graph[i].get(j));
			}
		}
	}
}
