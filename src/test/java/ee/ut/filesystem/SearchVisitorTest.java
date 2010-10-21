package ee.ut.filesystem;

public class SearchVisitorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Directory dir = new Directory(".");
		 
		SearchVisitor sv = new SearchVisitor(".*\\.java");
		
		dir.accept(sv);
		
		for (AbstractFile f : sv.getAbstractFileArray().getAbstractFile()) {
			
			System.out.println(f.getName());
		}

		
	}

}
