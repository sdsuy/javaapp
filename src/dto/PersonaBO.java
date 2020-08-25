package dto;

import java.util.LinkedList;

import basededatos.DAOPersona;

public class PersonaBO {
	
private LinkedList<PersonaVO> personas;
private PersonaVO persona;
	
	//Constructor que crea un linkedlist de personas vacio
	
	public PersonaBO() {
		this.personas = new LinkedList<>();
	}

	/**
	 * 
	 * Agrego una persona
	 * @param persona
	 * @return
	 */
	public boolean agregarPersona(PersonaVO persona) {
		return DAOPersona.nuevaPersona(persona);
	}
	
	 //Cargo las personas
	 
	public void obtenerPersonas() {
		personas = DAOPersona.seleccionarPersona();
	}
	
	/**
	 * 
	 * Actualizo una persona
	 * @param persona
	 * @return
	 */
	public boolean actualizarPersona(PersonaVO persona) {
		return DAOPersona.modificarPersona(persona);
	}
	
	/**
	 * 
	 * Elimino una persona
	 * @param idPersona
	 * @return
	 */
	public boolean eliminarPersona(int idPersona) {
		return DAOPersona.eliminarPersona(idPersona);
	}

	/**
	 * 
	 * Getter del linkedlist personas
	 * @return
	 */
	public LinkedList<PersonaVO> getPersonas() {
		return personas;
	}
	/**
	 * Busco una persona
	 * @param documento
	 */
	public void buscarPersona(String documento) {
		persona = DAOPersona.buscarPersona(documento);
	}
	public PersonaVO getPersona() {
		return persona;
		
	}

}
