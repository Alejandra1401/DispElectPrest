import java.util.Queue;
import java.util.Scanner;

public class menuTablet 
{
    public Queue<objTablet> menudeTablet(Queue<objTablet> c, Scanner sc) 
    {
        boolean bandera = true;
        int opt = 0;
        while (bandera) 
        {
            System.out.println(" Seleccione lo que desea hacer ");
            System.out.println("1 : Ingresar Tablet");
            System.out.println("2 : Prestar Tablet");
            System.out.println("3 : Modificar Tablet");
            System.out.println("4 : Devolver Tablet");
            System.out.println("5 : Mostrar inventario de Tablet");
            System.out.println("6 : Eliminar Tablet");
            System.out.println("7 : Regresar Menú Principal");
            while (!sc.hasNextInt()) 
            {
                System.out.println("Digito incorrecto, por favor intente de nuevo....");
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
                    System.out.println("Pagina 1 en mantenimiento");
                    break;
                case 2:
                    System.out.println("Pagina 2 en mantenimiento");
                    break;
                case 3:
                    System.out.println("Pagina 3 en mantenimiento");
                    break;
                case 4:
                    System.out.println("Pagina 4 en mantenimiento");
                    break;
                case 5:
                    System.out.println("Pagina 5 en mantenimiento");
                    break;
                case 6:
                    System.out.println("Pagina 6 en mantenimiento");
                    break;

                default:
                    System.out.println("Hasta pronto");
                    bandera = false; // Como se convierte en falso, me devuelve al menu principal que es donde esta siendo invocado el metodo 
                    break;
            }
        }
        return c;
    }
    
}
