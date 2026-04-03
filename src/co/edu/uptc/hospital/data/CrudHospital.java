package co.edu.uptc.hospital.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;

import co.edu.uptc.hospital.model.Hospital;

public class CrudHospital extends AbstractCrud<Hospital> {

    private List<Hospital> listaHospital;

    public CrudHospital() {
        super("Hospital");
        this.listaHospital = new ArrayList<Hospital>();
    }

    @Override
    protected Hospital createInstance() {

        String name = JOptionPane.showInputDialog(
                null,
                "Digite el nombre del hospital:",
                "Agregar registro de Hospital",
                JOptionPane.INFORMATION_MESSAGE);

        String nit = JOptionPane.showInputDialog(
                null,
                "Digite el NIT del hospital:",
                "Agregar registro de Hospital",
                JOptionPane.INFORMATION_MESSAGE);

        String address = JOptionPane.showInputDialog(
                null,
                "Digite la dirección del hospital:",
                "Agregar registro de Hospital",
                JOptionPane.INFORMATION_MESSAGE);

        String phone = JOptionPane.showInputDialog(
                null,
                "Digite el teléfono del hospital:",
                "Agregar registro de Hospital",
                JOptionPane.INFORMATION_MESSAGE);

        String gerenteName = JOptionPane.showInputDialog(
                null,
                "Digite el nombre del gerente:",
                "Agregar registro de Hospital",
                JOptionPane.INFORMATION_MESSAGE);


        JDateChooser dateChooser = new JDateChooser();
        int option = JOptionPane.showConfirmDialog(
                null,
                dateChooser,
                "Seleccione la fecha de fundación",
                JOptionPane.OK_CANCEL_OPTION); 

        Date foundationDate = null;
        if (option == JOptionPane.OK_OPTION) {
            foundationDate = dateChooser.getDate();
        }

        return new Hospital(name, nit, address, phone, foundationDate, gerenteName);
    }

    @Override
    protected boolean newRecord(Hospital record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaHospital.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Hospital findRecordById(int id) {
        return this.listaHospital.stream()
                .filter(h -> h.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    protected boolean updateRecord(Hospital t) {
        for (Hospital hospital : this.listaHospital) {
            if (hospital.getId() == t.getId()) {
                if (t.getName() != null)        hospital.setName(t.getName());
                if (t.getNit() != null)          hospital.setNit(t.getNit());
                if (t.getAddress() != null)      hospital.setAddress(t.getAddress());
                if (t.getPhone() != null)        hospital.setPhone(t.getPhone());
                if (t.getFoundationDate() != null) hospital.setFoundationDate(t.getFoundationDate());
                if (t.getGerenteName() != null)  hospital.setGerenteName(t.getGerenteName());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.listaHospital.removeIf(h -> h.getId() == id);
    }
}