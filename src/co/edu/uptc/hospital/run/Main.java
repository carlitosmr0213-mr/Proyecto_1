package co.edu.uptc.hospital.run;
 
import javax.swing.JOptionPane;
 
import co.edu.uptc.hospital.data.CrudDoctor;
import co.edu.uptc.hospital.data.CrudNurse;
import co.edu.uptc.hospital.data.CrudGerent;
import co.edu.uptc.hospital.data.CrudHospital;
 
public class Main {
 
    public static void main(String[] args) {
 
        CrudHospital   crudHospital   = new CrudHospital();
        CrudGerent     crudGerent     = new CrudGerent();
        CrudDoctor     crudDoctor     = new CrudDoctor();
        CrudNurse  crudEnfermero  = new CrudNurse();
 
        boolean running = true;
 
        while (running) {
            String menu =
                    "[1] Gestionar Hospitales\n" +
                    "[2] Gestionar Gerentes\n"   +
                    "[3] Gestionar Doctores\n"   +
                    "[4] Gestionar Enfermeros\n" +
                    "[5] Salir";
 
            String input = JOptionPane.showInputDialog(
                    null,
                    menu,
                    "========== MENÚ PRINCIPAL ==========",
                    JOptionPane.INFORMATION_MESSAGE);
 
            /*El usuario cerró la ventana o canceló*/
            if (input == null) {
                running = false;
                continue;
            }
 
            int opcion;
            try {
                opcion = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Por favor ingrese un número válido.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }
 
            switch (opcion) {
                case 1:
                    crudHospital.menu();
                    break;
                case 2:
                    crudGerent.menu();
                    break;
                case 3:
                    crudDoctor.menu();
                    break;
                case 4:
                    crudEnfermero.menu();
                    break;
                case 5:
                    running = false;
                    JOptionPane.showMessageDialog(null,
                            "¡Hasta luego!",
                            "Salir",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida. Ingrese un número entre 1 y 5.",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}