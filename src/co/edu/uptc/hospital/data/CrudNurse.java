package co.edu.uptc.hospital.data;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JOptionPane;
 
import co.edu.uptc.hospital.model.Nurse;
 
public class CrudNurse extends AbstractCrud<Nurse> {
 
    private List<Nurse> listaNurse;
 
    public CrudNurse() {
        super("Enfermero");
        this.listaNurse = new ArrayList<Nurse>();
    }
 
    @Override
    protected Nurse createInstance() {
        String firstName = JOptionPane.showInputDialog(
                null,
                "Digite el nombre del enfermero:",
                "Agregar registro de Enfermero",
                JOptionPane.INFORMATION_MESSAGE);
 
        String lastName = JOptionPane.showInputDialog(
                null,
                "Digite el apellido del enfermero:",
                "Agregar registro de Enfermero",
                JOptionPane.INFORMATION_MESSAGE);
 
        String idNumber = JOptionPane.showInputDialog(
                null,
                "Digite el número de cédula del enfermero:",
                "Agregar registro de Enfermero",
                JOptionPane.INFORMATION_MESSAGE);
 
        String specialty = JOptionPane.showInputDialog(
                null,
                "Digite la especialidad del enfermero:",
                "Agregar registro de Enfermero",
                JOptionPane.INFORMATION_MESSAGE);
 
        String shift = JOptionPane.showInputDialog(
                null,
                "Digite el turno del enfermero (Morning / Afternoon / Night):",
                "Agregar registro de Enfermero",
                JOptionPane.INFORMATION_MESSAGE);
 
        String phoneNumber = JOptionPane.showInputDialog(
                null,
                "Digite el teléfono del enfermero:",
                "Agregar registro de Enfermero",
                JOptionPane.INFORMATION_MESSAGE);
 
        return new Nurse(firstName, lastName, idNumber, specialty, shift, phoneNumber);
    }
 
    @Override
    protected boolean newRecord(Nurse record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaNurse.add(record);
            return true;
        }
        return false;
    }
 
    @Override
    protected Nurse findRecordById(int id) {
        return this.listaNurse.stream()
                .filter(e -> e.getId() == id)
                .findAny()
                .orElse(null);
    }
 
    @Override
    protected boolean updateRecord(Nurse t) {
        for (Nurse enfermero : this.listaNurse) {
            if (enfermero.getId() == t.getId()) {
                if (t.getFirstName()   != null) enfermero.setFirstName(t.getFirstName());
                if (t.getLastName()    != null) enfermero.setLastName(t.getLastName());
                if (t.getIdNumber()    != null) enfermero.setIdNumber(t.getIdNumber());
                if (t.getSpecialty()   != null) enfermero.setSpecialty(t.getSpecialty());
                if (t.getShift()       != null) enfermero.setShift(t.getShift());
                if (t.getPhoneNumber() != null) enfermero.setPhoneNumber(t.getPhoneNumber());
                return true;
            }
        }
        return false;
    }
 
    @Override
    protected boolean deleteRecord(int id) {
        return this.listaNurse.removeIf(e -> e.getId() == id);
    }
}