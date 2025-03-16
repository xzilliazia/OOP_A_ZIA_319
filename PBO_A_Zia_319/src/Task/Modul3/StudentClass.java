package Task.Modul3;

public class StudentClass extends UserLoginClass{
    public StudentClass(String userName, String userPassw){
        super(userName, userPassw);
    }

    @Override
    public boolean Login(String inputUserName, String inputUserPassw){
        return super.Login(inputUserName, inputUserPassw);
    }
}