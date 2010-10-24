package ee.ut.filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * One of the possible solutions where to implement the
 * findAll(), findAll(String exp), countFiles() ...
 * Create a globally accessible class root, implement 
 * the needed methods there
 * 
 *
 */
public class SingletonRoot {
	
	//Lazy loaded
	private static AbstractFile root;
	
	public static AbstractFile getRoot() {
		if (root == null) {
			root = Root.getInstance();
		}
		return root;
	}
	
	protected SingletonRoot() {		}
	
	
	/**
	 * Traverse the file-tree (pointed by afile) using Visitor v
	 * AbstractFile file
	 * @param file
	 * @param v
	 */
	public static void traverse(AbstractFile afile, Visitor v){
		afile.accept(v);
	}
	
	/**
	 * Traverse the file-tree (pointed by root) using Visitor 
	 * @param v
	 */
	public static void traverse(Visitor v){
		traverse(getRoot(), v);
	}
	
	/**
	 * Return the list of AbstractFiles (RegularFile and Directory) found by specific regexp in the directory tree pointed by file
	 * @param expr
	 * @return
	 */
	public static List<String> findAll(AbstractFile file, String expr){
		final SearchVisitor v = new SearchVisitor(expr);
		
		traverse(v);
		
		//map Files to String (file name)
		List<String> out = new ArrayList<String>();
		for (AbstractFile f : v.getAbstractFileArray().getAbstractFile()) {
			out.add(f.getName());
		}
	
		return out;
	}
	
	/**
	 * Return the list of AbstractFiles (RegularFile and Directory) found by specific regexp in the directory tree pointed by root
	 * @param expr
	 * @return
	 */
	public static List<String> findAll(String expr){
		return findAll(getRoot(), expr);
	}
	
	/**
	 * Return the list of AbstractFiles by String name found in the directory tree pointed by root
	 * (collects both RegularFiles and Directories)
	 * @return
	 */
	public static List<String> findAll(){
		return findAll(".*");
	}
	
	
	/**
	 * Return the list of AbstractFiles with java extension by String name found in the directory tree pointed by file
	 * (collects both RegularFiles and Directories)
	 * @return
	 */
	public static List<String> findAllJava(AbstractFile file) {
		return findAll(file, ".*\\.java");
	}
	
	
	/**
	 * Return the number of files found in the file-tree pointed by root
	 * @return
	 */
	public static int countFiles(){
		CounterVisitor v = new CounterVisitor();
		traverse(v);
		return v.getFileCounter();
	}
}

