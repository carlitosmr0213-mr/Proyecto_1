package co.edu.uptc.hospital.model;

public class Gerent extends BaseClass {

    private static int autoId = 0;

    private String firstName;
    private String lastName;
    private String idNum;

    public Gerent() {
        super();
    }

    public Gerent(String firstName, String lastName, String idNum) {
        super(++autoId);
        this.firstName = firstName;
        this.lastName  = lastName;
        this.idNum     = idNum;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getIdNum() { return idNum; }
    public void setIdNum(String idNum) { this.idNum = idNum; }

    @Override
    public String toString() {
        return "Gerent {"
                + "\n  ID       : " + id
                + "\n  Nombre   : " + firstName + " " + lastName
                + "\n  Cédula   : " + idNum
                + "\n}";
    }
}