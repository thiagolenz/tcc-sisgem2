package br.com.sisgem.webservice;
 
import javax.inject.Inject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlTransient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.sisgem.model.LocalizacaoLogEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.ILocalizacaoLogRepository;


@WebService(serviceName="Localizacao/longlatVendedor")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class LocalizacaoEndpoint extends SpringBeanAutowiringSupport implements LocalizacaoWebService{
 
	
	@Autowired
	private ILocalizacaoLogRepository localizacaologRepository;
	
	@Override
    @WebMethod
    public void LocalizacaoLog(@WebParam(name = "Latitude") String x,
            			   @WebParam(name = "Longitude") String y,
            			   @WebParam(name = "idUsuario") Integer id) {
    	
    	UsuarioEntity usuario = new UsuarioEntity();
        LocalizacaoLogEntity localizacaologEntity = new LocalizacaoLogEntity();

		usuario.setId((long) id);
			
		localizacaologEntity.setUsuario_idUsuario(usuario);
		localizacaologEntity.setLatitude(x);
		localizacaologEntity.setLongitude(y);
	
		this.localizacaologRepository.save(localizacaologEntity);
        
    }
   
}