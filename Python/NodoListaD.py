from NodoArbolAVL import NodoArbolAVL
from Pagina import Pagina

#_Nodo lista Doble: Usuarios
class NodoListaD ():
    def __init__(self, usuario = None, password = None, siguiente = None, anterior = None, NodoRaizB= Pagina(ramas =[None, None, None, None, None], claves =[None, None, None, None], cuentas =0)):
        self.usuario = usuario
        self.password = password
        self.siguiente = siguiente
        self.anterior = anterior
        self.NodoRaizB = NodoRaizB
        self.nodoAvl = NodoArbolAVL()
        
    def retornarNondoAvl(self):
        return self.nodoAvl
        
        