import java.util.Scanner;
public class TicTacToe {
	
	 
	private char[][] board; 
	private boolean playerX; 

	private Scanner input; 

	
	
	public TicTacToe()  {
	
		board = new char[3][3];
			
		for(int row = 0; row < 3; row++)  {
			
			for(int col = 0; col < 3; col++)
				board[row][col] = ' ';
		}
		
		playerX = true;
		
		input = new Scanner(System.in);
	}
	

	
	private void printRow(int row)  {
	
		System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
	}
	

	private void displayBoard()  {
	
		printRow(0);
		System.out.println("-----------");
		printRow(1);
		System.out.println("-----------");
		printRow(2);
	}
	
	
	
	private void printMenu()  {
	
		if(playerX)
			System.out.println("Player X Turn");
		else
			System.out.println("Player O Turn");
			
		System.out.println("Select an Option");
		System.out.println("1) Move");
		System.out.println("2) Start Over");
		System.out.println("3) Quit");
		System.out.print("Choice: ");
	}
	
	
	private boolean getMove()  {
	
		boolean invalid = true;
		int row = 0, column = 0;
		
		while(invalid)  {
	
			System.out.println("Enter two numbers separated by spaces to place your mark, Ex: 0 0 is top left corner");
			row = input.nextInt();
			column = input.nextInt();
			
			if(row >= 0 && row <= 2 && column >= 0 && column <= 2)  {
			
				if(board[row][column] != ' ')
					System.out.println("Box is taken");
				else
					invalid = false;
			}
			else
				System.out.println("Invalid position");
		}
		
		if(playerX)
			board[row][column] = 'X';
		else
			board[row][column] = 'O';
		
		return win(row,column);
	}
	
	
		
	
	
	private boolean win(int lR, int lC)  {
	
		boolean win = false; 
		char marker = board[lR][lC]; 
		int numPlace = 0;
		for(int c = 0; c < 3; c++)  {
			if(board[lR][c] == marker)
				numPlace++;
		}
		
		if(numPlace == 3)
			win = true;
	
		numPlace = 0;
		for(int r = 0; r < 3; r++)  {
			if(board[r][lC] == marker)
				numPlace++;
		}
		
		if(numPlace == 3)
			win = true;

		numPlace = 0;
		for(int i = 0; i < 3; i++)  {
			if(board[i][i] == marker)
				numPlace++;
		}
		
		if(numPlace == 3)
			win = true;
		
		numPlace = 0;
		for(int i = 0; i < 3; i++)  {
			if(board[i][2-i] == marker)
				numPlace++;
		}

		if(numPlace == 3)
			win = true;
			
		return win;
	}



	
	public void start()  {
	
		while(true)  {
		
			displayBoard();
			printMenu();
			
			int choice = input.nextInt();
		
			if(choice == 1)  {
			
				if(getMove())  {
					displayBoard();	
					
					if(playerX)
						System.out.println("Player X Wins");
					else
						System.out.println( " Player O Wins");
						
					System.exit(0);
				}
				else if(fullBoard())  {
				
					displayBoard(); 
					
					System.out.println("Tie");
					
					System.exit(0);
				}
				else  {
					playerX = !playerX;  
				}
			}
			else if(choice == 2)
				StartOver();
			else if(choice == 3)
				System.exit(0);	
			else
				System.out.println("Choose Different Option");
		}	

	}
	
	
	
	
	private void StartOver()  {
		
		for(int r = 0; r < 3; r++)  {
			
			for(int c = 0; c < 3; c++)
				board[r][c] = ' ';
		}

			
		playerX = true;
	}

	
	
	private boolean fullBoard()  {
		
		int numSpotsFilled = 0;
		
		for(int row = 0; row < 3; row++)  {
			
			for(int col = 0; col < 3; col++)  {
				if(board[row][col] == 'X' || board[row][col] == 'O')
					numSpotsFilled++;
			}
		}
		
		return numSpotsFilled == 9;
	}
	

	
	public static void main(String[] args) {

TicTacToe game = new TicTacToe();
		
		game.start();
	
	
	
	}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




















}
