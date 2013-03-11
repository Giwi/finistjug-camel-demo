package org.giwi.finistjug.finistjug.camel.demo.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PARTICIPANT database table.
 * 
 */
@Entity
@Table(name="PARTICIPANT")
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FORNAME")
	private String forname;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-one association to Jugpresentation
	@ManyToOne
	@JoinColumn(name="pres_id")
	private Jugpresentation jugpresentation;

	public Participant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getForname() {
		return this.forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Jugpresentation getJugpresentation() {
		return this.jugpresentation;
	}

	public void setJugpresentation(Jugpresentation jugpresentation) {
		this.jugpresentation = jugpresentation;
	}

}