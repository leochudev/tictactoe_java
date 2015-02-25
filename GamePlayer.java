import java.util.Scanner;

public class GamePlayer{
	private int type; // 1 for player X, 2 for player O
	private boolean isComputer;

	public GamePlayer(int type){
		this.type = type;
		isComputer = false;
	}

	public GamePlayer(int type, boolean isComputer){
		this.type = type;
		this.isComputer = isComputer;
	}

	public int nextStep(){
		int step = -1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input your next step: ");
		char input = sc.next().toLowerCase().charAt(0);

		switch (input){
			case '0':
			case 'q':
				step = 0;
				break;
			case '1':
			case 'w':
				step = 1;
				break;
			case '2':
			case 'e':
				step = 2;
				break;
			case '3':
			case 'a':
				step = 3;
				break;
			case '4':
			case 's':
				step = 4;
				break;
			case '5':
			case 'd':
				step = 5;
				break;
			case '6':
			case 'z':
				step = 6;
				break;
			case '7':
			case 'x':
				step = 7;
				break;
			case '8':
			case 'c':
				step = 8;
				break;
		}
		return step;
	}

	public int getType(){
		return type;
	}
}