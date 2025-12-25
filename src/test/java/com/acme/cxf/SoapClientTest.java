package com.acme.cxf;

import com.acme.cxf.api.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class SoapClientTest {
    
    private static final String SERVICE_URL = "http://localhost:9090/hello";
    
    public static void main(String[] args) {
        // Création du client SOAP
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress(SERVICE_URL);
        
        HelloService client = (HelloService) factory.create();
        
        // Test de l'opération sayHello
        String greeting = client.sayHello("Jean");
        System.out.println("Réponse du service: " + greeting);
        
        // Test de l'opération findPerson
        try {
            com.acme.cxf.model.Person person = client.findPerson("1");
            System.out.println("Personne trouvée: " + person.getName() + ", âge: " + person.getAge());
        } catch (Exception e) {
            System.out.println("Erreur lors de la recherche de la personne: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
