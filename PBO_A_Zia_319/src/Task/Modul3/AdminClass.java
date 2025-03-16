package Task.Modul3;

public class AdminClass extends UserLoginClass{
    public AdminClass(String userName, String userPassw){
        super(userName, userPassw);
    }

    @Override
    public boolean Login(String inputUserName, String inputUserPassw){
        return super.Login(inputUserName, inputUserPassw);
    }
}