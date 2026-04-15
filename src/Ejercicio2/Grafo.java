package Ejercicio2;

import java.util.*;

public class Grafo {
    private int[][] matrizAdyacencia;
    private String[] vertices;
    private int numVertices;

    public Grafo(int numVertices, String[] vertices){
        this.numVertices = numVertices;
        this.vertices = vertices;
        this.matrizAdyacencia = new int[numVertices][numVertices];

        for(int i = 0;  i< numVertices; i ++){
            for(int j = 0; j< numVertices; j ++){
                matrizAdyacencia[i][j] = 0;
            }
        }
    }

    public void agregarArista(String origen, String destino){
        int i = indiceVertice(origen);
        int j = indiceVertice(destino);

        if(i!= -1 && j != -1){
            matrizAdyacencia[i][j] = 1;
            matrizAdyacencia[j][i] = 1;
        }
    }

    private int indiceVertice(String nombre){
        for(int i = 0;  i< numVertices; i ++){
            if(vertices[i].equals(nombre)){
                return i;
            }
        }
        return  -1;
    }

    public List<String> bfs(String inicio){
        int inicioIdx = indiceVertice(inicio);
        if(inicioIdx ==-1){
            System.out.println("Vértice"+ inicio+ "no existe");
            return new ArrayList<>();
        }
        List<String> orden = new ArrayList<>();
        boolean[] visitados = new boolean[numVertices];
        Queue<Integer> cola = new LinkedList<>();

        visitados[inicioIdx] = true;
        cola.add(inicioIdx);

        while(!cola.isEmpty()){
            int actual = cola.poll();
            orden.add(vertices[actual]);

            for(int i = 0; i< numVertices; i++){
                if(matrizAdyacencia[actual][i] == 1 && !visitados[i]){
                    visitados[i]= true;
                    cola.add(i);
                }
            }
        }
        return orden;
    }

    public List<String> dfsIterativo(String inicio){
        int inicioIdx = indiceVertice(inicio);
        if(inicioIdx ==-1){
            System.out.println("Vértice"+ inicio + "no existe");
            return new ArrayList<>();
        }
        List<String> orden = new ArrayList<>();
        boolean[] visitados = new boolean[numVertices];
        Stack<Integer> pila = new Stack<>();

        pila.push(inicioIdx);

        while(!pila.isEmpty()){
            int actual = pila.pop();

            if(!visitados[actual]){
                visitados[actual]= true;
                orden.add(vertices[actual]);

                for(int i = numVertices -1; i>= 0; i--){
                    if(matrizAdyacencia[actual][i]== 1 && !visitados[i]){
                        pila.push(i);
                    }
                }
            }
        }
        return orden;
    }

    public List<String> dfsRecursivo(String inicio){
        int inicioIdx = indiceVertice(inicio);
        if(inicioIdx ==-1){
            System.out.println("Vértice"+ inicio + "no existe");
            return new ArrayList<>();
        }
        List<String> orden = new ArrayList<>();
        boolean[] visitados = new boolean[numVertices];

        dfsRecursivoAux(inicioIdx, visitados, orden);

        return orden;
    }

    private void dfsRecursivoAux(int actual, boolean[] visitados, List<String> orden){
        visitados[actual] = true;
        orden.add(vertices[actual]);

        for(int i = 0; i<numVertices; i++){
            if(matrizAdyacencia[actual][i]==1 && !visitados[i]){
                dfsRecursivoAux(i, visitados, orden);
            }
        }
    }

    public void mostrarMatriz(){
        System.out.println("====MATRIZ DE ADYACENCIA("+ numVertices + "x" + numVertices+ ")====");

        System.out.println("   ");
        for(String v : vertices){
            System.out.println(v + "  ");
        }
        System.out.println();

        for(int i = 0; i< numVertices; i++){
            System.out.print(vertices[i]+ "  ");
            for(int j= 0; j<numVertices; j++){
                System.out.print(matrizAdyacencia[i][j]+ "  ");
            }
            System.out.println();
        }

    }

    public void mostrarListaAdyacencia(){
        System.out.println("===LISTA DE ADYACENCIA===");
        for(int i = 0; i<numVertices; i++){
            System.out.println(vertices[i]+ " ");
            List<String> adyacentes = new ArrayList<>();
            for(int j = 0; j < numVertices; j++){
                if(matrizAdyacencia[i][j]==1){
                    adyacentes.add(vertices[j]);
                }
            }
            System.out.println(adyacentes);
        }

    }

    public void mostrarRecorrido(String titulo, List<String> recorrido){
        System.out.println(titulo + ":"+ recorrido);
    }
}
