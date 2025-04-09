import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class menuPrincipal
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        String rpta = "";
        Queue<objComput> c = new LinkedList<>();
        Queue<objTablet> t = new LinkedList<>();
        int opt = 0;
        while (bandera) 
        {
            do {
                rpta = JOptionPane.showInputDialog("------ BIENVENIDO ------\n" +
                                                   "1.Computador \n" +
                                                   "2.Tablet\n" +
                                                   "3.Salir\n");
            
                if (rpta == null || !rpta.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Dato incorrecto, reintente por favor");
                }
            } while (rpta == null || !rpta.matches("\\d+"));
            opt = Integer.parseInt(rpta);//Captura la opción que eligio 
            if (opt < 1 || opt > 3) //Validación de la opción
            {
                JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                continue;
            }
            switch (opt) 
            {
                case 1:
                    menuComputa mc = new menuComputa();
                    c = mc.menuComputador(c, sc);
                    break;
                case 2:
                    menuTablet mt = new menuTablet();
                    t = mt.menudeTablet(t, sc);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    bandera = false;
                    break;
            }
        }
        
    }
    
}
