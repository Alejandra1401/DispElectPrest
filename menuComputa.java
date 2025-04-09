import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class menuComputa 
{
    public Queue<objComput> menuComputador(Queue<objComput> c, Scanner sc) 
    {
        boolean bandera = true;
        String rpta = "";
        metodos m = new metodos();
        int opt = 0;
        while (bandera) 
        {
            do {
                rpta = JOptionPane.showInputDialog("      COMPUTADOR \n" +
                                                   "1.Registrar Computador\n" +
                                                   "2.Prestar Computador\n" +
                                                   "3.Modificar Computador\n" +
                                                   "4.Devolver Computador\n" + 
                                                   "5.Inventario de computadores \n" + 
                                                   "6.Eliminar Computador\n" +
                                                   "7.Menu Principal\n");
            
                if (rpta == null || !rpta.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Dato incorrecto, reintente por favor");
                }
            } while (rpta == null || !rpta.matches("\\d+"));
            opt = Integer.parseInt(rpta);
            if (opt < 1 || opt > 7) 
            {
                JOptionPane.showMessageDialog(null, "Opción no valida, reintente por favor");
                continue;
            }
            switch (opt) 
            {
                case 1:
                    c = m.IngresarComputador(c);
                    break;
                case 2:
                    c = m.PrestarComputador(c);
                    break;
                case 3:
                    c = m.modificarComp(c);
                    break;
                case 4:
                    c = m.devolverComp(c);
                    break;
                case 5:
                    m.MostrarDisponibles(c);
                    break;
                case 6:
                    c = m.eliminarComp(c);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Se ha salido del menu computadores, hasta pronto");
                    bandera = false;
                    break;
            }
        }
        return c;
    }
    
}
