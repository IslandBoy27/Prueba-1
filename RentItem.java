package progra2;

public class RentItem {
    private String itemCode;
    private String itemName;
    private double rentalPrice;
    private int copies;

    // Constructor para inicializar los atributos
    public RentItem(String itemCode, String itemName, double rentalPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.rentalPrice = rentalPrice;
        this.copies = 0;
    }

    // Método toString para representar los valores de los atributos como cadena
    @Override
    public String toString() {
        return "Código de Item: " + itemCode + ", Nombre de Item: " + itemName + ", Precio de Renta de Item: " + rentalPrice;
    }

    // Método pagoRenta que retorna 0
    public double pagoRenta(int dias) {
        return 0.0;
    }

    // Métodos get para los atributos
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public int getCopies() {
        return copies;
    }

    // Método submenu que retorna las subopciones
    public String submenu() {
        return "1-Imprimir";
    }

    // Método ejecutarOpcion para ejecutar una operación según la opción recibida
    public void ejecutarOpcion(int opcion) {
        if (opcion == 1) {
            System.out.println(toString() + ", Cantidad de copias: " + copies);
        } else {
            System.out.println("Opción No Válida");
        }
    }

    // Método main para probar la clase RentItem
    public static void main(String[] args) {
        RentItem item = new RentItem("123", "Laptop", 50.0);
        System.out.println(item.submenu());
        item.ejecutarOpcion(1);
        item.ejecutarOpcion(2);
    }
}
