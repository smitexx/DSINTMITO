package dsi;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		
		//Creamos la sesión con el mismo nombre que le hemos puesto en el kmodule.xml
		KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");
		
		KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger(kSession, "./helloWorld", 1000);
		
		
		//Lanzamos todas las reglas
		kSession.fireAllRules();
		logger.close();
	}

}
