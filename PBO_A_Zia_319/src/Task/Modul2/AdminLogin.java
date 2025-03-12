package Task.Modul2;

class AdminLogin{
    private String username;
    private String password;

    public AdminLogin(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean Login(String inputUsername, String inputPassword){
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}
