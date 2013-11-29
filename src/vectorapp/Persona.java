/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vectorapp;

public class Persona{
public int idPersona;    
public String nombre;     
public int altura;
public Persona(int idPersona, String nombre, int altura) 
	{
this.idPersona = idPersona;         
		this.nombre = nombre;         
		this.altura = altura;}
    @Override
public String toString() {
return "Persona-> ID: "+idPersona+" Nombre: "+nombre+" Altura: "+altura+"\n";
    }
}
