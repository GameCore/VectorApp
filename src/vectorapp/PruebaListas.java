
package vectorapp;

import java.util.*;

public class PruebaListas
{
public static void recorreConIterador (List<Integer>laLista) 
    {
int i=0;
System.out.println("Recorre la lista");
if (laLista.isEmpty()) {
System.out.println("La lista esta vacia");
} else {
System.out.println("Principio lista");
ListIterator<Integer>iter = laLista.listIterator();
while (iter.hasNext()) {
                Integer num = iter.next();
System.out.println("Posicion: "+i+"  Elemento:"+num);
i= i+1;
            }
System.out.println("Final lista");
        }
    }

public static void recorre (List<Integer>laLista) 
{
System.out.println("Recorre la lista");
if (laLista.isEmpty()) {
System.out.println("La lista esta vacia");
} else {
System.out.println("Principio lista");
for(int i=0; i<laLista.size(); i++) {;
System.out.println("Posicion : "+i+"  Elemento:"+laLista.get(i));
            }
System.out.println("Final lista");
        }
    }

public static void recorreAlRevesConIterador (List<Integer>laLista) 
    {
int i= laLista.size()-1;
System.out.println("Recorre la lista al reves");
if (laLista.isEmpty()) {
System.out.println("La lista esta vacia");
} else {
System.out.println("Final lista");
ListIterator<Integer>iter = laLista.listIterator(i);
while (iter.hasPrevious()) {
                Integer num = iter.previous();
System.out.println("Posicion: "+i+"  Elemento:"+num);
i= i-1;
            }
System.out.println("Principio lista");
        }
    }

public static void recorreAlReves (List<Integer>laLista) 
{
System.out.println("Recorre la lista al reves");
if (laLista.isEmpty()) {
System.out.println("La lista esta vacia");
} else {
System.out.println("Final lista");
for (int i=laLista.size()-1; i>=0; i--) {
System.out.println("Posicion : "+i+"  Elemento:"+laLista.get(i));
}
System.out.println("Principio lista");
}
    }

public static void main(String args[])
    {
//List<Integer>laLista = new ListaEnlazadaSimple<Integer>();
List<Integer>laLista = new ListaDoblementeEnlazada<Integer>();

ListIterator<Integer>iter= laLista.listIterator();

System.out.println("Prueba de listas con Iterador");
System.out.println("Recorre una lista vacia con iterador");
recorreConIterador(laLista);
System.out.println("");
System.out.println("Prueba del iterador");
System.out.println("Ver si hay siguiente: "+iter.hasNext());
System.out.println("Siguiente");
try {
iter.next();
}catch (NoSuchElementException e){
System.out.println(e);
        }
System.out.println("Borra");
try {
iter.remove();
}catch (IllegalStateException e){
System.out.println(e);
        }
System.out.println(""); 
System.out.println("Anade cinco elementos: 1,2,3,4,5");
for (int i=0; i<=4; i++) {
try {
laLista.add(new Integer(i+1));
}catch (UnsupportedOperationException e) {
System.out.println("Operacion add no soportada");
break;
            }
        }

recorreConIterador(laLista);
recorreAlRevesConIterador(laLista);

System.out.println("");
System.out.println("Contieneelemento");
System.out.println("Contieneelemento 1 :"+laLista.contains(1));
System.out.println("Contieneelemento 6 :"+laLista.contains(6));

System.out.println("Eliminaelemento 3");
try {
boolean eliminado = laLista.remove(new Integer(3));
System.out.println("Eliminado elemento 3 :"+ eliminado);
eliminado = laLista.remove(new Integer(6));
System.out.println("Eliminado elemento 6 :"+ eliminado);
        } catch (UnsupportedOperationException e) {
System.out.println(e);
        }

System.out.println("Elimina elemento 4");
try {
boolean eliminado = laLista.remove(new Integer(4));
System.out.println("Eliminado elemento 4 :"+ eliminado);
} catch (UnsupportedOperationException e) {
System.out.println(e);
}

recorreConIterador(laLista);
System.out.println("");

        // Prueba de los metodos set, add, remove del iterador
System.out.println("Prueba de los metodos set y add del iterador");
System.out.println("Trato de acceder a un elemento que no existe con el iterador");
try {
iter = laLista.listIterator(6);
        } catch (IndexOutOfBoundsException e) {
System.out.println(e);
        }
System.out.println("Accedo y borro el elemento que ocupa la posicion 2");
iter = laLista.listIterator(1);
iter.next();
iter.remove();
recorreConIterador(laLista);

System.out.println("Inserto un elemento");
iter.add(new Integer(9));
recorreConIterador(laLista);

System.out.println("Modifico el elemento siguiente");
iter.next();
iter.set(new Integer(33));
recorreConIterador(laLista);

System.out.println("Deja vacia");
laLista.clear();
System.out.println("Tamanodespues de borrar : "+laLista.size());


System.out.println("");
System.out.println("Prueba de listas con acceso posicional");
System.out.println("Recorre una lista vacia con acceso posicional");
recorre(laLista);

System.out.println("Anade cinco elementos: 1,2,3,4,5");
for ( int i=0; i <=4; i++) {
try {
laLista.add(i, new Integer(i+1));
}catch (UnsupportedOperationException e) {
System.out.println("Operacion add no soportada");
break;
            } catch (IndexOutOfBoundsException e) {
System.out.println("IndiceIncorrecto");
break;
            }   
        }

System.out.println("Muestra elemento de la posicion 4");
try {
System.out.println("El elementoes : "+laLista.get(4));
}catch (IndexOutOfBoundsException e){
System.out.println(e);
        }

System.out.println("Muestra elemento inexistente");
try {
laLista.get(6);
}catch (IndexOutOfBoundsException e){
System.out.println(e);
        }

System.out.println("Borra elemento inexistente");
try {
laLista.remove(7);
}catch (IndexOutOfBoundsException e){
System.out.println(e);
        } catch (UnsupportedOperationException e) {
System.out.println(e);
        }
System.out.println("");
System.out.println("Inserta elemento 25 en la posicion 2");
try {
laLista.add(2,new Integer(25));
        } catch (IndexOutOfBoundsException e) {
System.out.println("IndiceIncorrecto");
}

System.out.println("Busca la posicion del elemento 5");
System.out.println("El elemento 5 esta en la posicion : "+laLista.indexOf (new Integer(5)));

System.out.println("Busca la posicion de un elemento inexistente");
System.out.println("El elemento 9 esta en la posicion : "+laLista.indexOf (new Integer(9)));

System.out.println("Recorre la lista");
recorre(laLista);

System.out.println("Eliminamos el elemento de la posicion 3");
System.out.println("Eliminado el elemento : "+laLista.remove(3));

System.out.println("Recorre la lista al reves");
recorreAlReves(laLista);

System.out.println("Modifico el elemento de la posicion 1");
laLista.set(1,new Integer(45));

System.out.println("");
System.out.println("Recorre la sublista desde la posicion 1 hasta la 4");
recorre(laLista.subList(1,4));

        // PruebaparacontainsAll, addAll, removeAll, retainAll

List<Integer>nuevaLista = new ListaEnlazadaSimple<Integer>();
List<Integer>nuevaLista2 = new ListaEnlazadaSimple<Integer>();
nuevaLista.add(new Integer(4));
nuevaLista.add(new Integer(5));
nuevaLista2.add(new Integer(33));
nuevaLista2.add(new Integer(4));
System.out.println("Con la lista = [ 1 45 25 4 5 ], nuevaLista = [ 4 5 ] y nuevaLista2 = [33 4]");

System.out.println("MetodocontainsAll con nuevaLista");
try {
System.out.println(laLista.containsAll(nuevaLista));
        } catch (UnsupportedOperationException e) {
System.out.println(e);
}

System.out.println("MetodocontainsAll con nuevaLista2");
try {
System.out.println(laLista.containsAll(nuevaLista2));
        } catch (UnsupportedOperationException e) {
System.out.println(e);
        }

try {
System.out.println("MetodoaddAll con nuevaLista");
System.out.println(laLista.addAll(nuevaLista));
recorre(laLista);
        } catch (UnsupportedOperationException e) {
System.out.println(e);
        }
try {
System.out.println("MetodoaddAll desde la posicion 2 con nuevaLista");
System.out.println(laLista.addAll(2,nuevaLista));
recorre(laLista);
} catch (UnsupportedOperationException e) {
System.out.println(e);
}

try {
System.out.println("MetodoremoveAll con nuevaLista");
System.out.println(laLista.removeAll(nuevaLista));
recorre(laLista);
} catch (UnsupportedOperationException e) {
System.out.println(e);
}

try {
System.out.println("MetodoremoveAll con nuevaLista2");
System.out.println(laLista.removeAll(nuevaLista2));
recorre(laLista);
} catch (UnsupportedOperationException e) {
System.out.println(e);
        }

try {
System.out.println(laLista.addAll(nuevaLista));
        } catch (UnsupportedOperationException e) {
System.out.println(e);
}

System.out.println("Reestablezco la lista original");
try {
System.out.println("MetodoretainAll");
System.out.println(laLista.retainAll(nuevaLista));
recorre(laLista);
} catch (UnsupportedOperationException e) {
System.out.println(e);
}     

    }
}
