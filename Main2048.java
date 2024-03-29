public class Main2048 {
	public static void main(String[] args) {
		TwoThousandFourtyEight t1 = new TwoThousandFourtyEight(4, 4);
		TwoThousandFourtyEight t2;

		t1.up();
		// 0	0	2	0	
		// 0	0	0	0	
		// 0	0	2	0	
		// 0	0	0	0	
		// Score: 4
    System.out.println("Score: " + t1.getScore());

		t1.right();
		// 0	0	0	2	
		// 0	2	0	0	
		// 0	0	0	2	
		// 0	0	0	0	
		// Score: 6
    System.out.println("Score: " + t1.getScore());

		t1.down();
		// 2	0	0	0	
		// 0	0	0	0	
		// 0	0	0	0	
		// 0	2	0	4	
		// Score: 10
    System.out.println("Score: " + t1.getScore());

		t1.left();
		// 2	0	0	0	
		// 0	0	0	0	
		// 0	0	2	0	
		// 2	4	0	0	
		// Score: 12
    System.out.println("Score: " + t1.getScore());		
		
		for (int i = 0 ; i < 16 ; i++) {
			if (!t1.up() || !t1.left()) {
				break;
			}
		}
		
    assert(t1.getScore() == 128);

		t2 = t1.copy();
		for (int i = 0 ; i < 16 ; i++) {
			if (!t1.up() || !t1.left()) {
				break;
			}
		}
		assert(t1.getScore() == 256);
		assert(t2.getScore() == 128);
		if (!t2.down() || !t2.right() || !t2.up() || !t2.left()) {
			assert(false);
		}
		assert(t2.getScore() == 146);
		assert(t2.getHighestTile() == 32);
		// t2's state:
		// 2	8	16	32	
		// 8	2	0	0	
		// 8	0	0	0	
		// 4	0	0	2	
	}
}
