package dsi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import clasesMito.Objeto;
import clasesMito.Personaje;
import clasesMito.acciones.DarFavor; 
import clasesMito.acciones.Enojar;
import clasesMito.acciones.Liberar;

public class Parser {

	private LinkedList<String> Entrada;
	private LinkedList<Personaje> Personajes;
	private Object pregunta;

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
					switch (palabras.get(3)) {

					case "favor":
						p1 = getPersonaje(palabras.get(0));
						p2 = getPersonaje(palabras.get(5));

						O = new DarFavor(p2, p1);
						HechosDinamicos.add(O);
						break;
					case "enojo":
						p1 = getPersonaje(palabras.get(0));
						p2 = getPersonaje(palabras.get(5));
						O = new Enojar(p1, p2);
						HechosDinamicos.add(O);
						break;
					default:
						for (Personaje P : Personajes) {
							if (P.getNombre().equals(palabras.get(0))) {

								Objeto ObjetoParseado = new Objeto(palabras.get(2));
								P.getInventario().add(ObjetoParseado);
								// if (ObjetoParseado=="Anillo") then new
								// invisible(P);HechosDinamicos.add(invisible(p));
								// if (ObjetoParseado=="Espejo") then new
								// reflectante(P);HechosDinamicos.add(reflectante(p));
								// if (ObjetoParseado=="Conjuro") then new
								// volador(P);HechosDinamicos.add(volador(p));
							}
						}
						break;
					}
					break;
				case "no":
					for (Personaje P : Personajes) {
						if (P.getNombre().equals(palabras.get(0))) {
							Objeto ObjetoParseado = new Objeto(palabras.get(3));

							for (Objeto ObjetoInv : P.getInventario()) {
								if (ObjetoInv.getNombre().equals(ObjetoParseado.getNombre())) {
									P.getInventario().remove(ObjetoInv);

								}
							}
						}
						
						}
					

					break;
				case "Ninfas":// entraría por aquí ene l caso de las
					for (Personaje P : Personajes) {
						if (P.getNombre().equals("Ninfas")) {
							if (palabras.get(2).equals("no")) {
								Objeto ObjetoParseado = new Objeto(palabras.get(4));
								for (Objeto ObjetoInv : P.getInventario()) {
									if (ObjetoInv.getNombre().equals(ObjetoParseado.getNombre())) {
										P.getInventario().remove(ObjetoInv);
									}
								}
							}
						}

					}

				default:
					// solo entraríamos en fase1 con ¿Puede perseo...
					String NombreP1 = palabras.get(4).replace("?", "");
					p1 = getPersonaje(palabras.get(1));
					p2 = getPersonaje(NombreP1);
					O = new Liberar(p1, p2);
					pregunta = O;
				}
			}

		}

		return HechosDinamicos;
	}

	public LinkedList<Personaje> getPersonajes() {
		return Personajes;
	}

	private Personaje getPersonaje(String nombre) {
		for (Personaje P : Personajes) {
			if (P.getNombre().equals(nombre))
				return P;
		}

		return null;
	}

	public static List<String> getPalabras(String S) {
		return new ArrayList<String>(Arrays.asList(S.split(" ")));
	}

	public Object getPregunta() {
		return pregunta;
	}

}