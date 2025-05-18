package Task.Modul5.data;

import Task.Modul5.action.AdminAction;
import Task.Modul5.models.Entity;

public class Admin extends Entity implements AdminAction {
    private final String password;

    public Admin(int id, String name, String password) {
        super(id, name);
        this.password = password;
    }

    public String getPassword() { return password; }

    @Override
    public void manageItem(){}
    @Override
    public void manageUser(){}
}