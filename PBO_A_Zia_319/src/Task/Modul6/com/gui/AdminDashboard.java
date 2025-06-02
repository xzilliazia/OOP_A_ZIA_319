package Task.Modul6.com.gui;

import Task.Modul6.com.attr.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard {

    public static void show (Stage stage, AdminAttr admin) {

        stage.setTitle("Laporan Admin Dashboard");

        Label welcomeLabel = new Label("Halo, Administrator ganteng cok");
        Label laporanLabel = new Label("Laporan Barang");

        //tabel adminn cokkk ngango list laporan barang
        TableView<Item> itemTable = new TableView<>();
        TableColumn<Item, String> itemNamaCol = new TableColumn<>("Nama");
        itemNamaCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getItemName()));
        TableColumn<Item, String> itemDesCol = new TableColumn<>("Deskripsi");
        itemDesCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getItemDescription()));
        TableColumn<Item, String> itemLocCol = new TableColumn<>("Lokasi");
        itemLocCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getLocation()));
        TableColumn<Item, String> itemStatusCol = new TableColumn<>("Status");
        itemStatusCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus()));
        itemTable.getColumns().addAll(itemNamaCol, itemDesCol, itemLocCol, itemStatusCol);
        itemTable.setItems(admin.manageItems());

        Button claimBtn = new Button("Tandai diambil");
        claimBtn.setOnAction(e -> {
            Item selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Terambil");
                itemTable.refresh();
            }
        });

        //tabel mshsiswa sesiau modul njing
        TableView<Mahasiswa> mahasiswaTable = new TableView<>();
        TableColumn<Mahasiswa, String> namaMhsCol = new TableColumn<>("Nama");
        namaMhsCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNama()));
        namaMhsCol.setPrefWidth(250);
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNIM()));
        nimCol.setPrefWidth(250);
        namaMhsCol.prefWidthProperty().bind(mahasiswaTable.widthProperty().multiply(0.5));
        nimCol.prefWidthProperty().bind(mahasiswaTable.widthProperty().multiply(0.5));
        mahasiswaTable.getColumns().addAll(namaMhsCol, nimCol);
        mahasiswaTable.setItems(admin.manageUsers());

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            LoginPanel.showLogin(stage);
        });

        // Layout
        VBox kiri = new VBox(10, welcomeLabel, laporanLabel, itemTable, claimBtn, logoutBtn);
        kiri.setPrefWidth(500);

        VBox kanan = new VBox(39, new Label("Data Mahasiswa"), mahasiswaTable);
        kanan.setPrefWidth(500);
        kanan.setAlignment(Pos.TOP_CENTER);


        HBox main = new HBox(20, kiri, kanan);
        main.setPadding(new Insets(10));

        stage.setScene(new Scene(main));
        stage.setWidth(800);
        stage.setHeight(600);
        stage.centerOnScreen();
        stage.show();

    }
}
