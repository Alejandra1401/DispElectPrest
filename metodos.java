import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos 
{
    Scanner sc = new Scanner(System.in);
    public Queue<objComput> IngresarComputador(Queue<objComput> c) 
    {
        String ingreso = "";
        objComput o = new objComput();
        do {
            ingreso = JOptionPane.showInputDialog("Ingrese el serial del PC");
            
            if (ingreso == null) {
                JOptionPane.showMessageDialog(null, "Debe ingresar serial del pc");
            } else if (ingreso.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El serial no puede estar vacío");
            }
            
        } while (ingreso == null || ingreso.trim().isEmpty());
        o.setSerial(ingreso);
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese la marca del pc");
        while (ingreso == null || (ingreso.trim().isEmpty())) 
        {
            JOptionPane.showMessageDialog(null, "La marca no puede estar vacío");  
            ingreso = JOptionPane.showInputDialog(null, "Ingrese marca valida");
            
        }
        o.setMarca(ingreso);
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese la memoria ram del pc");
        while (!ingreso.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese memoria ram valida");
        }
        o.setMemoriaRam(Integer.parseInt(ingreso));
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese la capacidad del disco duro del pc");
        while (!ingreso.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese capacidad del DC valida");
        }
        o.setDiscoDuro(Integer.parseInt(ingreso));
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese el precio del pc");
            while (!ingreso.matches("\\d+(\\.\\d+)?")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese precio valido");
            }
        o.setPrecio(Double.parseDouble(ingreso));
        o.setDisponible(true);
        return validarExisteDispo(c,o);//No vaya a ingresar dispositivo exixtente 
    }
    public void mostrarCola (Queue<objComput> c)
    {
        for (objComput cola : c) //Deshapilando para mostrar(es lo mismo que un for normal)
        {
            JOptionPane.showMessageDialog(null, "COLA\n"+
                         "Serial:" + cola.getSerial()+"\n" + "Disponibilidad: " + cola.isDisponible() +"\n"+ 
                         "Marca " + cola.getMarca()); 
        }
    }
     public Queue<objComput> validarExisteDispo(Queue<objComput> c, objComput ingresoComp )
    {
        boolean encontrado = false;
        for(objComput ropa : c)
        {
            if (ropa.getSerial().equalsIgnoreCase(ingresoComp.getSerial())) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog( null, "El pc ya existe");
                break;
            }
        }
        if(!encontrado)
        {
            c.offer(ingresoComp);
            JOptionPane.showMessageDialog(null, "Computador ingresado correctamente");
        }
        mostrarCola(c);
        return c; 
    } 
    public Queue<objComput> PrestarComputador(Queue<objComput> c)
    {
        String serial = "";
        boolean dispComp = false; 
        boolean prestar = false;
        while (c.isEmpty()) 
        {
            System.out.println("No hay dispositivos en en la cola");
            c = IngresarComputador(c);
        }
        for (objComput o : c) //Valida si hay computadores disponibles para prestar
        {
            if (o.isDisponible()) 
            {
                dispComp = true;
                break;
            }
        }
        if (!dispComp) 
        {
            System.out.println("No hay computadores disponibles para prestar.");
            return c;
        }
        System.out.println("Por favor seleccione un computador disponible");
        MostrarDisponibles(c);
        while (!prestar) //en caso que ingrese serial errado vuelva y le pregunte 
        {
            System.out.println("Ingrese el serial del computador a prestar");
            serial = sc.next();
            for (objComput o : c) 
            {
                if (o.getSerial().equalsIgnoreCase(serial)) 
                {    
                    System.out.println("Ingrese nombre del usuario");
                    o.setNombreUsuario(sc.next());
                    System.out.println("Ingrese la cedula del usuario");
                    o.setCedula(sc.next());
                    o.setDisponible(false);
                    System.out.println("Se ha prestado computador con exito");
                    prestar = true;
                    break;
                }
            }
            if(!prestar)
            {
                System.out.println("No hay computadores con ese serial, intente nuevamente");
            }
        }
        return c;
    }
    public void MostrarDisponibles(Queue<objComput> c)
    {
        for (objComput o : c) 
        {
            if (o.isDisponible() == true) 
            {
                System.out.println("Marca : " + o.getMarca());
                System.out.println("Serial : " + o.getSerial());
                System.out.println("Memoria ram " + o.getMemoriaRam());
                System.out.println("Disco duro " + o.getDiscoDuro());
                System.out.println("Precio:" + o.getPrecio());
                System.out.println("Disponible :  SI");
            }
        }
    }
    public Queue<objComput> modificarComp(Queue<objComput> c)
    {
        while (c.isEmpty()) 
        {
            System.out.println("No hay computadores ingresados");
            c = IngresarComputador(c); //para me lleve directamente al metodo llenar y no al menu y comento el return
            //return;
        }
        System.out.println("Ingrese el serial del computador a modificar");
        String serial = sc.next();
        boolean amodif = false;
        for(objComput o : c)
        {
            if(o.getSerial().equalsIgnoreCase(serial))
            {
                amodif = true;
                System.out.println("Ingrese la opción a modificar\n" + "1: Memoria ram\n" + "2: Disco Duro\n" +
                                                                     "3: Precio\n");
                int opc = -1;
                while (!sc.hasNextInt() || ( opc = sc.nextInt()) < 1 || opc >3 ) 
                {
                    System.out.println("Opción no valida, reintente por favor");
                    sc.next();
                }
                switch (opc) 
                {
                    case 1:
                        System.out.println("Ingrese nuevo dato memoria ram de pc");
                        o.setMemoriaRam(sc.nextInt());
                    break;
                    case 2:
                        System.out.println("Ingrese nuevo dato de disco duro de pc");
                        o.setDiscoDuro(sc.nextInt());
                    break;
                    case 3:
                        System.out.println("Ingrese nuevo precio de pc");
                        o.setPrecio(sc.nextDouble());
                        break;
                        default:
                        JOptionPane.showMessageDialog(null, "Opción no disponible");
                    break;
                }
                    System.out.println("Dispositivo modificado");
                    System.out.println("Marca : " + o.getMarca());
                    System.out.println("Serial : " + o.getSerial());
                    System.out.println("Memoria ram " + o.getMemoriaRam());
                    System.out.println("Disco duro " + o.getDiscoDuro());
                    System.out.println("Precio:" + o.getPrecio());
                    
            }
        }
        if(!amodif)//llega falso porque "como no entra al if de arriba el se comvierte en true" y por eso el !amodif(false)
        {
            JOptionPane.showMessageDialog(null, "Serial no encontrado");
            return c; 
        }
        return c;
    }
    public Queue<objComput> devolverComp(Queue<objComput> c)
    { //FALTA ORGANIZAR EL MESAJE EN CASO TAL QUE NO HAYA PRESTADO Y QUE NO EXISTA EL SERIAL, EN ESTE MOMENTO MUESTRA EL MISMO MENSAJE PARA LAS DOS OPCIONES 
        String serial = "";
        while (c.isEmpty()) 
        {
            System.out.println("No hay dispositivos en en la cola");
            c = IngresarComputador(c);
        }
        boolean devolver = false;
        System.out.println("Ingrese el serial del computador a devolver");
        serial = sc.next();
        for (objComput o : c) 
        {
            if (o.getSerial().equalsIgnoreCase(serial) && !o.isDisponible()) 
            {    
                devolver = true;
                o.setDisponible(true);
                System.out.println("Computador devuelto");
                break;
                }
        }
        if(!devolver)
        {
            System.out.println("No hay computadores con ese serial, intente nuevamente");
        }            
        return c;
    }
    public Queue<objComput> eliminarComp (Queue<objComput> c)
    {
        String serial = "";
        while (c.isEmpty()) 
        {
            System.out.println("No hay dispositivos en en la cola");
            c = IngresarComputador(c);
        }
        boolean devolver = false;
        System.out.println("Ingrese serial del pc a eliminar");
        serial = sc.next();
        for (objComput o : c) 
        {
            if (o.getSerial().equalsIgnoreCase(serial)) 
            {    
                devolver = true;
                c.remove(o);
                System.out.println("Computador devuelto correctamente");
                mostrarCola(c);
                break;
            }
        }
        if(!devolver)
        {
            System.out.println("No hay computadores con ese serial, intente nuevamente");
        }            
        return c;
    }
}
