
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class _4008_숫자만들기 {

	static ArrayList<Integer> list;
	static int n;
	static boolean visit[];
	static int result[];
	static int num[];
	static int sum;
	static int max;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			num = new int[n];

			visit = new boolean[n - 1];
			result = new int[n - 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			sum = 0;
			list = new ArrayList<>();

			for (int i = 0; i < 4; i++) {
				int a = Integer.parseInt(st.nextToken());
				for (int j = 0; j < a; j++) {
					list.add(i);
				}
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			// System.out.println(num[0]);
			soon(0);
			// System.out.println(min);
			// System.out.println(max);
			sb.append("#" + t + " " + Math.abs(min - max) + "\n");

		}
		System.out.println(sb);
	}

	public static void soon(int idx) {

		if (idx == n - 1) {

			// System.out.println(Arrays.toString(result));
			int cal = calc();
			// System.out.println(cal);
			min = Math.min(min, cal);
			max = Math.max(max, cal);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			result[idx] = list.get(i);
			soon(idx + 1);
			visit[i] = false;

		}
	}

	public static int calc() {
		sum = num[0];
		for (int i = 0; i < result.length; i++) {

			switch (result[i]) {
			case 0: {
				sum += num[i + 1];
				break;
			}
			case 1: {
				sum -= num[i + 1];
				break;
			}
			case 2: {
				sum *= num[i + 1];
				break;
			}
			case 3: {
				sum /= num[i + 1];
				break;
			}

			}
		}
		return sum;

	}
}