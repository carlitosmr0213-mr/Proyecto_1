package co.edu.uptc.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {

    /* Sin autoId propio — BaseClass lo maneja */
    private String specialty;
    private String medicalLicense;
    private int    yearsOfExperience;

    private List<Schedule>      schedules;      // Agregación  (d)
    private List<MedicalRecord> medicalRecords; // Composición (e)

    public Doctor() {
        super();
        this.schedules      = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
    }

    public Doctor(String firstName, String lastName, String idNumber,
            String email, String birthDate,
            String specialty, String medicalLicense, int yearsOfExperience) {
    	super(firstName, lastName, idNumber, email, birthDate);
    	this.specialty         = specialty;
    	this.medicalLicense    = medicalLicense;
    	this.yearsOfExperience = yearsOfExperience;
    	this.schedules         = new ArrayList<>();
    	this.medicalRecords    = new ArrayList<>();
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

	public List<Schedule> getSchedules(){
		return schedules; 
		}
    public void addSchedule(Schedule s) { 
    	this.schedules.add(s); 
    	}

    public List<MedicalRecord> getMedicalRecords() {
    	return medicalRecords; 
    	}
    public void addMedicalRecord(MedicalRecord m) {
    	this.medicalRecords.add(m); 
    	}

    @Override
    public String toString() {
        return "Doctor {"
                + "\n  ID (sistema)        : " + id
                + "\n  First Name          : " + firstName
                + "\n  Last Name           : " + lastName
                + "\n  Cedula              : " + idNumber
                + "\n  Email               : " + email
                + "\n  Birth Date          : " + birthDate
                + "\n  Specialty           : " + specialty
                + "\n  Medical License     : " + medicalLicense
                + "\n  Years of Experience : " + yearsOfExperience
                + "\n  Schedules           : " + schedules.size()
                + "\n  Medical Records     : " + medicalRecords.size()
                + "\n}";
    }
}