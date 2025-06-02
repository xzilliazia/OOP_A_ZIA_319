package Task.Modul6.com.gui;

import Task.Modul6.com.attr.AdminAttr;
import Task.Modul6.com.attr.Mahasiswa;
import Task.Modul6.com.service.Login;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPanel{
        public static void showLogin(Stage stage) {
            stage.setTitle("Laporan Progam");

            Label titleLabel = new Label("Login Pages");
            ComboBox<String> roleCombo = new ComboBox<>();
            roleCombo.getItems().addAll("Mahasiswa", "Admin");
            roleCombo.setValue("Login as");

            TextField usernameField = new TextField();
            usernameField.setPromptText("Nama / Username");
//            usernameField.setEditable(true);
            usernameField.setMaxWidth(200);

            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("NIM / Password");
            passwordField.setMaxWidth(200);

            Label messageLabel = new Label();
            Button loginBtn = new Button("Login");

            loginBtn.setOnAction(e -> {

                String role = roleCombo.getValue();
                String user = usernameField.getText().trim();
                String pass = passwordField.getText().trim();

                if (role.equals("Mahasiswa")) {
                    Mahasiswa mhs = Login.loginMahasiswa(user, pass);
                    if (mhs != null) {
                        MahasiswaDashboard.show(stage, mhs);
                    } else {
                        messageLabel.setText("Login gagal, periksa kredensial.");
                    }
                } else {
                    AdminAttr admin = Login.loginAdmin(user, pass);
                    if (admin != null) {
                        AdminDashboard.show(stage, admin);
                    } else {
                        messageLabel.setText("Login gagal, periksa kredensial.");
                    }
                }
            });

            // Layout
            VBox layout = new VBox(10,
                    titleLabel,
                    roleCombo,
                    usernameField,
                    passwordField,
                    loginBtn,
                    messageLabel
            );
            layout.setPadding(new Insets(20));
            layout.setStyle("-fx-font-family: Arial;");
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            stage.centerOnScreen();
            stage.setScene(scene);

        }
}


