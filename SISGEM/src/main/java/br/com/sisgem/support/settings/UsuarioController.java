package br.com.sisgem.support.settings;
import java.io.Serializable;
import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.sisgem.mb.usuario.UsuarioAddEditMB;  
 
  
public class UsuarioController implements Serializable {  
      
	private static final long serialVersionUID = 1L;
	private UsuarioAddEditMB usuario;  
      
      
    public UsuarioController(){  
        usuario = new UsuarioAddEditMB();  
        SecurityContext context = SecurityContextHolder.getContext();  
        if(context instanceof SecurityContext)  
        {  
            Authentication authentication = context.getAuthentication();  
            if(authentication instanceof Authentication)  
            {  
                 usuario.setCargoLogado(((User)authentication.getPrincipal()).getAuthorities());
                 usuario.setBemvindoAddEdit(((User)authentication.getPrincipal()).getUsername());
            }  
        }           
    }

	public UsuarioAddEditMB getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioAddEditMB usuario) {
		this.usuario = usuario;
	}     
    
      
}  