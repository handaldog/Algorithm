import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _케빈베이컨의6단계법칙 {

	static class node {
		int x;
		int cnt;

		node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	static ArrayList<Integer>[] list;
	static boolean visit[];
	static int n, sum, res;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];

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

			bfs(i, 1);
			if (min > sum) {
				min = sum;
				res = i;
			}
		}

		System.out.println(res);
	}

	public static void bfs(int i, int cnt) {
		Queue<node> que = new LinkedList<>();
		visit = new boolean[n + 1];
		sum = 0;

		que.offer(new node(i, cnt));
		visit[i] = true;

		while (!que.isEmpty()) {
			node no = que.poll();
			visit[no.x] = true;
			for (int j = 0; j < list[no.x].size(); j++) {
				int l = list[no.x].get(j);

				if (!visit[l]) {
					for (int k = 1; k <= n; k++) {
						if (l == k) {
							sum += no.cnt;
						}
					}
					visit[l] = true;
					que.offer(new node(l, no.cnt + 1));
				}
			}
		}
	}
}
