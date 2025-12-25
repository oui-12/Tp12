package com.acme.cxf.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Classe modèle représentant une personne.
 * Utilise les annotations JAXB pour la sérialisation/désérialisation XML.
 */
@XmlRootElement(name = "Person")
public class Person {
    private String id;
    private String name;
    private int age;

    /**
     * Constructeur par défaut requis par JAXB.
     */
    public Person() {}

    /**
     * Constructeur avec paramètres.
     * @param id Identifiant unique de la personne
     * @param name Nom de la personne
     * @param age Âge de la personne
     */
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters et setters avec annotations JAXB
    @XmlElement
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @XmlElement
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @XmlElement
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}