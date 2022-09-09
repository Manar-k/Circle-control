/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3_circle;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;//*
import javafx.event.EventHandler;//*
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author lokamloka
 */
public class Lecture3_circle extends Application {
        Circle circle = new Circle(50);
    @Override
    public void start(Stage primaryStage) {
        circle.setStroke(Color.BLACK); 
        circle.setFill(Color.CHOCOLATE);
        
        HBox hBox = new HBox();
        hBox.setSpacing(10); 
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge"); 
        Button btShrink = new Button("Shrink"); 
        hBox.getChildren().addAll(btEnlarge, btShrink); 
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circle);
        borderPane.setBottom(hBox);
//////////////////////////////////////////////////////////////////////////////////        
//        btEnlarge.setOnAction(new EnlargeHandler()); //1st*
//        btShrink.setOnAction(new ShrinkHandler());   //1st*
//////////////////////////////////////////////////////////////////////////////////        
        btEnlarge.setOnAction(new EventHandler<ActionEvent>() //delete the class only #2nd
                {
                   @Override // Override the handle method
                   public void handle(ActionEvent e)
                   {
                       circle.setRadius(circle.getRadius()+2);
                   } 
    });
//////////////////////////////////////////////////////////////////////////////////        
        btShrink.setOnAction(e ->{circle.setRadius(circle.getRadius()-2);});//3d
//////////////////////////////////////////////////////////////////////////////////
        Scene scene = new Scene(borderPane, 200, 150); 
        primaryStage.setTitle("ControlCircle"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
    }
//////////////////////////////////////////////////////////////////////////////////    
    class EnlargeHandler implements EventHandler<ActionEvent>//1st
                {
            @Override // Override the handle method
            public void handle(ActionEvent e)
            {
                circle.setRadius(circle.getRadius()+2);
            }
        }

    class ShrinkHandler implements EventHandler<ActionEvent> 
                {
            @Override // Override the handle method
            public void handle(ActionEvent e)
            {
                circle.setRadius(circle.getRadius()-2);
            }
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
