package problems.Utilities;

public class Runner {

	private int[][] matrix;
	private int homeCol, homeRow;
	private int runLength;
	private int col = 0, row = 0;
	
	public Runner(int[][] matrix, int homeCol, int homeRow, int runLength) {
		this.matrix = matrix;
		this.homeCol = homeCol;
		this.homeRow = homeRow;
		this.runLength = runLength;
	}
	
	public long runRight() {
		return this.run(1, 0);
	}
	
	public long runDown() {
		return this.run(0, 1);
	}
	
	public long runDiagonal() {
		return this.run(1, 1);
	}
	
	private long run(int dcol, int drow) {
		long product = 1;
		this.goHome();
		product *= matrix[col][row];
		for(int i = 1; i < runLength; i++)
			product *= this.abstractRun(dcol, drow);
		return product;
	}

	private void goHome() {
		col = homeCol;
		row = homeRow;
	}

	private int abstractRun(int dcol, int drow) {
		this.move(dcol, drow);
		if(this.inBounds())
			return matrix[col][row];
		else
			return 0;
	}

	private boolean inBounds() {
		return col < matrix.length && row < matrix.length
				&& col >= 0 && row >= 0;
	}

	private void move(int dcol, int drow) {
		col += dcol;
		row += drow;
	}
}
