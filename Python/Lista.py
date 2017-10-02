from NodoListaD import NodoListaD
from NodoArbolAVL import NodoArbolAVL 
from Logical import Logical

class ListaDoble():
    def __init__(self):
        self.inicio = None
        self.ultimo = None
        self.grafica = "digraph G{\n"
        
    def insertarListaD(self, usuario, password):
        if self.inicio != None:
            temporal = self.inicio
            temporal2 = self.ultimo
            
            while temporal.siguiente != self.inicio:
                temporal = temporal.siguiente
            
            temporal.siguiente = NodoListaD(usuario, password)                   
            temporal2 = temporal.siguiente
            temporal2.siguiente = self.inicio
                    
        else:
            self.inicio =  self.ultimo = NodoListaD(usuario, password)
            self.ultimo.siguiente = self.inicio
        
    def mostrarListaD(self):
        if self.inicio != None:
            temporal = self.inicio
                
        while True:
            print "Usuario: "+str(temporal.usuario)+" Contra: "+str(temporal.password)+ " ->" + " usuario: " +str(temporal.siguiente.usuario)+" Contra: "+str(temporal.siguiente.password )
            temporal = temporal.siguiente
            if temporal.siguiente == self.inicio:
                print "Usuario: "+str(temporal.usuario)+" Contra: "+str(temporal.password)+ " ->" + " usuario: " +str(temporal.siguiente.usuario)+" Contra: "+str(temporal.siguiente.password )
                break
                
                
    def retornarNodoRaizB(self, usuario, password):
        temporal = self.inicio
        while temporal != None:
            if temporal.usuario == usuario and temporal.password == password:
                return temporal.NodoRaizB
            temporal = temporal.siguiente
            if temporal == self.inicio:
                return "False"
            
    def actualizarNodoRaizB(self, usuario, password, raizAInsertar):
        temporal = self.inicio
        while temporal != None:
            if temporal.usuario == usuario and temporal.password == password:
                temporal.NodoRaizB = raizAInsertar
            temporal = temporal.siguiente
            if temporal == self.inicio:
                return "False"            
                
    def verificarUsuario(self, usuario, password):
        if self.inicio != None:
            temporal = self.inicio
            while True:
                if temporal.usuario == usuario and temporal.password == password:
                    return "True"
                else:
                    temporal = temporal.siguiente
                    if temporal == self.inicio:
                        return "Datos erroneos"
                    
    def obtnerNodoLC(self, usuario):
        if self.inicio != None:
            temporal = self.inicio
            while True:
                if temporal.usuario == usuario:
                    return temporal
                else:
                    temporal = temporal.siguiente
                    if temporal == self.inicio:
                        break  
    
      
    #rotaciones                 
    def rotacionIzDer(self, nodo, nodo1):
        nodo2 = nodo1.derecha
        nodo1.derecha = nodo2.izquierda
        nodo2.izquierda = nodo1
        nodo.izquierda = nodo2.derecha
        nodo2.derecha = nodo
        if nodo2.factor == 1:
            nodo1.factor =-1
        else:
            nodo1.factor = 0
        if nodo2.factor == -1:
            nodo.factor = 1
        nodo2.factor = 0
        return nodo2
    
    def rotacionIzIz(self, nodo, nodo1):
        nodo.izquierda = nodo1.derecha
        nodo1.derecha = nodo
        if nodo1.factor == -1:
            nodo.factor = 0
            nodo1.factor = 0
        else:
            nodo.factor = -1
            nodo1.factor = 1
        return nodo1
    
    def rotacionDerDer(self, nodo, nodo1):
        nodo.derecha = nodo1.izquierda
        nodo1.izquierda = nodo
        if nodo1.factor == 1:
            nodo.factor = 0
            nodo1.factor = 0
        else:
            nodo.factor = 1
            nodo1.factor = -1
        return nodo1
    
    def rotacionDerIz(self, nodo, nodo1):
        nodo2 = nodo1.izquierda
        nodo1.izquierda = nodo2.derecha
        nodo2.derecha = nodo1
        nodo.derecha = nodo2.izquierda
        nodo2.izquierda = nodo
        if nodo2.factor == 1:
            nodo.factor = -1
        else:
            nodo.factor = 0
        if nodo2.factor == -1:
            nodo1.factor = 1
        else:
            nodo1.factor = 0
        nodo2.factor = 0
        return nodo2    
        
