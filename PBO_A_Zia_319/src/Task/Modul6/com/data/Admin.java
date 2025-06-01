package Task.Modul6.com.data;

import java.util.HashMap;
import java.util.Scanner;

public class Admin {
    private final HashMap<String, String> admins = new HashMap<>();
    public Admin() {
        admins.put("admin1", "1111");
        admins.put("admin2", "2222");
    }
    public boolean isValidAdmin(String username, String password) {
        return admins.containsKey(username) && admins.get(username).equals(password);
    }
}
