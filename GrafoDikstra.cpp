#include <iostream>
#include <vector>
#include <queue>
#include <limits>
#include <stack>

using namespace std;

// Estructura para representar una arista en el grafo
struct Edge {
    int destination;
    int weight;
};

// Clase para representar el grafo
class Graph {
    int numVertices;
    vector<vector<Edge>> adjacencyList;
    unordered_map<string, int> nodeIndices;

public:
    Graph(int V) {
    numVertices = V;
    adjacencyList.resize(numVertices);
}

// Agregar una arista al grafo
void addEdge(const string &source, const string &destination, int weight) {
    if(nodeIndices.find(source) == nodeIndices.end()){
        nodeIndices[source] = nodeIndices.size();
    }
    if(nodeIndices.find(destination) == nodeIndices.end()){
        nodeIndices[destination] = nodeIndices.size();
    }

    int sourceIndex = nodeIndices[source];
    int destinationIndex = nodeIndices[destination];
    
    Edge edge;
    edge.destination = destinationIndex;
    edge.weight = weight;
    adjacencyList[sourceIndex].push_back(edge);
}

// Encontrar el camino más corto entre dos nodos utilizando el algoritmo de Dijkstra
void shortestPath(const string &source, const string &destination) {
// Inicializar los valores de distancia como infinito
    if(nodeIndices.find(source) == nodeIndices.end() || nodeIndices.find(destination) == nodeIndices.end()){
        cout << "Nodos inválidos" >> endl;
        return;
    }

    int sourceIndex = nodeIndices[source];
    int destinationIndex = nodeIndices[destination];
    
    vector<int> distance(numVertices, numeric_limits<int>::max());

    // El vértice fuente tiene una distancia de 0
    distance[source] = 0;

    // Vector para almacenar los nodos visitados previamente en el camino más corto
    vector<int> previous(numVertices, -1);

    // Cola de prioridad para seleccionar el vértice con la distancia mínima
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push(make_pair(0, source));

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        // Recorrer todas las aristas adyacentes al vértice actual
        for (const auto& edge : adjacencyList[u]) {
        int v = edge.destination;
        int weight = edge.weight;

        // Si se encuentra un camino más corto hacia v, actualizar la distancia, el nodo previo y encolar el vértice
    if (distance[v] > distance[u] + weight) {
        distance[v] = distance[u] + weight;
        previous[v] = u;
        pq.push(make_pair(distance[v], v));
        }
    }
}

// Mostrar el camino más corto desde el nodo fuente hasta el nodo destino
cout << "La distancia más corta desde el nodo " << source << " hasta el nodo " << destination << " es: " << distance[destination] << endl;

// Construir el camino recorrido
stack<int> path;
int current = destination;
while (current != -1) {
    path.push(current);
    current = previous[current];
}

// Mostrar los nodos recorridos en el camino más corto
cout << "Camino recorrido: ";
while (!path.empty()) {
    int nodeIndex = path.top();
    for(const auto &pair : nodeIndices){
        if (pair.second == nodeIndex) {
            cout << pair.first << "";
            break;
        }
    }
    
    path.pop();
}
cout << endl;
}
};

int main() {
// Crear un grafo con 5 nodos
    Graph graph(3);

    // Agregar aristas al grafo
    graph.addEdge("Pueblo Paleta", "Ciudad Carmín", 5);
    graph.addEdge("Pueblo Paleta", "Ciudad Ferri", 4);
    graph.addEdge("Ciudad Carmín", "Villa Verde", 1);
    graph.addEdge("Villa Verde", "Ciudad Ferri", 7);

    // Encontrar el camino más corto entre el nodo 0 y el nodo 4
    graph.shortestPath("Pueblo Paleta", "Villa Verde");

    return 0;
}