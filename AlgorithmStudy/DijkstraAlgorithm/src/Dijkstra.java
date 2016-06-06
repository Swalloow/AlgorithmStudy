
public class Dijkstra {
	private int[][] ad;			// 간선저장
	private int[] dist;			// 해당 노드까지의 최단거리
	private boolean[] visit;	// 방문점 체크
	private int nE, nV;
	private final int inf = 100000;	// 거리 default 값

	public int getnE() {return nE;}
	public void setnE(int nE) {this.nE = nE;}
	public int getnV() {return nV;}
	public void setnV(int nV) {this.nV = nV;}

	public Dijkstra(int nV, int nE) {
		this.nV = nV;
		this.nE = nE;
		ad = new int[nV+1][nV+1];
		dist = new int[nV+1];
		visit = new boolean[nV+1];

		for(int i=1; i<=nV; i++) {
			dist[i] = inf;	// 임의의 값으로 거리값 초기화 (10만)
		}
		
		this.setGraph();
	}
	
	public void setGraph() {
		ad[0][0] = 0;
		ad[0][1] = 2;
		ad[0][2] = 4;
		ad[0][3] = 6;
		ad[1][0] = 2;
		ad[1][1] = 0;
		ad[1][2] = 0;
		ad[1][3] = 8;
		ad[2][0] = 4;
		ad[2][1] = 0;
		ad[2][2] = 0;
		ad[2][3] = 1;
		ad[3][0] = 6;
		ad[3][1] = 8;
		ad[3][2] = 1;
		ad[3][3] = 0;
	}

	public void findDistance(int start, int end) {
		dist[start] = 0;	// 최초 시작 값 distance 초기화
		String s = "";
		for(int j=0; j<nV; j++) {	// dist 값을 한번 초기화 했으므로 n-1번만 진행
			int min = inf + 1;		// dist 최소값 찾기 위한 임시 값 초기화
			int index = -1;
			for(int k = 1; k <= nV; k++) {
				if(visit[k] == false && min > dist[k]) {
					min = dist[k];
					index = k;
				}
			}
			visit[index] = true;
			s += index + " ";		// 경로를 체크하는 방법

			for(int l=1; l<=nV; l++) {
				// 인접행렬을 검사하여 최적의 값을 찾음
				if(ad[index][l] != 0 && dist[l] > dist[index] + ad[index][l]) {
					dist[l] = dist[index] + ad[index][l];
				}
			}
		}

		// 최단거리 출력
		for(int i=1; i<=nV; i++) {
			System.out.print(dist[i]);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println(s);
	}
}







