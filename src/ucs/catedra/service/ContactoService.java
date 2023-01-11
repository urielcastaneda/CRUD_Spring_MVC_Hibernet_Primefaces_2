package ucs.catedra.service;

import java.util.List;

import ucs.catedra.model.Contacto;

public interface ContactoService {
	
	public void addContacto(Contacto c);
    public List<Contacto> listContactos();
    public void deleteContacto(Contacto c);
    public void updateContacto(Contacto c);
    public void testLog();
}
