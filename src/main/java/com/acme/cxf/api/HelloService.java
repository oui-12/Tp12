package com.acme.cxf.api;

import com.acme.cxf.model.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

/**
 * Interface du service web SOAP.
 * Définit les opérations exposées par le service.
 */
@WebService(
        targetNamespace = "http://api.cxf.acme.com/",
        name = "HelloService"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface HelloService {

    @WebMethod(operationName = "SayHello")
    @WebResult(name = "greeting")
    String sayHello(
        @WebParam(name = "name", targetNamespace = "")
        String name
    );

    @WebMethod(operationName = "FindPerson")
    @WebResult(name = "person")
    Person findPerson(
        @WebParam(name = "id", targetNamespace = "")
        String id
    );
}