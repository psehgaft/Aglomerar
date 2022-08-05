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
          Document doc = documentBuilder.parse(new InputSource(new FileInputStream("libro.xml")));  
            
          // Obtenemos la etiqueta raiz  
          Element elementRaiz = doc.getDocumentElement();  
          	System.out.println(elementRaiz.getNodeName()+" "+elementRaiz.getAttribute("titulo"));
          	
          // Iteramos sobre sus hijos  
          NodeList hijos = elementRaiz.getChildNodes();  
      
          for(int i=0;i<hijos.getLength();i++){  
             Node nodo = hijos.item(i);  
            if (nodo instanceof Element){  
           
                System.out.println(nodo.getNodeName());
            }
            
           
             //Segundo for
                
          // Iteramos sobre sus hijos  
          NodeList hijos1 = nodo.getChildNodes();  
          for(int j=0; j<hijos1.getLength();j++){  
            Node nodo1 = hijos1.item(j);  
            if (nodo1 instanceof Element){  
            	
            	if (nodo1.getNodeName().equals("autor")==true)
            	 System.out.println(nodo1.getNodeName()+" "+nodo1.getAttributes().getNamedItem("nombre")+" "+nodo1.getAttributes().getNamedItem("apellido"));
            	
            	else           
                System.out.println(nodo1.getNodeName()+" "+nodo1.getAttributes().getNamedItem("titulo"));  
                	 
            }  
            	// Tercer for
            	  // Iteramos sobre sus hijos  
                 NodeList hijos2 = nodo1.getChildNodes();  
                 for(int k=0; k<hijos2.getLength();k++){  
                 Node nodo2 = hijos2.item(k);  
                if (nodo2 instanceof Element){  
               
                System.out.println(nodo2.getNodeName()+" "+nodo2.getAttributes().getNamedItem("titulo"));  
            }
            
            NodeList hijos3 = nodo2.getChildNodes();  
                 for(int l=0; l<hijos3.getLength();l++){  
                 Node nodo3 = hijos3.item(l);  
                if (nodo3 instanceof Element){  
               
                System.out.println(nodo3.getNodeName()+"\n"+nodo3.getTextContent());  
            }
           
            }
            
              
          } 
            	//Termina tercer for
          } 
             //Termina segundo for
             
          }  
            
      
            
            
            
          
            
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