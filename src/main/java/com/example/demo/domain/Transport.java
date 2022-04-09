package com.example.demo.domain;

public abstract class Transport {
	
	protected String name;
	protected TransportTypeEnum type;
	protected String description;
	
	public Transport(String name, TransportTypeEnum type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public abstract String getDescription();

	public String getName() {
		return name;
	}
	
	public TransportTypeEnum getType() {
		return type;
	}
	
	
	
}
