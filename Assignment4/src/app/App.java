package app;

import java.io.IOException;

import dataservices.DataService;

public class App {

	public static void main(String[] args) throws IOException {
		DataService service = new DataService();
		service.dataService("student-master-list.csv");
		service.cleanArrayFromNull();
		service.sort();
		service.splitSortedArray();
		service.write();
	}

}
