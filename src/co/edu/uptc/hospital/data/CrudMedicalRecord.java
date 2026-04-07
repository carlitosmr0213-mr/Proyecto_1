package co.edu.uptc.hospital.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;

import co.edu.uptc.hospital.model.MedicalRecord;

public class CrudMedicalRecord extends AbstractCrud<MedicalRecord> {

    private List<MedicalRecord> listaMedicalRecord;

    public CrudMedicalRecord() {
        super("Registro Médico");
        this.listaMedicalRecord = new ArrayList<MedicalRecord>();
    }

    @Override
    protected MedicalRecord createInstance() {
        String patientName = JOptionPane.showInputDialog(null,
                "Digite el nombre del paciente:",
                "Agregar Registro Médico", JOptionPane.INFORMATION_MESSAGE);

        String diagnosis = JOptionPane.showInputDialog(null,
                "Digite el diagnóstico:",
                "Agregar Registro Médico", JOptionPane.INFORMATION_MESSAGE);

        String treatment = JOptionPane.showInputDialog(null,
                "Digite el tratamiento:",
                "Agregar Registro Médico", JOptionPane.INFORMATION_MESSAGE);

        String observations = JOptionPane.showInputDialog(null,
                "Digite las observaciones:",
                "Agregar Registro Médico", JOptionPane.INFORMATION_MESSAGE);

        JDateChooser dateChooser = new JDateChooser();
        int option = JOptionPane.showConfirmDialog(null, dateChooser,
                "Seleccione la fecha de creación del registro",
                JOptionPane.OK_CANCEL_OPTION);
        Date creationDate = (option == JOptionPane.OK_OPTION) ? dateChooser.getDate() : new Date();

        return new MedicalRecord(diagnosis, treatment, creationDate, observations, patientName);
    }

    @Override
    protected boolean newRecord(MedicalRecord record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaMedicalRecord.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected MedicalRecord findRecordById(int id) {
        return this.listaMedicalRecord.stream()
                .filter(m -> m.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    protected boolean updateRecord(MedicalRecord t) {
        for (MedicalRecord record : this.listaMedicalRecord) {
            if (record.getId() == t.getId()) {
                if (t.getPatientName()  != null) record.setPatientName(t.getPatientName());
                if (t.getDiagnosis()    != null) record.setDiagnosis(t.getDiagnosis());
                if (t.getTreatment()    != null) record.setTreatment(t.getTreatment());
                if (t.getObservations() != null) record.setObservations(t.getObservations());
                if (t.getCreationDate() != null) record.setCreationDate(t.getCreationDate());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.listaMedicalRecord.removeIf(m -> m.getId() == id);
    }
}