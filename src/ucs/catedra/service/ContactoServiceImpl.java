package ucs.catedra.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ucs.catedra.dao.ContactoDAO;
import ucs.catedra.model.Contacto;


@Service
@ManagedBean(name = "contactoService")
@SessionScoped
public class ContactoServiceImpl implements ContactoService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(ContactoServiceImpl.class);
	private ContactoDAO contactoDAO;

	public void setContactoDAO(ContactoDAO contactoDAO) {
		this.contactoDAO = contactoDAO;
	}

	@Override
	@Transactional
	public void addContacto(Contacto c) {
		this.contactoDAO.addContacto(c);
	}

	@Override
	@Transactional
	public List<Contacto> listContactos() {
		return this.contactoDAO.listContactos();
	}

	@Override
	@Transactional
	public void deleteContacto(Contacto c) {
		this.contactoDAO.deleteContacto(c);
	}

	@Override
	@Transactional
	public void updateContacto(Contacto c) {
		this.contactoDAO.updateContacto(c);
	}

	@Override
	public void testLog() {
		
	}

}