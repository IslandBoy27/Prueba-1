package progra2;

import java.util.Calendar;
import java.util.Scanner;

public class PS3Game extends RentItem {
    private Calendar fechaPublicacion;

    // Constructor que inicializa los atributos de la clase padre y la fecha de publicación
    public PS3Game(String itemCode, String itemName) {
        super(itemCode, itemName, 30.0); // El precio de renta es fijo y es de Lps. 30
        this.fechaPublicacion = Calendar.getInstance();
    }

    // Redefine toString para agregar la fecha de publicación y " - PS3 Game"
    
    public String toString() {
        return super.toString() + ", Fecha de Publicación: " + fechaPublicacion.getTime() + " - PS3 Game";
    }

    // Método para actualizar la fecha de publicación
    public void setFechaPublicacion(int year, int mes, int dia) {
        this.fechaPublicacion.set(year, mes - 1, dia); // El mes en Calendar es 0-based
    }

    // Redefine pagoRenta para retornar el precio de renta por cada día que se recibe
    public double pagoRenta(int dias) {
        return getRentalPrice() * dias;
    }

    // Redefine la función submenu para adicionar "2-Actualizar Fecha de Publicación"
    public String submenu() {
        return super.submenu() + "\n2-Actualizar Fecha de Publicacion";
    }

    // Redefine ejecutarOpcion para manejar las opciones del submenú
    public void ejecutarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println(toString() + ", Cantidad de copias: " + getCopies());
                break;
            case 2:
                System.out.print("Ingrese el año de publicación: ");
                int year = scanner.nextInt();
                System.out.print("Ingrese el mes de publicación: ");
                int mes = scanner.nextInt();
                System.out.print("Ingrese el día de publicación: ");
                int dia = scanner.nextInt();
                setFechaPublicacion(year, mes, dia);
                System.out.println("Fecha de publicación actualizada a: " + fechaPublicacion.getTime());
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

   
}
