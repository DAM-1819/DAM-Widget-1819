package IvanHisado;

import java.io.Serializable;

/**
 *
 * @author ivan hisado
 */
public class Usuario implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private String fechaNacimiento;

    public Usuario() {
    }

    public Usuario(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

 

  
    
}
