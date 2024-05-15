import java.util.ArrayList;
import java.util.Scanner;

class Empleado {
    String nombre;
    String apellido;
    String documento;
    int diasTrabajados;
    boolean subsidioTransporte;

    public Empleado(String nombre, String apellido, String documento, int diasTrabajados, boolean subsidioTransporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.diasTrabajados = diasTrabajados;
        this.subsidioTransporte = subsidioTransporte;
    }

    public double calcularSalarioBruto(double salarioBase, double valorDia, double valorSubsidioTransporte) {
        double salarioBruto = (salarioBase * diasTrabajados) / 30;
        if (subsidioTransporte) {
            salarioBruto += valorSubsidioTransporte;
        }
        return salarioBruto;
    }

    public double calcularSalarioNeto(double salarioBase, double valorDia, double valorSubsidioTransporte) {
        double salarioBruto = calcularSalarioBruto(salarioBase, valorDia, valorSubsidioTransporte);
        return salarioBruto;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // datos neccesarios
        double salarioBase = 1160.000;
        double valorDia = 43.333; //
        double valorSubsidioTransporte = 162.000;

        // lista para guardar a los empleados
        ArrayList<Empleado> empleados = new ArrayList<>();

        // ingreso de datos del empleado/s
        System.out.print("¿Cuántos empleados desea liquidar? ");
        int numEmpleados = scanner.nextInt();
        scanner.nextLine(); // limpia el buffer del scanner

        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("\nIngrese los datos del empleado " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Documento: ");
            String documento = scanner.nextLine();
            System.out.print("Días trabajados: ");
            int diasTrabajados = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer del scanner
            System.out.print("¿Recibe subsidio de transporte? (true/false): ");
            boolean subsidioTransporte = scanner.nextBoolean();
            scanner.nextLine(); // limpiar el buffer del scanner

            //  crea y agrega empleaados a la lista
            empleados.add(new Empleado(nombre, apellido, documento, diasTrabajados, subsidioTransporte));
        }

        //  calcula y agrega la nomina de cada empleado
        System.out.println("\n--- NÓMINA ---");
        for (Empleado empleado : empleados) {
            double salarioNeto = empleado.calcularSalarioNeto(salarioBase, valorDia, valorSubsidioTransporte);

            System.out.println("\nEmpleado: " + empleado.nombre + " " + empleado.apellido);
            System.out.println("Documento: " + empleado.documento);
            System.out.println("Días trabajados: " + empleado.diasTrabajados);
            System.out.println("Subsidio de transporte: " + (empleado.subsidioTransporte ? "Sí" : "No"));

            double salarioBruto = empleado.calcularSalarioBruto(salarioBase, valorDia, valorSubsidioTransporte);

            System.out.println("Total bruto: " + salarioBruto);
            System.out.println("Valor neto a pagar: " + salarioNeto);
        }
    }
}