#Metodos AVL
    def agregarAVL(self, raiz, nuevoNodo, h):
        if raiz == None:
            raiz = nuevoNodo
            h.setLogical(True)
        elif int(nuevoNodo.nombre) < int(raiz.nombre):
            nodoIZ = self.agregarAVL(raiz.izquierda, nuevoNodo, h)
            raiz.izquierda = nodoIZ
            if h.getLogical() == True:
                op = raiz.factor
                if op == 1:
                    raiz.factor = 0
                    h.setLogical(False)
                elif op == 0:
                    raiz.factor = -1
                elif op == -1:
                    nodo1 = raiz.izquierda
                    if nodo1.factor == -1:
                        raiz = self.rotacionIzIz(raiz, nodo1)
                    else:
                        raiz = self.rotacionIzDer(raiz, nodo1)
                    h.setLogical(False)
        elif int(nuevoNodo.nombre) > int(raiz.nombre):
            nodoDer = self.agregarAVL(raiz.derecha, nuevoNodo, h)
            raiz.derecha = nodoDer
            if h.getLogical() == True:
                op = raiz.factor
                if op == 1:
                    nodo1 = raiz.derecha
                    if nodo1.factor == 1:
                        raiz = self.rotacionDerDer(raiz, nodo1)
                    else:
                        raiz = self.rotacionDerIz(raiz, nodo1)
                    h.setLogical(False)
                elif op == 0:
                    raiz.factor = 1
                elif op == -1:
                    raiz.factor = 0
                    h.setLogical(False)
        return raiz

    def agregarAVL1(self, nuevoNodo, usuario):
        nodoCircular = self.obtnerNodoLC(usuario)
        temp = self.retornarAVL(nuevoNodo, nodoCircular)
        if tmprl == None:
            h = Logical(False)
            nodoCircular.nodoAvl.setAvlRaiz(self.agregarAVL(nodoCircular.nodoAvl.getAVLraiz(), nuevoNodo, h))
            print("nodo agregado ")
        else:
            print("nodo ya existe")
            
        
    def retornarAVL(self, nuevoNodo, nuevoNodoC):
        nuevoNodoC.nodoAvl.serAVLencontrado(None)
        self.buscarAVL(nuevoNodoC.nodoAVL.getAVLraiz(), nuevoNodo, nuevoNodoC)
        return nuevoNodoC.nodoAVL.getAVLencontrado()
    
        
    def buscarAVL(self, raiz, nuevoNodo, nodoCircular):
        if raiz != None:
            if nuevoNodo.nombre == raiz.nombre:
                nodoCircular.nodoAVL.setAVLencontrado(raiz)
            else:
                self.buscarAVL(raiz.izquierda, nuevoNodo, nodoCircular)
                self.buscarAVL(raiz.derecha, nuevoNodo, nodoCircular)
 
 
 #metodos para Graficar AVL   
    def graficarAVL(self, usuario):
        if self.inicio != None:
            tmprl = self.inicio
            while True:
                if tmprl.usuario == usuario:
                    self.graficarArbolUser(tmprl)
                    break
                else:
                    tmprl = tmprl.siguiente
                    if tmprl == self.inicio:
                        break
                    
    def graficarArbolUser(self, nodoCircular):
        nodoAvltmprl = nodoCircular.nodoAVL
        self.limpirParGraficar()
        self.grabarArchivo(nodoAvltmprl.getAVLraiz())
        
    def limpirParGraficar(self):
        self.grafica = "digraph G{\n"
        
        
    def escribirArchivo(self, nuevoNodo):
        archivo = open("C:\\Users\\usuario1\\Desktop\\arbol.txt",'w')
        self.graficarPreOrden()
        
    def graficarPreOrden(self, nuevoNodo):
        if nuevoNodo != None:
            self.grafica += "nodo: "+str(nuevoNodo.nombre)+' [label="' +str(nuevoNodo.nombre)+'"]\n'
            if nuevoNodo.izquierda != None:
                self.grafica += "nodo: " +str(nuevoNodo.nombre)+ " -> " "nodo: " +str(nuevoNodo.izquierda.nombre)+ "\n"
                self.graficarPreOrden(nuevoNodo.izquierda)
            else:
                pass
            if nuevoNodo.derecha != None:
                self.grafica += "nodo: " +str(nuevoNodo.nombre)+ " -> " "nodo: " +str(nuevoNodo.derecha.nombre)+ "\n"
                self.graficarPreOrden(nuevoNodo.derecha)
            else:
                pass
        else:
            pass
        