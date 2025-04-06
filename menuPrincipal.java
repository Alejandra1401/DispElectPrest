import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class menuPrincipal
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        Queue<objComput> c = new LinkedList<>();
        Queue<objTablet> t = new LinkedList<>();
        int opt = 0;
        while (bandera) 
        {
            System.out.println("Bienvenido al departamento de prestamos de dispositivos!");
            System.out.println("Por favor seleccione dispositivo ");
            System.out.println("1 : Computador");
            System.out.println("2 : Tablet");
            System.out.println("3 : Salir");
            while (!sc.hasNextInt()) 
            {
                System.out.println("Digito incorrecto, por favor intente de nuevo....");
                sc.next();
            }
            opt = sc.nextInt();//Captura la opción que eligio 
            sc.nextLine();
            if (opt < 1 || opt > 3) //Validación de la opción
            {
                System.out.println("Por favor ingrese un digito entre 1 y 3");
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
                    System.out.println("Hasta Pronto");
                    bandera = false;
                    break;
            }
        }
        
    }
    
}
