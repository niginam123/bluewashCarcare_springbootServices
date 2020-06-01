package com.bluewash.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CarWasher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String branch;
	
	@Column
	private String status;

	public CarWasher() {
		super();
	}	

	public CarWasher(Long id, String name, String branch, String status) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CarWasher [id=" + id + ", name=" + name + ", branch=" + branch + ", status=" + status + "]";
	}	
}
