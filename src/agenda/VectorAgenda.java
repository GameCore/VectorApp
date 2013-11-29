

package agenda;

import java.util.Date;


public class VectorAgenda {
public int idPersona;    
public String nombre; 
public String apellidoPaterno;
public String apellidoMaterno;
public String correo;
public int telefonoCasa;
public int telefonoCel;
public String fechaNacimiento;

public VectorAgenda (int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, int telefonoCasa, int telefonoCel,String correo, String fechaNacimiento ) 
	{
                this.idPersona = idPersona;         
		this.nombre = nombre;         
		this.apellidoPaterno = apellidoPaterno ;
                this.apellidoMaterno = apellidoMaterno;
                this.telefonoCasa = telefonoCasa;
                this.telefonoCel = telefonoCel;
                this.correo = correo;
                this.fechaNacimiento = fechaNacimiento;
        }

    @Override
public String toString() {
return "Persona-> ID: " + idPersona + " Nombre: " + nombre+ " Apellido Paterno: "+ apellidoPaterno + "Apellido Materno: " + apellidoMaterno + "\n" +
        "Telefono Casa: " + telefonoCasa +" Telefono Celular: " + telefonoCel + "Fecha de nacimiento " + fechaNacimiento + "\n";
    }
}
