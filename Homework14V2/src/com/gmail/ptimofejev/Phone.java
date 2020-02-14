package com.gmail.ptimofejev;

public class Phone {
	private String model;
	private double balance;
	private Network network;
	private String number;
	private boolean netCoverage;

	public Phone() {

	}

	public Phone(String model, double balance, Network network, String number, boolean netCoverage) {
		super();
		this.model = model;
		this.balance = balance;
		this.network = network;
		this.number = number;
		this.netCoverage = netCoverage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isNetCoverage() {
		return netCoverage;
	}

	public void setNetCoverage(boolean netCoverage) {
		this.netCoverage = netCoverage;
	}

	public void call(String outNumber) {
		if (!isNetCoverage()) {
			System.out.println(number + ": No Network coverage.");
			return;
		}
		if (!checkBalance()) {
			System.out.println(number + ": Insufficient funds.");
			return;
		}
		if (number.equals(outNumber)) {
			System.out.println(number + ": You tried calling your own number.");
			return;
		}
		if (!checkCorrectNumber(outNumber)) {
			System.out.println(number + ": Incorrect number format.");
			return;
		}
		if (network.checkOutNumber(outNumber)) {
			System.out.println(number + ": You successfully called " + outNumber);
			network.initIncCall(number, outNumber);
		}
	}

	public void incomingCall(String inNumber) {
		System.out.println(number + ": Incoming call from " + inNumber);
	}

	public void register() {
		if (isNetCoverage()) {
			System.out.println(number + ": Number is already registered in Network.");
			return;
		}
		if (checkCorrectNumber(number)) {
			network.addToDatabase(this);
			setNetCoverage(true);
			System.out.println(number + ": Number has been registered in Network");
			return;
		}
		System.out.println(number + ": Incorrect number format.");
	}

	public void unregister() {
		if (!isNetCoverage()) {
			System.out.println(number + ": Number has not been registered in Network.");
			return;
		}
		network.removeFromDatabase(this);
		setNetCoverage(false);
		System.out.println(number + ": Number has been unregistered from Network.");

	}

	public boolean checkCorrectNumber(String numberToCheck) {
		if (numberToCheck.length() != 13) {
			return false;
		}
		if (!(numberToCheck.substring(0, 4).equals(network.getCountryCode()))) {
			return false;
		}
		for (int i = 3; i < numberToCheck.length(); i++) {
			if (!(Character.isDigit(numberToCheck.toCharArray()[i]))) {
				return false;
			}
		}

		return true;
	}

	public boolean checkBalance() {
		if (balance > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Phone [model=" + model + ", balance=" + balance + ", network=" + network.getName() + ", number="
				+ number + ", netCoverage=" + netCoverage + "]";
	}

}
