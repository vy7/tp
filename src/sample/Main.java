package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    GridPane grid = new GridPane();

    final Scene scene = new Scene(grid, 700, 300);

    @Override
    public void start(Stage window) {


        //Label
        Label label = new Label();
        label.setText("Guess the Number to watch a funny video: ");
        label.setStyle("-fx-font: 20 arial ;-fx-fill: BLACK;");
        grid.setConstraints(label,0,0);

        //Text Field
        TextField textInput = new TextField();
        textInput.setPromptText("Guess the number");
        textInput.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9");
        grid.setConstraints(textInput, 0,1);

        //Button:
        Button b1;
        b1 = new Button("Guess");
        b1.setStyle("-fx-font: 26 arial; -fx-base: #b6e7c9");
        b1.setOnAction(e ->{
            if(isInt(textInput) == true)
            {
                WebView webview = new WebView();
                webview.getEngine().load("https://www.youtube.com/watch?v=BCZVL3otrss");
                webview.setPrefSize(640, 390);
                Scene s2 = new Scene(webview);
                window.setScene(s2);
                window.setFullScreen(true);
                window.show();
            }
            else;
        });
        DropShadow shadow = new DropShadow();
        b1.setOnMouseEntered(e -> b1.setEffect(shadow));
        b1.setOnMouseExited(e -> b1.setEffect(null));
        grid.setConstraints(b1,1,1);

        //drop down
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("BLUE","GREEN","RED","PURPLE","AQUA");
        comboBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> change(newValue));
        comboBox.setPromptText("Background Color");
        comboBox.setStyle("-fx-base: BLACK");
        grid.setConstraints(comboBox,3,5);


        grid.setHgap(5);
        grid.setVgap(2);
        grid.setStyle("-fx-base: #5427E5");
        grid.getChildren().addAll(b1,comboBox, textInput, label);



        window.setScene(scene);
        window.show();

    }


    private void change(String newValue) {
        grid.setStyle("-fx-base: "+ newValue);
    }

    private boolean isInt(TextField textInput){
        try {
            int x = Integer.parseInt(textInput.getText());

            if (x == 7) {
                textInput.setStyle("-fx-font: 26 arial; -fx-base: GREEN");
                return true;
            } else {
                textInput.setStyle("-fx-font: 26 arial; -fx-base: RED");
                return false;
            }
        }
        catch(NumberFormatException e) {
            grid.setStyle("-fx-base: RED");
            AlertBox.display("Error!", "Enter a number");
            some();
            return false;
        }
    }
    private void some(){
        try {Thread.sleep(1000);}
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}