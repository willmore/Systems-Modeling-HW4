package ee.ut.filesystem;

public class SummarizeFileSizeVisitorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Directory dir = new Directory(".");
		 
		SummarizeFileSizeVisitor sv = new SummarizeFileSizeVisitor();
		
		dir.accept(sv);
		
	
	}

}
