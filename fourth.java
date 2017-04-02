import java.util.ArrayList;
import java.util.Scanner;

public class fourth {
///salaaaam
////chetoriii
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), e = in.nextInt();
		int[][] g = new int[n][n];

		for (int k = 0; k < e; k++) {
			int i = in.nextInt(), j = in.nextInt();
			g[i][j] = in.nextInt();
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (g[i][j] == 0)
					g[i][j] = 100;
		int dist[][] = new int[n][n];
		ArrayList<Integer> path[][] = new ArrayList[n][n];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				path[k][i] = new ArrayList<Integer>();
			}
		}
		for (int i = 0; i < n; i++) {
			dist[i][i] = 0;
			g[i][i] = 0;
			
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n ; j++) {
				dist[i][j] = g[i][j];
				path[i][j].add(i);
				path[i][j].add(j);
			}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][j] > (dist[i][k] + dist[k][j])) {
						dist[i][j] = (dist[i][k] + dist[k][j]);
						int x = path[i][j].indexOf(j);
						path[i][j].add(x, k);

					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("i = " + i + " j =  " + j + " : ");
				for (int k = 0; k < path[i][j].size(); k++)
					System.out.print(path[i][j].get(k) + " ");
				System.out.println("dist" + dist[i][j]);
			}
			
			System.out.println();
		}
		
	}
	

}
