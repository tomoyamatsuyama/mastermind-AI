import java.util.*;

public class Solver {
	static int limit = MasterMind.getlimit(); // 提出回数
	static int zigen = MasterMind.getzigen(); // 正解の桁数
	static int[] x = new int[zigen];
	static int[] hint = new int[2];
	static ArrayList<Integer> search = new ArrayList<Integer>(); //ここに仮のやつを入れる。そのあとに全探索

	public static void answer() {
		for(int i=0; i<=9; i++) {
			for (int j=0; j<zigen; j++) {
				x[j] = i;
			}

			hint = MasterMind.evaluate(x);

			if (hint[0] > 0) {
				for(int h=0; h<hint[0]; h++) {
					search.add(i);
				}
			}
		}

		Permutation per = new Permutation();
		List<List<Integer>> lists = per.make(search);

		for(List<Integer> li: lists) {
			for(int l=0; l<zigen;l++) {
				x[l] = li.get(l);
			}
			hint = MasterMind.evaluate(x);

			if(hint[0] == zigen) {
				MasterMind.submit(x);
				break;
			}
		}
	}
}
