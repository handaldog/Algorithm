import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _보호필름 {

	static boolean visit[], pvisit[];
	static int depth, width, pass;
	static int result[], presult[];
	static ArrayList<Integer> list;
	static int copyfilm[][];
	static int film[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			depth = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			pass = Integer.parseInt(st.nextToken());

			visit = new boolean[depth];

			film = new int[depth][width];
			copyfilm = new int[depth][width];

			for (int i = 0; i < depth; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= depth; i++) {
				result = new int[i];

				jo(0, 0, i);
			}
		}
	}

	public static void jo(int start, int idx, int cnt) {
		if (idx == cnt) {
			list = new ArrayList<>();
			for (int i = 0; i < depth; i++) {
				if (visit[i]) {
					list.add(result[i]);
				}
			}
			pvisit = new boolean[depth];
			presult = new int[cnt];
			part(0, cnt);
			return;
		}
		for (int i = start; i < depth; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			result[idx] = i;
			jo(start + 1, idx + 1, cnt);
			visit[i] = false;

		}
	}

	public static void part(int idx, int cnt) {
		if (idx == 1) {
			for (int i = 0; i < 1; i++) {
				if (pvisit[i]) {
					// true면 A(0)
					for (int j = 0; j < width; j++) {
						copyfilm[presult[i]][j] = 0;
					}

				} else {
					// false면 B(1)
					for (int j = 0; j < width; j++) {
						copyfilm[presult[i]][j] = 1;
					}
				}
			}
			if (check() == false) {
				makecopy();
			}
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (pvisit[i])
				continue;
			pvisit[i] = true;
			presult[i] = list.get(i);
			part(idx + 1, cnt);
			pvisit[i] = false;
			part(idx + 1, cnt);
		}
	}

	public static boolean check() {
		int sum = 0;
		int checkcnt = 0;
		for (int i = 0; i < width; i++) {
			sum = 0;
			for (int j = 0; j <= depth - pass; j++) {
				for (int k = 0; k < pass; k++) {
					sum += copyfilm[j][i + k];
				}
				if (sum == 0 || sum == pass) {
					checkcnt++;
					break;
				}

				else {
					sum = 0;
				}

			}
		}
		if (checkcnt == width) {
			return true;
		}
		return false;
	}

	public static void makecopy() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < width; j++) {
				film[list.get(i)][j] = copyfilm[list.get(i)][j];
			}
		}
	}
}
