package Last;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jacob
 */
public class FirstPosterExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane mainPane = new BorderPane();
        Scene scene = new Scene(mainPane, 600, 750);
        BackgroundImage bg = new BackgroundImage(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Munku-Sardyk.jpg/640px-Munku-Sardyk.jpg", mainPane.getWidth(), mainPane.getHeight(), false, true), 
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        mainPane.setBackground(new Background(bg));
        
        HBox hb = new HBox();
        VBox vbb = new VBox();
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        VBox vb3 = new VBox();
        
        Text title = new Text("ELEVATE");
        title.setFont(Font.font("Cambria", FontWeight.BOLD, 100));
//        System.out.println(javafx.scene.text.Font.getFamilies());
        title.setFill(Color.AQUA);
        Text aboveTitle = new Text("A John Smith Film");
        aboveTitle.setFont(Font.font("Cambria", FontWeight.BOLD, 25));
        aboveTitle.setFill(Color.AQUAMARINE);
        Text belowTitle = new Text("Coming January 55");
        belowTitle.setFont(Font.font("Cambria", FontWeight.BOLD, 35));
        belowTitle.setFill(Color.AQUAMARINE);
        
        vbb.getChildren().addAll(aboveTitle, title, belowTitle);
        vbb.setAlignment(Pos.CENTER);
        mainPane.setBottom(vbb);
        
        Text fname1 = new Text("Johnson");
        fname1.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        fname1.setFill(Color.BLACK);
        Text lname1 = new Text("Jackson");
        lname1.setFont(Font.font("Arial", FontWeight.MEDIUM, 25));
        lname1.setFill(Color.BLACK);
        vb1.getChildren().addAll(fname1, lname1);
        vb1.setAlignment(Pos.CENTER);
        ArrayList actors = new ArrayList();
        actors.add(vb1);
        hb.getChildren().addAll(actors);
        hb.setAlignment(Pos.CENTER);
        mainPane.setTop(hb);
        
        primaryStage.setTitle("Insert Poster Title");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
