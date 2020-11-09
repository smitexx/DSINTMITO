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

import clasesMito.*;
import clasesMito.Personajes.*;
import clasesMito.acciones.*;

public class KieMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		
		//Creamos la sesi�n con el mismo nombre que le hemos puesto en el kmodule.xml
		KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");
		
		KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger(kSession, "./LOGMITO", 1000);
		
		//HECHOS DE PARTIDA 
		//Objetos
		Objeto cabezaMedusa = new Objeto ("CabezaMedusa");
		Objeto cascoHades = new Objeto ("CascoHades");
		Objeto hozAcero = new Objeto ("HozAcero");
		Objeto mapaGrayas = new Objeto ("MapaGrayas");
		Objeto mapaNinfas = new Objeto ("MapaNinfas");
		Objeto ojoGraya = new Objeto ("OjoGraya");
		Objeto sandaliasAladas = new Objeto ("SandaliasAladas");
		Objeto zurronMagico = new Objeto ("ZurronMagico");
		Objeto escudoBronce = new Objeto ("EscudoBronce");
		//Inventarios con sus objetos
		List<Objeto> inventarioMedusa = new LinkedList<Objeto>();
		inventarioMedusa.add(cabezaMedusa);
		
		List<Objeto> inventarioGrayas = new LinkedList<Objeto>();
		Collections.addAll(inventarioGrayas, ojoGraya, mapaNinfas);
		
		List<Objeto> inventarioHermes = new LinkedList<Objeto>();
		inventarioHermes.add(hozAcero);
		
		List<Objeto> inventarioAtenea = new LinkedList<Objeto>();
		Collections.addAll(inventarioAtenea, escudoBronce, mapaGrayas);
		
		List<Objeto> inventarioHades = new LinkedList<Objeto>();
		inventarioHades.add(cascoHades);
		
		List<Objeto> inventarioNinfaNorte = new LinkedList<Objeto>();
		Collections.addAll(inventarioNinfaNorte, zurronMagico, sandaliasAladas);
		
		//Personajes
		List<Personaje> hijosZeus = new LinkedList<Personaje>();
		List<Personaje> hijosCasiopea = new LinkedList<Personaje>();
		
		Personaje zeus = new Dios(null, null, "Zeus", hijosZeus, "Rayo");
		Personaje poseidon = new Dios(null, null, "Poseidon", null, "Agua");
		Personaje hades = new Dios(null, inventarioHades, "Hades", null, "Inframundo");
		Personaje hermes = new Dios(null, inventarioHermes, "Hades", null, "Comercio");
		Personaje atenea = new Dios(null, inventarioAtenea, "Atenea", null, "Guerra");
		Personaje hefesto = new Dios(null, null, "Hefesto", null, "Fuego");
		
		Personaje grayas = new Graya(null, inventarioGrayas, "Grayas", null);
		
		Personaje doris = new Ninfa(null, null, "Doris", null);
		Personaje nereidas = new Ninfa(null, null, "Nereidas", null);
		Personaje ninfasNorte = new Ninfa(null, inventarioNinfaNorte, "NinfasNorte", null);
		
		Personaje perseo = new Semidios(zeus, null, "Perseo", null);
		
		Personaje casiopea = new Humano(null, null, "Casiopea", hijosCasiopea);
		Personaje andromeda = new Humano(casiopea, null, "Andromeda", null);
		
		Personaje ceto = new CriaturaMarina(null, null, "Ceto", null);
		
		Personaje esteno = new Gorgona(null, null, "Esteno", null );
		Personaje euriale = new Gorgona(null, null, "Euriale", null );
		Personaje medusa = new Gorgona(null, inventarioMedusa, "Medusa", null );
		
		//HIJOS DE PERSONAJES
		Collections.addAll(hijosZeus, perseo, hermes, hefesto, atenea);
		hijosCasiopea.add(andromeda);
		
		//PARSER PARA HECHOS DINAMICOS
		File fichero=new File("D:\\eclipse\\workspace\\DSINTMITO\\entrada1.txt");
		List <String> Pregunta  = new LinkedList<String>();
	    List <String> Condiciones  = new LinkedList<String>();
	    List <String> Descartos  = new LinkedList<String>();
	    Collections.addAll(Descartos, ",","Condiciones:","¿Puede","tiene","a","el","de");

		try (Scanner scanner = new Scanner(fichero);) {//new File(filename)
		    while (scanner.hasNext()) {
		    	String palabraLeida = scanner.next();
		    	if (!Descartos.contains(palabraLeida))Pregunta.add(palabraLeida);
		    	
		    if (palabraLeida.endsWith("?")) break;
		    }
			scanner.hasNext(); //dejamos pasar la palabra condiciones
		    while (scanner.hasNext()) {
		    	String CondicionLeida = scanner.next();
		    	if (!Descartos.contains(CondicionLeida))Condiciones.add(CondicionLeida);		    
		    }
		    scanner.close();

		}
		
		//con pregunta hacer NEW accion 
		System.out.println(Pregunta.toString());
		System.out.println(Condiciones.toString());
		//Lanzamos todas las reglas
		kSession.fireAllRules();
		logger.close();
	}

}
