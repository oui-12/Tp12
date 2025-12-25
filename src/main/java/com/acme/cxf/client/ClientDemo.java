package com.acme.cxf.client;

import com.acme.cxf.api.HelloService;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        // Mettez à jour l'URL pour utiliser le port 9090
        URL wsdl = new URL("http://localhost:9090/hello?wsdl");
        QName qname = new QName("http://api.cxf.acme.com/", "HelloService");
        Service svc = Service.create(wsdl, qname);
        HelloService port = svc.getPort(HelloService.class);

        System.out.println(port.sayHello("ClientJava"));
        // Utilisation de findPerson au lieu de findPersonById
        System.out.println(port.findPerson("P-777").getName());
    }
}