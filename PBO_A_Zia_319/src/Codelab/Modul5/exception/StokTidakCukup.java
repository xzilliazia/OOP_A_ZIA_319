package Codelab.Modul5.exception;
import java.lang.Exception;

public class StokTidakCukup extends Exception {
    public StokTidakCukup(String message) {
        super(message);
    }
}