package shopping;

import java.util.Random;

public class OpenFillLotteryTest {
	public static void main(String[] args) {
		Random ran =new Random();
		for(int i = 0;i<20 ;i++){
			int d = ran.nextInt(10);
			System.out.println("中奖编号--->" + d);
		}
		
	}
}
