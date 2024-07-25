package progra2;

import java.util.Scanner;

public class Movie extends RentItem {
    private String estado;

    // Constructor que inicializa los atributos de la clase padre y el estado
    public Movie(String itemCode, String itemName) {
        super(itemCode, itemName, 0.0);
        this.estado = "ESTRENO";
    }

    // Métodos set y get para estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    // Redefine toString para agregar el estado y " - Movie"
    @Override
    public String toString() {
        return super.toString() + ", Estado: " + estado + " - Movie";
    }

    // Redefine pagoRenta para calcular el monto a pagar basado en el estado y días de renta
    @Override
    public double pagoRenta(int dias) {
        double monto = getRentalPrice();
        if (estado.equals("ESTRENO") && dias > 2) {
            monto += 50 * (dias - 2);
        } else if (!estado.equals("ESTRENO") && dias > 5) {
            monto += 30 * (dias - 5);
        }
        return monto;
    }

    // Redefine la función submenu para adicionar "2-Cambiar Estado"
    @Override
    public String submenu() {
        return super.submenu() + "\n2-Cambiar Estado";
    }

    // Redefine ejecutarOpcion para manejar las opciones del submenú
    @Override
    public void ejecutarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println(toString() + ", Cantidad de copias: " + getCopies());
                break;
            case 2:
                System.out.print("Ingrese el nuevo estado: ");
                String nuevoEstado = scanner.nextLine();
                setEstado(nuevoEstado);
                System.out.println("Estado actualizado a: " + estado);
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }
}
