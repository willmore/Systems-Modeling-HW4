package ee.ut.filesystem;

import java.io.BufferedReader;
import java.io.IOException;

public class SummarizeFileSizeVisitorTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 
		System.out.print("Enter directory to summarize contents: ");
		
		BufferedReader stdin = new BufferedReader(new java.io.InputStreamReader(System.in));
		final String dirName = stdin.readLine();
		
		Directory dir = new Directory(dirName);
		 
		SummarizeFileSizeVisitor sv = new SummarizeFileSizeVisitor();
		
		SingletonRoot.traverse(dir, sv);
		
	
	}

}
