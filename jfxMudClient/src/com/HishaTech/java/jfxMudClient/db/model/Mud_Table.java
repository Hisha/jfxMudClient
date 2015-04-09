package com.HishaTech.java.jfxMudClient.db.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Mud_Table {

	private SimpleIntegerProperty id = new SimpleIntegerProperty();
	private SimpleStringProperty name = new SimpleStringProperty("");
	private SimpleStringProperty description = new SimpleStringProperty("");
	private SimpleStringProperty ipaddress = new SimpleStringProperty("");
	private SimpleStringProperty port = new SimpleStringProperty("");

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String Name) {
		this.name.set(Name);
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String Description) {
		this.description.set(Description);
	}

	public String getIPAddress() {
		return ipaddress.get();
	}

	public void setIPAddress(String IPAddress) {
		this.ipaddress.set(IPAddress);
	}

	public String getPort() {
		return port.get();
	}

	public void setPort(String Port) {
		this.port.set(Port);
	}

}
