package progra2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<RentItem> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Item");
            System.out.println("2. Consultar Item");
            System.out.println("3. Ejecutar Sub Menú");
            System.out.println("4. Imprimir Todo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el tipo (MOVIE o PS3): ");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Ingrese el código del Item: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del Item: ");
                    String nombre = scanner.nextLine();

                    if (tipo.equals("MOVIE")) {
                        items.add(new Movie(codigo, nombre));
                        System.out.println("Movie agregada exitosamente.");
                    } else if (tipo.equals("PS3")) {
                        items.add(new PS3Game(codigo, nombre));
                        System.out.println("PS3 Game agregado exitosamente.");
                    } else {
                        System.out.println("TIPO INCORRECTO");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el código del Item: ");
                    codigo = scanner.nextLine();
                    RentItem item = findItemByCode(items, codigo);

                    if (item != null) {
                        System.out.println(item.toString() + ", Cantidad de copias: " + item.getCopies());
                        System.out.print("Ingrese los días a rentar: ");
                        int dias = scanner.nextInt();
                        System.out.println("Monto a pagar: Lps. " + item.pagoRenta(dias));
                    } else {
                        System.out.println("Item No Existe");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el código del Item: ");
                    codigo = scanner.nextLine();
                    item = findItemByCode(items, codigo);

                    if (item != null) {
                        System.out.println(item.submenu() + "\nEscoja Opción: ");
                        int subOption = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        item.ejecutarOpcion(subOption);
                    } else {
                        System.out.println("Item No Existe");
                    }
                    break;
                case 4:
                    for (RentItem i : items) {
                        System.out.println(i.toString() + ", Cantidad de copias: " + i.getCopies());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }

    private static RentItem findItemByCode(ArrayList<RentItem> items, String code) {
        for (RentItem item : items) {
            if (item.getItemCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
