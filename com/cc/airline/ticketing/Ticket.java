package com.cc.airline.ticketing;

import com.cc.airline.passengers.Passenger;

public class Ticket {
	private Passenger passenger;
	private Seat seat;
	private double price;
	private long ticketNo;
	private static long count = 0;
	private static final long BASE_TICKET_NO = 1000000; // Define a constant for the magic number

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public double getPrice() {
		return price;
	}

	public Ticket(Passenger passenger, Seat seat, double price) {
		this.passenger = passenger;
		this.price = price;
		this.seat = seat;
		this.ticketNo = ++count + BASE_TICKET_NO; // Use the constant here
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(long ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String toString() {
		return ticketNo + " for seat " + seat.getRow() + seat.getLetter() +  " at $" + price;
	}
}
