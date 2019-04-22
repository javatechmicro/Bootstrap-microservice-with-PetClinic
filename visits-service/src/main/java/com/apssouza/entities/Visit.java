package com.apssouza.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Visit Entity
 *
 * @author Mohammad
 */
@Entity
public class Visit {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "visit_date")
    private Date visitDate = new Date();

    @NotNull
    @Size(min = 2, max = 256)
    private String name;

    @Size(max = 8192)
    @Column(name = "description")
    private String description;
    
    @Column(name = "pet_id")
    private int petId;

    @Version
    private long version;

    public Visit() {
    }
    
    

	public Visit(Date visitDate, String name, String description, int petId) {
		super();
		this.visitDate = visitDate;
		this.name = name;
		this.description = description;
		this.petId = petId;
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
    
    
}
