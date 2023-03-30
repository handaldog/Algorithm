package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _연결요소의개수 {

	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<Integer>[] list;
	static boolean visit[];
	static boolean flag = false;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[h].add(b);
			list[b].add(h);
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				dfs(i);
				res++;
			}
		}
		System.out.println(res);

	}

	public static void dfs(int a) {

		for (int i = 0; i < list[a].size(); i++) {
			if (!visit[list[a].get(i)]) {
				visit[list[a].get(i)] = true;
				dfs(list[a].get(i));
			}

		}
	}
}
