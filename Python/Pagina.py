from NodoArbolB import NodoArbolB

nodoB = NodoArbolB()

#_La clase Pagina contiene 5 posiciones(Claves) y cada una contiene un Nodo del Arbol B
class Pagina: 
    def __init__(self, ramas=[0,0,0,0,0], claves=[0,0,0,0], cuentas=0):		
        self.ramas = ramas
        self.claves = claves
        self.cuentas = cuentas
        #self.raiz = None 