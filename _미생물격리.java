import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _미생물격리 {

	static class node {
		int num;
		int cnt;
		int dir;

		node(int cnt, int dir) {

			this.cnt = cnt;
			this.dir = dir;

		}

		node(int num, int cnt, int dir) {
			this.num = num;
			this.cnt = cnt;
			this.dir = dir;

		}
	}

	static int n;
	static node area[][];
	static node area2[][];
	static int di[] = { -1, 1, 0, 0 }; // 상:1, 하:2, 좌:3, 우:4
	static int dj[] = { 0, 0, -1, 1 };
	static ArrayList<node> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			area = new node[n][n];
			area2 = new node[n][n];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				area[x][y] = new node(cnt, dir);
			}

			for (int i = 0; i < m; i++) {

				// 리스트 정렬시키기, 그리고 뽑아내면서 비교
				
				// copyarea를 검사하고, area에 덮어 씌우기
			}

		}
	}

	public static void move() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (area[i][j] != null) {
					int nexti = i + di[area[i][j].dir];
					int nextj = j + dj[area[i][j].dir];

					if (area2[nexti][nextj] == null) {
						area2[nexti][nextj] = new node(area[i][j].cnt, area[i][j].dir);

					}
					// 가야할 군집에 다른 군집이 존재함.
					else if (area2[nexti][nextj] != null) {
						list.add(new node(nexti * n + nextj, area[i][j].cnt, area[i][j].dir));
					}
				}
			}
		}
	}

	public static void check() {

	}

}
