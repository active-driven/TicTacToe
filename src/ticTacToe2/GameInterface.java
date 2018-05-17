package ticTacToe2;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameInterface extends Application {
	
	private Text gameStatus;
	
	public static void main(String[] args) {
		launch(args);		
	}

	@Override
	public void start(Stage primaryStage) {

		PlayGame test = new PlayGame();
		
        primaryStage.setTitle("Tic Tac Toe");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setPadding(new Insets(35, 35, 35, 35));
        grid.setStyle("-fx-background-color: transparent;");   // or null; if not set, scene background is (default) white always
  //    grid.setGridLinesVisible(true);
       
        Text startingLine = new Text("Click me:)");
        startingLine.setFill(Color.BLACK);
        startingLine.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid.add(startingLine, 0, 0, 4, 1);
        Label emptyLine = new Label("");
        grid.add(emptyLine, 0, 1, 4, 1);
        
        setButtons(grid, test);        
        
        Label gameInfo = new Label("Game info: ");
        gameInfo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(gameInfo, 1, 30, 2, 30);
      
        gameStatus = new Text("Player 1 starts the game");
        gameStatus.setFill(Color.BROWN);
        gameStatus.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(gameStatus, 2, 30, 4, 30);   
        
        Label gameName = new Label("TicTacToe");
        gameName.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 14));
        Label gameVersion = new Label("ver. 2.0");
        gameVersion.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 14));
        gameVersion.setAlignment(Pos.BASELINE_RIGHT);
        Label authorName = new Label("by dream_tree");
        authorName.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 14));
        authorName.setTextFill(Color.FIREBRICK);
        grid.add(gameName, 4, 70, 30, 70);
        grid.add(gameVersion, 4, 80, 30, 80);
        grid.add(authorName, 4, 90, 30, 90);
        
        DropShadow shadow = new DropShadow();
        shadow.setRadius(40.0);
        shadow.setColor(Color.RED);
   //   shadow.setOffsetX(-7.0);
   //   shadow.setOffsetY(-7.0);
        
        Button playAgain = new Button("Play again");
        playAgain.setFont(Font.font("TAHOMA", 15));
        playAgain.setEffect(shadow);
        Circle playAgainCircle = new Circle(1);    // must be any radius specified
        playAgain.setMinSize(80, 80);              // must be used to set circle at all
        playAgain.setShape(playAgainCircle); 
        grid.add(playAgain, 35, 2);
        playAgain.setOnAction(e -> start(primaryStage));
        
        Button readMe = new Button("Read me");
        readMe.setFont(Font.font("TAHOMA", 15)); 
        readMe.setEffect(shadow);
        Circle readMeCircle = new Circle(1);
        readMe.setMinSize(80, 80);
        readMe.setShape(readMeCircle); 
        grid.add(readMe, 35, 3);
        readMe.setOnAction(f -> {
        			Random random = new Random();
        			gameStatus.setText(randomText(random));
        			gameStatus.setFill(Color.LIMEGREEN);
       		});    
        
        Button exit = new Button("Exit game");
        exit.setFont(Font.font("TAHOMA", 15));        
        exit.setEffect(shadow);
        Circle exitCircle = new Circle(1);
        exit.setMinSize(80, 80);
        exit.setShape(exitCircle);
        grid.add(exit, 35, 4);
        exit.setOnAction(g -> System.exit(0));     
         
        Scene scene = new Scene(grid, 700, 650);
        scene.setFill(Color.NAVAJOWHITE); 
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	/* (non-Javadoc) 
	 * why using setOpacity() method:
	 * setting buttons as disabled by setDisable(true) method (in setOnAction() method)
	 * causes the text on the button to be very pale,
	 * setting opacity by setOpacity() method causes the text to be well visible again 
	 * (all values except 0 give the same effect) 
	 */ 	 	
	/**
	 * Sets and defines buttons on GridPane.
	 * @param grid GridPane pane
	 * @param test PlayGame instance
	 */	
	public void setButtons(GridPane grid, PlayGame test) {  // nodes/buttons on GridPane are going from top to down and next column then
		
			Button[][] buttons = new Button[3][3];
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					buttons[i][j] = new Button("");           
					buttons[i][j].setMinSize(120, 120);
					buttons[i][j].setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
					buttons[i][j].setTextFill(Color.FIREBRICK);
					buttons[i][j].setOpacity(50); 
					grid.add(buttons[i][j], i+1, j+2);  // starting at column 1, row 2, than column 1, row 3, then column 1, r0w 4 etc.
				}
			}
       
			buttons[0][0].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[0][0].setDisable(true);
	        	} else { 		
		        	if(test.getPlayer()==0) {
		        		buttons[0][0].setText("O");
		        		String x = test.setValueAndReturnStatus(0, 0, 0);
		        		gameStatus.setText(x);   
		        	} else {
		        		buttons[0][0].setText("X");
		        		String x = test.setValueAndReturnStatus(0, 0, 1);
		        		gameStatus.setText(x);     
		        	}
		        	buttons[0][0].setDisable(true);
	        	}
	        });
			buttons[0][1].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[0][1].setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		buttons[0][1].setText("O");
		        		String x = test.setValueAndReturnStatus(1, 0, 0);   // (0, 1) on int[][] gameGrid is (1, 0) on GridPane grid
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[0][1].setText("X");
		        		String x = test.setValueAndReturnStatus(1, 0, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[0][1].setDisable(true);
	        	}
	        });
			buttons[0][2].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[0][2].setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		buttons[0][2].setText("O");
		        		String x = test.setValueAndReturnStatus(2, 0, 0);
		        		gameStatus.setText(x);        		
		        	} else {
		        		buttons[0][2].setText("X");
		        		String x = test.setValueAndReturnStatus(2, 0, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[0][2].setDisable(true);
	        	}
	        });
			buttons[1][0].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[1][0].setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		buttons[1][0].setText("O");
		        		String x = test.setValueAndReturnStatus(0, 1, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[1][0].setText("X");
		        		String x = test.setValueAndReturnStatus(0, 1, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[1][0].setDisable(true);
	        	}
	        });
			buttons[1][1].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[1][1].setDisable(true);
	        	} else {
		        	if(test.getPlayer()==0) {
		        		buttons[1][1].setText("O");
		        		String x = test.setValueAndReturnStatus(1, 1, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[1][1].setText("X");
		        		String x = test.setValueAndReturnStatus(1, 1, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[1][1].setDisable(true);
	        	}
	        });
			buttons[1][2].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[1][2].setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		buttons[1][2].setText("O");
		        		String x = test.setValueAndReturnStatus(2, 1, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[1][2].setText("X");
		        		String x = test.setValueAndReturnStatus(2, 1, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[1][2].setDisable(true);
	        	}
	        });
			buttons[2][0].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[2][0].setDisable(true);
	        	} else {
		        	if(test.getPlayer()==0) {
		        		buttons[2][0].setText("O");
		        		String x = test.setValueAndReturnStatus(0, 2, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[2][0].setText("X");
		        		String x = test.setValueAndReturnStatus(0, 2, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[2][0].setDisable(true);
	        	}
	        });
			buttons[2][1].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[2][1].setDisable(true);
	        	} else {
		        	if(test.getPlayer()==0) {
		        		buttons[2][1].setText("O");
		        		String x = test.setValueAndReturnStatus(1, 2, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[2][1].setText("X");
		        		String x = test.setValueAndReturnStatus(1, 2, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[2][1].setDisable(true);
		        }
	        });
			buttons[2][2].setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		buttons[2][2].setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		buttons[2][2].setText("O");
		        		String x = test.setValueAndReturnStatus(2, 2, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		buttons[2][2].setText("X");
		        		String x = test.setValueAndReturnStatus(2, 2, 1);
		        		gameStatus.setText(x);
		        	}
		        	buttons[2][2].setDisable(true);
	        	}
	        });
	}
	
	public String randomText(Random random) {
		String[] randomSentences = {"Do you like me?", "Kiss me please:-)", "Give me one more chance", 
				"Summer holiday needed..", "Check my buttons", "Dreaming..", "Aren't you sleepy?", "I'm hungry",
				"Go to bed, it`s late!", "Cookies please!!"} ;
		int index = random.nextInt(randomSentences.length);	
		return randomSentences[index];
	}	
}
