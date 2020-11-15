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
import clasesMito.acciones.Obtener;
import clasesMito.estados.CapacidadInvisible;
import clasesMito.estados.CapacidadReflejo;
import clasesMito.estados.CapacidadVuelo;

public class Parser {

	private LinkedList<String> Entrada;
	private LinkedList<Personaje> Personajes;
	private LinkedList<Objeto> Objetos;

	private Object pregunta;

	public Parser(LinkedList<String> entrada, LinkedList<Personaje> personajes, LinkedList<Objeto> objeto) {
		this.Entrada = entrada;
		this.Personajes = personajes;
		this.Objetos = objeto;
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
								if (ObjetoParseado.getNombre().equals("Anillo")) {
									CapacidadInvisible CI = new CapacidadInvisible(P);
									HechosDinamicos.add(CI);
								}
								if (ObjetoParseado.getNombre().equals("Espejo")) {
									CapacidadReflejo CR = new CapacidadReflejo(P);
									HechosDinamicos.add(CR);
								}
								if (ObjetoParseado.getNombre().equals("Conjuro")) {
									CapacidadVuelo CV = new CapacidadVuelo(P);
									HechosDinamicos.add(CV);
								}

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
					switch (palabras.get(2)) {
					case "liberar":
						// solo entraríamos en fase1 con ¿Puede perseo...
						String NombreP2 = palabras.get(4).replace("?", "");
						p1 = getPersonaje(palabras.get(1));
						p2 = getPersonaje(NombreP2);
						O = new Liberar(p1, p2);
						pregunta = O;
						break;
					
						default:
							if (palabras.get(3).equals("Capacidad")) {
								String NombreObjeto = palabras.get(4);
								CapacidadVuelo CV = new CapacidadVuelo(getPersonaje(palabras.get(1)));

								pregunta = CV;
							}
							
							else {
								String NombreObjeto = palabras.get(3);
								p1 = getPersonaje(palabras.get(1));
								Objeto O1 = getObjeto(NombreObjeto);
								O = new Obtener(p1, O1);

								pregunta = O;
							}
							
						break;
					
				}
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
	private Objeto getObjeto(String nombre) {
		for (Objeto O : Objetos) {
			if (O.getNombre().equals(nombre))
				return O;
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