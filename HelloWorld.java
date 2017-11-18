package application;

import org.omg.CORBA.PUBLIC_MEMBER;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;



public class HelloWorld extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane root = new GridPane();
        final int size = 8 ;
        int[][] centre_of_mass = new int[size][size];
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
                String name = "";
                String color ;
                String borderColor;
                color = "white";
                borderColor = "black";
                square.setStyle("-fx-background-color: "+color+";"+"-fx-border-color:"+borderColor+";");
                name += String.valueOf(row) + " , "+ String.valueOf(col) ;
                if(row == 0 && col == 0 || row == 0 && col == size-1 || row == size-1 && col == 0 || row == size-1 && col == size-1){
                	centre_of_mass[row][col]= 1;
                }
                else if(row == 0 || col == 0 || row == size-1 || col == size-1){
                	centre_of_mass[row][col]= 2;
                }
                else{
                	centre_of_mass[row][col]= 3;
                }
                Label label = new Label();
                label.setText(name);
                label.setTextFill(Color.web("#0076a3"));
                label.setFont(new Font("Arial", 12));
                
                GridPane.setConstraints(label, col	, row);
                //System.out.println(centre_of_mass);
               // square.setOnMouseClicked(e -> System.out.println(centre_of_mass));
                square.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        //want to get column index =0 and row index=0
                    	int r =  GridPane.getRowIndex(square);
                    	int c =  GridPane.getColumnIndex(square);
                    	//System.out.println("Row: "+ GridPane.getRowIndex(square));
                    	//System.out.println("Column: "+ GridPane.getColumnIndex(square));
                    	System.out.println("Centre of mass of selected cell is: "+centre_of_mass[r][c]);
                    }
                });
                root.add(square, col, row);
                root.getChildren().add(label);
            }
        }
       
        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
     
        
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
