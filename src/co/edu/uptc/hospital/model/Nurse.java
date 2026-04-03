package co.edu.uptc.hospital.model;
 
public class Nurse extends BaseClass {
 
    private static int autoId = 0;
 
    private String firstName;
    private String lastName;
    private String idNumber;
    private String specialty;
    private String shift;
    private String phoneNumber;
 
    public Nurse() {
        super();
    }
 
    public Nurse(String firstName, String lastName, String idNumber,
                     String specialty, String shift, String phoneNumber) {
        super(++autoId);
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.idNumber    = idNumber;
        this.specialty   = specialty;
        this.shift       = shift;
        this.phoneNumber = phoneNumber;
    }
 
 
    public static int getAutoId() {
		return autoId;
	}

	public static void setAutoId(int autoId) {
		Nurse.autoId = autoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
        return "Enfermero {"
                + "\n  ID           : " + id
                + "\n  First Name   : " + firstName
                + "\n  Last Name    : " + lastName
                + "\n  ID Number    : " + idNumber
                + "\n  Specialty    : " + specialty
                + "\n  Shift        : " + shift
                + "\n  Phone Number : " + phoneNumber
                + "\n}";
    }
}