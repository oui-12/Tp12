package com.acme.cxf.impl;

import com.acme.cxf.api.HelloService;
import com.acme.cxf.model.Person;
import jakarta.jws.WebService;

/**
 * Implémentation du service web SOAP.
 * Contient la logique métier des opérations exposées.
 */
@WebService(
        serviceName = "HelloService",
        portName = "HelloServicePort",
        endpointInterface = "com.acme.cxf.api.HelloService",
        targetNamespace = "http://api.cxf.acme.com/"
)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        // Vérification des entrées
        if (name == null || name.trim().isEmpty()) {
            return "Bonjour, inconnu";
        }
        return "Bonjour, " + name;
    }

    @Override
    public Person findPerson(String id) {
        // En production, on irait chercher la personne en base de données
        return new Person(id, "Ada Lovelace", 36);
    }
}