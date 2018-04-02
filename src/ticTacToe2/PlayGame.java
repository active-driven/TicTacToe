package ticTacToe2;

public class PlayGame {
	
	private int[][] gameGrid;
	private int player = 0;
	private int countMoves = 9;
	private boolean stopActionStatus = false;
	
	PlayGame()  {
		gameGrid = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				gameGrid[i][j] = -1;
			}
		}
	}

	/**
	 * @param player player 1 or player 2 
	 */
	public String play(int player) {
		printGrid();    // for debugging purpose only
		countMoves--;
		if       (gameGrid[0][0] == player && gameGrid[0][1] == player && gameGrid[0][2] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[1][0] == player && gameGrid[1][1] == player && gameGrid[1][2] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[2][0] == player && gameGrid[2][1] == player && gameGrid[2][2] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[0][0] == player && gameGrid[1][0] == player && gameGrid[2][0] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[0][1] == player && gameGrid[1][1] == player && gameGrid[2][1] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[0][2] == player && gameGrid[1][2] == player && gameGrid[2][2] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[0][0] == player && gameGrid[1][1] == player && gameGrid[2][2] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(gameGrid[0][2] == player && gameGrid[1][1] == player && gameGrid[2][0] == player)  {
			return "Player " + (player+1) + " wins!!";
		} else if(countMoves==0) {     // happens only if no one wins
			return "Draw! Wanna play again?";
		} else {
			return player==1 ? "Next move: Player " + 1 : "Next move: Player " + 2;
		}
		
	}
	
	/**
	 * @param positionX gameGrid x coordinate
	 * @param positionY gameGrid y coordinate
	 * @param player one of two possible values: 
	 * 0 is nought (Player 1)
	 * 1 is cross (Player 2)
	 * @return actual game info status (GameInterface.Text info field)
	 */
	public String setValueAndReturnStatus(int positionX, int positionY, int player) {
		gameGrid[positionX][positionY] = player;
		String x = play(player);
		System.out.println(x);    // for debugging purpose only
		if(x.substring(9, 13).equals("wins")) {
			stopAction();	
		}
		invertPlayer(player);
		return x;
	}

	public void printGrid() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
			System.out.printf("%2d ", gameGrid[i][j]);		
			}
		System.out.println();
		}
	}

	public void stopAction() {
		stopActionStatus=true;
	}
	
	public boolean getStopActionStatus() {
		return stopActionStatus;
	}

	public void invertPlayer(int player) {
		if(player==0) {
			setPlayer(1);
		} else {
			setPlayer(0);
		}
	}
	public int getPlayer() {
		return player;
	}
	
	public int setPlayer(int player) {
		return this.player=player;
	}
}