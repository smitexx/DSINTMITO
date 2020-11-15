package dsi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import clasesMito.*;
import clasesMito.Personajes.*;
//import clasesMito.acciones.*;
import clasesMito.acciones.Liberar;

public class KieMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		
		//Creamos la sesion con el mismo nombre que le hemos puesto en el kmodule.xml
		KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");

		KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger(kSession, "./LOGMITO", 1000);
		
		//HECHOS ESTÁTICOS DE PARTIDA 
		//Objetos
		Objeto cabezaMedusa = new Objeto ("Cabeza");
		Objeto cascoHades = new Objeto ("Casco");
		Objeto hozAcero = new Objeto ("Hoz Acero");
		Objeto mapaGrayas = new Objeto ("Mapa Grayas");
		Objeto mapaNinfas = new Objeto ("Mapa Ninfas");
		Objeto ojoGraya = new Objeto ("Ojo Graya");
		Objeto sandaliasAladas = new Objeto ("Sandalias");
		Objeto zurronMagico = new Objeto ("Zurron Magico");
		Objeto escudoBronce = new Objeto ("Escudo");
		//Inventarios con sus objetos
		List<Objeto> inventarioMedusa = new LinkedList<Objeto>();
		inventarioMedusa.add(cabezaMedusa);
		
		List<Objeto> inventarioGrayas = new LinkedList<Objeto>();
		Collections.addAll(inventarioGrayas, ojoGraya, mapaNinfas);
		
		List<Objeto> inventarioHermes = new LinkedList<Objeto>();
		inventarioHermes.add(hozAcero);
		
		List<Objeto> inventarioAtenea = new LinkedList<Objeto>();
		Collections.addAll(inventarioAtenea, mapaGrayas, escudoBronce);

		List<Objeto> inventarioHades = new LinkedList<Objeto>();
		inventarioHades.add(cascoHades);
		
		List<Objeto> inventarioNinfaNorte = new LinkedList<Objeto>();
		Collections.addAll(inventarioNinfaNorte, zurronMagico, sandaliasAladas);
		


		//Personajes
		List<Personaje> hijosZeus = new LinkedList<Personaje>();
		List<Personaje> hijosCasiopea = new LinkedList<Personaje>();
		
		Personaje zeus = new Dios(null, null, "Zeus", hijosZeus, "Rayo");
		Personaje poseidon = new Dios(null, null, "Poseidón", null, "Agua");
		Personaje hades = new Dios(null, inventarioHades, "Hades", null, "Inframundo");
		Personaje hermes = new Dios(null, inventarioHermes, "Hermes", null, "Comercio");
		Personaje atenea = new Dios(null, inventarioAtenea, "Atenea", null, "Guerra");
		Personaje hefesto = new Dios(null, null, "Hefesto", null, "Fuego");
		
		Personaje grayas = new Graya(null, inventarioGrayas, "Grayas", null);
		
		Personaje doris = new Ninfa(null, null, "Doris", null);
		Personaje nereidas = new Ninfa(null, null, "Nereidas", null);
		Personaje ninfasNorte = new Ninfa(null, inventarioNinfaNorte, "Ninfas", null);
		
		Personaje perseo = new Semidios(zeus, new LinkedList<Objeto>(), "Perseo", null,  null);
		
		Personaje casiopea = new Humano(null, null, "Casiopea", hijosCasiopea, null);
		Personaje andromeda = new Humano(casiopea, null, "Andrómeda", null, null);
		
		Personaje ceto = new CriaturaMarina(null, null, "Ceto", null, null);
		
		Personaje esteno = new Gorgona(null, null, "Esteno", null, null );
		Personaje euriale = new Gorgona(null, null, "Euriale", null, null );
		Personaje medusa = new Gorgona(null, inventarioMedusa, "Medusa", null, null ); 
		
		//HIJOS DE PERSONAJES
		Collections.addAll(hijosZeus, perseo, hermes, hefesto, atenea);
		hijosCasiopea.add(andromeda);
		
		//COLECCIÓN DE OBJETOS
		LinkedList<Objeto> objetosMito = new LinkedList<Objeto>();
		Collections.addAll(objetosMito, cabezaMedusa, cascoHades, hozAcero, mapaGrayas,mapaNinfas, ojoGraya,
				sandaliasAladas, zurronMagico, escudoBronce);
		
		LinkedList<Personaje> personajesMito = new LinkedList<Personaje>();
		Collections.addAll(personajesMito, zeus, poseidon, hades, hermes, atenea, hefesto,
				grayas, doris, nereidas, ninfasNorte, perseo, casiopea, andromeda, ceto, esteno, euriale,
				medusa);

		// PARSER PARA HECHOS DINAMICOS
		//File fichero = new File("/home/pablo/eclipse-workspace/perseo/DSINTMITO-main/entrada1.txt");
		File fichero = new File("D:\\UM\\4\\DSINT\\Práctica1\\DSINTMITO\\entrada1.txt");
		LinkedList<String> LineasFich = new LinkedList<String>();
		
		try (Scanner scanner = new Scanner(fichero);) {// new File(filename)
			while (scanner.hasNext()) {
				String linealeida = scanner.nextLine();
				if (!linealeida.equals("Condiciones:"))//eliminamos la linea condiciones
					LineasFich.add(linealeida);
			}
			scanner.close();
		}
		Parser P = new Parser(LineasFich, personajesMito,objetosMito);
		LinkedList<Object> hechosDinamicos = P.parsear();
		System.out.println(hechosDinamicos);
		personajesMito=P.getPersonajes();

		//Lanzamos todas las reglas
		
		//Añadimos TODOS LOS HECHOS A LA SESIÓN (faltan los dinamicos)
				for (Objeto obj : objetosMito) {
					kSession.insert(obj);
				}
				for (Personaje p : personajesMito) {
					kSession.insert(p);
				}
				for (Object o : hechosDinamicos) {
					kSession.insert(o);
				}
		//Lanzamos todas las reglas
		kSession.setGlobal("respuestaReglas", new LinkedList<String>());
		kSession.fireAllRules();
		//Obtenemos la respuesta a la pregunta
		QueryResults respuesta = null;
		Object pregunta = P.getPregunta();
		if (pregunta instanceof Accion) {
			Accion preguntaA = ((Accion)pregunta);
			respuesta= preguntaA.buscarRespuesta(kSession);
			if (respuesta.size() != 0) {
				System.out.println("Si, " + preguntaA.getSujeto() + " puede " + preguntaA.getClass().getSimpleName() + " a " + preguntaA.getAfectadoP() + " debido a que:");
			} else {
				System.out.println("No, no se encutra forma de que " + preguntaA.getSujeto() + " pueda " + preguntaA.getClass().getSimpleName() 
						+ ((preguntaA.getAfectadoC() != null) ? " " + preguntaA.getAfectadoC() : "")
						+ ((preguntaA.getAfectadoP() != null) ?" a " + preguntaA.getAfectadoP() : ""));
			}
		} else if (pregunta instanceof Estado) {
			Estado preguntaE = ((Estado)pregunta);
			respuesta= preguntaE.buscarRespuesta(kSession);
			if (respuesta.size() != 0) {
				System.out.println("Si, " + preguntaE.getSujeto() + " tiene " + preguntaE.getClass().getSimpleName() + " debido a que:");
			} else {
				System.out.println("No, no se encutra forma de que " + preguntaE.getSujeto() + " tenga " + preguntaE.getClass().getSimpleName());
			}
		}
		
		logger.close();
	
		
	}

}
