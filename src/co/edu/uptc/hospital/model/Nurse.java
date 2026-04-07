package co.edu.uptc.hospital.model;

public class Nurse extends Person {

    /* Sin autoId propio — BaseClass lo maneja */
    private String specialty;
    private String shift;
    private String phoneNumber;

    public Nurse() {
        super();
    }

    public Nurse(String firstName, String lastName, String idNumber,
                 String email, String birthDate,
                 String specialty, String shift, String phoneNumber) {
        super(firstName, lastName, idNumber, email, birthDate);
        this.specialty   = specialty;
        this.shift       = shift;
        this.phoneNumber = phoneNumber;
    }
    

    public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
    public String toString() {
        return "Nurse {"
                + "\n  ID (sistema) : " + id
                + "\n  First Name   : " + firstName
                + "\n  Last Name    : " + lastName
                + "\n  Cedula       : " + idNumber
                + "\n  Email        : " + email
                + "\n  Birth Date   : " + birthDate
                + "\n  Specialty    : " + specialty
                + "\n  Shift        : " + shift
                + "\n  Phone Number : " + phoneNumber
                + "\n}";
    }
}