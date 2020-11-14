package dsi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import clasesMito.Personaje;
import clasesMito.acciones.DarFavor;
import clasesMito.acciones.Enojar;
import clasesMito.acciones.Liberar;

public class Parser {

	private LinkedList<String> Entrada;
	private LinkedList<Personaje> Personajes;

	public Parser(LinkedList<String> entrada, LinkedList<Personaje> personajes) {
		this.Entrada = entrada;
		this.Personajes = personajes;
	}

	public LinkedList<Object> parsear() {
		LinkedList<Object> HechosDinamicos = new LinkedList<Object>();

		for (String frase : Entrada) {
			List<String> palabras = getPalabras(frase);
			if (!palabras.get(0).equals("Condiciones")) {
				Personaje p1;
				Personaje p2;
				Object O;
				switch (palabras.get(1)) {
				case "tiene":
					p1 = getPersonaje(palabras.get(0));
					p2 = getPersonaje(palabras.get(5));

					switch (palabras.get(3)) {

					case "favor":
						O = new DarFavor(p2,p1);
						HechosDinamicos.add(O);
						break;
					case "enojo":
						O = new Enojar(p1,p2);
						HechosDinamicos.add(O);
						break;
					}
					break;
				default:
					// solo entraríamos en fase1 con ¿Puede perseo...
					String NombreP1 = palabras.get(4).replace("?", "");
					p1 = getPersonaje(palabras.get(1));
					p2 = getPersonaje(NombreP1);
					System.out.println(palabras.toString());
					O = new Liberar(p1, p2);
					HechosDinamicos.add(O);
				}
			}

		}

		return HechosDinamicos;
	}

	private Personaje getPersonaje(String nombre) {
		for (Personaje P : Personajes) {
			if (P.getNombre().equals(nombre))
				return P;
		}

		return null;
	}

	public static List<String> getPalabras(String S) {
		return new ArrayList(Arrays.asList(S.split(" ")));
	}

}