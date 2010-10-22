package ee.ut.filesystem;

import java.io.BufferedReader;
import java.io.IOException;

public class CounterVisitorTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("CounterVistor Test");
		System.out.print("Enter directory to visit: ");
		
		
		BufferedReader stdin = new BufferedReader(new java.io.InputStreamReader(System.in));
		final String dirName = stdin.readLine();
		System.out.print("Enter optional extension filter (example: java): ");
		final String extension = stdin.readLine();
		
		Directory dir = new Directory(dirName);
		CounterVisitor visitor = new CounterVisitor();
		
		if (!extension.trim().isEmpty()) {
			visitor.setExtensionFilter(new ExtensionFilter(extension));
		}
		
		dir.accept(visitor);
		visitor.getFileCounter();
		
		System.out.println("Directory: " + dir.getName());
		System.out.println("Extension Filter: " + visitor.getExtensionFilter() != null ?
																visitor.getExtensionFilter() :
																"[NONE]");
		
		System.out.println("File count: " + visitor.getFileCounter());
	}

}
