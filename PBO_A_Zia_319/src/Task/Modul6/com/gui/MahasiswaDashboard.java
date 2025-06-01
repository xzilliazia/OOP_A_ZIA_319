package Task.Modul6.com.gui;

import Task.Modul6.com.attr.Item;
import Task.Modul6.com.attr.Mahasiswa;
import Task.Modul6.com.data.ItemStorage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard {
    private final Mahasiswa currentMahasiswa;

    public MahasiswaDashboard(Mahasiswa namaMahasiswa) {
        this.currentMahasiswa = namaMahasiswa;
        Stage stage = new Stage();
        stage.setTitle("Laporan " + namaMahasiswa);

        Label instruksi = new Label("Laporkan Barang Hilang/Temuan");
        TextField namaF = new TextField();
        namaF.setPromptText("Nama Barang");
        TextField deskripsiF = new TextField();
        deskripsiF.setPromptText("Deskripsi Barang");
        TextField lokasiF = new TextField();
        lokasiF.setPromptText("Lokasi Kejadian");
        Button laporBtn = new Button("Laporkan");
        laporBtn.setOnAction(e -> {
           String nama = namaF.getText();
           String deskripsi = deskripsiF.getText();
           String lokasi = lokasiF.getText();

           if (!nama.isEmpty() && !lokasi.isEmpty()){
               currentMahasiswa.reportItem(nama, deskripsi, lokasi);
               namaF.clear();
               deskripsiF.clear();
               lokasiF.clear();
           }
        });
        TableView<Item> itemTable = new TableView<>(currentMahasiswa.viewReportedItems());
        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getItemName()));
        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getLocation()));
        itemTable.getColumns().addAll(namaCol, lokasiCol);

        // Tombol logout
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> stage.close());

        // Layout
        HBox inputForm = new HBox(10, namaF, deskripsiF, lokasiF, laporBtn);
        VBox main = new VBox(10, instruksi, inputForm, new Label("Daftar Laporan Anda"), itemTable, logoutBtn);
        main.setPadding(new Insets(10));

        stage.setScene(new Scene(main));
        stage.show();
    }

}
