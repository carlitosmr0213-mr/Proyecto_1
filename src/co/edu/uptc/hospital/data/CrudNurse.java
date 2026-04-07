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
        String firstName = JOptionPane.showInputDialog(null,
                "Digite el nombre del enfermero:",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String lastName = JOptionPane.showInputDialog(null,
                "Digite el apellido del enfermero:",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String idNumber = JOptionPane.showInputDialog(null,
                "Digite el número de cédula del enfermero:",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String email = JOptionPane.showInputDialog(null,
                "Digite el email del enfermero:",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String birthDate = JOptionPane.showInputDialog(null,
                "Digite la fecha de nacimiento (dd/mm/aaaa):",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String specialty = JOptionPane.showInputDialog(null,
                "Digite la especialidad del enfermero:",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String shift = JOptionPane.showInputDialog(null,
                "Digite el turno (Morning / Afternoon / Night):",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        String phoneNumber = JOptionPane.showInputDialog(null,
                "Digite el teléfono del enfermero:",
                "Agregar registro de Enfermero", JOptionPane.INFORMATION_MESSAGE);

        return new Nurse(firstName, lastName, idNumber, email, birthDate,
                         specialty, shift, phoneNumber);
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
        for (Nurse nurse : this.listaNurse) {
            if (nurse.getId() == t.getId()) {
                if (t.getFirstName()   != null) nurse.setFirstName(t.getFirstName());
                if (t.getLastName()    != null) nurse.setLastName(t.getLastName());
                if (t.getIdNumber()    != null) nurse.setIdNumber(t.getIdNumber());
                if (t.getEmail()       != null) nurse.setEmail(t.getEmail());
                if (t.getBirthDate()   != null) nurse.setBirthDate(t.getBirthDate());
                if (t.getSpecialty()   != null) nurse.setSpecialty(t.getSpecialty());
                if (t.getShift()       != null) nurse.setShift(t.getShift());
                if (t.getPhoneNumber() != null) nurse.setPhoneNumber(t.getPhoneNumber());
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