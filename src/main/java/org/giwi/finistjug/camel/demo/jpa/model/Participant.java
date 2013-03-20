package org.giwi.finistjug.camel.demo.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the PARTICIPANT database table.
 * 
 */
@Entity
@Table(name = "PARTICIPANT")
public class Participant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FORNAME")
    private String forname;

    @Column(name = "NAME")
    private String name;

    // bi-directional many-to-one association to Jugpresentation
    @ManyToOne
    @JoinColumn(name = "pres_id")
    private Jugpresentation jugpresentation;

    public Participant() {
    }

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(final String email) {
	this.email = email;
    }

    public String getForname() {
	return forname;
    }

    public void setForname(final String forname) {
	this.forname = forname;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public Jugpresentation getJugpresentation() {
	return jugpresentation;
    }

    public void setJugpresentation(final Jugpresentation jugpresentation) {
	this.jugpresentation = jugpresentation;
    }

}