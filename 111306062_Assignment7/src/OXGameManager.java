public class OXGameManager {
	private boolean state = true;
	private boolean finish = false;
	private int count = 0;
	private int[] checkerboard = new int[9]; //一階陣列
	private String winner = null;
	private int scoreO = 0;
	private int scoreX = 0;
	//private int sum = 0;

// Play the O, X on checkerboard
	public String play(int index) {
		count++;
		if (state) {
			state = false;
			checkerboard[index] = 1;
			return "O";
		} else {
			state = true;
			checkerboard[index] = -1;
			return "X";
		}
	}

// Return if the game is finish or not
//三元運算子：when "count == 9" is true, return true to finish, else return false to finish
	public boolean finish() {
		return count == 9 ? true : finish;
	}

// Initialize the game
	public void initialize() {
		state = true;
		finish = false;
		count = 0;
		checkerboard = new int[9];
		winner = null;
	}

// Get O score
	public int getScoreO() {
		return scoreO;
	}

// Get X score
	public int getScoreX() {
		return scoreX;
	}

// Checking who is the winner or null
	public String checkWin() {
// All line on the board
		int[][] lines = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },{ 0, 4, 8 }, { 2, 4, 6 } };
// Implement an algorithm to find the winner here //
		for (int i = 0; i<8; i++) {
			if(checkerboard[lines[i][0]] == 1 && checkerboard[lines[i][1]] == 1 && checkerboard[lines[i][2]] == 1) {
				scoreO++;
				winner = "O";
				finish = true;
				break;
			}else if(checkerboard[lines[i][0]] == -1 && checkerboard[lines[i][1]] == -1 && checkerboard[lines[i][2]] == -1) {
				scoreX++;
				winner = "X";
				finish = true;
				break;
			}
		}
// check if there is a winner on one of the lines (above local variable) //
// e.g. if O wins winner = "O"; //
		return winner;
	}
}