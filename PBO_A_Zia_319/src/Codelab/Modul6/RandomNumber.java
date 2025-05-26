package Codelab.Modul6;

import javafx.application.Application;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RandomNumber extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private int correctNumber;
    private int jumlahPercobaan = 0;

    public void start(Stage stage) {
        correctNumber = new Random().nextInt(100) + 1;

        Label nameApp = new Label("🎯Random Number 1 to 100");
        nameApp.setFont(Font.font("TAHOMA", 20));
        nameApp.setTextFill(Color.BLUEVIOLET);

        TextField inputUserNumber = new TextField();
        inputUserNumber.setPrefWidth(80);
        inputUserNumber.setPromptText("Masukkan angka di sini");

        Button guessNumber = new Button("Coba tebak");
        guessNumber.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        Label result = new Label();
        result.setFont(Font.font("TAHOMA", 20));

        Label infoPercobaan = new Label("Jumlah Percobaan: 0");
        infoPercobaan.setStyle("-fx-font-size: 10px");
        infoPercobaan.setTextFill(Color.GRAY);

        guessNumber.setOnAction(e -> {
            if (guessNumber.getText().equals("Main lagi")) {
                correctNumber = new Random().nextInt(100) + 1;
                jumlahPercobaan = 0;
                result.setText("");
                infoPercobaan.setText("Jumlah Percobaan: 0");
                inputUserNumber.clear();
                guessNumber.setText("Coba tebak");
                guessNumber.setDisable(false);
                return;
            }

            try {
                int tebakan = Integer.parseInt(inputUserNumber.getText());
                jumlahPercobaan++;

                if (tebakan < correctNumber) {
                    result.setText("🔻 Terlalu kecil");
                    result.setTextFill(Color.ORANGE);
                    inputUserNumber.clear();
                } else if (tebakan > correctNumber) {
                    result.setText("🔼 Terlalu besar");
                    result.setTextFill(Color.ORANGE);
                    inputUserNumber.clear();
                } else {
                    result.setText("👍Tebakan benar\nJumlah percobaan: " + jumlahPercobaan);
                    result.setTextFill(Color.GREEN);
                    guessNumber.setText("Main lagi");
                }

                infoPercobaan.setText("Jumlah Percobaan: " + jumlahPercobaan);

            } catch (NumberFormatException e2) {
                result.setText("Angka invalid");
                result.setTextFill(Color.RED);
                inputUserNumber.clear();
            }
        });

        HBox hbox = new HBox(10, inputUserNumber, guessNumber);
        hbox.setStyle("-fx-alignment: center;");
        VBox root = new VBox(15, nameApp, hbox, result, infoPercobaan);
        root.setStyle("-fx-alignment: center");

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Random Number Game");
        stage.setScene(scene);
        stage.show();
    }
}