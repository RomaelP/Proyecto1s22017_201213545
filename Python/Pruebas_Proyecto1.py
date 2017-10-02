from NodoListaD import NodoListaD 
from Lista import ListaDoble
from listaS import listaS
from ArbolB import ArbolB

arbolB = ArbolB()
listaCD = ListaDoble()
#listaS = listaS()
listaBitacora = listaS()

if __name__ == "__main__":
    
    
    while True:
        print "*****Menu de Prueba*****"
        print "1.-Probar"
        num = input("Ingrese un numero: ")
    
        if num == 1:  
            listaCD.insertarListaD("Roma","123")
            raizArbolB = listaCD.retornarNodoRaizB("Roma","123")
            raizNuevaArbolB = arbolB.crearNodoInsertarUsuario(10, "Carpeta", "15", raizArbolB)
            listaCD.actualizarNodoRaizB("Roma","123", raizNuevaArbolB)
            print("carpeta creada en")  
            
        if num == 2:            
            raizArbolB = listaCD.retornarNodoRaizB("Roma","123")
            raizNuevaArbolB = arbolB.crearNodoInsertarUsuario(12, "CarpetaNueva", "20", raizArbolB)
            listaCD.actualizarNodoRaizB("Roma","123", raizNuevaArbolB)
            print("carpeta creada en")
            
        if num == 3:  
            raizArbolB = listaCD.retornarNodoRaizB("Roma","123")
            raizNuevaArbolB = arbolB.crearNodoInsertarUsuario(20, "Carpeta1", "15", raizArbolB)
            listaCD.actualizarNodoRaizB("Roma","123", raizNuevaArbolB)
            print("carpeta creada en")  
                    
        if num == 4:            
            raizArbolB = listaCD.retornarNodoRaizB("Roma","123")
            raizNuevaArbolB = arbolB.crearNodoInsertarUsuario(15, "CarpetaNueva1", "20", raizArbolB)
            listaCD.actualizarNodoRaizB("Roma","123", raizNuevaArbolB)
            print("carpeta creada en")
        
        if num == 4:            
            raizArbolB = listaCD.retornarNodoRaizB("Roma","123")
            raizNuevaArbolB = arbolB.crearNodoInsertarUsuario(25, "CarpetaNueva2", "20", raizArbolB)
            listaCD.actualizarNodoRaizB("Roma","123", raizNuevaArbolB)
            print("carpeta creada en")             
    
            
        if num ==5:
            raizArbolBgrafica = listaCD.retornarNodoRaizB("Roma","123")
            arbolB.crearArchivo(raizArbolBgrafica)            
            