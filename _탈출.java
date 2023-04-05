import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _탈출 {

	static class node {
		int wx;
		int wy;
		int sx;
		int sy;

		node(int wx, int wy, int sx, int sy) {
			this.wx = wx;
			this.wy = wy;
			this.sx = sx;
			this.sy = sy;
		}
	}

	static int Di, Dj;
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static Queue<node> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char arr[][] = new char[r][c];
		Di = 0;
		Dj = 0;
		int Si = 0;
		int Sj = 0;
		int seai = 0;
		int seaj = 0;

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'D') {
					Di = i;
					Dj = j;
				}
				if (arr[i][j] == 'S') {
					Si = i;
					Sj = j;
				}
				if (arr[i][j] == '*') {
					seai = i;
					seaj = j;
				}
			}
		}

	}

	public static void bfs(int si, int sj, int seai, int seaj, int cnt) {
		
		while(!que.isEmpty()) {
			node no = que.poll().
		}
		
		if (si == Di && sj == Dj) {
			return;
		}

		for (int c = 0; c < 4; c++) {
			int Nsi = si + di[c];
			int Nsj = sj + dj[c];
		}

	}

}
