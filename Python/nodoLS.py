#_########### Nodo Lista Simple para Guardar 2 atributos, Usuario y la accion realizada

class Nodo ():
    def __init__(self, tipo = None, usuario = None, siguiente = None):
        self.tipo = tipo
        self.usuario = usuario
        self.siguiente = siguiente
        