package com.sample.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String name;
	private Integer active;
	private Set contents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(Integer typeId, Integer active) {
		this.typeId = typeId;
		this.active = active;
	}

	/** full constructor */
	public Type(Integer typeId, String name, Integer active, Set contents) {
		this.typeId = typeId;
		this.name = name;
		this.active = active;
		this.contents = contents;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Set getContents() {
		return this.contents;
	}

	public void setContents(Set contents) {
		this.contents = contents;
	}

}