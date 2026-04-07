package co.edu.uptc.hospital.data;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.uptc.hospital.model.Gerent;

public class CrudGerent extends AbstractCrud<Gerent> {

    private List<Gerent> listaGerent;

    public CrudGerent() {
        super("Gerente");
        this.listaGerent = new ArrayList<Gerent>();
    }

    @Override
    protected Gerent createInstance() {
        String firstName = JOptionPane.showInputDialog(null,
                "Digite el nombre del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        String lastName = JOptionPane.showInputDialog(null,
                "Digite el apellido del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        String idNumber = JOptionPane.showInputDialog(null,
                "Digite el número de cédula del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        String email = JOptionPane.showInputDialog(null,
                "Digite el email del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        String birthDate = JOptionPane.showInputDialog(null,
                "Digite la fecha de nacimiento (dd/mm/aaaa):",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        String department = JOptionPane.showInputDialog(null,
                "Digite el departamento del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        String salaryStr = JOptionPane.showInputDialog(null,
                "Digite el salario del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);
        double salary = Double.parseDouble(salaryStr);

        String phoneNumber = JOptionPane.showInputDialog(null,
                "Digite el teléfono del gerente:",
                "Agregar registro de Gerente", JOptionPane.INFORMATION_MESSAGE);

        return new Gerent(firstName, lastName, idNumber, email, birthDate,
                          department, salary, phoneNumber);
    }

    @Override
    protected boolean newRecord(Gerent record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaGerent.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Gerent findRecordById(int id) {
        return this.listaGerent.stream()
                .filter(g -> g.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    protected boolean updateRecord(Gerent t) {
        for (Gerent gerent : this.listaGerent) {
            if (gerent.getId() == t.getId()) {
                if (t.getFirstName()   != null) gerent.setFirstName(t.getFirstName());
                if (t.getLastName()    != null) gerent.setLastName(t.getLastName());
                if (t.getIdNumber()       != null) gerent.setIdNumber(t.getIdNumber());
                if (t.getEmail()       != null) gerent.setEmail(t.getEmail());
                if (t.getBirthDate()   != null) gerent.setBirthDate(t.getBirthDate());
                if (t.getDepartment()  != null) gerent.setDepartment(t.getDepartment());
                if (t.getSalary()      != 0)    gerent.setSalary(t.getSalary());
                if (t.getPhoneNumber() != null) gerent.setPhoneNumber(t.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.listaGerent.removeIf(g -> g.getId() == id);
    }
}