package Task.Modul2;

class StudentLogin{
    private String name;
    private String studentId;

    public StudentLogin(String name, String studentId){
        this.name = name;
        this.studentId = studentId;
    }

    public boolean getLogin(String name, String studentId){
        return this.name.equals(name) && this.studentId.equals(studentId);
    }
    public void displayInfo(){
        System.out.println("Nama Mahasiswa: "+ this.name);
        System.out.println("NIM: "+ this.studentId);
    }
}
