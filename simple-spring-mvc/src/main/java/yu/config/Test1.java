package yu.config;

public class Test1 {
	private int[] column; //同栏是否有皇后，1表示有
	private int[] rup; //右上至左下是否有皇后
	private int[] lup; //左上至右下是否有皇后
	private int[] queen; //解答
	private int num; //解答编号

	public Test1() {
		column = new int[8];
		rup = new int[(2*7)+1];
		lup = new int[(2*7)+1];
		for (int i = 1; i < 8; i++)
			column[i] = 0;
		for (int i = 0; i < 15; i++)
			rup[i] = lup[i] = 0;  //初始定义全部无皇后
		queen = new int[8];
	}

	public void backtrack(int i) {
		if (i >= 8) {
			showAnswer();
		} else {
			for (int j = 0; j < 8; j++) {
				if ((column[j] == 0) && (rup[i+j] == 0) && (lup[i-j+7] == 0)   ) {
					//若无皇后
					queen[i] = j; //设定为占用
					column[j] = rup[i+j] = lup[i-j+7] = 1;
					backtrack(i+1);  //循环调用
					column[j] = rup[i+j] = lup[i-j+7] = 0;
				}
			}
		}
	}

	protected void showAnswer() {
		num++;
		System.out.println("\n解答" + num);
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if(queen[y]==x) {
					System.out.print("Q");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Test1 queen = new Test1();
		queen.backtrack(0);
	}
}
