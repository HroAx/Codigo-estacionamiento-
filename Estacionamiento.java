package estacionamiento;

import java.util.Scanner;

public class Estacionamiento {
    
    
    private int totalVehiculos = 0;
    private int totalHoras = 0;
    private double totalRecaudado = 0;
    private int vehiculosConDescuento = 0;

    
    public void registrarVehiculo(int horas) {
        if (horas <= 0) {
            System.out.println("El número de horas debe ser mayor que cero.\n");
            return;
        }

        double pago = 20.0;
        if (horas > 1) {
            pago += (horas - 1) * 15.0;
        }

        if (horas > 5) {
            double descuento = pago * 0.10;
            pago -= descuento;
            this.vehiculosConDescuento++;
            System.out.printf("Descuento aplicado: $%.2f\n", descuento);
        }

        this.totalVehiculos++;
        this.totalHoras += horas;
        this.totalRecaudado += pago;

        System.out.printf("Total a pagar: $%.2f\n\n", pago);
    }

   
    public void mostrarReporte() {
        System.out.println("----- REPORTE FINAL -----");
        System.out.println("Vehículos atendidos: " + this.totalVehiculos);
        System.out.println("Total de horas registradas: " + this.totalHoras);
        System.out.println("Vehículos con descuento: " + this.vehiculosConDescuento);
        System.out.printf("Total recaudado: $%.0f\n", this.totalRecaudado);
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamiento estacionamiento = new Estacionamiento();
        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {
            System.out.print("Ingrese las horas que permaneció el vehículo: ");
            int horas = scanner.nextInt();
            
            estacionamiento.registrarVehiculo(horas);
            
            System.out.print("¿Desea registrar otro vehículo? (S/N): ");
            continuar = scanner.next();
            System.out.println();
        }
        
        estacionamiento.mostrarReporte();
        scanner.close();
    }
}