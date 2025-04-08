import java.util.Queue;
import java.util.Scanner;

public class menuComputa 
{
    public Queue<objComput> menuComputador(Queue<objComput> c, Scanner sc) 
    {
        boolean bandera = true;
        metodos m = new metodos();
        int opt = 0;
        while (bandera) {
            System.out.println(" Seleccione lo que desea hacer ");
            System.out.println("1 : Ingresar Computador");
            System.out.println("2 : Prestar Computador");
            System.out.println("3 : Modificar Computador");
            System.out.println("4 : Devolver Computador");
            System.out.println("5 : Mostrar inventario computador");
            System.out.println("6 : Eliminar Computador");
            System.out.println("7 : Regresar Menú Principal");
            while (!sc.hasNextInt()) 
            {
                System.out.println("Digito Incorrecto por favor intente de nuevo....");
                sc.next();

            }
            opt = sc.nextInt();
            sc.nextLine();
            if (opt < 1 || opt > 7) 
            {
                System.out.println("Por favor ingrese un digito de 1 a 7");
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
                    System.out.println("Hasta pronto");
                    bandera = false;
                    break;
            }
        }
        return c;
    }
    
}
