package Ejercicio2;

public class Main {
    public static void main(String[] args){

        String[] vertices = {"A","B","C","D","E","F","G"};

        Grafo grafo = new Grafo(7,vertices);

        grafo.agregarArista("A","B");
        grafo.agregarArista("A","C");
        grafo.agregarArista("A","D");

        grafo.agregarArista("B", "C");
        grafo.agregarArista("B", "E");
        grafo.agregarArista("B", "G");

        grafo.agregarArista("C", "D");
        grafo.agregarArista("C", "F");

        grafo.agregarArista("D", "G");

        grafo.agregarArista("E","F");
        grafo.agregarArista("E","G");

        grafo.agregarArista("F","G");

        grafo.mostrarMatriz();

        grafo.mostrarListaAdyacencia();

        System.out.println("Búsqueda en Anchura");
        System.out.println("Explora en orden ascendente por etiqueta");
        grafo.mostrarRecorrido("Orden BFS deste A", grafo.bfs("A"));

        System.out.println("Búsqueda en Profundidad");
       grafo.mostrarRecorrido("Orden DFS Recursivo desde A", grafo.dfsRecursivo("A"));

    }
}
