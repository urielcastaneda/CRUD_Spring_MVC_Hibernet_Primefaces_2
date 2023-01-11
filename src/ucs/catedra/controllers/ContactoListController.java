package ucs.catedra.controllers;
 
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.JDBCException;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ucs.catedra.model.Contacto;
import ucs.catedra.service.ContactoService;
 
@ManagedBean(name="ContactoListController")
@ViewScoped  
public class ContactoListController implements Serializable {
   
	private static final Logger logger = LoggerFactory.getLogger(ContactoListController.class);
	private static final long serialVersionUID = 8604437196619149720L;
	

	@ManagedProperty("#{contactoService}")
    private ContactoService contactoService;
	
	private Contacto contacto;
	private List<Contacto> contactos;
   
	@PostConstruct
    public void init() {
		try
		{
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
    	contacto = new Contacto();
        contactos = contactoService.listContactos();
        logger.info("Inicializado controlador ContactoListController");
    }
    
    public ContactoService getContactoService() {
		return contactoService;
	}

	public void setContactoService(ContactoService contactoService) {
		this.contactoService = contactoService;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto getContacto() {
		return contacto;
	} 

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	/**
	 * @return
	 */
	public String addContacto() {
		
		//validamos que le campo de entrada de datos no esté vacío
		Boolean HayTexto = this.contacto.getNombre().trim().isBlank();
		if (!HayTexto) {
			// --- se puede guardar el registro
			try
			{
				contactoService.addContacto(this.contacto);
				this.contactos = contactoService.listContactos();
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Contacto... "+this.contacto + ", fue adicionado satisfactoriamente"));
				logger.info(" **** INSERT *****  Contacto... "+this.contacto + ", fue adicionado satisfactoriamente");
				this.contacto.setNombre("");
				this.contacto.setDescripcion("");
			}
			
			catch(Exception e) { 
				logger.error("*** ERR *** " + e.getMessage()); 
				  
				FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage("** ERROR ** \n No fue posible registrar el contacto \n" +
									this.contacto.getNombre() + "\n YA EXISTE en la B.D." ));			  
			  }
	

			return "";
		} else {         // - el registro está vacío,  no se puede guardar

			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("** ERROR ** \n Nombre del contacto no puede ser en blanco. Debe registrar datos completos..." ));				
			return "";			
		}

	}
	

	public String deleteContacto(Contacto contacto) {
		try
		{
			contactoService.deleteContacto(contacto);
			contactos = contactoService.listContactos();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Contacto... "+ contacto.toString() +", fue borrado satisfactoriamente"));
			logger.info(" **** DELETE *****  Contacto... "+ contacto +", fue borrado satisfactoriamente");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return "";
	}
	
	public void onRowEdit(RowEditEvent event) {
			
			//validamos que le campo de entrada de datos no esté vacío
        	Contacto c = (Contacto)event.getObject();			
			Boolean HayTexto = c.getNombre().trim().isBlank();
			if (!HayTexto) {
				// --- se puede guardar el registro
				try
				{					
		        contactoService.updateContacto(c);	        
				logger.info(" **** UPDATE *****  Contacto... "+ c +" fue actualizado satisfactoriamente");
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("Contacto... "+this.contacto + ", fue ACTUALIZADO satisfactoriamente"));

				}
			
				catch(Exception e) { 
					logger.error("*** ERR *** " + e.getMessage()); 
					  
					FacesContext.getCurrentInstance().addMessage(null, 
								new FacesMessage("** ERROR ** \n No fue posible registrar el contacto \n" +
										c.getNombre() + "\n YA EXISTE en la B.D." ));			  
				}				
			}else {         // - el registro está vacío,  no se puede guardar

				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("** ERROR ** \n Nombre del contacto no puede ser en blanco. Debe registrar datos completos..." ));							
			}
		
	 }
    
	public String terminar() {
		try
		{
			logger.info("****** Log out CRUD *******");
			return "Index";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}   

}