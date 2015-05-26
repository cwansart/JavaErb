package com.wordpress.ctwart;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Database database = new Database();
		database.addTestData();
		
		MainWindow window = new MainWindow("JavaERB");
	}

}
