

package personas;
import java.util.Scanner;
/**
 *
 * @author Pablo
 */
public class Nodo {
 
    Scanner sc = new Scanner(System.in);

    
    public int idPersona = 0;    
public String nombre; 
public String apellidoPaterno;
public String apellidoMaterno;
public String correo;
public int telefonoCasa;
public int telefonoCel;
public String fechaNacimiento;

  
public Nodo(){}

    public Nodo(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, int telefonoCasa, int telefonoCel,String correo, String fechaNacimiento)
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

    
    
     public void datos()
    {
         System.out.println("Escribe los datos de tu contacto ");
         
     System.out.println("Identificador Numerico : " );
     idPersona = sc.nextInt();
     nombre = sc.nextLine();
     System.out.println("Nombre : " );
     nombre = sc.nextLine();
     
     System.out.println("Apellido Paterno : " );
     apellidoPaterno = sc.nextLine();
     
     System.out.println("Apellido Materno : " );
     apellidoMaterno = sc.nextLine();
     
     System.out.println("Correo Electronico : " );
     correo = sc.nextLine();
     
     System.out.println("Telefono de casa : " );
     telefonoCasa = sc.nextInt();
     
     System.out.println("Telefono Celular : " );
     telefonoCel = sc.nextInt();
     
     fechaNacimiento = sc.nextLine();
     System.out.println("Fecha de nacimiento Elemplo DD/MM/AAAA      :");
     fechaNacimiento = sc.nextLine();
    }
    
    @Override
public String toString() {
return "Persona-> ID: " + idPersona + " Nombre: " + nombre+ " Apellido Paterno: "+ apellidoPaterno + "Apellido Materno: " + apellidoMaterno + "\n" +
        "Telefono Casa: " + telefonoCasa +" Telefono Celular: " + telefonoCel + "Fecha de nacimiento " + fechaNacimiento + "\n";
    }
    
    
    
   

}
