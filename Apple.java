package Hello;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Apple extends Application {
   
    private TextArea textArea = new TextArea();
   
    private TextField textField = new TextField();
   
    private Label label = new Label();
   
    private Button bt = new Button(">>");
   
    private Button bt1 = new Button("<<");
   
    private Button bt2 = new Button("Check Answers");
   
    private String s = "";
   
    @Override
   
    public void start(Stage stage) throws Exception {
       
        FileChooser fileChooser = new FileChooser();
       
        fileChooser.setTitle("Title");
        //I added a filter even though there was no such thing in the video
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.txt"));
       
        Button button = new Button("Load File");
       
        button.setOnAction(e->{
            File file = fileChooser.showOpenDialog(stage);
       
            Scanner sc = new Scanner(System.in);
       
            while(sc.hasNextLine()){
                Quiz quiz = new Quiz();
                String s = sc.nextLine();
                try {
                    quiz.loadFromFile(s);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        Scene scene = new Scene(button);
        stage.setScene(scene);
        stage.setTitle("Title");
        stage.show();
    }
    public String ReURL(){
        return s;
    }
}
