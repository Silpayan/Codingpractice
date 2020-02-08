package leetcode.array.matrix;
/*
 * 1275 Find Winner on a Tic Tac Toe Game
 * 
 */
public class FindWinnerofTicTacToeGame {

	public static void main(String[] args) {

		int moves[][] = {{2,0},{1,1},{0,2},{2,1},{1,2},{1,0},{0,0},{0,1}};//{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};//{{0,0},{2,1},{2,2}};;//{{0,0},{2,0},{1,1},{2,1},{2,2}};

		FindWinnerofTicTacToeGame winner = new FindWinnerofTicTacToeGame();

		System.out.println(winner.tictactoe(moves));
	}

	public String tictactoe(int[][] moves) {

		char tictactoe[][] = new char[3][3];
		if (moves.length < 5)
			return "Pending";

		for (int i = 0; i < moves.length; i++) {
			//for (int j = 0; j < moves[0].length; j++) {
				System.out.print(moves[i][0]+" "+moves[i][1]);
				
				if(i%2==0) {
					tictactoe[moves[i][0]][moves[i][1]] = 'X';
				} else {
					tictactoe[moves[i][0]][moves[i][1]] = 'O';
				}
					
		}

		System.out.println("Print Matrix");
		
		int countX = 0, countO = 0;
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				
				if(tictactoe[i][j] == 'X') countX++;
				else if(tictactoe[i][j] == 'O') countO++;
				System.out.print(tictactoe[i][j]);
				
				if(countX==3) return "A";
				if(countO==3) return "B";
			
			}
			System.out.println();
			countX = 0; countO = 0;
		}
		
		for (int j = 0; j < 3; j++) {
			
			for (int i = 0; i < 3; i++) {
				
				if(tictactoe[i][j] == 'X') countX++;
				else if(tictactoe[i][j] == 'O') countO++;
				System.out.print(tictactoe[i][j]);
				
				if(countX==3) return "A";
				if(countO==3) return "B";
			
			}
			System.out.println();
			countX = 0; countO = 0;
		}
		
		//Left Diagonal
		countX = 0; countO = 0;
		
		for(int i = 0;i<3;i++) {
			
			if(tictactoe[i][i]=='X')
				countX++;
			if(tictactoe[i][i]=='O')
				countO++;
			
		}

		if(countX == 3)
			return "A";
		if(countO == 3)
			return "B";
		
		System.out.println(countX+" "+countO);
		
		//right Diagonal
		countX = 0; countO = 0;
		
		for(int i = 0;i<3;i++) {
			//int countX = 0, countO = 0;
			System.out.println(tictactoe[i][2-i]+ " "+i);
			if(tictactoe[i][2-i]=='X')
				countX++;
			if(tictactoe[i][2-i]=='O')
				countO++;
		}

		if(countX == 3)
			return "A";
		if(countO == 3)
			return "B";
		
		System.out.println(countX+" "+countO);
				
		return moves.length == 9?"Draw":"Pending";

	}

}