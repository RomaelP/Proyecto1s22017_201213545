package Clases;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import org.apache.taglibs.standard.tag.el.core.OutTag;

public class Conexion {
    
    public static String globalUsuario = "";
    public static String globalContra = "";
    public static String globalCarpeta = "";
    
    public static OkHttpClient webClient = new OkHttpClient();
    
    /*Metodo Generico que recibe el nombre al cual se va a conectar en python
    y recibe un FormBoy que contiene los parametros a enviar*/
    public static String MetodoJava(String metodo, RequestBody formBody) {

        try {
            URL url = new URL("http://127.0.0.5:5000/" + metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String valorrespuesta = response.body().string();//y este seria el string de las respuesta
            System.out.println(valorrespuesta);
            return valorrespuesta;
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String metodoCrearCarpeta(String usuario, String contra, String nombre, String id) 
    {
    RequestBody formBody = new FormEncodingBuilder()
            .add("usuario",usuario)
            .add("contra",contra)
            .add("nombreCarpeta", nombre)
            .add("idCarpeta", id)
            .build();
        String r = MetodoJava("crearCarpeta",formBody);
        System.out.println(r);
    return r;          
    }
    
    public String RecuperarCarpeta(String usuario, String contra) 
    {
    RequestBody formBody = new FormEncodingBuilder()
            .add("usuario",usuario)
            .add("contra",contra)
            .build();
        String r = MetodoJava("RetornarCarpetas",formBody);        
    return r;          
    }
    
    
    public String metodoCargarArchivos(String usuario, String contra, String carpetaContenedora, String idCarpeta, String arregloBytes) 
    {
    RequestBody formBody = new FormEncodingBuilder()
            .add("usuario",usuario)
            .add("contra", contra)
            .add("nombreCarpeta",carpetaContenedora)
            .add("idCarpeta",idCarpeta)
            .add("archivoByte", arregloBytes)
            .build();
        String r = MetodoJava("crearArchivoCarpetaAVL",formBody);
        System.out.println(r);
    return r;          
    } 
    
    public void metodoEscribirArchivoB(String usuario, String contra){
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario", usuario)
                .add("contra", contra)
                .build();
        String respuestaEscribirArbolB = MetodoJava("crearArchivoArbolB", formBody);
        System.out.println("Arbol B escrito"+respuestaEscribirArbolB);
    }
    
    public String metodoConexion(String usuario){
    String nombre = usuario;
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato", nombre)
                .build();
        String r = MetodoJava("metodo", formBody); 
        return  r;
    }
    
    public String metodoVerificarUsuario(String usuario, String contra){
    RequestBody formBody = new FormEncodingBuilder()
            .add("usuario",usuario)
            .add("contra",contra)
            .build();
    String r = MetodoJava("verificar",formBody);
        System.out.println(r);
    return r;    
    }
    
    public String metodoAgregarUsuario(String usuario, String contra){
        RequestBody formBody = new FormEncodingBuilder()
            .add("usuario", usuario)
            .add("contra", contra)
            .build();
    
        String r = MetodoJava("agregarLD",formBody);
    return r;
    }
    
    public String PruebaByte(String archivoByte){
        RequestBody formBody = new FormEncodingBuilder()
                       .add("archivoByte", archivoByte)
                       .build();
    return ConexionPythonPruebaByte(formBody);
    }       

    public static String ConexionPythonPruebaByte(RequestBody formBody) 
    {
        try {
            URL url = new URL("http://127.0.0.5:5000/PruebaByte");
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response respuestaPython = webClient.newCall(request).execute();
            return respuestaPython.body().string();
        }catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch (IOException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }
    
    public String descargarArchivos(String usuario, String contra, String idCarpeta, String nombreArchivo){
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario",usuario)
                .add("contra", contra)
                .add("idCarpeta", idCarpeta)
                .add("nombreCarpeta", nombreArchivo)
                .build();
        
        conexionDescargar(formBody);
        return "True"; 
    }
    
    public String conexionDescargar(RequestBody formBody) 
    {
        try {
            URL url = new URL("http://127.0.0.5:5000/RespuestaByte");
            Request request = new Request.Builder().url(url).get().build();
            Response respuestaPython = webClient.newCall(request).execute();
            return respuestaPython.body().string();
        }catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch (IOException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }
    
    
    public String ConexionPythonRespuestaByte(String usuario, String contra, String idCarpeta, String nombreCarpeta, String nombreArchivo) 
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario",usuario)
                .add("contra", contra)
                .add("idCarpeta", idCarpeta)
                .add("nombreCarpeta", nombreCarpeta)
                .add("nombreArchivo", nombreArchivo)
                .build();
        String respuestaDescarga = MetodoJava("RespuestaArchivo", formBody);
        
        return respuestaDescarga;
    }  
    
    public String cargarNombresCarpetas(String nombre, String contra)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario", nombre)
                .add("contra", contra)
                .build();
        
        String cadenaCarpetas = MetodoJava("concatenarNombresC",formBody);
    return "cadena concatenada";
    }
    
    public static String obtenerCodigoNombreCarpeta(String nombre) {
       String codigoNombreCarpeta = "";
       String numero = "";
       int posicion = 0;
       int codigoAscii;
       
       for(posicion = 0; posicion < nombre.length(); posicion++){
           codigoAscii = nombre.charAt(posicion);
           numero = Integer.toString(codigoAscii);
           codigoNombreCarpeta = codigoNombreCarpeta + numero;
       }
    return codigoNombreCarpeta;
    }
    
    public String recuperarArchivos(String usuario, String contra, String idCarpeta)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("usuario", usuario)
                .add("contra", contra)
                .add("idCarpeta", idCarpeta)
                .build();
        
        String cadenaArchivos = MetodoJava("RetornarArchivos",formBody);
    return cadenaArchivos;
    }
}
