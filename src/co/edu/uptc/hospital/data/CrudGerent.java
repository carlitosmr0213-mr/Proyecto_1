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
        String firstName = JOptionPane.showInputDialog(
                null,
                "Digite el nombre del gerente:",
                "Agregar registro de Gerente",
                JOptionPane.INFORMATION_MESSAGE);

        String lastName = JOptionPane.showInputDialog(
                null,
                "Digite el apellido del gerente:",
                "Agregar registro de Gerente",
                JOptionPane.INFORMATION_MESSAGE);

        String idNum = JOptionPane.showInputDialog(
                null,
                "Digite el número de cédula del gerente:",
                "Agregar registro de Gerente",
                JOptionPane.INFORMATION_MESSAGE);

        return new Gerent(firstName, lastName, idNum);
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
                if (t.getFirstName() != null) gerent.setFirstName(t.getFirstName());
                if (t.getLastName()  != null) gerent.setLastName(t.getLastName());
                if (t.getIdNum()     != null) gerent.setIdNum(t.getIdNum());
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