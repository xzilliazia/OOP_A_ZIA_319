package Task.Modul5.data;

import Task.Modul5.action.RegularAction;
import Task.Modul5.models.Entity;

public class Mahasiswa extends Entity implements RegularAction {

    public Mahasiswa(int id, String name) {
        super(id, name);
    }

    @Override
    public void reportItem() {}
    @Override
    public void viewReportItem() {}
}