package Task.Modul6.com.gui;

import Task.Modul6.com.attr.AdminAttr;
import Task.Modul6.com.attr.Mahasiswa;
import Task.Modul6.com.data.Admin;
import Task.Modul6.com.data.ItemStorage;
import Task.Modul6.com.service.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPanel extends Stage{
        public LoginPanel() {
            this.setTitle("Laporan Progam");

            Label titleLabel = new Label("Login Sistem Lost & Found");
            ComboBox<String> roleCombo = new ComboBox<>();
            roleCombo.getItems().addAll("Mahasiswa", "Admin");
            roleCombo.setValue("Mahasiswa");

            TextField usernameField = new TextField();
            usernameField.setPromptText("Nama / Username");

            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("NIM / Password");

            Label messageLabel = new Label();
            Button loginBtn = new Button("Login");

            loginBtn.setOnAction(e -> {
                String role = roleCombo.getValue();
                String user = usernameField.getText().trim();
                String pass = passwordField.getText().trim();

                if (role.equals("Mahasiswa")) {
                    Mahasiswa mhs = Login.loginMahasiswa(user, pass);
                    if (mhs != null) {
                        new MahasiswaDashboard(mhs);
                        this.close();
                    } else {
                        messageLabel.setText("Login gagal, periksa kredensial.");
                    }
                } else {
                    AdminAttr admin = Login.loginAdmin(user, pass);
                    if (admin != null) {
                        new AdminDashboard(admin);
                        this.close();
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
            layout.setPrefWidth(320);
            layout.setStyle("-fx-font-family: Arial;");

            this.setScene(new Scene(layout));
            this.show();
        }
}


