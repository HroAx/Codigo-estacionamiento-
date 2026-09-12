package tienda;

import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        String[] productos = new String[10];
        double[] precios = new double[10];
        int[] cantidades = new int[10];
        double[] subtotales = new double[10];
        double[] descuentos = new double[10];
        double[] totales = new double[10];
        
        int contador = 0;
        int opcion = 0;
        
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar venta");
            System.out.println("2. Salir y ver resumen");
            System.out.print("Elige una opcion: ");
            opcion = leer.nextInt();
            
            if (opcion == 1) {
                if (contador < 10) {
                    System.out.print("Nombre del producto: ");
                    productos[contador] = leer.next();
                    
                    System.out.print("Precio: $");
                    precios[contador] = leer.nextDouble();
                    
                    System.out.print("Cantidad: ");
                    cantidades[contador] = leer.nextInt();
                    
                    subtotales[contador] = precios[contador] * cantidades[contador];
                    
                    if (subtotales[contador] >= 1000) {
                        descuentos[contador] = subtotales[contador] * 0.10;
                    } else if (subtotales[contador] >= 500) {
                        descuentos[contador] = subtotales[contador] * 0.05;
                    } else {
                        descuentos[contador] = 0;
                    }
                    
                    totales[contador] = subtotales[contador] - descuentos[contador];
                    
                    System.out.println("Total a pagar: $" + totales[contador]);
                    
                    contador = contador + 1;
                } else {
                    System.out.println("Ya no puedes registrar mas, llegaste a 10.");
                }
            }
            
        } while (opcion != 2);
        
        if (contador > 0) {
            System.out.println("\n--- RESULTADOS ---");
            
            double totalVendido = 0;
            int ventasDescuento = 0;
            double ventaMasAlta = 0;
            
            for (int i = 0; i < contador; i = i + 1) {
                System.out.println("Venta " + (i + 1) + ": " + productos[i] + 
                                   " | Cantidad: " + cantidades[i] + 
                                   " | Total: $" + totales[i]);
                
                totalVendido = totalVendido + totales[i];
                
                if (descuentos[i] > 0) {
                    ventasDescuento = ventasDescuento + 1;
                }
                
                if (totales[i] > ventaMasAlta) {
                    ventaMasAlta = totales[i];
                }
            }
            
            double promedio = totalVendido / contador;
            
            System.out.println("\nTotal vendido: $" + totalVendido);
            System.out.println("Ventas con descuento: " + ventasDescuento);
            System.out.println("Venta mas alta: $" + ventaMasAlta);
            System.out.println("Promedio de las ventas: $" + promedio);
            
        } else {
            System.out.println("No hubo ventas hoy :( ");
        }
        
        leer.close();
    }
}
