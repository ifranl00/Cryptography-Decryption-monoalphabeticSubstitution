import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
		
		//N = 81 => MODULO 81
		
		/* EJERCICIO 1 
		 * Sabiendo que la función de cifrado usada ha sido una sustitución monoalfabética 
		 * con clave [16, 62], descifrar el mensaje cifrado texto 01.
		 * ----------------------
		 * ( n(a)*16 + 62 )%81 y esto corresponde a otra letra que esta en
		 * cifrado ya.
		 */
		
		System.out.println("EJERCICIO 1\n");
		
		String t1 = "FúhíYzHX,.Yz UW,xXzYiúuzTzTúzxYHúhxXMzTzXuH-kYVúuzzYÍÍ.zYzÍYzjUXh8YZzpúuzYkUhh.YVúuzTz,úuzXGYuÚXh-kYVúuzzYzÚYhHXuzWwUYÍXuMzX,zVXKWúzKXzÍYzxYÍVYzYxXWHúuYMzzKXzÍYzJWÚIxhWHYzÚY8zKXzÍYzWuÍYZ\"\r\n";
		traducir(sustitucionMonoalfabetica(alf),t1);
			
		
		/* EJERCICIO 2
		 * Sabiendo que se ha usado un cifrado de Vigenère con clave “21 de abril”,
		 * descifrar el mensaje cifrado texto 02.
		 * ----------------------
		 * hay que restar %81 OJO
		 */
		
		System.out.println("\n\nEJERCICIO 2\n");
		
		String t2 = "Áh(vxmaumEl51:lsheumcE7ÚplimoomÁAfdmhq-iérÁfebm-yha.yCófé -úoe.rylf6:me3 hrúÉ2fgdó4 nvrlá13B(krqÓpx2Ú -yh úAmxeb4-úoiÁscx3f3-x(mjúifebm-mhvjKpn)65\"\r\n";
		//obtenemos la clave de descifrado numerica
		ArrayList<Integer> c2 = calculaClaveDescifrado("21 de abril", alf);
		
		//pasamos el mensaje cifrado a numero
		ArrayList<Integer> m2 = deLetraANum(t2, alf);
		
		//hacemos el descifrado de vigenere
		ArrayList<Integer> v = vigenere(m2, c2);
		
		//traducimos el mensaje descifrado numerico a letra
		String t2v = traduceVigenere(v, alf);
		corrigeEjecucion(t2v);
		
		
		/* EJERCICIO 3 TODO
		 * Sabiendo que para cifrar los mensajes hemos aplicado primero una sustitución 
		 * mono-alfabética con clave [16, 62] y, a continuación, un cifrado de Vigenère
		 * con clave “21 de abril” (es decir, una composición de los cifrados anteriores),
		 * descifrar el mensaje cifrado texto 03.
		 * ----------------------
		 * 1) Deshacer cifrado de Vigenere
		 * 2) Deshacer sustitucion mono-alfabetica
		 */
		
		System.out.println("\n\nEJERCICIO 3\n");
		
		String t3 = "m4whh)ChQlp6DwhjGzhn8K6Lb)3td0Z3SLztQpÚAnéÍZáy";
		
		// 1. primero desciframos con vigenere 
		
				//obtenemos la clave de descifrado numerica
				ArrayList<Integer> c3 = calculaClaveDescifrado("21 de abril", alf);
				
				//pasamos el mensaje cifrado a numero
				ArrayList<Integer> m3 = deLetraANum(t3, alf);
				
				//hacemos el descifrado de vigenere
				ArrayList<Integer> v3 = vigenere(m3, c3);
				
				//traducimos el mensaje descifrado numerico a letra
				String t3v = traduceVigenere(v3, alf);
				
		// 2. traduccion monoalfabetica
				
				traducir(sustitucionMonoalfabetica(alf),t3v);
				
	}
	
		
	public static ArrayList<Simbolo> sustitucionMonoalfabetica(String alf) {
		
		ArrayList<Simbolo> res = new ArrayList<Simbolo>();
		
		for (int i = 0; i < alf.length(); i++) {
			
			res.add(new Simbolo(alf.charAt(i) + "", (16*i + 62)%81));
			
		}
		return res;
	}
	
	public static void traducir(ArrayList<Simbolo> sustitucion, String t1) {
		
		String traducido = "";
		
		for (int i = 0; i < t1.length(); i++) {
			for (int j = 0; j < sustitucion.size(); j++) {
				
				if(sustitucion.get(j).getSim().equals(t1.charAt(i)+"")) {
					for (int x = 0; x < sustitucion.size(); x++) {
						if(j == sustitucion.get(x).getSus()) {
							
							traducido = traducido + sustitucion.get(x).getSim();
						}
					}
				}
			}
		}
		
		for (int k = 0; k < traducido.length(); k++) {
			
			 if(traducido.charAt(k) == ' ' && traducido.charAt(k+1) == ' ') {
				 System.out.println(""); k++; 
			 }else{
			 
				 System.out.print(traducido.charAt(k));
			 }
		}
	}
	
	public static ArrayList<Integer> calculaClaveDescifrado(String claveCif, String alf) {
		
		ArrayList<Integer> claveNumCif = deLetraANum(claveCif, alf); //clave de cif pasada a numero
		ArrayList<Integer> claveNumDes = new ArrayList<Integer>();;
		
		for (int i = 0; i < claveNumCif.size(); i++) {
			
			claveNumDes.add((claveNumCif.get(i)*(-1)+81)%81);
			
		}
		
		return claveNumDes;
	}
	
	private static ArrayList<Integer> deLetraANum(String letras, String alf) {
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for (int i = 0; i < letras.length(); i++) {
			
			for (int j = 0; j < alf.length(); j++) {
				
				if(letras.charAt(i) == alf.charAt(j)) {
					
					num.add(j);
				}
			}
		}

		return num;
	}
	
	public static ArrayList<Integer> vigenere(ArrayList<Integer> m2, ArrayList<Integer> c2){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i < m2.size(); i++) {
			
			res.add((m2.get(i)+c2.get(i%c2.size()))%81);
		}
		return res;
	}
	
	public static String traduceVigenere(ArrayList<Integer> v, String alf) {
		
		String traducido = "";
		
		for (int i = 0; i < v.size(); i++) {
			
			traducido = traducido + ""+ alf.charAt(v.get(i));
						
		}
		return traducido;

	}
	
	private static void corrigeEjecucion(String res) {
		
		for (int k = 0; k < res.length(); k++) {
			
			 if(res.charAt(k) == ' ' && res.charAt(k+1) == ' ') {
				 System.out.println(""); k++; 
			 }else{
			 
				 System.out.print(res.charAt(k));
			 }
		}
	}

}
