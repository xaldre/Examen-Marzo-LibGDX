package interfaces;

public interface Elemento {

	/**
	 * nos dice si un elemento debe reaccionar de una forma controlada en una
	 * colisión
	 * 
	 * @return
	 */
	public boolean isReacting();

	/**
	 * Si te hace falta puedes crear una propiedad id en la clase que implementa
	 * esta interfaz. Será útil para reconocer a cada elemento
	 * @param id
	 */
	public void setID(String id);

	public String getID();
}
