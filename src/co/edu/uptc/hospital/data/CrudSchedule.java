package co.edu.uptc.hospital.data;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.uptc.hospital.model.Schedule;

public class CrudSchedule extends AbstractCrud<Schedule> {

    private List<Schedule> listaSchedule;

    public CrudSchedule() {
        super("Horario");
        this.listaSchedule = new ArrayList<Schedule>();
    }

    @Override
    protected Schedule createInstance() {
        String dayOfWeek = JOptionPane.showInputDialog(null,
                "Digite el día de la semana (Monday, Tuesday...):",
                "Agregar registro de Horario", JOptionPane.INFORMATION_MESSAGE);

        String startTime = JOptionPane.showInputDialog(null,
                "Digite la hora de inicio (HH:mm):",
                "Agregar registro de Horario", JOptionPane.INFORMATION_MESSAGE);

        String endTime = JOptionPane.showInputDialog(null,
                "Digite la hora de fin (HH:mm):",
                "Agregar registro de Horario", JOptionPane.INFORMATION_MESSAGE);

        String consultRoom = JOptionPane.showInputDialog(null,
                "Digite el consultorio asignado:",
                "Agregar registro de Horario", JOptionPane.INFORMATION_MESSAGE);

        String availStr = JOptionPane.showInputDialog(null,
                "¿Está disponible? (1 = Sí / 0 = No):",
                "Agregar registro de Horario", JOptionPane.INFORMATION_MESSAGE);
        boolean isAvailable = availStr.trim().equals("1");

        return new Schedule(dayOfWeek, startTime, endTime, consultRoom, isAvailable);
    }

    @Override
    protected boolean newRecord(Schedule record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaSchedule.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Schedule findRecordById(int id) {
        return this.listaSchedule.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    protected boolean updateRecord(Schedule t) {
        for (Schedule schedule : this.listaSchedule) {
            if (schedule.getId() == t.getId()) {
                if (t.getDayOfWeek()   != null) schedule.setDayOfWeek(t.getDayOfWeek());
                if (t.getStartTime()   != null) schedule.setStartTime(t.getStartTime());
                if (t.getEndTime()     != null) schedule.setEndTime(t.getEndTime());
                if (t.getConsultRoom() != null) schedule.setConsultRoom(t.getConsultRoom());
                schedule.setAvailable(t.isAvailable());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.listaSchedule.removeIf(s -> s.getId() == id);
    }
}