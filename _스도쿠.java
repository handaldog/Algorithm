package two_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _스도쿠 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int area[][] = new int [9][9];
		
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<9;j++) {
				area[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				
			}
		}
	}
}
