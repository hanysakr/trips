package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class Station implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7217524483672168830L;
	
	public Station() {}
	
	private String name;
	
	public Station(String name) {
		this.name= name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		return Objects.equals(name, other.name);
	}
	
	
	
}
