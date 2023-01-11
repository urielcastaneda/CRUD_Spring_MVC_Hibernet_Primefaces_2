package ucs.catedra.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ucs.catedra.model.Contacto;
/**
 * Contacto data access object interface implementation
 * */
@Repository
public class ContactoDAOImpl implements ContactoDAO {

	private static final Logger logger = LoggerFactory.getLogger(ContactoDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addContacto(Contacto c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(c);
	        logger.info("Contacto GUARDADO satisfactoriamente,  Datos-->> "+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Contacto> listContactos() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Contacto> contactoList = session.createQuery("from Contacto").list();
	        for(Contacto c : contactoList) {
	            logger.info("Datos Contacto --> " + c.getId()+" "+c);
	        }
	        return contactoList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteContacto(Contacto c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("Contacto BORRADO satisfactoriamente, Datos-->> "+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateContacto(Contacto c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("Contacto ACTUALIZADO satisfactoriamente,  Datos-->> "+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
}
