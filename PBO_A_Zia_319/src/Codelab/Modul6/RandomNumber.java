package Codelab.Modul6;

import javafx.application.Application;
import java.util.Scanner;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RandomNumber extends Application {
    public static void main(String[] args) {
    launch(args);
//        Scanner input = new Scanner(System.in);
//        Random random = new Random();
//
//        int angkaTebak = random.nextInt(100) + 1;
//        int tebakan = 0;
//
//        System.out.println("Tebak angka 1 sampai 100");
//
//        while (tebakan != angkaTebak) {
//            System.out.print("Masukkan angka: ");
//            tebakan = input.nextInt();
//
//            if (tebakan > angkaTebak) {
//                System.out.println("Angka terlalu besar!");
//            } else if (tebakan < angkaTebak) {
//                System.out.println("Tebak terlalu kecil!");
//            } else {
//                System.out.println("TEbakan BEnaar");
//            }
//        }
//    input.close();
    }
    private int correctNumber;
    public void start(Stage stage){
        correctNumber = new Random().nextInt(100)+1;
        final int [] jumlahPercobaan = {0};

        Label nameApp = new Label("🎯Random Number 1 to 100");
        nameApp.setFont(Font.font("TAHOMA",20));
        nameApp.setTextFill(Color.BLUEVIOLET);

        TextField inputUserNumber = new TextField();
        inputUserNumber.setPrefWidth(80);
        inputUserNumber.setPromptText("Masukkan anfka disini");

        Button guessNumber = new Button("Coba tebak");
        guessNumber.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        Label result = new Label();
        result.setFont(Font.font("TAHOMA",20));

        Label infoPercobaan = new Label("Jumlah Percobaan: 0 ");
        infoPercobaan.setStyle("-fx-font-size: 10px");
        infoPercobaan.setTextFill(Color.GRAY);

        guessNumber.setOnAction(e -> {
           try {
                int tebakan = Integer.parseInt(inputUserNumber.getText());
                jumlahPercobaan[0]++;

                if (tebakan < correctNumber) {
                    result.setText("🔻Terlalu kecil");
                    result.setTextFill(Color.ORANGE);
                } else if (tebakan > correctNumber) {
                    result.setText("🔼Terlalu besar");
                    result.setTextFill(Color.ORANGE);
                } else {
                   result.setText("\t👍Tebakan benar\nJumlah percobaan: " + jumlahPercobaan[0]);
                    result.setTextFill(Color.GREEN);
                    guessNumber.setDisable(true);
                }

                infoPercobaan.setText("Jumlah Percobaan: "+ jumlahPercobaan[0]);

           } catch (NumberFormatException e2){
               result.setText("Angka inpalid");
               result.setTextFill(Color.RED);
           }
        });

        HBox hbox = new HBox(10, inputUserNumber,guessNumber);
        hbox.setStyle("-fx-alignment: center;");

        VBox root = new VBox(15, nameApp, hbox, result, infoPercobaan);
        root.setStyle("-fx-alignment: center");

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Random Number Game");
        stage.setScene(scene);
        stage.show();
    }
}