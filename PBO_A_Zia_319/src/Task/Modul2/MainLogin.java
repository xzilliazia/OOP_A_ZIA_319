package Task.Modul2;
import java.util.Scanner;

class AdminLogin{
    private String username;
    private String password;

    public AdminLogin(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean login(String inputUsername, String inputPassword){
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}

class studentLogin{
    private String name;
    private String studentId;

    public studentLogin(String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    public boolean login(String name, String studentId){
        return this.name.equals(name) && this.studentId.equals(studentId);
    }
    public void displayInfo(){
        System.out.println("Nama Mahasiswa: "+ this.name);
        System.out.println("NIM: "+ this.studentId);
    }
}

public class MainLogin {
    public static void main(String[] args) {
        //data object
        AdminLogin admin = new AdminLogin("Zia", "240");
        studentLogin student = new studentLogin("Iza", "319");

        //trywithresource
        try (Scanner input = new Scanner(System.in)){
            System.out.println("Pilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.print("Masukkan pilihan (1/2): ");
            int choise = input.nextInt();
            input.nextLine();

            String inputUser, inputPassword;

        switch (choise) {
            case 1 :
                System.out.print("Masukkan Username: ");
                inputUser = input.nextLine();
                System.out.print("Masukkan Password: ");
                inputPassword = input.nextLine();
                
                if (admin.login(inputUser, inputPassword)){
                    System.out.println("Login Berhasil!!");
                    
                } else {
                    System.out.println("Login Admin Gagal! Username atau Password salah.");
                }
                break;

            case 2 :
                System.out.print("Masukkan Nama Mahsiswa: ");
                inputUser = input.nextLine();
                System.out.print("Masukkan NIM: ");
                inputPassword = input.nextLine();
                
                if (student.login(inputUser, inputPassword)){
                    System.out.println("Berhasil Login");
                    
                } else {
                    System.out.println("Login Gagal! Username atau Password salah.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                break;
            
        }
        } catch (Exception e){
            System.out.println("Terjadi Eror: "+ e.getMessage());
        } 
    }
}