package Task.Modul3;

public class StudentClass extends UserLoginClass{
    public StudentClass(String userName, String userPassw){
        super(userName, userPassw);
    }

    @Override
    public boolean Login(String inputUserName, String inputUserPassw){
        boolean isLogin = getName().equals(inputUserName) && getPassw().equals(inputUserPassw);
        displayInfo(isLogin);
        return isLogin;
    }
    public void displayInfo(boolean isLogin){
        if(isLogin){
            System.out.println("Login Berhasil");
        } else {
            System.out.println("Username / Password Salah!");
        }
    }
}