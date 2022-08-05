 import java.io.*;
 import javax.xml.parsers.*;  
 import javax.xml.xpath.*;
 import org.w3c.dom.*; 
 import org.xml.sax.*; 
 
 public class VisualizarLibro {  

public VisualizarLibro() {
    }
   
     void leer(){  
         
       try {  
               
          // Implementación DOM por defecto de Java  
          // Construimos nuestro DocumentBuilder  
          DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
          // Procesamos el fichero XML y obtenemos nuestro objeto Document  
          Document doc = documentBuilder.parse(new InputSource(new FileInputStream("Aglomerado.xml")));  
          
          // Obtenemos la etiqueta raiz  
          Element elementRaiz = doc.getDocumentElement();  
          	System.out.println("<"+elementRaiz.getNodeName()+">");
          		
          
          	
          // Iteramos sobre sus hijos  
          NodeList hijos = elementRaiz.getChildNodes();  
      
          for(int i=0;i<hijos.getLength();i++){  
             Node nodo = hijos.item(i);  
            if (nodo instanceof Element){  
           
                System.out.println(nodo.getNodeName()+" "+nodo.getAttributes().getNamedItem("titulo"));
            }
           
          }
          System.out.println("</"+elementRaiz.getTagName()+">");  
            
       } catch (FileNotFoundException e) {  
          e.printStackTrace();  
       } catch (SAXException e) {  
          e.printStackTrace();  
       } catch (IOException e) {  
          e.printStackTrace();      
       } catch (ParserConfigurationException e) {  
          e.printStackTrace();  
       }  
         
    }  
   
 } 