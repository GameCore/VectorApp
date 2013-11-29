
package agenda;

import java.util.*;

public class Prueba {

public static void main(String arg[]) 
{
Vector<VectorAgenda> v = new Vector<VectorAgenda>();
System.out.println("La capacidad inicial del vector es: "+v.capacity());

	v.add(new VectorAgenda ( 1 ,"Pablo", "Avila" ,"Balderas",585587412, 044551 , "arg@outlookcom", "01/19/1990" ));
        v.add(new VectorAgenda ( 2 ,"Ruben", "Avila" ,"Balderas",585587412, 044551 , "arg@outlookcom", "01/19/1990" ));
        v.add(new VectorAgenda ( 3 ,"Susana", "Avila" ,"Balderas",585587412, 044551 , "arg@outlookcom", "01/19/1990" ));
        v.add(new VectorAgenda ( 4 ,"Alejandro", "Avila" ,"Balderas",585587412, 044551 , "arg@outlookcom", "01/19/1990" ));

System.out.println("La capacidad actual del vector es: "+v.capacity());
v.trimToSize();
//System.out.println("La capacidad actual del vector es: "+v.capacity());
//v.ensureCapacity(50);
//System.out.println("La capacidad actual del vector es: "+v.capacity());

 System.out.println("Impresion por enumeracion");
Enumeration enum1= v.elements();
while(enum1.hasMoreElements())
    {
	System.out.print(enum1.nextElement() +"\t");
        System.out.println();
    }

System.out.println("Impresion por objeto toString");
System.out.println(v.toString());


} 
}    

