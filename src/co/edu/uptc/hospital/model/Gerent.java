package co.edu.uptc.hospital.model;
 
public class Gerent extends Person {
 
    private String department;
    private double salary;
    private String phoneNumber;
 
    public Gerent() {
        super();
    }
 
    public Gerent(String firstName, String lastName, String idNumber,
                  String email, String birthDate,
                  String department, double salary, String phoneNumber) {
        super(firstName, lastName, idNumber, email, birthDate);
        this.department  = department;
        this.salary      = salary;
        this.phoneNumber = phoneNumber;
    }

 
    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    @Override
    public String toString() {
        return "Gerent {"
                + "\n  ID (sistema) : " + id
                + "\n  First Name   : " + firstName
                + "\n  Last Name    : " + lastName
                + "\n  Cedula       : " + idNumber
                + "\n  Email        : " + email
                + "\n  Birth Date   : " + birthDate
                + "\n  Department   : " + department
                + "\n  Salary       : " + salary
                + "\n  Phone        : " + phoneNumber
                + "\n}";
    }
}