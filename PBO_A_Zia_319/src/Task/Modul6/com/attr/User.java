package Task.Modul6.com.attr;

public abstract class User {
    private String userName;
    private String userPass;
    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return userPass;
    }
}
