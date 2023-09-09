
import java.util.Scanner;
public class User extends Trainer {
	
	private int width = 15;
	private int height = 30;
	private String[][] field;
	private int xLoc;
	private int yLoc;
	private String spaceOn;
	private String spaceLeft = ".";
	private int grassSpots = 100;
	boolean inBattle = true;
	boolean userTurn = true;
	private Pokemon faceing;
	private Pokemon currentPoke;
	
	public User(Pokemon poke1, Pokemon poke2, Pokemon poke3, Pokemon poke4, Pokemon poke5, Pokemon poke6, int yLoc, int xLoc) {
		super(poke1, poke2, poke3, poke4, poke5, poke6, yLoc, xLoc);
		
	}
	public int getXLoc() {
		return xLoc;
	}
	public int getYLoc() {
		return yLoc;
	}
	
	public void generateBoard() {
		field = new String[width][height];
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < height; c++) {
				field[r][c] = (".");
			}
		}
		for (int k = 0; k < grassSpots; k++) {
			int r = (int) (Math.random() * width - 1);
			int c = (int) (Math.random() * height - 1);
			field[r][c] = ("*");
		}
	}
	public void placePlayer(int x, int y) {
		field[yLoc][xLoc] = "A";
	}
	
	public void displayBoard() {
		for (int r = 0; r < width; r++) {
			for (int c = 0; c < height; c++) {
				System.out.print(field[r][c]);
			}
			System.out.println("");
		}
	}
	
	public void update() {
		placePlayer(yLoc, xLoc);
		displayBoard();
	}
	
	public void moveLeft(int x, int y) {
		if (y != 0) {
			xLoc --;
			field[x][y] = spaceLeft;
			System.out.println(yLoc + " " + xLoc);
			spaceLeft = field[x-1][y];
			update();
			return;
		}
		else {
			xLoc = height - 1;
			field[x][y] = spaceLeft;
			spaceLeft = field[x][width-1];
			update();
			System.out.println(yLoc + "..." + xLoc);
			return;
		}
		//System.out.println("That is not a viable move");
	}
	public void moveRight(int x, int y) {
		if (y != height - 1) {
			xLoc ++;
			field[x][y] = spaceLeft;
			System.out.println(yLoc + " " + xLoc);
			spaceLeft = field[x+1][y];
			update();
			return;
		}
		else {
			xLoc = 0;
			field[x][y] = spaceLeft;
			spaceLeft = field[x][width-1];
			update();
			System.out.println(yLoc + "..." + xLoc);
			return;
		}
		//System.out.println("That is not a viable move");
	}
	public void moveUp(int x, int y) {
		if (x != 0) {
			yLoc --;
			field[x][y] = spaceLeft;
			System.out.println(yLoc + " " + xLoc);
			spaceLeft = field[x][y-1];
			update();
			return;
		}
		else {
			yLoc = width - 1;
			field[x][y] = spaceLeft;
			spaceLeft = field[x][width-1];
			update();
			System.out.println(yLoc + "..." + xLoc);
			return;
		}
		//system.out.println("That is not a viable move");
	}
	public void moveDown(int x, int y) {
		if (x != width-1) {
			yLoc ++;
			field[x][y] = spaceLeft;
			System.out.println(yLoc + " " + xLoc);
			spaceLeft = field[x][y+1];
			update();
			return;
		}
		else {
			yLoc = 0;
			field[x][y] = spaceLeft;
			spaceLeft = field[x][width-1];
			update();
			System.out.println(yLoc + "..." + xLoc);
			return;
		}
		//System.out.println("That is not a viable move");
	}
	public void move(String direction) {
		if (direction.equals("w")) moveUp(getYLoc(), getXLoc());
		else if (direction.equals("a")) moveLeft(getYLoc(), getXLoc());
		else if (direction.equals("d")) moveRight(getYLoc(), getXLoc());
		else if (direction.equals("s")) moveDown(getYLoc(), getXLoc());
		else if (direction.equals("i")) {
			System.out.println("w = move up\ns = move down\na = move left\nd = move right\ni = view instructions");
		}
		else System.out.println("That is not a viable move");
	}
	
	public void play(Trainer player) {
		
	}
	
	public void battleChoices(String choice, Trainer user) {
		if (choice.equals("i")) System.out.println("'v' = deal attack damage to the opponent\n'b' = raise stats\n'n' = use item\n'm' = run away\n'l' = swap pokemon");
		else if (choice.equals("m")) { 
			if ((int) (Math.random() * 4) < 2) {
				inBattle = false; System.out.println("You have sucsessfuly escaped from the wild Pokemon");
			}
			else System.out.println("Escape attempt failed"); userTurn = false;
		}
		else if (choice.equals("v")) {
			faceing.takeDamage(currentPoke.getAttack()); 
			if (faceing.getHeath() == 0) { 
				System.out.println("Congradulations you have defeated the wild " + faceing.getName() + "\nYou have gained " + faceing.getLevel() * 10 + " XP"); 
				currentPoke.gainXP(faceing.getLevel() * 10); 
				currentPoke.deflateStats();
				inBattle = false; 
			}
		}
		else if (choice.equals("l")) {
			System.out.println("What pokemon would you like to switch " + currentPoke.getName() + " with?\nEnter the number that corresponds with it");
			System.out.println(printParty(user));
			Scanner kboard = new Scanner(System.in);
			int pick = kboard.nextInt();
			if (party.get(pick) != null) {
				switchOrder(user, party.get(pick), currentPoke);
				currentPoke = party.get(0);
				userTurn = false;
			}
			else System.out.println("Sorry, there is no Pokemon there");
		}
		else if (choice.equals("b")) {
			currentPoke.raiseStats();
			userTurn = false;
		}
		else if (choice.equals("n")) System.out.println("Sorry, this effect has not been implimented yet");
		else System.out.println("That is not a valid option\nPress 'i' to get a list of the valid options\n");
	}
	
	public void wildBattle(Trainer user) {
		if ((int) (Math.random() * 100) > 20) {
			faceing = Pokemon.getRanPoke();
			currentPoke = party.get(0);
			System.out.println("You have entered a battle with a wild " + faceing.getName() + "!");
			userTurn = true;
			inBattle = true;
			while (inBattle) {
				if (userTurn) {
					System.out.print("Your Pokemon " + currentPoke.getName() + " level " + currentPoke.getLevel() + " has:\n" + currentPoke.getHeath() + " health\n\nThe wild " + faceing.getName() + " level " + faceing.getLevel() + " has:\n" + faceing.getHeath() + " health\nWhat do you chose to do?");
					Scanner kboard = new Scanner(System.in);
					String action = kboard.nextLine();
					battleChoices(action.toLowerCase(), user);
				}
				else {
					System.out.println("It is the computer's turn");
					userTurn = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		boolean gameOn = true;
		
		User player = new User(null, null, null, null, null, null, 5, 0);
		player.addPoke(player, Pokemon.getRanPoke());
		//player.addPoke(player, party);
		player.generateBoard();
		player.placePlayer(player.getYLoc(), player.getXLoc());
		System.out.println("Press 'i' for instructions at any point if unsure what to do");
		while (gameOn) {
			Scanner kboard = new Scanner(System.in);
			System.out.println("\nEnter your move:");
			String direction = kboard.nextLine();
			player.move(direction.toLowerCase());
			if (player.spaceLeft.equals("*")) player.wildBattle(player);
		}
	}
}

