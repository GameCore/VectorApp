/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorapp;

/**
 * Clase que representa una lista implementada mediante
 * una lista doblemente enlazada
 */
import java.util.*;

public class ListaDoblementeEnlazada<E>
extends AbstractSequentialList<E>
{
    // atributos privados
private Celda<E> principio;
private Celda<E> fin;
private int num;

    // clase privada que define la celda
private static class Celda<E> {
E contenido;
        Celda<E> siguiente;
        Celda<E> anterior;

Celda(E cont) {
contenido=cont;    
        }
    }

    /**
     * Constructor que crea la lista vacia
     */
public ListaDoblementeEnlazada()
    {
num=0;
    }

    /**
     * Constructor que crea la lista vacia con los
     * elementos de la coleccion c
     */
public ListaDoblementeEnlazada ( Collection<E> c)
{
this();
for (E e:c) {
add(e); // inserta al final
        }
    }

    /**
     * Retorna el tamano de la lista
*/
public int size() {
return num; 
}

    /**
     * Anade al final
     */
public boolean add(E e) {
        Celda<E>nuevaCelda=new Celda<E> (e);
if (isEmpty()) {
principio=nuevaCelda;
fin=nuevaCelda;
        } else {
fin.siguiente=nuevaCelda;
nuevaCelda.anterior=fin;
fin=nuevaCelda;
        }
num++;
return true;
    }

    /**
     * Clase iteradora de lista
     */
public static class IteradorListaDoblementeEnlazada<E>
implements ListIterator<E>
    {
        // atributos del iterador
private Celda<E>proximo;
private Celda<E>ultAcc;
private ListaDoblementeEnlazada<E> lista;

        /*
         * Constructor del iterador; no es publico
         */
IteradorListaDoblementeEnlazada(ListaDoblementeEnlazada<E> lista) {
this.lista=lista;
proximo=lista.principio;
        }

        /*
         * Constructor del iterador; no es publico
         */
IteradorListaDoblementeEnlazada(ListaDoblementeEnlazada<E> lista, int i) {
this(lista);
if (i==lista.num) {
proximo=null;
            } else {
for (int j=0; j<i; j++) {
next();   
                }
ultAcc=null;
            }
        }

        /**
         * Indica si hay elemento siguiente
*/
public  boolean hasNext() {
return proximo != null;
}

        /**
         * Obtiene el siguiente y avanza el iterador
*/
public E next() {
if (hasNext()) {
ultAcc=proximo;            
proximo=proximo.siguiente;
return ultAcc.contenido;
            } else {
throw new NoSuchElementException();   
}
        }

        /**
         * Indica si hay elemento previo
         */
public boolean hasPrevious() {
            //returnlista.principio!=null&&proximo!=lista.principio;
return proximo != lista.principio;
        }

        /**
         * Obtiene el elemento previo y retrocede el iterador
*/
public E previous() {
if (hasPrevious()) {
if (proximo==null) {
                    // estamosdespues del final
proximo=lista.fin;
                } else {
proximo=proximo.anterior;
                }
ultAcc=proximo;            
return proximo.contenido;                       
} else {
throw new NoSuchElementException();   
            }            
        }

        /**
         * Obtiene el indicedelelementoproximo
         */
public int nextIndex() {
return previousIndex()+1;
}

        /**
         * Obtiene el indice del elemento previo
*/
public int previousIndex() {
if (proximo==null) {
// despues del final
return lista.num-1;
            } else {
int ind=-1;
                Celda<E> actual=lista.principio;
while (actual!=proximo) {
actual=actual.siguiente;
ind++;
                }
return ind;
            }
        }

        /**
         * Borra el ultimo elemento accedido
*/
public void remove() {
if (ultAcc!=null) {
if (ultAcc.anterior==null) {
                    // borrando el primero
lista.principio=ultAcc.siguiente;
                } else {
ultAcc.anterior.siguiente=ultAcc.siguiente;
                }
if (ultAcc.siguiente==null) {
                    // borrando el ultimo
lista.fin=ultAcc.anterior;
                } else {
ultAcc.siguiente.anterior=ultAcc.anterior;
                }
if (proximo==ultAcc) {
proximo=ultAcc.siguiente;
}
ultAcc=null;
lista.num--;
            } else {
throw new IllegalStateException();
            }
        }

        /**
         * Cambia el ultimo elemento accedido
*/
public void set(E e) {
if (ultAcc!=null) {
ultAcc.contenido=e;
            } else {
throw new IllegalStateException();
}
        }

        /**
         * Anade un nuevo elemento entre el previo y el proximo
         */
public void add(E e) {
if (proximo==null) {
                //anade al final
lista.add(e);
            } else {
                Celda<E> nueva=new Celda<E>(e);
                Celda<E> previo=proximo.anterior;
nueva.siguiente=proximo;
proximo.anterior=nueva;
nueva.anterior=previo;
if (previo==null) {
                    // insertar al principio
lista.principio=nueva;
                } else {
previo.siguiente=nueva;
                }
lista.num++;
            }
ultAcc=null;
        }

    }

    /**
     * Metodo que retorna el iterador
     */
public ListIterator<E>listIterator() {
return new IteradorListaDoblementeEnlazada<E>(this);   
    }

    /**
     * Metodo que retorna el iterador colocado 
     * en la posicion i
     */
public ListIterator<E>listIterator(int i) {
if (i>=0 &&i<=size()) {
return new IteradorListaDoblementeEnlazada<E>(this,i);
        } else {
throw new IndexOutOfBoundsException("Index: " + i + ", Size: "+ size());
}
    }

}

