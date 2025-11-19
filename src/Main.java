import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // --- 1. Inicialización de Miembros ---
        Universidad miUniversidad = new Universidad("Universidad de Levantamiento de Pala");

        Estudiante est1 = new Estudiante("Ana", "Gomez", 20, "45123456", "Ingeniería de Software");
        Estudiante est2 = new Estudiante("Carlos", "Arias", 22, "40000000", "Derecho");
        Estudiante est3 = new Estudiante("Laura", "Zapata", 19, "48765432", "Medicina");
        Estudiante est4 = new Estudiante("Juan", "Díaz", 25, "35987654", "Ingeniería de Software");
        
        Profesor prof1 = new Profesor("Roberto", "Pérez", 45, "15789012", "Física Teórica", 15);
  
        Personal pers1 = new Personal("Marta", "Juárez", 35, "28345678", "Recursos Humanos", "Analista Senior", LocalDate.of(2018, 5, 10));

        // --- 2. DEMOSTRACIÓN DE POLIMORFISMO Y LISTADO ORDENADO ---
        System.out.println("\n===== 1. DEMOSTRACIÓN DE INSERCIÓN ORDENADA =====");
        
        miUniversidad.agregarMiembro(est1); // Gomez
        miUniversidad.agregarMiembro(prof1); // Pérez
        miUniversidad.agregarMiembro(pers1); // Juárez
        miUniversidad.agregarMiembro(est2); // Arias
        miUniversidad.agregarMiembro(est3); // Zapata
        miUniversidad.agregarMiembro(est4); // Díaz
        
        // La lista debe salir ordenada: Arias, Díaz, Gomez, Juárez, Pérez, Zapata
        miUniversidad.listarTodosLosMiembros();

        // --- 3. CALCULO DE PROMEDIOS (Recursivo vs. Iterativo) ---
        System.out.println("\n===== 2. CALCULO DE PROMEDIOS =====");
        
        Materia m1 = new Materia("POO", "PRG101", 6, 8, prof1);
        Materia m2 = new Materia("Bases de Datos", "DB101", 5, 9, prof1);
        Materia m3 = new Materia("Matemática", "MAT101", 7, 7, null);
        
        est1.agregarMateria(m1);
        est1.agregarMateria(m2);
        est1.agregarMateria(m3);
        
        // Versión Iterativa
        double promedioIterativo = est1.calcularPromedioIterativo();
        System.out.println("Promedio de " + est1.getNombre() + " (Iterativo): " + String.format("%.2f", promedioIterativo));
        
        // Versión Recursiva
        double promedioRecursivo = est1.calcularPromedioRecursivo();
        System.out.println("Promedio de " + est1.getNombre() + " (Recursivo): " + String.format("%.2f", promedioRecursivo));

        // --- 4. CONTEO Y BÚSQUEDA (Lista Enlazada) ---
        System.out.println("\n===== 3. CONTEO Y BÚSQUEDA (Lista Enlazada) =====");
        
        String rolBuscar = "Estudiante";

        // Conteo de Estudiantes (Iterativo)
        int conteoIterativo = miUniversidad.contarEstudiantesPorCarreraIterativo(rolBuscar);
        System.out.println("Conteo de '" + rolBuscar + "' (Iterativo): " + conteoIterativo);

        // Conteo de Estudiantes (Recursivo)
        int conteoRecursivo = miUniversidad.contarEstudiantesPorCarreraRecursivo(rolBuscar);
        System.out.println("Conteo de '" + rolBuscar + "' (Recursivo): " + conteoRecursivo);
        
        // Búsqueda por rol
        miUniversidad.buscarPorRol("Profesor");
        miUniversidad.buscarPorRol("Estudiante");

        // Búsqueda por documento (recursiva e iterativa)
        String docBuscar = "40000000"; // Carlos Arias
        
        MiembroUniversidad miembroIt = miUniversidad.buscarMiembroPorDocumentoIterativo(docBuscar);
        System.out.println("\n--- Búsqueda de Documento " + docBuscar + " (Iterativo) ---");
        if (miembroIt != null) {
            System.out.println("Encontrado: " + ((Persona)miembroIt).getNombre() + " (" + miembroIt.obtenerRol() + ")");
        } else {
            System.out.println("No encontrado.");
        }
        
        MiembroUniversidad miembroRec = miUniversidad.buscarMiembroPorDocumentoRecursivo(docBuscar);
        System.out.println("\n--- Búsqueda de Documento " + docBuscar + " (Recursivo) ---");
        if (miembroRec != null) {
            System.out.println("Encontrado: " + ((Persona)miembroRec).getNombre() + " (" + miembroRec.obtenerRol() + ")");
        } else {
            System.out.println("No encontrado.");
        }
    }
}