package com.piotrowski.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "sizeOfRoomInPersons")
	private int sizeOfRoomInPersons;

	@Column(name = "positionOfWindow")
	private String positionOfWindow;

	@Column(name = "price")
	private float price;

	@Column(name = "floor")
	private float floor;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private Set<Reservation> reservation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSizeOfRoomInPersons() {
		return sizeOfRoomInPersons;
	}

	public void setSizeOfRoomInPersons(int sizeOfRoomInPersons) {
		this.sizeOfRoomInPersons = sizeOfRoomInPersons;
	}

	public String getPositionOfWindow() {
		return positionOfWindow;
	}

	public void setPositionOfWindow(String positionOfWindow) {
		this.positionOfWindow = positionOfWindow;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getFloor() {
		return floor;
	}

	public void setFloor(float floor) {
		this.floor = floor;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}
}
