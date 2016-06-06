import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int nV = scan.nextInt();
		int nE = scan.nextInt();
		
		Dijkstra dijkstra = new Dijkstra(nV, nE);
		dijkstra.findDistance(1, 1);
		
		scan.close();
	}
}
