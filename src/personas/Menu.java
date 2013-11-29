
package personas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pablo
 * 
 */
public class Menu{
    
     
    
     public static void main(String [] args ){
         
         Scanner sc = new Scanner(System.in);   
         LinkedList lista = new LinkedList();
         int aux = 0;
         Nodo a1 = new Nodo(1,"Pablo","Avila","Balderas",58851279,55212214,"siempre@gmail.com","19/01/1994");
         Nodo a2 = new Nodo(2,"Ruben","Avila","Balderas",58851279,55212214,"siempre@gmail.com","19/01/1993");
         Nodo a3 = new Nodo(3,"Susana","Avila","Balderas",58851279,55212214,"siempre@gmail.com","19/01/1990");
         Nodo a4 = new Nodo();
         lista.add(a1.toString());
         lista.add(a2.toString());
         lista.add(a3.toString());
         
       
 
 
        
       

while(aux != 9)    
{
    try{
        System.out.println("Esta es una agenda personal donde podras escribir algunos de los datos\n"
            + "de tus amigos o clientes por favor escoge unas de las opciones siguientes\n"
            + "1.-Ingresa el primer contacto en la lista\n"
            + "2.-Ingresa el contacto en el ultimo elemento de lista\n"
            + "3.-Ingresa un valor en un valor especifico de la lista\n"
            + "4.-Elimina el primer elemento de la lista\n"
            + "5.-Elimina el ultimo elemento en la lista\n"
            + "6.-Elimina un un contacto de la lista\n"
                + "7.-Elimina todos los contactos\n"
            + "7.-Buscar un elemento \n"
            + "8.-Ver todos tus contactos en tu lista \n"
                + "9.-Salir\n"
                + "10.-Ordenar por orden"
                + "Seleccion:");
        
        switch(sc.nextInt()) {
 case 1:
a4.datos();
lista.addFirst(a4.toString());
System.out.println("Se añadido el contacto");

     break;
 case 2: 
     a4.datos();
lista.addLast(a4.toString());
System.out.println("Se añadido el contacto");
     
     break;
 case 3: 
     a4.datos();
     System.out.println("Selecciones el numero de la lista que deceas insertar este nuevo contacto");
 int x =    sc.nextInt();
lista.add(x,a4.toString());
System.out.println("Se añadido el contacto");
     break;
 case 4: 
     System.out.println( "Se borrara el primer contacto de la lista" );
    lista.removeFirst();
     break;
 case 5:
lista.removeLast();
System.out.println("Se elimino el ultimo contacto de la lista");
     break;
           case 6: 
     System.out.println( "Escoge un elemento de la lista para eliminar" );
       lista.remove(sc.nextInt());
     break;
  case 7: 
       System.out.println( "Se borraran todos los elementos de la lista" );
       lista.clear();
     break;
 case 8:
 
                      System.out.println( "La lista es la siguiente" );
                      List lista2 = new ArrayList(lista);
                      Iterator it = lista2.iterator();
                      while (it.hasNext()){
                           System.out.println(it.next()+"");
                              }
 
                      
     break;
     

     
      case 9: 
     System.exit(0);

     break;
          
     case 10: 
 System.out.println( "La lista es la siguiente" );
 Collections.sort(lista);
 System.out.println("Se an ordenado");
     break;
 default: 
     
     System.out.println("Esta no es una opcion valida");

        }
        
}catch(Exception e)
{

}
    finally
    {
    System.out.println("Gracias por usar este software \n");
    }
    }
    
  
}
    
     }
     
