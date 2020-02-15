package com.gmail.ptimofejev;

import java.util.Arrays;

public class Network {
	private String name;
	private String countryCode;
	private Phone[] regNumbers;

	public Network() {

	}

	public Network(String name, String countryCode, Phone[] regNumbers) {
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

	public Phone[] getRegNumbers() {
		return regNumbers;
	}

	public void setRegNumbers(Phone[] regNumbers) {
		this.regNumbers = regNumbers;
	}

	public void addToDatabase(Phone phone) {
		extendDatabaseSize();
		regNumbers[regNumbers.length - 1] = phone;
	}

	public void extendDatabaseSize() {
		Phone[] tempDatabase = Arrays.copyOf(regNumbers, regNumbers.length + 1);
		regNumbers = tempDatabase;
	}

	public void removeFromDatabase(Phone phone) {
		int entry = -1;
		for (int i = 1; i < regNumbers.length; i++) {
			if (regNumbers[i].getNumber().equals(phone.getNumber())) {
				regNumbers[i] = null;
				entry = i;
			}
		}
		reduceDatabaseSize(entry);
	}

	public void reduceDatabaseSize(int entry) {
		Phone[] tempDatabase = new Phone[regNumbers.length - 1];
		System.arraycopy(regNumbers, 1, tempDatabase, 1, entry - 1);
		System.arraycopy(regNumbers, entry + 1, tempDatabase, entry, regNumbers.length - entry - 1);
		regNumbers = tempDatabase;
	}

	public boolean checkOutNumber(String outNumber) {
		for (int i = 1; i < regNumbers.length; i++) {
			if (regNumbers[i].getNumber().equals(outNumber)) {
				return true;
			}
		}
		return false;
	}

	public void initIncCall(String inNumber, String outNumber) {
		for (int i = 1; i < regNumbers.length; i++) {
			if (regNumbers[i].getNumber().equals(outNumber)) {
				regNumbers[i].incomingCall(inNumber);
			}
		}
	}

	@Override
	public String toString() {
		return "Network [name=" + name + ", countryCode=" + countryCode + ", regNumbers=" + Arrays.toString(regNumbers)
				+ "]";
	}

}
