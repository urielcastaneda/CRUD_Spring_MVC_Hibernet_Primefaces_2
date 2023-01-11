package ucs.catedra.dao;

import java.util.List;

import ucs.catedra.model.Contacto;
/**
 * Contacto data access object interface
 * */

public interface ContactoDAO {
	
	public void addContacto(Contacto c);
    public List<Contacto> listContactos();
    public void deleteContacto(Contacto c);
    public void updateContacto(Contacto c);

}
