package yang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _탈출 {

	static class node {
		int x;
		int y;
		int time;

		node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int dociX, dociY, caveX, caveY, waterX, waterY, r, c;
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static Queue<node> water = new LinkedList<>();
	static Queue<node> dochi = new LinkedList<>();
	static boolean wvisit[][];
	static boolean dovisit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		char arr[][] = new char[r][c];

		wvisit = new boolean[r][c];
		dovisit = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'D') {
					caveX = i;
					caveY = j;
				}
				if (arr[i][j] == 'S') {
					dociX = i;
					dociY = j;
				}
				if (arr[i][j] == '*') {
					waterX = i;
					waterY = j;
				}
			}
		}
		water.offer(new node(waterX, waterY, 1));
		dochi.offer(new node(dociX, dociY, 1));

	}

	public static void bfs() {

		while (!water.isEmpty()) {
			node wno = water.poll();

			wvisit[wno.x][wno.y] = true;

			for (int c = 0; c < 4; c++) {
				int wnexti = wno.x + di[c];
				int wnextj = wno.y + dj[c];

				if (wnexti >= 0 && wnextj >= 0 && wnexti < r && wnextj < c && !wvisit[wnexti][wnextj]) {
					wvisit[wnexti][wnextj] = true;
					water.offer(new node(wnexti, wnextj, wno.time + 1));
				}
			} // water 4방면 끝나는 부분

			while (!dochi.isEmpty()) {
				node dno = dochi.poll();

				wvisit[dno.x][dno.y] = true;

				for (int c = 0; c < 4; c++) {
					int dnexti = dno.x + di[c];
					int dnextj = dno.y + dj[c];

					if (dnexti >= 0 && dnextj >= 0 && dnexti < r && dnextj < c && !dovisit[dnexti][dnextj] && !wvisit[dnexti][dnextj]) {
						dovisit[dnexti][dnextj] = true;
						dochi.offer(new node(dnexti, dnextj, dno.time + 1));
					}
				}

			}

		}

	}

}
