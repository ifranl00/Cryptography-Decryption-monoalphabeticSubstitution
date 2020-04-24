
public class Main {

	public static void main(String[] args) {
		
		String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		
		//N = 81 => MODULO 81
		
		/* EJERCICIO 1 TODO
		 * Sabiendo que la función de cifrado usada ha sido una sustitución monoalfabética 
		 * con clave [16, 62], descifrar el mensaje cifrado texto 01.
		 * ----------------------
		 * ( n(a)*16 + 62 )%81 y esto corresponde a otra letra que esta en
		 * cifrado ya.
		 */
		
		/* EJERCICIO 2 TODO
		 * Sabiendo que se ha usado un cifrado de Vigenère con clave “21 de abril”,
		 * descifrar el mensaje cifrado texto 02.
		 * ----------------------
		 * hay que restar %81 OJO
		 */
		
		/* EJERCICIO 3 TODO
		 * Sabiendo que para cifrar los mensajes hemos aplicado primero una sustitución 
		 * mono-alfabética con clave [16, 62] y, a continuación, un cifrado de Vigenère
		 * con clave “21 de abril” (es decir, una composición de los cifrados anteriores),
		 * descifrar el mensaje cifrado texto 03.
		 * ----------------------
		 * 1) Deshacer cifrado de Vigenere
		 * 2) Deshacer sustitucion mono-alfabetica
		 */

	}

}
