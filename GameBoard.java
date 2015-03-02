public class GameBoard{
	private int winner; // 1 for player X and 2 for player O

	int board[] = {		0, 0, 0, 
						0, 0, 0,
						0, 0, 0};

	public GameBoard(){ // constructor
		winner = 0;
	}

	public boolean inputStep(int step, int type){
		if (board[step]!=0){
			return false;
		}
		board[step] = type;
		return true;
	}

	public boolean isGameBoardFull(){
		for (int i : board){
			if (i == 0)
				return false;
		}
		return true;
	}

	public void printWinner(){
		if (winner == 0){
			System.out.println("Draw Game!");
		} else{
			char winChar = winner == 1? 'X':'O';
			System.out.printf("The player %c wins the game!\n", winChar);
		}
	}

	public int getWinner(){
		return winner;
	}

	public int checkWinner(){
		int i, j=0;
		for(i = 0; i < 3; i++){
			j = i*3;
			if (board[j] == board[j+1] && board[j] == board[j+2] && board[j] != 0){ // for horizontal
				winner = board[j];
				return winner;
			}

			if (board[i] == board[i+3] && board[i] == board[i+6] && board[i] != 0){ // for vertical
				winner = board[i];
				return winner;
			}
		}

		if (board[0] == board[4] && board[0] == board[8] && board[0] != 0){ // for diagonal \
			winner = board[0];
			return winner;
		}

		if (board[2] == board[4] && board[2] == board[6] && board[0] != 0){ // for diagonal /
			winner = board[2];
			return winner;
		}

		return 0;
	}

	public void printBoard(int round){
		int i;
		System.out.printf("\nRound %d\n", round);
		System.out.println("-----------");
		for (i = 0; i<board.length; i++){
			char c;
			switch (board[i]){
				case 1:
					c = 'X';
					break;
				case 2:
					c = 'O';
					break;
				default:
					c = ' ';
					break;
			}
			String output = i%3 == 2 && i >0? " %c\n-----------\n":" %c |";
			System.out.printf(output, c);
		}
		System.out.println();
	}
}