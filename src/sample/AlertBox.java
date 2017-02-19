package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(300);

        Label label = new Label();
        label.setText(message);

        Button cb = new Button("Close");
        cb.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,cb);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-base: RED");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
