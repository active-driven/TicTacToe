package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
  //      grid.setGridLinesVisible(true);

        
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
        gameStatus.setFill(Color.WHITESMOKE);
        gameStatus.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(gameStatus, 2, 30, 4, 30);   
        
        Label gameName = new Label("TicTacToe");
        gameName.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 14));
        gameName.setLayoutX(-5);
        Label gameVersion = new Label("ver. 1.0");
        gameVersion.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 14));
        gameVersion.setAlignment(Pos.BASELINE_RIGHT);
        Label authorName = new Label("by dream_tree");
        authorName.setFont(Font.font(STYLESHEET_CASPIAN, FontPosture.ITALIC, 14));
        authorName.setTextFill(Color.DARKORCHID);
        grid.add(gameName, 3, 70);
        grid.add(gameVersion, 3, 71);
        grid.add(authorName, 3, 72);
        
         
        Scene scene = new Scene(grid, 600, 600);
        scene.setFill(Color.YELLOWGREEN); 
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public void setButtons(GridPane grid, PlayGame test) {   // nodes/buttons are going from top to down and then next column
		 	Button btn1 = new Button("");    // (0, 0) coordinate on gameGrid
	        Button btn2 = new Button("");    // (1, 0)
	        Button btn3 = new Button("");    // (2, 0)
	        Button btn4 = new Button("");    // (0, 1)
	        Button btn5 = new Button("");    // (1, 1)
	        Button btn6 = new Button("");    // (2, 1)
	        Button btn7 = new Button("");    // (0, 2)
	        Button btn8 = new Button("");    // (1, 2)
	        Button btn9 = new Button("");    // (2, 2)
	        
	        btn1.setMinSize(120, 120);
	        btn2.setMinSize(120, 120);
	        btn3.setMinSize(120, 120);
	        btn4.setMinSize(120, 120);
	        btn5.setMinSize(120, 120);
	        btn6.setMinSize(120, 120);
	        btn7.setMinSize(120, 120);
	        btn8.setMinSize(120, 120);
	        btn9.setMinSize(120, 120);
	        
	        btn1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn3.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn4.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn5.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn6.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn7.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn8.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        btn9.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
	        
	        btn1.setTextFill(Color.DARKORANGE);
	        btn2.setTextFill(Color.DARKORANGE);
	        btn3.setTextFill(Color.DARKORANGE);
	        btn4.setTextFill(Color.DARKORANGE);
	        btn5.setTextFill(Color.DARKORANGE);
	        btn6.setTextFill(Color.DARKORANGE);
	        btn7.setTextFill(Color.DARKORANGE);
	        btn8.setTextFill(Color.DARKORANGE);
	        btn9.setTextFill(Color.DARKORANGE);
	     
	        // when setting buttons as disabled by setDisable(true) method (in setOnAction() method)
	        // causes the text on the button to be very pale;
	        // setting opacity by setOpacity() method causes the text to be well visible again 
	        // (all values gives the same effect except 0)      
	        btn1.setOpacity(50);     
	        btn2.setOpacity(50); 
	        btn3.setOpacity(50); 
	        btn4.setOpacity(50); 
	        btn5.setOpacity(50); 
	        btn6.setOpacity(50); 
	        btn7.setOpacity(50); 
	        btn8.setOpacity(50); 
	        btn9.setOpacity(50); 
	        
	        grid.add(btn1, 1, 2);
	        grid.add(btn2, 1, 3);
	        grid.add(btn3, 1, 4);
	        grid.add(btn4, 2, 2);
	        grid.add(btn5, 2, 3);
	        grid.add(btn6, 2, 4);
	        grid.add(btn7, 3, 2);
	        grid.add(btn8, 3, 3);
	        grid.add(btn9, 3, 4); 	
	        
	        
	        btn1.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn1.setDisable(true);
	        	} else { 		
		        	if(test.getPlayer()==0) {
		        		btn1.setText("O");
		        		String x = test.setValueAndReturnStatus(0, 0, 0);
		        		gameStatus.setText(x);   
		        	} else {
		        		btn1.setText("X");
		        		String x = test.setValueAndReturnStatus(0, 0, 1);
		        		gameStatus.setText(x);     
		        	}
		        	btn1.setDisable(true);
	        	}
	        });
	        btn2.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn2.setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		btn2.setText("O");
		        		String x = test.setValueAndReturnStatus(1, 0, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn2.setText("X");
		        		String x = test.setValueAndReturnStatus(1, 0, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn2.setDisable(true);
	        	}
	        });
	        btn3.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn3.setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		btn3.setText("O");
		        		String x = test.setValueAndReturnStatus(2, 0, 0);
		        		gameStatus.setText(x);        		
		        	} else {
		        		btn3.setText("X");
		        		String x = test.setValueAndReturnStatus(2, 0, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn3.setDisable(true);
	        	}
	        });
	        btn4.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn4.setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		btn4.setText("O");
		        		String x = test.setValueAndReturnStatus(0, 1, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn4.setText("X");
		        		String x = test.setValueAndReturnStatus(0, 1, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn4.setDisable(true);
	        	}
	        });
	        btn5.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn5.setDisable(true);
	        	} else {
		        	if(test.getPlayer()==0) {
		        		btn5.setText("O");
		        		String x = test.setValueAndReturnStatus(1, 1, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn5.setText("X");
		        		String x = test.setValueAndReturnStatus(1, 1, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn5.setDisable(true);
	        	}
	        });
	        btn6.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn6.setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		btn6.setText("O");
		        		String x = test.setValueAndReturnStatus(2, 1, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn6.setText("X");
		        		String x = test.setValueAndReturnStatus(2, 1, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn6.setDisable(true);
	        	}
	        });
	        btn7.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn7.setDisable(true);
	        	} else {
		        	if(test.getPlayer()==0) {
		        		btn7.setText("O");
		        		String x = test.setValueAndReturnStatus(0, 2, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn7.setText("X");
		        		String x = test.setValueAndReturnStatus(0, 2, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn7.setDisable(true);
	        	}
	        });
	        btn8.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn8.setDisable(true);
	        	} else {
		        	if(test.getPlayer()==0) {
		        		btn8.setText("O");
		        		String x = test.setValueAndReturnStatus(1, 2, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn8.setText("X");
		        		String x = test.setValueAndReturnStatus(1, 2, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn8.setDisable(true);
		        }
	        });
	        btn9.setOnAction((t) -> {
	        	if(test.getStopActionStatus()) {
	        		btn9.setDisable(true);
	        	} else { 
		        	if(test.getPlayer()==0) {
		        		btn9.setText("O");
		        		String x = test.setValueAndReturnStatus(2, 2, 0);
		        		gameStatus.setText(x);
		        	} else {
		        		btn9.setText("X");
		        		String x = test.setValueAndReturnStatus(2, 2, 1);
		        		gameStatus.setText(x);
		        	}
		        	btn9.setDisable(true);
	        	}
	        });
 
	}
	

}
