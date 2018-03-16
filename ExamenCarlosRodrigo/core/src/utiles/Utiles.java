package utiles;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Utiles {
	public final static float SCALE=.25f;
	public final static float PIXELS_TO_METERS = 100f;
	public final static float GRAVITY=-10; 
	public final static boolean DEBUG = true;

	/**
	 * Establece una direccion basandose en la linea imaginaria que une dos puntos cualesquiera
	 * y le da una magnitud que nunca supera a [-1,1]
	 * @param origenX
	 * @param origenY
	 * @param destinoX
	 * @param destinoY
	 * @return
	 */
	public static Vector2 calculateTrigonmetricDirection(float origenX,float origenY,float destinoX,float destinoY) {
		float hipotenusa=(float) Math.sqrt(Math.pow(destinoX-origenX, 2)+Math.pow(destinoY-origenY,2));
		float coseno=(float)((destinoX-origenX)/hipotenusa);	
		float seno=(destinoY-origenY)/hipotenusa;
		return new Vector2(coseno,seno);
		
	}
	/**
	 * valores pequeños entre 0.2 y 1 funcionan mejor. 
	 * Retorna un valor de vector aleatorio
	 * @param cotaX
	 * @param cotaY
	 * @return
	 */
	public static Vector2 pushRandom(float cotaX,float cotaY) {
		//me aseguro de que salgan valores negativos
		float factorEmpujeX = (float) ((Math.random() * cotaX) - (Math.random() * cotaX));
		float factorEmpujeY = (float) ((Math.random() * cotaY) - (Math.random() * cotaY));
		return new Vector2(factorEmpujeX, factorEmpujeY);
	}
}
