package Task.Modul6.com.gui;

import Task.Modul6.com.attr.*;
import Task.Modul6.com.data.Admin;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard extends Stage{
    private final AdminAttr admin;
    public AdminDashboard(AdminAttr admin) {
        this.admin = admin;
        initUI();
    }
    private void initUI() {
        this.setTitle("Laporan Admin Dashboard");

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
        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNIM()));
        mahasiswaTable.getColumns().addAll(namaMhsCol, nimCol);
        mahasiswaTable.setItems(admin.manageUsers());

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> this.close());

        // Layout
        VBox kiri = new VBox(10, welcomeLabel, laporanLabel, itemTable, claimBtn, logoutBtn);
        kiri.setPrefWidth(300);

        VBox kanan = new VBox(10, new Label("Data Mahasiswa"), mahasiswaTable);
        kanan.setPrefWidth(300);

        HBox main = new HBox(20, kiri, kanan);
        main.setPadding(new javafx.geometry.Insets(10));

        this.setScene(new Scene(main));
        this.show();
    }
}
