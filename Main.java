
package proyectop2;

/**
 *
 * @author 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<persona> personas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("=== Gestión de Personas ===");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Listar nombres de personas");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarPersona(personas);
                    break;
                case 2:
                    listarPersonas(personas);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println();
        }
    }

    public static void agregarPersona(List<persona> personas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Agregar Datos de Persona ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        System.out.println("Seleccione tipo de persona:");
        System.out.println("1. Doctor");
        System.out.println("2. Deportista");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();

        persona persona;

        switch (opcion) {
            case 1:
                persona = new Doctor(nombre, apellido, edad);
                break;
            case 2:
                persona = new Deportista(nombre, apellido, edad);
                break;
            default:
                System.out.println("Opción inválida. Registro como persona normal.");
                persona = new persona(nombre, apellido, edad);
                break;
        }

        personas.add(persona);
        System.out.println("Persona agregada correctamente.");
    }

    public static void listarPersonas(List<persona> personas) {
        System.out.println("=== Listado de Personas ===");
        for (int i = 0; i < personas.size(); i++) {
            System.out.println("Persona " + (i + 1) + ":");
            personas.get(i).obtenerInformacion();
            System.out.println();
        }
    }
}