package graph;

import java.io.File;

public class DisplayFiles {
	public void printFileNames(File[] a, int i, int lvl) {
		if (i == a.length) {
			return;
		}

		if (a[i].isFile()) {
			System.out.println(a[i].getName());
		}

		printFileNames(a, i + 1, lvl);
	}

	public void showGraphOptions(){
		// Providing the full path for the directory
		String path = System.getProperty("user.dir") + "/myfiles";
		// creating a file object
		File fObj = new File(path);
		// creating on object of the class DisplayFileExample
		DisplayFiles obj = new DisplayFiles();
		if (fObj.exists() && fObj.isDirectory()) {
			// array for the files of the directory pointed by fObj
			File a[] = fObj.listFiles();
			// display statements
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("Displaying Files from the directory : " + fObj);
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			// Calling the method
			obj.printFileNames(a, 0, 0);
		}
	}
}