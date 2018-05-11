package master_esport;

import Views.Login;
import com.sun.istack.internal.Pool;

public class Validaciones {
    Pool metodospool = new Pool();
    
public int validar_ingreso(){
    String usuario = Login.JCUsuarioInicio.getText();
    String clave =String.valueOf(Login.JRContraseñaUsuario.getPassword());
    
    int resultado= 0;
    
    String SSQL="'Select * FROM usuarios Where usuario'"+usuario+"'AND clave=LLamaloX('"+clave+"')";
    
    connection conect = null;
    
    conect = metodospool.dataSource.getConnection();
}    
    
    
}
