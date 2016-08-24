import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

public class Main {

	/* 100만건 유저 데이터 (Id, score) 
	 * Id 이름으로 검색 - 키로 검색
	 * 상위 100건 랭커 - 정렬
	 * 내 순위 가져오기 - 검색 */

	static LinkedHashMap<UUID, Integer> userData = new LinkedHashMap<UUID, Integer>();
	final static int USER_SIZE = 1000000;

	public static void main(String[] args) {

		for(int i=0; i<USER_SIZE; i++) {
			UUID uid = new UUID(new Random().nextInt(), new Random().nextInt());
			int score = new Random().nextInt();
			userData.put(uid, score);
		}

		UUID uid1 = new UUID(new Random().nextInt(), new Random().nextInt());
		userData.put(uid1, new Random().nextInt(10000));

		System.out.println(searchRank(uid1));
		ranking();
	}

	static int searchRank(UUID uid) {
		int rank = userData.get(uid);
		return rank;
	}

	static void ranking() {
		
		for(Entry<UUID, Integer> userData : userData.entrySet()) {
			System.out.println(userData);

			if(userData.getValue().equals(100))
				break;
		}
	}
	
	class RankingComparator implements Comparator<Integer> {

		public RankingComparator() {}
		
		@Override
		public int compare(Integer a, Integer b) {
			if (userData.get(a) >= userData.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        }
		}
	}
}
