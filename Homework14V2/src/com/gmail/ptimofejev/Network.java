package com.gmail.ptimofejev;

import java.util.ArrayList;
import java.util.Iterator;

public class Network {
	private String name;
	private String countryCode;
	private ArrayList<Phone> regNumbers;

	public Network() {

	}

	public Network(String name, String countryCode, ArrayList<Phone> regNumbers) {
		super();
		this.name = name;
		this.countryCode = countryCode;
		this.regNumbers = regNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public ArrayList<Phone> getRegNumbers() {
		return regNumbers;
	}

	public void setRegNumbers(ArrayList<Phone> regNumbers) {
		this.regNumbers = regNumbers;
	}

	public void addToDatabase(Phone phone) {
		regNumbers.add(phone);
	}

	public void removeFromDatabase(Phone phone) {
		Iterator<Phone> phoneIterator = regNumbers.iterator();
		while (phoneIterator.hasNext()) {
			Phone phoneRem = phoneIterator.next();
			if (phoneRem.getNumber().equals(phone.getNumber())) {
				phoneIterator.remove();
			}
		}
	}
	
	public boolean checkOutNumber(String outNumber) {
		Iterator<Phone> phoneIterator = regNumbers.iterator();
		while (phoneIterator.hasNext()) {
			Phone phoneNum = phoneIterator.next();
			if (phoneNum.getNumber().equals(outNumber)) {
				return true;
			}
		}
		return false;
	}
	
	public void initIncCall(String inNumber, String outNumber) {
		Iterator<Phone> phoneIterator = regNumbers.iterator();
		while (phoneIterator.hasNext()) {
			Phone phoneIn = phoneIterator.next();
			if (phoneIn.getNumber().equals(outNumber)) {
				phoneIn.incomingCall(inNumber);
			}
		}
	}

	@Override
	public String toString() {
		return "Network [name=" + name + ", countryCode=" + countryCode + ", regNumbers=" + regNumbers + "]";
	}

}
