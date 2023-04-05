import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _소문난칠공주 {

	static class node {
		int x;
		int y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean visit[][];
	static boolean Svisit[];
	static boolean Yvisit[];
	static char area[][];
	static node result[];
	static int any[][];
	static ArrayList<node> Y = new ArrayList<>();
	static ArrayList<node> S = new ArrayList<>();

	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int s, y, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		area = new char[5][5];

		result = new node[7];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < 5; j++) {
				area[i][j] = str.charAt(j);
				if (area[i][j] == 'Y')
					Y.add(new node(i, j));
				if (area[i][j] == 'S')
					S.add(new node(i, j));
			}
		}

//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(area[i][j] + " ");
//			}
//			System.out.println();
//		}

		if (S.size() < 4) {
			System.out.println("끝?");
			System.out.println(0);
			return;
		}

		visit = new boolean[5][5];
		Svisit = new boolean[S.size()];
		Yvisit = new boolean[Y.size()];

		if (S.size() >= 8) {
			System.out.println("8보다크네");
			for (int i = 7; i >= 4; i--) {
				comS(0, 0, i);

			}
		} else if (S.size() <= 7) {
			System.out.println("7보다작네");
			for (int i = S.size(); i >= 4; i--) {
				comS(0, 0, i);
			}
		}

		System.out.println(res);

	}

	public static void comS(int start, int idx, int cnt) {
		// System.out.println("comS");
		if (idx == cnt) {

			comY(0, 7 - (7 - cnt), 7);

			return;
		}
		for (int i = 0; i < S.size(); i++) {
			if (Svisit[i])
				continue;
			Svisit[i] = true;
			result[idx] = S.get(i);
			comS(i + 1, idx + 1, cnt);
			Svisit[i] = false;
		}
	}

	public static void comY(int start, int idx, int cnt) {
		// System.out.println("comY");
		if (idx == cnt) {
			any = new int[5][5];

			for (int i = 0; i < 7; i++) {
				any[result[i].x][result[i].y] = 1;
			}

			dfs(result[0].x, result[0].y, 1);
			return;

		}

		for (int i = 0; i < Y.size(); i++) {
			if (Yvisit[i])
				continue;
			Yvisit[i] = true;
			result[idx] = Y.get(i);
			comY(i + 1, idx + 1, cnt);
			Yvisit[i] = false;
		}
	}

	public static void dfs(int i, int j, int cnt) {
		System.out.println("dfs");
		if (cnt == 7) {
			res++;
		}
		visit[i][j] = true;

		for (int c = 0; c < 4; c++) {
			int nexti = i + di[c];
			int nextj = j + dj[c];

			if (nexti >= 0 && nextj >= 0 && nexti < 5 && nextj < 5 && !visit[nexti][nextj] && any[nexti][nextj] == 1) {
				visit[nexti][nextj] = true;

				dfs(nexti, nextj, cnt + 1);
			}
		}

	}

}
