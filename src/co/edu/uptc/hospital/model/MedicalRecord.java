package co.edu.uptc.hospital.model;
 
import java.util.Date;
 
public class MedicalRecord extends BaseClass {
 
    private String diagnosis;
    private String treatment;
    private Date   creationDate;
    private String observations;
    private String patientName;
 
    public MedicalRecord() {
        super();
    }
 
    public MedicalRecord(String diagnosis, String treatment,
                         Date creationDate, String observations, String patientName) {
        super(true);
        this.diagnosis    = diagnosis;
        this.treatment    = treatment;
        this.creationDate = creationDate;
        this.observations = observations;
        this.patientName  = patientName;
    }  
 
    public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Override
    public String toString() {
        return "MedicalRecord {"
                + "\n  ID (sistema) : " + id
                + "\n  Patient      : " + patientName
                + "\n  Diagnosis    : " + diagnosis
                + "\n  Treatment    : " + treatment
                + "\n  Created      : " + creationDate
                + "\n  Observations : " + observations
                + "\n}";
    }
}