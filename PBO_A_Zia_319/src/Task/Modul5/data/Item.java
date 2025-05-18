package Task.Modul5.data;

import Task.Modul5.models.Content;

public class Item extends Content {
    private String username;

    public Item(String username, String itemName, String itemDescription, String itemLocation, String itemStatus) {
        super(itemName, itemDescription, itemLocation, itemStatus);
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void info() {
        System.out.println("\nUsername: " + username + "\nNama: " + getItemName() + "\nDeskripsi: " + getDeskriptionItem() + "\nLokasi: "+ getItemlocation() + "\nStatus: " + getItemStatus());
    }
}
