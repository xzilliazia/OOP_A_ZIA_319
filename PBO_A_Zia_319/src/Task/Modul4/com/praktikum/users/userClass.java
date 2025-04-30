package Task.Modul4.com.praktikum.users;

public abstract class userClass {
    protected String username;
    protected String password;

    public userClass (String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public abstract boolean login();
    abstract void displayAppMenu();
}
