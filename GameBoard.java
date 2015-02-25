public class GameBoard{
	private int round;
	private int winner; // 1 for player X and 2 for player O
	private GamePlayer players[];

	int board[] = {		0, 0, 0, 
						0, 0, 0,
						0, 0, 0};

	public GameBoard(){ // constructor
		round = winner = 0;

		players = new GamePlayer[2];
		players[0] = new GamePlayer(1);
		players[1] = new GamePlayer(2);

		startGame();
	}

	public void startGame(){
		int step;
		boolean isValidInput;

		printBoard();
		while (winner == 0 && !isGameBoardFull()){
			round++;
			step = -1;
			isValidInput = false;
			
			while (!isValidInput){
				step = players[round%2].nextStep();

				if (step < 0 || step >=9){
					System.out.printf("Invalid input.\n", step);
				}else if (board[step]!=0){
					System.out.printf("Position %d is already input.\n", step);
				}  else {
					isValidInput = true;
					board[step] = players[round%2].getType();
				}
			}
			printBoard();
			checkWinner();
		}
		printWinner();
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

	public int checkWinner(){
		int i;
		boolean isWin = false;
		
		for(i = 0; i < 3; i++){
			if (board[i] == board[i+1] && board[i] == board[i+2] && board[i] != 0){ // for horizontal
				winner = board[i];
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

		if (board[2] == board[4] && board[0] == board[6] && board[0] != 0){ // for diagonal /
			winner = board[0];
			return winner;
		}

		return 0;
	}

	public void printBoard(){
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