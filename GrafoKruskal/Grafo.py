from typing import List, MutableSet

class Nodo:
    def __init__(self, etiqueta) -> None:
        self.etiqueta=etiqueta

class Arista:
    def __init__(self, origen:Nodo, destino:Nodo, peso:float):
        self.origen = origen
        self.destino = destino
        self.peso = peso

class Grafo:
    def __init__(self):
        self.aristas = []
        self.padres = {}
        self.nodos:List[Nodo] = []
       
    def agregar_arista(self, origen, destino, peso):
        self.aristas.append(Arista(origen, destino, peso))
       
    def buscar_padre(self, nodo):
        if self.padres[nodo.etiqueta] == nodo:
            return nodo
        else:
            return self.buscar_padre(self.padres[nodo.etiqueta])
       
    def unir_nodos(self, padre1, padre2):
        self.padres[padre2] = padre1
       
    def kruskal(self)->List[Arista]:
        self.aristas = sorted(self.aristas, key=lambda arista: arista.peso)
        for nodo in self.nodos:
            self.padres[nodo.etiqueta] = nodo
        arbol:List[Arista] = []
        for arista in self.aristas:
            padre1 = self.buscar_padre(arista.origen)
            padre2 = self.buscar_padre(arista.destino)
            if padre1 != padre2:
                arbol.append(arista)
                self.unir_nodos(padre1, padre2)
        return arbol

class Program:
    def __init__(self) -> None:
        self.grafo=Grafo()
        self.grafo.nodos.append(Nodo("Central de suministros"))

    def menu(self):
        print("""
        Control de la red de provisión de suministros a Tiendas.
        1. Registrar tienda
        2. Registrar la distancia entre 2 tiendas
        3. Mostrar las tiendas registradas
        4. Mostrar las distancias registradas
        5. Encontrar ruta óptima entre la central y una tienda
        0. Salir

        """, end="")

    def ejecutar(self):
        while True:
            self.menu()
            opcion=input("Ingresa una opción: ")
            if opcion=="0":
                break
            elif opcion=="1":
                self.inputNode()
            elif opcion=="2":
                self.ingresarArista()
            elif opcion=="3":
                self.mostrarNodos()
            elif opcion=="4":
                self.mostrarAristas()
            elif opcion=="5":
                self.mostrarCaminoOptimo()
            else:
                print("Opción no válida")
            print()
            input("Presione una tecla para continuar...\n")
   
    def inputNode(self):
        id = input("Ingrese el nombre de la tienda: ")
        self.grafo.nodos.append(Nodo(id))
   
    def mostrarNodos(self):
        for index, nodo in enumerate(self.grafo.nodos):
            print(f"\t{index+1}. {nodo.etiqueta}")

    def mostrarAristas(self):
        for index, arista in enumerate(self.grafo.aristas):
            print(f"{index+1}. ({arista.origen.etiqueta}, {arista.destino.etiqueta}) = {arista.peso}km")

    def mostrarOpcionesDeNodos(self, showCentral:bool=True):
        if showCentral:
            for index, nodo in enumerate(self.grafo.nodos):
                print(f"{chr(index+65)}) {nodo.etiqueta}")
        else:
            for index in range(1, len(self.grafo.nodos)):
                print(f"{chr(index+64)}) {self.grafo.nodos[index].etiqueta}")


    def obtenerNodoSeleccionado(self, valor)->Nodo:
        if type(valor)==str:
            valor=ord(valor)
        for index, nodo in enumerate(self.grafo.nodos):
            if index == valor-65:
                return nodo

    def ingresarArista(self):
        self.mostrarOpcionesDeNodos()
        valor = input(f"Seleccione la tienda de origen (A-{chr(len(self.grafo.nodos)+64)}): ")
        nodoA=self.obtenerNodoSeleccionado(valor)

        self.mostrarOpcionesDeNodos()
        valor = input(f"Seleccione la tienda de destino (A-{chr(len(self.grafo.nodos)+64)}): ")
        nodoB=self.obtenerNodoSeleccionado(valor)

        peso = float(input("Ingrese la distancia (km) entre ambas tiendas: "))
        self.grafo.agregar_arista(nodoA, nodoB, peso)

    def mostrarCaminoOptimo(self) -> None :
        self.mostrarOpcionesDeNodos()
        valor = ord(input(f"Seleccione la tienda de origen (A-{chr(len(self.grafo.nodos)+64)}): "))
        nodo1=self.obtenerNodoSeleccionado(valor)

        self.mostrarOpcionesDeNodos()
        valor = ord(input(f"Seleccione la tienda de destino (A-{chr(len(self.grafo.nodos)+64)}): "))
        nodo2=self.obtenerNodoSeleccionado(valor)

        caminoOptimo:List[Nodo]=self.encontrarCaminoOptimo(nodo1,nodo2)
        print(f"La ruta de distribucíon óptima partiendo de {nodo1.etiqueta} es:")
        for index, nodo in enumerate(caminoOptimo):
            print(f"\t{index}. {nodo.etiqueta}")

    def encontrarCaminoOptimo(self, origen:Nodo, destino:Nodo) -> List[Nodo] :
        arbol:List[Arista] = self.grafo.kruskal()
        visitados:MutableSet[Nodo] = set()
        camino:List[Nodo] = []

        def dfs(actual:Nodo, destino:Nodo):
            visitados.add(actual)

            if actual == destino:
                return True
           
            for arista in arbol:
                if arista.origen == actual and arista.destino not in visitados:
                    camino.append(arista.destino)
                    if dfs(arista.destino, destino):
                        return True
                    camino.pop()
                elif arista.destino == actual and arista.origen not in visitados:
                    camino.append(arista.origen)
                    if dfs(arista.origen, destino):
                        return True
                    camino.pop()
            return False
       
        dfs(actual=origen,destino=destino)
        return camino


Program().ejecutar()