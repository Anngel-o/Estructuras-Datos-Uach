class Grafo(object):
def __init__(self):
self.relaciones = {} 
def __str__(self):
return str(self.relaciones)

def agregar(grafo, elemento):
grafo.relaciones.update({elemento: []}) 

def relacionar(grafo, elemento1, elemento2):
relacionarUnilateral(grafo, elemento1, elemento2) 
relacionarUnilateral(grafo, elemento2, elemento1) 

def relacionarUnilateral(grafo, origen, destino):
grafo.relaciones[origen].append(destino)


anngelOmz = "Anngel Omz"
rosita123 = "Rosita 123"
alcachofasNews = "Alcachofas News"
devZero = "Dev Zero"
progX = "Prog X"

grafo = Grafo() 

agregar(grafo, anngelOmz )
agregar(grafo, rosita123 )
agregar(grafo, alcachofasNews)
agregar(grafo, devZero)
agregar(grafo, progX )

relacionar(grafo, anngelOmz , rosita123 )
relacionar(grafo, anngelOmz , alcachofasNews)
relacionar(grafo, rosita123, progX)
relacionar(grafo, rosita123, devZero)
relacionar(grafo, devZero, progX)

def profundidadPrimero(grafo, elementoInicial, funcion, elementosRecorridos=[]):
if elementoInicial in elementosRecorridos:
return 
funcion(elementoInicial) 
elementosRecorridos.append(elementoInicial) 
for vecino in grafo.relaciones[elementoInicial]:
profundidadPrimero(grafo, vecino, funcion, elementosRecorridos) 