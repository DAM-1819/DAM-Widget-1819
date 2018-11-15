package IvanHisado;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
*
* @author ivan hisado
*/
public class MyObjectTunning extends DataOutputStream{

	public MyObjectTunning(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}

	protected void writeStreamHeader() throws IOException {
		// NO HACE NADA DE NADA
	}

	
}
