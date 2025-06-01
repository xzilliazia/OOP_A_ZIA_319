package Task.Modul6.com.attr;

public class Item {
    private String itemName;
    private String itemDescription;
    private String location;
    private String status;

    public Item(String itemName, String itemDescription, String location, String status) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.location = location;
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }
    public String getLocation() {
        return location;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getItemDescription() {
        return itemDescription;
    }

}
