package com.acme.cxf;

import com.acme.cxf.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Classe principale pour démarrer le serveur SOAP.
 */
public class Server {

    private static final String SERVICE_URL = "http://localhost:9090/hello";

    public static void main(String[] args) {
        try {
            // Création du serveur SOAP
            HelloServiceImpl implementor = new HelloServiceImpl();
            
            // Configuration du point de terminaison
            JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
            factory.setServiceClass(HelloServiceImpl.class);
            factory.setAddress(SERVICE_URL);
            factory.setServiceBean(implementor);
            
            // Démarrage du serveur
            factory.create();
            
            System.out.println("Serveur SOAP démarré avec succès !");
            System.out.println("WSDL disponible à : " + SERVICE_URL + "?wsdl");
            System.out.println("Appuyez sur Ctrl+C pour arrêter le serveur...");
            
            // Garder le serveur en vie
            Thread.sleep(Long.MAX_VALUE);
            
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur : " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}