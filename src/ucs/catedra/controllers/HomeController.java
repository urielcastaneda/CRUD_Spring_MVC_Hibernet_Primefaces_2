package ucs.catedra.controllers;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// para obtener y dar formato a la fecha del sistema...
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@ManagedBean(name="HomeController")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	
	public String ReporteContactosPrimefaces() {
			 
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean inicioCorrecto = true;
        Session session = this.sessionFactory.openSession();
       
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = dateFormat.format(new Date()); 
        
        if(inicioCorrecto)
        {
        	logger.info("******** Iniciamos Ejecición CRUD ****************  " + date);
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicia Operación CRUD : " + date,null );
        	FacesContext.getCurrentInstance().addMessage(null, message);
        	context.addCallbackParam("loggedIn", inicioCorrecto);
        	return "ListadoContactos2";
        }
        else
        {
        	return "Index";
        }
    }   

}
