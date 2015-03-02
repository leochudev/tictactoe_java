public class Game{
	public static void main (String[] args){
		startGame();
	}

	public static void startGame(){
		GameBoard board = new GameBoard();

		GamePlayer players[] = new GamePlayer[2];
		players[0] = new GamePlayer(1);
		players[1] = new GamePlayer(2);

		int step, round=0;
		boolean isValidInput;

		board.printBoard(round);
		while (board.checkWinner() == 0 && !board.isGameBoardFull()){
			round++;
			step = -1;
			isValidInput = false;
			
			while (!isValidInput){
				step = players[round%2].nextStep();
				
				if (step < 0 || step >=9){
					System.out.printf("Invalid input.\n", step);
				} else {
					isValidInput = board.inputStep(step, players[round%2].getType());
					if (!isValidInput){
						System.out.printf("Position %d is already input.\n", step);	
					}
				}
			}
			board.printBoard(round);
		}
		board.printWinner();
	}
}