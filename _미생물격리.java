package yang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _미생물격리2 {

	static class node implements Comparable<node> {
		int num;
		int cnt;
		int dir;

		node(int num, int cnt, int dir) {
			this.num = num;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(node o) {
			return o.cnt - this.cnt; // 내림차순
		}
	}

	static PriorityQueue<node> pq;

	static int di[] = { -1, 1, 0, 0 }; // 상:1, 하:2, 좌:3, 우:4
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			int sum = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			node area[][] = new node[n][n];

			pq = new PriorityQueue<>();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				area[x][y] = new node(x * n + y, cnt, dir);

			}

			for (int m = 0; m < M; m++) {
				// 배열에 있는 거 빼서 pq에 넣기
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (area[i][j] != null) {

							int nexti = i + di[area[i][j].dir];
							int nextj = j + dj[area[i][j].dir];

							pq.add(new node(nexti * n + nextj, area[i][j].cnt, area[i][j].dir));
						}
					}
				}

				area = new node[n][n]; // pq에 옮겨놨으니 다시 옮길 곳을 초기화 시킴.

				// pq사이즈만큼 돌면서 배열에 다시 넣기
				for (int i = 0; i < pq.size(); i++) {
					node no = pq.poll();
					if (area[no.num / n][no.num % n] == null) { // 배열이 비어있으면 넣기
						area[no.num / n][no.num % n] = new node(no.num, no.cnt, no.dir);
					} else if (area[no.num / n][no.num % n] != null) { // 배열이 비어있지 않으면 미생물을 더해줌.
						area[no.num / n][no.num % n] = new node(no.num, area[no.num / n][no.num % n].cnt + no.cnt,
								no.dir);

					}
				}

				// 방향이 빨간약쪽에 있으면 미생물을 반으로 나누어 주고 방향을 바꿔줌.
				for (int i = 0; i < n; i++) {
					if (area[0][i] != null) { // i가 0이면 방향이 상,하 밖에 없음.
						area[0][i].cnt = area[0][i].cnt / 2;
						if (area[0][i].dir == 3) {
							area[0][i].dir = 4;
						}
						if (area[0][i].dir == 4) {
							area[0][i].dir = 3;
						}
					}
					if (area[i][0] != null) { // i가 0이면 방향이 상,하 밖에 없음.
						area[i][0].cnt = area[i][0].cnt / 2;
						if (area[i][0].dir == 1) {
							area[i][0].dir = 2;
						}
						if (area[i][0].dir == 2) {
							area[i][0].dir = 1;
						}
					}
				}
			} // m번 반복문 끝

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum += area[i][j].cnt;
				}
			}

			System.out.println(sum);

		}
	}
}
