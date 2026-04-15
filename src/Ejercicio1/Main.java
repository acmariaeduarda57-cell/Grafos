package Ejercicio1;

public class Main {
    public static void main(String[] args){
        Grafo grafo = new Grafo();

        grafo.agregarVertice("A", 30);
        grafo.agregarVertice("B", 20);
        grafo.agregarVertice("C", 25);
        grafo.agregarVertice("D", 45);
        grafo.agregarVertice("E", 10);
        grafo.agregarVertice("F", 50);

        grafo.agregarArista("A", "B", 20);
        grafo.agregarArista("A", "D", 50);
        grafo.agregarArista("B", "C", 10);
        grafo.agregarArista("C", "A", 25);
        grafo.agregarArista("C", "F", 45);
        grafo.agregarArista("D", "C", 30);
        grafo.agregarArista("D", "E", 10);
        grafo.agregarArista("E", "F", 5);
        grafo.agregarArista("F", "A", 30);
        grafo.agregarArista("F", "D", 25);

        grafo.mostrarListaAdyacencia();

        System.out.println("Búsqueda en Anchura");
        System.out.println("Orden de Exploración desde el vértice A");
        grafo.mostrarRecorrido("Orden BFS", grafo.bfs("A"));

        System.out.println("Búsqueda en Profundidad");
        System.out.println("Orden de Exploración desde el vértice A");
        grafo.mostrarRecorrido("Orden DFS", grafo.dfs("A"));



    }
}
