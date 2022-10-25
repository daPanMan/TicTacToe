import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe{
	public static void main (String[]args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the tic tac toe game!\nNumber of people playing (1 or 2) ");
		String num = input.nextLine();
		while(!num.equals("1") && !num.equals("2")) {
			System.out.println("Not a valid number, please try again\nNumber of people playing (1 or 2) ");
			num = input.nextLine();
		}
		String[][] board = new String[7][13];
		initBoard(board);
		printboard(board);
		int n = Integer.valueOf(num);
		rungame(board, n);
		input.close();
	}
	
	public static String[][] initBoard(String[][] board) {
		int n = 1;
		for(int a = 0; a < board.length; a++) {
			for(int b = 0; b < board[0].length; b++) {
				if(a % 2 == 0 && b%4 == 2) {
					board[a][b] = "-";
				}else if(a % 2 != 0 && b % 4 == 0) {
					board[a][b] = "|";
				}else if(a % 2 != 0 && b % 4 == 2) {
					board[a][b] = String.valueOf(n);
					n++;
				}else {
					board[a][b] = " ";
				}
			}
		}
		return board;
	}
	
	public static void placeXmarker(String[][] bo)  throws InterruptedException {
		if(isFilled(bo)) {
			System.out.println("It's a tie!");
			return;
		}
		Scanner i = new Scanner(System.in);
		System.out.print("\nPlace the marker position (1 to 9): ");
		int ans = i.nextInt();
		int a = 0;
		int b = 0;
		switch(ans) {
			case 1:
				a = 1;
				b = 2;
				break;
			case 2:
				a = 1;
				b = 6;
				break;
			case 3:
				a = 1;
				b = 10;
				break;
			case 4:
				a = 3;
				b = 2;
				break;
			case 5:
				a = 3;
				b = 6;
				break;
			case 6:
				a = 3;
				b = 10;
				break;
			case 7:
				a = 5;
				b = 2;
				break;
			case 8:
				a = 5;
				b = 6;
				break;
			case 9:
				a = 5;
				b = 10;
				break;
			default:
				System.out.println("invalid, please try again. ");
				placeXmarker(bo);
				break;
		}
		if(bo[a][b] != "X" && bo[a][b] != "O") {
			bo[a][b] = "X";
		}else{
			System.out.print("this is occupied, so");
			for(int q = 0; q < 6; q++) {
				System.out.print(" .");
				TimeUnit.MILLISECONDS.sleep(200);
			}
			placeXmarker(bo);
		}
	}
	
	public static void CPUX(String[][] pf) throws InterruptedException {
		int[] posX = {1, 3, 5};
		int[] posY = {2, 6, 10};
		int a = posX[(int) (Math.random()*3)];
		int b = posY[(int) (Math.random()*3)];
		if(pf[a][b] != "X" && pf[a][b] != "O") {
			pf[a][b] = "X";
		}else {
			if(isFilled(pf)) {
				System.out.println("It's a tie!");
				return;
			}
			CPUX(pf);
		}
		System.out.print("CPU: Hmm .");
		for(int q = 0; q < 6; q++) {
			System.out.print(" .");
			TimeUnit.MILLISECONDS.sleep(200);
		}
		System.out.println();
	}
	
	public static void placeOmarker(String[][] bo)  throws InterruptedException {
		if(isFilled(bo)) {
			System.out.println("It's a tie!");
			return;
		}
		Scanner i = new Scanner(System.in);
		System.out.print("\nPlace the marker position (1 to 9): ");
		int ans = i.nextInt();
		int a = 0;
		int b = 0;
		switch(ans) {
			case 1:
				a = 1;
				b = 2;
				break;
			case 2:
				a = 1;
				b = 6;
				break;
			case 3:
				a = 1;
				b = 10;
				break;
			case 4:
				a = 3;
				b = 2;
				break;
			case 5:
				a = 3;
				b = 6;
				break;
			case 6:
				a = 3;
				b = 10;
				break;
			case 7:
				a = 5;
				b = 2;
				break;
			case 8:
				a = 5;
				b = 6;
				break;
			case 9:
				a = 5;
				b = 10;
				break;
			default:
				System.out.println("invalid, please try again. ");
				placeOmarker(bo);
				break;
		}
		if(bo[a][b] != "O" && bo[a][b] != "X") {
			bo[a][b] = "O";
		}else{
			System.out.print("this is occupied, so");
			for(int q = 0; q < 6; q++) {
				System.out.print(" .");
				TimeUnit.MILLISECONDS.sleep(200);
			}
			placeOmarker(bo);
		}
	}
	
	public static boolean isFilled(String[][] board) {
		int count = 0;
		for(int a = 1; a < board.length; a+=2) {
			for(int b = 1; b < board[0].length; b+=2) {
				if(board[a][b] != " ") {
					count++;
				}
			}
		}
		return count == 9;
	}
	
	public static void CPUO(String[][] pf) throws InterruptedException {
		int[] posX = {1, 3, 5};
		int[] posY = {2, 6, 10};
		int a = posX[(int) (Math.random()*3)];
		int b = posY[(int) (Math.random()*3)];
		if(pf[a][b] != "O" && pf[a][b] != "X") {
			pf[a][b] = "O";
		}else {
			if(isFilled(pf)) {
				System.out.println("It's a tie!");
				return;
			}
			CPUO(pf);
		}
		System.out.print("CPU: Hmm .");
		for(int q = 0; q < 6; q++) {
			System.out.print(" .");
			TimeUnit.MILLISECONDS.sleep(200);
		}
		System.out.println();
	}
	
	public static void rungame(String[][] boa, int players) throws InterruptedException {
		boolean isNotDone = true;
		Scanner in = new Scanner(System.in);
		if(players == 1) {
			System.out.println("Which marker do you want? (X or O)");
			String p = in.nextLine();
			while(!p.equals("X") && !p.equals("x") && !p.equals("O") && !p.equals("o")){
				System.out.println("Invalid input, please try again. (X or O)");
				p = in.nextLine();
			}
			if(p.indexOf('X')!=-1 || p.indexOf('x')!=-1) {
				Scanner input = new Scanner(System.in);
				System.out.print("Do you wanna go first or second? (answer first or second)");
				String order = input.nextLine();
				if(order.contains("f")) {
					do{
						placeXmarker(boa);
						isNotDone = determine(boa,isNotDone);
						printboard(boa);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						CPUO(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}else{
					do{
						CPUO(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						placeXmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}
				input.close();
			}else{
				Scanner en = new Scanner(System.in);
				System.out.print("Do you wanna go first or second?  (answer first or second)");
				String order = en.nextLine();
				if(order.contains("f")) {
					 do{
						placeOmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						CPUX(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}else{
					 do{
						CPUX(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						placeOmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}
				en.close();
			}
		}else if(players == 2) {
			System.out.println("which marker does the first player want? (X or O)");
			String p = in.nextLine();
			if(p.indexOf('X')!=-1 || p.indexOf('x')!=-1) {
				Scanner input = new Scanner(System.in);
				System.out.print("Do you wanna go first or second? (answer first or second)");
				String order = input.nextLine();
				if(order.contains("f")) {
						do {
						placeXmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						placeOmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}else{
					do{
						placeOmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						placeXmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone) ;
				}
				input.close();
			}else {
				Scanner en = new Scanner(System.in);
				System.out.print("Do you wanna go first or second? (answer first or second)");
				String order = en.nextLine();
				if(order.contains("f")) {
					 do{
						placeOmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						placeXmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}else{
					 do{
						placeXmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
						if(!isNotDone) {
							in.close();
							printResult(boa);
							return;
						}
						placeOmarker(boa);
						printboard(boa);
						isNotDone = determine(boa,isNotDone);
					}while(isNotDone);
				}
				en.close();
			}
		}
		in.close();
		printResult(boa);
	}
	
	public static void printResult(String[][] b) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println("We have a result!");
		TimeUnit.MILLISECONDS.sleep(1000);
		if(Winner(b) == "X") {
			System.out.println("X wins!");
		}else if(Winner(b) == "O") {
			System.out.println("O wins!");
		}else{
			System.out.println("It's a tie, how intense!");
		}
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println("JOHN PAN 2019, ALL RIGHTS RESERVED");
	}
	
	public static boolean determine(String[][] b, boolean ind) {
		if(b[1][2] == b[3][6] && b[3][6] == b[5][10] && b[5][10] != " "){
			return false;
		}else if(b[1][10] == b[3][6] && b[3][6] == b[5][2] && b[5][2] != " ") {
			return false;
		}else {
			for(int i = 1; i < b.length; i+=2) {
				if(b[i][2] == b[i][6] && b[i][6] == b[i][10] && b[i][10] != " ") {
					return false;
				}
			}
			for(int i = 1; i < b.length; i+=2) {
				if(b[1][i] == b[3][i] && b[3][i] == b[5][i] && b[5][i] != " ") {
					return false;
				}
			}
		}
		return true;
	}

	public static String Winner(String[][] b) {
		if(b[1][2] == b[3][6] && b[3][6] == b[5][10] && b[5][10] == "X"){
			return "X";
		}else if(b[1][10] == b[3][6] && b[3][6] == b[5][2] && b[5][2] == "X") {
			return "X";
		}else {
			for(int i = 1; i < b.length; i+=2) {
				if(b[i][2] == b[i][6] && b[i][6] == b[i][10] && b[i][10] == "X") {
					return "X";
				}
			}
			for(int i = 1; i < b.length; i+=2) {
				if(b[1][i] == b[3][i] && b[3][i] == b[5][i] && b[5][i] == "X") {
					return "X";
				}
			}
		}
		if(b[1][2] == b[3][6] && b[3][6] == b[5][10] && b[5][10] == "O"){
			return "O";
		}else if(b[1][10] == b[3][6] && b[3][6] == b[5][2] && b[5][2] == "O") {
			return "O";
		}else {
			for(int i = 1; i < b.length; i+=2) {
				if(b[i][2] == b[i][6] && b[i][6] == b[i][10] && b[i][10] == "O") {
					return "O";
				}
			}
			for(int i = 1; i < b.length; i+=2) {
				if(b[1][i] == b[3][i] && b[3][i] == b[5][i] && b[5][i] == "O") {
					return "O";
				}
			}
		}
		return "";
	}
	
	public static boolean hasResult(String[][] b) {
		int counter = 0;
		for(int i = 1; i < 6; i+=2) {
			for(int j = 1; j < 6; j+=2) {
				if(b[i][j] != " ") {
					counter++; 
				}
			}
		}
		if (counter == 9) {
			return true;
		}else if(b[1][1] == b[3][3] && b[3][3] == b[5][5]){
			return true;
		}else if(b[1][5] == b[3][3] && b[3][3] == b[5][1]) {
			return true;
		}
		return false;
	}
	
	public static void printboard(String[][] b) {
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}
}
