
from NodoArbolB import NodoArbolB
from Pagina import Pagina
from Lista import ListaDoble

pagina = Pagina()
nodoB = NodoArbolB()
claseListaCircular = ListaDoble()

class ArbolB:
    def __init__(self):
        self.inicio = Pagina()
        self.inicio2 = Pagina()
        self.inserta = NodoArbolB()
        self.enlace = Pagina()
        self.pivote = False
        self.existe = False
        self.existe2 = False
        self.contadorArbolB=0
        self.stringdeCarpetasRetornarArbol = None
        
        
    def crearNodoInsertarUsuario(self, idcarpeta, nombreCarpeta, direccion, raizArbolB):#<------------ Crea el Nodo del Arbol B de un Usuario
        nodob = NodoArbolB(idcarpeta, nombreCarpeta, direccion)
        RaizRetornada = self.InsertarArbolB(nodob, raizArbolB)
        return RaizRetornada


    #Crea el Nodo del Arbol B
    def crearNodoInsertar(self, idcarpeta, nombreCarpeta, direccion):
        nodob = NodoArbolB(idcarpeta, nombreCarpeta, direccion)
        RaizB = self.InsertarArbolB(nodob, self.inicio)		
        return RaizB


    #_########################################Inserta el nodo al Arbol B, La clase es el Nodo y la raiz la Pagina
    def InsertarArbolB(self, clave, raiz):
        self.inicio = raiz
        self.agregar(clave, raiz)
        if(self.pivote == True):
            self.inicio = Pagina(ramas=[None,None,None,None,None], claves=[None,None,None,None], cuentas=0)
            self.inicio.cuentas = 1
            self.inicio.claves[0] = self.inserta
            self.inicio.ramas[0] = raiz
            self.inicio.ramas[1] = self.enlace

        return self.inicio


    #_################################Agregar al Arbol, Balanceando el arbol por Id
    def agregar(self, clave, raiz):
        pos = 0              
        self.pivote = False; 

        vacioBol = self.vacio(raiz)

        if(vacioBol == True):
            self.pivote = True
            self.inserta = clave
            self.enlace = None
        else:
            pos = self.existeNodo(clave, raiz)

            if(self.existe == True):
                self.pivote = False
            else:
                self.agregar(clave, raiz.ramas[pos])

                if(self.pivote == True):

                    if(raiz.cuentas < 4):
                        self.pivote = False;
                        self.insertarClave(self.inserta, raiz, pos)
                    else:
                        self.pivote = True
                        self.dividirPagina(self.inserta, raiz, pos)
                        print("Inserto")


    #_################################# Metodo para Verificar si la raiz no Existe
    def vacio(self, raiz):
        if(raiz == None or raiz.cuentas == 0):
            return True
        else:
            return False


    #_###############################################Metodo para Insertar Claves en Pagina
    def insertarClave(self, clave, raiz, posicion):
        i = raiz.cuentas

        while i != posicion:
            raiz.claves[i] = raiz.claves[i - 1]
            raiz.ramas[i + 1] = raiz.ramas[i]
            i-=1

        raiz.claves[posicion] = clave
        raiz.ramas[posicion + 1] = self.enlace
        val = raiz.cuentas+1
        raiz.cuentas = val
        print("Inserto Valor")


    #_############################################### Metodo para Dividir Pagina si los nodos en una pagina son 5
    def dividirPagina(self, clave, raiz, posicion):
        pos = 0
        Posmda = 0
        if(posicion <= 2):
            Posmda = 2
        else:
            Posmda = 3

        Mder = Pagina(ramas=[None,None,None,None,None], claves=[None,None,None,None], cuentas=0)
        pos = Posmda + 1

        while pos != 5:
            i = ((pos - Posmda) - 1)
            j = (pos - 1)
            Mder.claves[i] = raiz.claves[j]
            Mder.ramas[pos - Posmda] = raiz.ramas[pos]
            pos+=1

        Mder.cuentas = 4 - Posmda
        raiz.cuentas = Posmda

        if(posicion <= 2):
            self.insertarClave(clave, raiz, posicion)
        else:
            self.insertarClave(clave, Mder, (posicion - Posmda))

        self.inserta = raiz.claves[raiz.cuentas - 1]
        Mder.ramas[0] = raiz.ramas[raiz.cuentas]
        val = raiz.cuentas - 1
        raiz.cuentas = val
        self.enlace = Mder


    #_##########################################Metodo para Verificar si Existe el Nodo	
    def existeNodo(self, clave, raiz):
        valor =0
        if(clave.nombreID < raiz.claves[0].nombreID):
            self.existe2 = False
            valor = 0
        else:
            valor = raiz.cuentas
            while (clave.nombreID < raiz.claves[valor - 1].nombreID and valor > 1):
                valor-=1

            if (clave.nombreID < raiz.claves[valor - 1].nombreID):
                self.existe = True
            else:
                self.existe = False

            if (clave.nombreID == raiz.claves[valor - 1].nombreID):
                self.existe2 = True
                print(raiz.claves[valor - 1].nombreID)
            else:
                self.existe2 = False

        return valor

    #_#################################################################### Metodo para Buscar Nodo
    def retornarNodoArbolB(self, idBuscar, nombreCarpeta, direccion, raiz):	
        self.inicio = raiz 
        clave = NodoArbolB(idBuscar, nombreCarpeta, direccion)
        return self.retornarNodo(clave, self.inicio)

    #_##################################Devuelve el nodo encontrado
    def retornarNodo(self, clave, raiz):
        valorEncontrado = None
        pos = 0
        vacioBol = self.vacio(raiz)

        if(vacioBol == True):
            print("No Existe")
        else:
            pos = self.existeNodo(clave, raiz)
            if(self.existe2 == True):
                valorEncontrado = raiz.claves[pos - 1]				
            else:
                valorEncontrado = self.retornarNodo(clave, raiz.ramas[pos])
        return valorEncontrado


    #_##############################################################Metodo para Crear Nodo para Actualizar Raiz AVL
    '''def ActualizarRaizAVL_De_ArbolB(self, idBuscar, nombreCarpeta, direccion, raizB, raizAVL):	
        self.inicio = raizB 
        self.inicio.RiazNodoAVL = raizAVL		
        return "True'''

    #_###########################MEtodo para Crear Archivo del Arbol B
    def crearArchivo(self, raiz):
        archivo=open('C:\Users\USuario1\Desktop\ArbolB.txt','w')
        archivo.write('digraph G{\n')
        archivo.write("node [shape = record];\n");
        archivo.write("rankdir = TD;\n");
        archivo.close()
        self.CrearArchivoParche1(raiz)		

    #_###################################Escribir el inicio del Archivo
    def CrearArchivoParche1(self, raiz):
        self.inicio = raiz
        self.grabarArchivo(self.inicio)
        archivo=open('C:\Users\USuario1\Desktop\ArbolB.txt','a')
        archivo.write('}')
        archivo.close()

    #_#########################################Escribir Contenido del Archivo
    def grabarArchivo(self, raiz):
        nodo = raiz		
        archivo=open('C:\Users\USuario1\Desktop\ArbolB.txt','a')		

        if(nodo == None):
            print("No hay nada que Graficar")
        else:
            if (nodo.cuentas != 0):
                archivo.writelines("activo_" + str(nodo.claves[0].nombreID) + " [label= \"")
                k=1
                while k <= nodo.cuentas:
                    archivo.writelines("<r" + str(k - 1) + ">" + " | " + "<cl" + str(k) + ">" + "IdArbol: " + str(nodo.claves[k - 1].nombreID) + " &#92;" + "nDato: " + str(nodo.claves[k - 1].nombreCarpeta) + " | ")
                    k+=1


                archivo.writelines("<r" + str(k - 1) + "> \"];\n")
                i=0
                while i <= nodo.cuentas:
                    if (nodo.ramas[i] != None):
                        if (nodo.ramas[i].cuentas != 0):
                            archivo.writelines("activo_" + str(nodo.claves[0].nombreID) + ":r" + str(i) + " -> activo_" + str(nodo.ramas[i].claves[0].nombreID) + ";\n")							

                    i+=1

                j=0
                while j <= nodo.cuentas:
                    self.grabarArchivo(nodo.ramas[j])
                    j+=1
                    
                    
    def RetornarArbolCompleto(self, raiz):
        self.stringdeCarpetasRetornarArbol = ""
        self.RetornarArbolCompletoParche(raiz)
        return self.stringdeCarpetasRetornarArbol
    
    def RetornarArbolCompletoParche(self, pagina):
        nodo = pagina

        if(nodo == None):
            print("No hay nada que Graficar")
        else:
            if (nodo.cuentas != 0):
                k=1
                while k <= nodo.cuentas:
                    self.stringdeCarpetasRetornarArbol += str(nodo.claves[k - 1].nombreCarpeta) + "@"
                    k+=1
                i=0
                while i <= nodo.cuentas:
                    if (nodo.ramas[i] != None):
                        if (nodo.ramas[i].cuentas != 0):					
                            hola = "Nada"
                    i+=1

                j=0
                while j <= nodo.cuentas:
                    self.RetornarArbolCompletoParche(nodo.ramas[j])
                    j+=1  
                    
    #Crear Nodo para Actualizar Raiz AVL
    def retornarArbol(self, clave, raiz, raizAVL):
        valorEncontrado = None
        pos = 0
        vacioBol = self.vacio(raiz)
    
        if(vacioBol == True):
            print("No Existe")
        else:
            pos = self.existeNodo(clave, raiz)
            if(self.existe2 == True):
                raiz.claves[pos - 1].RiazNodoAVL = raizAVL
                self.TodoElArbol = raiz 
            else:
                self.retornarArbol(clave, raiz.ramas[pos], raizAVL)
        return self.TodoElArbol
    
