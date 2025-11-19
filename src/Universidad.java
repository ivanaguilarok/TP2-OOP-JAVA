public class Universidad {
    private String nombre;
    private ListaEnlazada<MiembroUniversidad> miembros; 

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.miembros = new ListaEnlazada<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        if (miembro != null) {
            miembros.insertarOrdenado(miembro); 
            System.out.println("Miembro agregado ORDENADAMENTE: " + miembro.obtenerRol() + " - " + ((Persona)miembro).getNombre());
        }
    }

    // ------------------------------------------------------------------------------
    public void listarTodosLosMiembros() {
        System.out.println("\n--- Listado de Miembros de la " + nombre + " (ORDENADO por Apellido) ---");
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros regitrados.");
            return;
        }
        for (MiembroUniversidad miembro : miembros) { 
            System.out.println("-> Rol: " + miembro.obtenerRol());
            System.out.println("   Info: " + miembro.obtenerInformacionCompleta());
        }
        System.out.println("----------------------------------------");
    }

    public void buscarPorRol(String rol) {
        System.out.println("\n--- Buscando Miembros con Rol: " + rol + " ---");
        int contador = 0;
        for (MiembroUniversidad miembro : miembros) { 
            if (miembro.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println("   " + miembro.obtenerInformacionCompleta());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No se encontraron miembros con el rol '" + rol + "'.");
        }
        System.out.println("----------------------------------------");
    }
    // ------------------------------------------------------------------------------
    // --- 2. Contar Estudiantes por Carrera ---
    // Versión Iterativa
    public int contarEstudiantesPorCarreraIterativo(String carrera) {
        int contador = 0;
        for (MiembroUniversidad miembro : miembros) {
            if (miembro instanceof Estudiante) {
                Estudiante e = (Estudiante) miembro;
                if (e.getCarrera().equals(carrera)) {
                    contador++;
                }
            }
        }
        return contador;
    }
    // Versión Recursiva
    private static int contarEstudiantesRecursivo(Nodo<MiembroUniversidad> nodoActual, String carrera) {
        if (nodoActual == null) {
            return 0;
        }
        
        int sumaActual = 0;
        MiembroUniversidad miembro = nodoActual.getDato();
        
        if (miembro instanceof Estudiante) {
            Estudiante e = (Estudiante) miembro;
            if (e.getCarrera() != null && e.getCarrera().equalsIgnoreCase(carrera)) {
                sumaActual = 1;
            }
        }
        
        return sumaActual + contarEstudiantesRecursivo(nodoActual.getSiguiente(), carrera);
    }
    
    public int contarEstudiantesPorCarreraRecursivo(String carrera) {
        return contarEstudiantesRecursivo(miembros.getHead(), carrera);
    }

    // --- 3. Buscar Miembro por Documento ---
    // Versión Iterativa
    public MiembroUniversidad buscarMiembroPorDocumentoIterativo(String documento) {
        for (MiembroUniversidad miembro : miembros) {
            Persona persona = (Persona)miembro; 
            if (persona.getDocumento() != null && persona.getDocumento().equals(documento)) {
                return miembro; 
            }
        }
        return null;
    }
    // Versión Recursiva
    private static MiembroUniversidad buscarMiembroRecursivo(Nodo<MiembroUniversidad> nodoActual, String documento) {
        if (nodoActual == null) {
            return null;
        }
        
        Persona persona = (Persona)nodoActual.getDato();
        
        if (persona.getDocumento() != null && persona.getDocumento().equals(documento)) {
            return nodoActual.getDato();
        }
        
        return buscarMiembroRecursivo(nodoActual.getSiguiente(), documento);
    }
    
    public MiembroUniversidad buscarMiembroPorDocumentoRecursivo(String documento) {
        return buscarMiembroRecursivo(miembros.getHead(), documento);
    }
}