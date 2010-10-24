package ee.ut.filesystem;

import java.io.BufferedReader;
import java.io.IOException;

public class SearchVisitorTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("SearchVistor Test");
		System.out.print("Enter directory to visit: ");
		
		BufferedReader stdin = new BufferedReader(new java.io.InputStreamReader(System.in));
		final String dirName = stdin.readLine();
		
		System.out.print("Enter Java Regex to search for (example .*\\.java): ");
		final String pattern = stdin.readLine();
		
		Directory dir = new Directory(dirName);
		 
		SearchVisitor sv = new SearchVisitor(pattern);
		
		SingletonRoot.traverse(dir,sv);
		
		for (AbstractFile f : sv.getAbstractFileArray().getAbstractFile()) {
			System.out.println(f.getName());
		}

		
	}

}
