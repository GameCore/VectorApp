/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorapp;


import java.util.*;
public class ListaEnlazadaSimple<E>
extends AbstractSequentialList<E>
{

    // atributos privados
private Celda<E> principio;
private int num;

    // clase privada que define la celda
private static class Celda<E> {
E contenido;
        Celda<E> siguiente;

Celda(E cont) {
contenido=cont;    
        }
    }

    /**
     * Constructor que crea la lista vacia
     */
public ListaEnlazadaSimple()
    {
        // crea la cabecera
principio=new Celda<E>(null);
num=0;
    }

    /**
     * Constructor que crea la lista vacia con los
     * elementos de la coleccion c
     */
public ListaEnlazadaSimple(Collection<E> c)
    {
this();
        Celda<E> actual=principio;
for (E e:c) {
actual.siguiente=new Celda<E>(e);
actual=actual.siguiente;
num++;
        }
    }

    /**
     * Retorna el tamano de la lista
*/
public int size() {
return num; 
}

    /**
     * Clase iteradora de lista
     */
public static class IteradorListaEnlazada <E>
implements ListIterator<E>
    {
        // atributos del iterador
private Celda<E> previo;
private Celda<E>antUltAcc;
private ListaEnlazadaSimple<E> lista;

        /*
         * Constructor del iterador; no es publico
         */
IteradorListaEnlazada(ListaEnlazadaSimple<E> lista) {
this.lista=lista;
previo=lista.principio;
        }

        /*
         * Constructor del iterador; no es publico
         */
IteradorListaEnlazada(ListaEnlazadaSimple<E> lista, int i) {
this(lista);
for (int j=0; j<i; j++) {
next();   
            }
antUltAcc=null;
        }

        /**
         * Indica si hay elemento siguiente
*/
public  boolean hasNext() {
return previo.siguiente != null;
}

        /**
         * Obtiene el siguiente y avanza el iterador
*/
public E next() {
if (hasNext()) {
antUltAcc=previo;            
previo=previo.siguiente;
return previo.contenido;
            } else {
throw new NoSuchElementException();   
}
        }

        /**
         * Indica si hay elemento previo
         */
public boolean hasPrevious() {
return previo!=lista.principio;
}

        /**
         * Obtiene el elemento previo y retrocede el iterador
*/
public E previous() {
if (hasPrevious()) {
E cont=previo.contenido;
                // buscar el elemento anterior al previo
                Celda<E> anterior=lista.principio;
while (anterior.siguiente!=previo) {
anterior=anterior.siguiente;
}
previo=anterior;
antUltAcc=previo;            
return cont;
            } else {
throw new NoSuchElementException();   
}            
        }

        /**
         * Obtiene el indice del elemento proximo
*/
public int nextIndex() {
return previousIndex()+1;
}

        /**
         * Obtiene el indice del elemento previo
*/
public int previousIndex() {
int ind = -1;
Celda<E> actual=lista.principio;
while (actual!=previo) {
actual=actual.siguiente;
ind++;
            }
return ind;
        }

        /**
         * Borra el último elemento accedido
*/
public void remove() {
if (antUltAcc!=null) {
Celda<E> borrar=antUltAcc.siguiente;
antUltAcc.siguiente=borrar.siguiente;
if (previo==borrar) {
previo=antUltAcc;
                }
antUltAcc=null;
lista.num--;
            } else {
throw new IllegalStateException();
            }
        }

        /**
         * Cambia el ultimo elemento accedido
*/
public void set(E e) {
if (antUltAcc!=null) {
antUltAcc.siguiente.contenido=e;
            } else {
throw new IllegalStateException();
            }
        }

        /**
         * Anade un nuevo elemento entre el previo y el proximo
         */
public void add(E e) {
            Celda<E> nueva=new Celda<E>(e);
nueva.siguiente=previo.siguiente;
previo.siguiente=nueva;
previo=nueva;
antUltAcc=null;
lista.num++;
        }

    }

    /**
     * Metodo que retorna el iterador
     */
public ListIterator<E>listIterator() {
return new IteradorListaEnlazada<E>(this);   
    }

    /**
     * Metodo que retorna el iterador colocado 
     * en la posicion i
     */
public ListIterator<E>listIterator(int i) {
if (i>=0 &&i<=size()) {
return new IteradorListaEnlazada<E>(this,i);
        } else {
throw new IndexOutOfBoundsException("Index: " + i + ", Size: "+ size());
}
    }

}

