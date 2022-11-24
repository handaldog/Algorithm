import java.util.Scanner;

public class D3_7102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1;test<=tc;test++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max =0;
			int arr[] = new int [N+M+1];
			
			for(int i=1;i<=N;i++)
			{
				for(int j=1;j<=M;j++)
				{
					arr[i+j]++;
				}
			}
			System.out.print("#" + test + " " );
			for(int i=0;i<N+M+1;i++)
			{
				if(max <= arr[i])
				{
					max = arr[i];
				}
					
			}
			for(int i=0;i<N+M+1;i++) {
			if(max == arr[i])
			{
				System.out.print( i  + " ");
			}
			}
			System.out.println();
		
		}
	}

}
