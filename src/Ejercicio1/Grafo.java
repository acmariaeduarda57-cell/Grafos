package Ejercicio1;

import java.util.*;

public class Grafo {
    private Map<String, List<Arista>> listaAdyacencia;
    private Map<String, Integer> pesosVertices;

    static class Arista{
        String destino;
        int peso;

        Arista(String destino, int peso){
           this.destino = destino;
           this.peso = peso;
        }

        @Override
        public String toString() {
            return "Arista{" +
                    "destino='" + destino + '\'' +
                    ", peso=" + peso +
                    '}';
        }
    }

    public Grafo(){
        listaAdyacencia = new HashMap<>();
        pesosVertices = new HashMap<>();
    }

    public void agregarVertice(String vertice, int peso){
        listaAdyacencia.putIfAbsent(vertice, new LinkedList<>());
        pesosVertices.put(vertice, peso);
    }

    public void agregarArista(String origen, String destino, int peso){
        listaAdyacencia.putIfAbsent(origen,new LinkedList<>());
        listaAdyacencia.putIfAbsent(destino,new LinkedList<>());
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
    }

    public List<String> bfs(String inicio){
        if(!listaAdyacencia.containsKey(inicio)){
            System.out.println("Vértice"+ inicio+ "no existe");
            return new ArrayList<>();
        }
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while(!cola.isEmpty()){
            String actual = cola.poll();
            orden.add(actual);

            for(Arista arista : listaAdyacencia.get(actual)){
                String vecino = arista.destino;
                if(!visitados.contains(vecino)){
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return orden;
    }

    public List<String> dfs(String inicio){
        if(!listaAdyacencia.containsKey(inicio)){
            System.out.println("Vértice"+ inicio+ "no existe");
            return new ArrayList<>();
        }
        List<String> orden = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Stack<String> pila = new Stack<>();

        pila.push(inicio);

        while(!pila.isEmpty()){
            String actual = pila.pop();

            if(!visitados.contains(actual)){
                visitados.add(actual);
                orden.add(actual);

                List<Arista> vecinos = listaAdyacencia.get(actual);
                for(int i = vecinos.size()-1; i>= 0; i--){
                    String vecino = vecinos.get(i).destino;
                    if(!visitados.contains(vecino)){
                        pila.push(vecino);
                    }
                }
            }
        }
        return orden;
    }
    public void mostrarListaAdyacencia(){
        System.out.println("====LISTA DE ADYACENCIA====");
        for(String v : listaAdyacencia.keySet()){
            System.out.println(v+ "(peso vértice:"+ pesosVertices.get(v)+")  "+ listaAdyacencia.get(v));

        }
    }

    public void mostrarRecorrido(String titulo, List<String> recorrido){
        System.out.println(titulo +":" + recorrido);
    }
    public int getPesoVertice(String vertice){
        return pesosVertices.getOrDefault(vertice, 0);
    }

    public Set<String> getVertices(){
        return listaAdyacencia.keySet();
    }
}
