package com.gmail.ptimofejev;

public class Main {

	public static void main(String[] args) {

		Phone[] database = new Phone[1];
		Network mobile = new Network("Mobile network", "+380", database);
		Phone phone1 = new Phone("Samsung Galaxy 8", 20.0, mobile, "+380501234567", false);
		Phone phone2 = new Phone("Apple IPhone 10S", 777.0, mobile, "+380997654321", false);
		Phone phone3 = new Phone("Motorola Talkabout", -2.0, mobile, "+380635555555", false);
		Phone phone4 = new Phone("Sony Ericsson M500", 7.0, mobile, "+380972221111", false);
		Phone phone5 = new Phone("Alcatel C320", 2.0, mobile, "+15555551234", false);

		phone1.register();
		phone2.register();
		phone3.register();
		phone4.register();
		phone5.register();

		phone3.call("+380997654321");
		phone1.call("1234");
		phone1.call("+15555551234");
		phone1.call("+380501234567");
		phone1.call("+380997654321");

	}

}
