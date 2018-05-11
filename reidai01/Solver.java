import java.util.Random;

public class Solver {
	static int limit = MasterMind.getlimit(); // 提出回数
	static int zigen = MasterMind.getzigen(); // 正解の桁数
	static int[] x = new int[zigen]; 
	static int[] hint = new int[2];
	static int[] bestanswer = new int[zigen];
	static int[] bestscore = { 0, 0 };

	public static void answer() {
		Random r = new Random();
		for (int i=0; i<limit; i++) {
			for (int j=0; j<zigen; j++) {
				x[j] = r.nextInt(9);
			}
			hint = MasterMind.evaluate(x);
			if(bestscore[0] < hint[0]){
				update();
			} else if (bestscore[1] < hint[1]){
				update();
			}
		}
		MasterMind.submit(bestanswer); //[Int]ファイナルアンサー
	}

	private static void update() {
		for (int j=0; j<zigen; j++) {
			bestanswer[j] = x[j];
		}
		bestscore[0] = hint[0];
		bestscore[1] = hint[1];
	}
}