#RetornaTodoElArbol
    def retornarArbol(self, clave, raiz, raizAVL):
        valorEncontrado = None
        pos = 0
        vacioBol = self.vacio(raiz)

        if(vacioBol == True):
            print("No Existe")
        else:
            pos = self.existeNodo(clave, raiz)
            if(self.existe2 == True):
                raiz.claves[pos - 1].RiazNodoAVL = raizAVL
                self.TodoElArbol = raiz 
            else:
                self.retornarArbol(clave, raiz.ramas[pos], raizAVL)
        return self.TodoElArbol
    
    #Crear Nodo para Actualizar Raiz AVL
    def ActualizarRaizAVL_De_ArbolB(self, idcarpeta, raizB, raizAVL):	
        nodoB = NodoB(idcarpeta, "C1", "C2")
        RaizArbolB = self.retornarArbol(nodoB, raizB, raizAVL)
        return RaizArbolB
    
    
    #RetornaTodoElArbol
    def retornarArbol(self, clave, raiz, raizAVL):
        valorEncontrado = None
        pos = 0
        vacioBol = self.vacio(raiz)

        if(vacioBol == True):
            print("No Existe")
        else:
            pos = self.existeNodo(clave, raiz)
            if(self.existe2 == True):
                raiz.claves[pos - 1].RiazNodoAVL = raizAVL
                self.TodoElArbol = raiz 
            else:
                self.retornarArbol(clave, raiz.ramas[pos], raizAVL)
        return self.TodoElArbol