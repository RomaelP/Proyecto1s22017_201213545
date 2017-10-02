from nodoLS import Nodo 

class listaS ():
    def __init__(self):
        self.inicio = None
        
    def insertar(self, tipo, usuario):
        if self.inicio == None:
            nuevoNodo = Nodo(tipo, usuario)
            self.inicio = nuevoNodo
        else:
            temporal = self.inicio
            while (temporal.siguiente != None):
                temporal = temporal.siguiente
                
            nuevoNodo = Nodo(tipo, usuario)
            temporal.siguiente = nuevoNodo
            
    def mostrarListaSimple(self):
        return "aqui voy a mostrar o devolver la listaBitacora"
    
