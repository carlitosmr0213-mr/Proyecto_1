package co.edu.uptc.hospital.data;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JOptionPane;
 
import co.edu.uptc.hospital.model.Doctor;
 
public class CrudDoctor extends AbstractCrud<Doctor> {
 
    private List<Doctor> listaDoctor;
 
    public CrudDoctor() {
        super("Doctor");
        this.listaDoctor = new ArrayList<Doctor>();
    }
 
    @Override
    protected Doctor createInstance() {
        String firstName = JOptionPane.showInputDialog(
                null,
                "Digite el nombre del doctor:",
                "Agregar registro de Doctor",
                JOptionPane.INFORMATION_MESSAGE);
 
        String lastName = JOptionPane.showInputDialog(
                null,
                "Digite el apellido del doctor:",
                "Agregar registro de Doctor",
                JOptionPane.INFORMATION_MESSAGE);
 
        String idNumber = JOptionPane.showInputDialog(
                null,
                "Digite el número de cédula del doctor:",
                "Agregar registro de Doctor",
                JOptionPane.INFORMATION_MESSAGE);
 
        String specialty = JOptionPane.showInputDialog(
                null,
                "Digite la especialidad del doctor:",
                "Agregar registro de Doctor",
                JOptionPane.INFORMATION_MESSAGE);
 
        String medicalLicense = JOptionPane.showInputDialog(
                null,
                "Digite el número de registro médico:",
                "Agregar registro de Doctor",
                JOptionPane.INFORMATION_MESSAGE);
 
        String yearsStr = JOptionPane.showInputDialog(
                null,
                "Digite los años de experiencia del doctor:",
                "Agregar registro de Doctor",
                JOptionPane.INFORMATION_MESSAGE);
        int yearsOfExperience = Integer.parseInt(yearsStr);
 
        return new Doctor(firstName, lastName, idNumber, specialty, medicalLicense, yearsOfExperience);
    }
 
    @Override
    protected boolean newRecord(Doctor record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaDoctor.add(record);
            return true;
        }
        return false;
    }
 
    @Override
    protected Doctor findRecordById(int id) {
        return this.listaDoctor.stream()
                .filter(d -> d.getId() == id)
                .findAny()
                .orElse(null);
    }
 
    @Override
    protected boolean updateRecord(Doctor t) {
        for (Doctor doctor : this.listaDoctor) {
            if (doctor.getId() == t.getId()) {
                if (t.getFirstName()         != null) doctor.setFirstName(t.getFirstName());
                if (t.getLastName()          != null) doctor.setLastName(t.getLastName());
                if (t.getIdNumber()          != null) doctor.setIdNumber(t.getIdNumber());
                if (t.getSpecialty()         != null) doctor.setSpecialty(t.getSpecialty());
                if (t.getMedicalLicense()    != null) doctor.setMedicalLicense(t.getMedicalLicense());
                if (t.getYearsOfExperience() != 0)    doctor.setYearsOfExperience(t.getYearsOfExperience());
                return true;
            }
        }
        return false;
    }
 
    @Override
    protected boolean deleteRecord(int id) {
        return this.listaDoctor.removeIf(d -> d.getId() == id);
    }
}