package Task.Modul6.com.actions;

import Task.Modul6.com.attr.Item;
import javafx.collections.ObservableList;

public interface MahasiswaAc {
    void reportItem(String nama, String deskripsi, String lokasi);
    ObservableList<Item> viewReportedItems();
}

//package Task.Modul6.com.gui;
//
//import Task.Modul6.com.attr.AdminAttr;
//import Task.Modul6.com.attr.Mahasiswa;
//import Task.Modul6.com.data.Admin;
//import Task.Modul6.com.data.ItemStorage;
//import Task.Modul6.com.service.Login;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//public class LoginPanel extends Stage{
//    public LoginPanel() {
//        VBox root = new VBox(10);
//        root.setPadding(new Insets(20));
//
//        Label lblUser = new Label("Username:");
//        TextField tfUser = new TextField();
//        Label lblPass = new Label("Password:");
//        PasswordField pfPass = new PasswordField();
//        Button btnLogin = new Button("Login");
//
//        Label lblMessage = new Label();
//
//        btnLogin.setOnAction(e -> {
//            String username = tfUser.getText().trim();
//            String password = pfPass.getText().trim();
//
//            Admin adminAuth = new Admin();
//            if (adminAuth.isValidAdmin(username, password)) {
//                AdminAttr adminUser = new AdminAttr(username, password);
//                new AdminDashboard(adminUser).show();
//                this.close();
//            } else {
//                lblMessage.setText("Login gagal. Coba lagi.");
//            }
//        });
//
//        root.getChildren().addAll(lblUser, tfUser, lblPass, pfPass, btnLogin, lblMessage);
//
//        Scene scene = new Scene(root, 300, 200);
//        setScene(scene);
//        setTitle("Admin Login");
//        }
//}