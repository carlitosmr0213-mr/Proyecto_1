package co.edu.uptc.hospital.model;
 
public class Person extends BaseClass {
 
    protected String firstName;
    protected String lastName;
    protected String idNumber;
    protected String email;
    protected String birthDate;
 
    public Person() {
        super();
    }
 
    public Person(String firstName, String lastName,
            String idNumber, String email, String birthDate) {
    	super(true);             // BaseClass asigna el id automático
    	this.firstName = firstName;
    	this.lastName  = lastName;
    	this.idNumber  = idNumber;
    	this.email     = email;
    	this.birthDate = birthDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
    public String toString() {
        return "Person {"
                + "\n  ID         : " + id
                + "\n  First Name : " + firstName
                + "\n  Last Name  : " + lastName
                + "\n  ID Number  : " + idNumber
                + "\n  Email      : " + email
                + "\n  Birth Date : " + birthDate
                + "\n}";
    }
}