package Task.Modul5.models;

public abstract class Content {
    private String itemName;
    private String deskriptionItem;
    private String itemlocation;
    private String itemStatus;
    
    public Content(String itemName, String deskriptionItem, String location, String status){
         this.itemName = itemName;
         this.deskriptionItem = deskriptionItem;
         this.itemlocation = location;
         this.itemStatus = status;
     }

    public String getItemName() { return itemName; }
    public String getDeskriptionItem() { return deskriptionItem; }
    public String getItemlocation(){ return itemlocation; }
    public String getItemStatus(){ return itemStatus; }

    public abstract void info();
}
