package co.edu.uptc.hospital.model;
 
public class Doctor extends BaseClass {
 
    private static int autoId = 0;
 
    private String firstName;
    private String lastName;
    private String idNumber;
    private String specialty;
    private String medicalLicense;
    private int    yearsOfExperience;
 
    public Doctor() {
        super();
    }
 
    public Doctor(String firstName, String lastName, String idNumber,
                  String specialty, String medicalLicense, int yearsOfExperience) {
        super(++autoId);
        this.firstName         = firstName;
        this.lastName          = lastName;
        this.idNumber          = idNumber;
        this.specialty         = specialty;
        this.medicalLicense    = medicalLicense;
        this.yearsOfExperience = yearsOfExperience;
    }
 
 
    public static int getAutoId() {
		return autoId;
	}

	public static void setAutoId(int autoId) {
		Doctor.autoId = autoId;
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

	public String getMedicalLicense() {
		return medicalLicense;
	}

	public void setMedicalLicense(String medicalLicense) {
		this.medicalLicense = medicalLicense;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
    public String toString() {
        return "Doctor {"
                + "\n  ID                  : " + id
                + "\n  First Name          : " + firstName
                + "\n  Last Name           : " + lastName
                + "\n  ID Number           : " + idNumber
                + "\n  Specialty           : " + specialty
                + "\n  Medical License     : " + medicalLicense
                + "\n  Years of Experience : " + yearsOfExperience
                + "\n}";
    }
}