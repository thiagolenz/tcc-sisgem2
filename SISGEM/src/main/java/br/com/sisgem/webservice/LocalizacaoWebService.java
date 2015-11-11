package br.com.sisgem.webservice;
 
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import br.com.sisgem.model.LocalizacaoLogEntity;


@WebService
@WebServiceProvider
public interface LocalizacaoWebService {
	
	@Autowired
	@WebMethod
    void LocalizacaoLog(@WebParam(name = "Latitude") String latitude
    		, @WebParam(name = "Longitude") String longitude
    		, @WebParam(name = "idUsuario") Integer idUsuario);
}