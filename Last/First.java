/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Last;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class First extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        

        GridPane gridPane = new GridPane();

        mainPane.setCenter(gridPane);
        
        // make all buttons
        Button btn1 = new Button();
        btn1.setText("?");
        Button btn2 = new Button();
        btn2.setText("?");
        Button btn3 = new Button();
        btn3.setText("?");
        Button btn4 = new Button();
        btn4.setText("?");
        Button btn5 = new Button();
        btn5.setText("?");
        Button btn6 = new Button();
        btn6.setText("?");
        Button btn7 = new Button();
        btn7.setText("?");
        Button btn8 = new Button();
        btn8.setText("?");
        Button btn9 = new Button();
        btn9.setText("?");
        Button btn10 = new Button();
        btn10.setText("?");
        Button btn11 = new Button();
        btn11.setText("?");
        Button btn12 = new Button();
        btn12.setText("?");
        Button btn13 = new Button();
        btn13.setText("?");
        Button btn14 = new Button();
        btn14.setText("?");
        Button btn15 = new Button();
        btn15.setText("?");
        Button btn16 = new Button();
        btn16.setText("?");

//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });

        // add all buttons
        gridPane.add(btn1, 0, 0);
        gridPane.add(btn2, 0, 1);
        gridPane.add(btn3, 0, 2);
        gridPane.add(btn4, 0, 3);
        gridPane.add(btn5, 1, 0);
        gridPane.add(btn6, 1, 1);
        gridPane.add(btn7, 1, 2);
        gridPane.add(btn8, 1, 3);
        gridPane.add(btn9, 2, 0);
        gridPane.add(btn10, 2, 1);
        gridPane.add(btn11, 2, 2);
        gridPane.add(btn12, 2, 3);
        gridPane.add(btn13, 3, 0);
        gridPane.add(btn14, 3, 1);
        gridPane.add(btn15, 3, 2);
        gridPane.add(btn16, 3, 3);
        
        Image circle = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Circulo_verde.png/640px-Circulo_verde.png", 100, 100, false, false);
        Image square = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Red_square.svg/480px-Red_square.svg.png", 100, 100, false, false);
        Image octagon = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Basic_octagon.svg/600px-Basic_octagon.svg.png", 100, 100, false, false);
        Image triangle = new Image("https://upload.wikimedia.org/wikipedia/commons/e/e8/Triangle_-_polygon.png", 100, 100, false, false);
        Image cross = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Star_polygon_6-3.svg/640px-Star_polygon_6-3.svg.png", 100, 100, false, false);
        Image rhombus = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Isotoxal_rhombus.svg/346px-Isotoxal_rhombus.svg.png", 100, 100, false, false);    
        Image pentagon = new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/5_Sided_Polygon.jpg", 100, 100, false, false);
        Image star = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Pinwheeled_Red_Star.svg/631px-Pinwheeled_Red_Star.svg.png", 100, 100, false, false);
        
        btn1.setGraphic(new ImageView(circle));
        btn2.setGraphic(new ImageView(square));
        btn3.setGraphic(new ImageView(octagon));
        btn4.setGraphic(new ImageView(triangle));
        btn5.setGraphic(new ImageView(cross));
        btn6.setGraphic(new ImageView(rhombus));
        btn7.setGraphic(new ImageView(pentagon));
        btn8.setGraphic(new ImageView(star));
        
        
        mainPane.setTop(new Label("Title Here"));

        Scene scene = new Scene(mainPane, 700, 700);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
