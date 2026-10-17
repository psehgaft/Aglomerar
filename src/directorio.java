  
 import java.io.*;
 import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
  
 import javax.xml.parsers.*;
 
 
 import org.w3c.dom.*; 
 import org.xml.sax.InputSource;  
 import org.xml.sax.SAXException;  
   
 import com.sun.org.apache.xerces.internal.parsers.DOMParser;  
 import com.sun.org.apache.xml.internal.serialize.LineSeparator;  
 import com.sun.org.apache.xml.internal.serialize.OutputFormat;  
 import com.sun.org.apache.xml.internal.serialize.XMLSerializer;  
 import com.sun.org.apache.xpath.internal.XPathAPI;  
  import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
 
 public class directorio {  
   
     void adjuntar( ) {  
         
       try {  
            // Carpeta de entrada: se busca primero ./archivosXML y despues
            // classes/archivosXML (la carpeta de ejemplo versionada en el repo).
            // Antes estaba una ruta absoluta de Windows que solo existia en la maquina del autor.
            File dir = new File("archivosXML");
            if (!dir.isDirectory()) {
                dir = new File("classes" + File.separator + "archivosXML");
            }
            if (!dir.isDirectory()) {
                System.out.println("No se encontro la carpeta 'archivosXML' ni 'classes/archivosXML'.");
                System.out.println("Crea una carpeta 'archivosXML' con los documentos XML a aglomerar e intenta de nuevo.");
                return;
            }
            String[] files = dir.list();
            if (files == null || files.length == 0) {
                System.out.println("La carpeta '" + dir.getPath() + "' no contiene archivos XML.");
                return;
            }
            String cad = dir.getPath() + File.separator;
   
        // Creamos el parseador  
          DOMParser parser = new DOMParser();  
        Document doc= null;
        Element etiquetaRaizACopiar= null;
        Node etiquetaRaizCopiada = null;
          // Vamos a crear un XML desde cero  
          // En este caso usamos DocumentBuilder  
          DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
          // Creamos el documento XML  
          Document docNuevo = docBuilder.newDocument();  
          // Creamos la etiqueta raiz  
          Element raiz = docNuevo.createElement("biblio");  
          docNuevo.appendChild(raiz);  
          
   
         for (int i=0; i<files.length; i++){
                   
          parser.parse(new InputSource(new FileInputStream(cad+files[i].toString())));  
          // Obtenemos el objeto Document  
         doc = parser.getDocument(); 
          	
          // Incluso podemos copiar parte de otro documeto XML en este nuevo  
          // Vamos a copiar todo el XML parseado en este nuevo  
          // Primero obtenemos la etiqueta Raiz del XML parseado al principio  
       etiquetaRaizACopiar = doc.getDocumentElement();  
          // Luego la copiamos bajo nuestra etiqueta hijaRaiz, por ejemplo  
          etiquetaRaizCopiada = docNuevo.importNode(etiquetaRaizACopiar, true); // El segundo atributo indica si queremos copiar los hijos  
          // Ya tenemos una copia de la etiqueta en nuestro document. Ahora la situamos bajo etiquetaHija  
          raiz.appendChild(etiquetaRaizCopiada);  
            
          }
          	try{	TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(docNuevo);
			StreamResult result = new StreamResult(new File("aglomerado.xml"));
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}         
            
            
       } catch (FileNotFoundException e) {  
          e.printStackTrace();  
       } catch (SAXException e) {  
          e.printStackTrace();  
       } catch (IOException e) {  
          e.printStackTrace();  
//       } catch (TransformerException e) {  
//          e.printStackTrace();  
       } catch (ParserConfigurationException e) {  
          e.printStackTrace();  
       }  
         
    }  
   
 } 