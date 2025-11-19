# TP2-OOP-JAVA
El objetivo principal de este trabajo práctico es reemplazar las colecciones estáticas (Array y ArrayList) por la estructura de datos dinámica Lista Enlazada Simple (ListaEnlazada y Nodo), demostrando el dominio de la manipulación de punteros y la adaptación de algoritmos iterativos y recursivos a esta nueva estructura.

I. ENTREGABLES ADICIONALES MODIFICADOS
1. Implementación Completa de Nodo.java y ListaEnlazada.java
Se han creado e implementado dos clases genéricas (<T>) que cumplen con la estructura de la Lista Enlazada Simple, basadas en la revisión teórica del Capítulo Listas:
🧱 Clase Nodo<T>

Propósito: La unidad básica de la lista. Almacena un dato (T dato) y una referencia al siguiente nodo (Nodo<T> siguiente).

Encapsulamiento: Se utilizan getters y setters para garantizar el acceso seguro a los atributos.

🔗 Clase ListaEnlazada<T>

Propósito: Gestiona la colección completa a través de la referencia al primer nodo (nodoInicial o head).

Funcionalidades Clave:

Inscripción Ordenada: Se implementó insertarOrdenado(T dato) en ListaEnlazada (que requiere que T implemente Comparable). Esta inserción garantiza que la lista de miembros de la Universidad se mantenga ordenada por apellido sin necesidad de usar algoritmos de ordenamiento posterior (como el Selection Sort que se eliminó).

Recorrido: Implementa Iterable<T> para permitir el uso del bucle for-each de Java, aunque los métodos centrales de la Universidad fueron adaptados para usar el recorrido manual (while (actual != null)) para fines académicos.

2. Adaptación de Clases del Sistema Educativo

Todas las clases que anteriormente utilizaban Array o ArrayList para sus colecciones internas fueron migradas a ListaEnlazada.

Adaptación de Algoritmos Clave

Estudiante.calcularPromedioRecursivo(): El avance recursivo fue adaptado para usar el nodo actual como parámetro, reemplazando el array y el índice.

Universidad (Algoritmos Recursivos e Iterativos): Todos los métodos de búsqueda y conteo (contarMiembrosPorRolRecursivo, buscarMiembroPorDocumentoRecursivo, etc.) fueron reescritos para utilizar el patrón de recorrido nodo por nodo (nodoActual.getSiguiente()) en lugar de trabajar con índices o arrays auxiliares.

II. ANÁLISIS ESTRUCTURAL

3. Diferencias Clave: Arrays vs. Listas Enlazadas

4. Ventajas y Desventajas de Usar Listas Enlazadas en este Contexto

✅ Ventajas en el Contexto Universitario

Inserción/Eliminación Eficiente de Miembros (O(1)):

Contexto: Los miembros de la Universidad se insertan una sola vez. Al implementar la Inserción Ordenada, se logra mantener la colección organizada por apellido con una complejidad baja, evitando el costoso (O(N²)) de ordenar un array cada vez que se lista.

Uso Eficiente de Memoria:

Contexto: La memoria se asigna solo cuando se agrega un nuevo miembro o materia, evitando la pre-asignación de grandes bloques de memoria (como ocurre con los arrays).

Flexibilidad de las Colecciones:

Contexto: Las listas de materias en Estudiante y Profesor pueden crecer sin limitación predefinida.

❌ Desventajas en el Contexto Universitario

Acceso Secuencial Lento (O(N)):

Contexto: Para buscar un miembro por documento o un estudiante por carrera en la Universidad, la lista debe ser recorrida desde la cabeza hasta el final. No existe la posibilidad de Búsqueda Binaria o acceso directo, lo que hace que estas operaciones sean menos eficientes que en un array indexado.

Mayor Consumo de Memoria por Punteros:

Contexto: Aunque asignan memoria dinámicamente, cada objeto Materia o MiembroUniversidad consume memoria adicional para almacenar la referencia (siguiente) del Nodo.
