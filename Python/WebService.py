from Lista import ListaDoble 
from listaS import listaS
from flask import Flask, request, Response
from ArbolB import ArbolB
from ArbolAVL import ArbolAVL
import json

app = Flask("EDD")

arbolB = ArbolB()
listaCD = ListaDoble()
#listaS = listaS()
listaBitacora = listaS()
arbolAVL = ArbolAVL()

class WebService():
    #_______________METODO PARA PROBAR EL SERVIDOR_______________________________
    @app.route('/metodo',methods = ['POST'])
    def PruebaMetodo():
        cadena = str(request.form['dato'])
        return cadena + "Prueba"
    
    #________________METODO PARA AGREGAR UN NUEVO USUARIO________________________
    @app.route('/agregarLD', methods = ['POST'])
    def agregarListaDoble():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])
        listaCD.insertarListaD(usuario, contra)
        listaBitacora.insertar("Se agrego un nuevo usuario", usuario); #se manda a guardar en una lista simple con las acciones para la bitacora
        return "True"
    #__________________METODO PARA VERIFICAR EL LOGUIN___________________________
    @app.route('/verificar',methods=['POST'])
    def VerificarDatos():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])
        respuesta = listaCD.verificarUsuario(usuario, contra)
        listaBitacora.insertar("El usuario se logueo ", usuario)
        return respuesta
    
    
   
    @app.route('/crearCarpeta', methods=['POST'])
    def CrearCarpeta():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])
        nombreCarpeta = str(request.form['nombreCarpeta'])
        idCarpeta = str(request.form['idCarpeta'])
        
        raizArbolB = listaCD.retornarNodoRaizB(usuario,contra)
        raizNuevaArbolB = arbolB.crearNodoInsertarUsuario(idCarpeta, nombreCarpeta, "15", raizArbolB)
        listaCD.actualizarNodoRaizB(usuario, contra, raizNuevaArbolB)
        return "carpeta creada en g " +usuario
    
    
#___________________________METODOS PARA GRAFICAR ESTRUCTURAS_______________________     
    @app.route('/crearArchivoArbolB', methods=['POST']) 
    def crearArchivoGraficaB():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])
        raizArbolBgrafica = listaCD.retornarNodoRaizB(usuario, contra)
        arbolB.crearArchivo(raizArbolBgrafica)
        return "Archivo creado con exito"
    
    @app.route('/CrearArchivoListaCircular')
    def CrearArchivoListaCircular():	
        claseListaCircular.grabarArchivo()
        return "Archivo Creado"
    
    @app.route('/CrearArchivoListaSimple')
    def CrearArchivoListaSimple():	
        claseListaSimple.crearArchivo()
        return "Archivo Creado"
    
    @app.route('/CrearArchivoArbolB',methods=['POST'])
    def CrearCarpetasArbolB():
        usuario = str(request.form['usuario'])
        contrasena = str(request.form['contrasena'])
    
        raizArbolB = claseListaCircular.RetornarRaizArbolB(usuario, contrasena)
        claseArbolB.crearArchivo(raizArbolB)
        return "Archivo Creado"	    
         
    @app.route('/crearArchivoCarpetaAVL', methods=['POST'])   
    def CrearArchivosArbolAVL():
        archivoByte = request.form["archivoByte"] 
        objFile = json.loads(archivoByte) 
        
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])
        nombreCarpeta = str(request.form['nombreCarpeta'])
        idCarpeta = str(request.form['idCarpeta'])
        #idArchivo = str(request.form['idArchivo'])
        archivo = objFile["fileBytes"]
        nombreArchivo = objFile["fileName"]
        
        raizArbolB = listaCD.retornarNodoRaizB(usuario,contra)
        raizNuevaArbolB = arbolB.retornarNodoArbolB(idCarpeta, nombreCarpeta, "10", raizArbolB)
        raizArbolAVL = arbolAVL.CrearNodo(nombreArchivo, archivo, raizNuevaArbolB.RiazNodoAVL)
        NuevaRaizB = arbolB.ActualizarRaizAVL_De_ArbolB(idCarpeta, raizArbolB, raizArbolAVL)
        listaCD.actualizarNodoRaizB(usuario, contra, NuevaRaizB)        
        
        return "Archivo Creado"
                  
    
    @app.route('/PruebaByte',methods=['POST'])
    def PruebaByte():
        archivoByte = request.form["archivoByte"] 
        objFile = json.loads(archivoByte)
        #listaS.insertar(objFile["fileBytes"], objFile["fileName"])
        #claseListaSimple.insertar(objFile["fileBytes"], objFile["fileName"], "3")
        return "Inserto"
    
    @app.route('/RespuestaArchivo',methods=['POST'])#<-----Metodo para descargar el archivo
    def RespuestaArchivo():
        usuario = request.form['usuario']
        contra = request.form['contra']
        idCarpeta = request.form['idCarpeta']
        nombreCarpeta = request.form['nombreCarpeta']
        nombreArchivo = request.form['nombreArchivo']
        
        raizArbolB = listaCD.retornarNodoRaizB(usuario,contra)
        retornarCarpeta = arbolB.retornarNodoArbolB(idCarpeta, nombreCarpeta, 10, raizArbolB)#<------ dos veces idCarpeta
        datosAVL = arbolAVL.obtenerAVL(nombreArchivo, retornarCarpeta.RiazNodoAVL)
        
        objFile ={"fileName":str(datosAVL.nombre) ,"fileBytes":str(datosAVL.archivo)}
        jsonFile = json.dumps(objFile)
        return jsonFile 
    
    @app.route('/concatenarNombresC')
    def concatenarNombresCarpetas():
        usuario = request.form['usuario']
        contra = request.form['contra']
        raizArbolB = listaCD.retornarNodoRaizB(usuario, contra)#aqui tengo la raiz del Arbol B deberia mandar a escribir todos los nombres con ese nodo de parametro
        
        
#---------------------------RETORNAR CARPETAS---------------------------------#
    @app.route('/RetornarCarpetas',methods=['POST'])
    def RetornarCarpetas():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])

        raizArbolB = listaCD.retornarNodoRaizB(usuario, contra) #Buscamos en el Nodo de la lista el ArbolB
        StringDelArbolB = arbolB.RetornarArbolCompleto(raizArbolB) #Retornamos todas las carpetas
        return StringDelArbolB	 
    
    @app.route('/concatenarNombresArchivos')
    def concatenarNombresArchivos():
        usuario = request.form['usuario']
        contra = request.form['contra']
        idCarpeta = request.form['idCarpeta']
        
        
    @app.route('/RetornarArchivos',methods=['POST'])
    def RetornarArchivos():
        usuario = str(request.form['usuario'])
        contra = str(request.form['contra'])
        idCarpeta = str(request.form['idCarpeta'])		

        raizArbolB = listaCD.retornarNodoRaizB(usuario, contra) #Buscamos en el Nodo de la lista el ArbolB
        RetornarCarpeta = arbolB.retornarNodoArbolB(idCarpeta, idCarpeta, "C100", raizArbolB) #Retorno Carpeta
        datosDeArchivoAVL = arbolAVL.retornarArchivos(RetornarCarpeta.RiazNodoAVL) #Retornamos Archivos Dentro de Carpeta
        return datosDeArchivoAVL
        
            
    
    if __name__ == "__main__":
        app.run(debug=True, host='127.0.0.5')