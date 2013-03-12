package org.giwi.finistjug.finistjug.camel.demo.jpa.model;

import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the JUGPRESENTATION database table.
 * 
 */
@Entity
@Table(name = "JUGPRESENTATION")
@NamedQueries({
		@NamedQuery(name = "step1", query = "select j from Jugpresentation j where j.id = 1"),
		@NamedQuery(name = "step2", query = "select j from Jugpresentation j") })
public class Jugpresentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Lob
	@Column(name = "DESCRIPTION")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PRESENTATIONDATE")
	private Date presentationdate;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "URL")
	private String url;

	// bi-directional many-to-one association to Participant
	@OneToMany(mappedBy = "jugpresentation", fetch = EAGER)
	private List<Participant> participants;

	public Jugpresentation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPresentationdate() {
		return presentationdate;
	}

	public void setPresentationdate(Date presentationdate) {
		this.presentationdate = presentationdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setJugpresentation(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setJugpresentation(null);

		return participant;
	}

}