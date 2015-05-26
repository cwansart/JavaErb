package com.wordpress.ctwart;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean withTestData = false;
		for(String arg: args) {
			if(arg.equals("withTestData")) {
				withTestData = true;
			}
		}
		
		Database database = new Database();
		if(withTestData) {
			database.addTestData();
		}
		
		MainWindow window = new MainWindow("JavaERB");
	}

}
