import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BCNFTest {
  /**
   * Performs a basic test on a simple table.
   * gives input attributes (a,b,c) and functional dependency a->c
   * and expects output (a,c),(b,c) or any reordering
   **/
  @Test
  public void testSimpleBCNF() {
    //construct table
    AttributeSet attrs = new AttributeSet();
    attrs.addAttribute(new Attribute("a"));
    attrs.addAttribute(new Attribute("b"));
    attrs.addAttribute(new Attribute("c"));

    System.out.println(attrs);

    //create functional dependencies
    Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
    AttributeSet ind = new AttributeSet();
    AttributeSet dep = new AttributeSet();
    ind.addAttribute(new Attribute("a"));
    dep.addAttribute(new Attribute("c"));
    FunctionalDependency fd = new FunctionalDependency(ind, dep);
    fds.add(fd);

    //run client code
    Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

    //verify output
    assertEquals("Incorrect number of tables", 2, bcnf.size());

    for(AttributeSet as : bcnf) {
      assertEquals("Incorrect number of attributes", 2, as.size());
      assertTrue("Incorrect table", as.contains(new Attribute("a")));
    }

  }

	@Test
	public void test2BCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("b"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		dep.addAttribute(new Attribute("d"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		System.out.println("test2");
		assertEquals("Incorrect number of tables", 3, bcnf.size());
		for (AttributeSet as : bcnf) {
			System.out.println(as);
		}

	}

	@Test
	public void test3BCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("f"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		ind.addAttribute(new Attribute("b"));
		dep.addAttribute(new Attribute("f"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("b"));
		dep.addAttribute(new Attribute("f"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		System.out.println("test3");
		assertEquals("Incorrect number of tables", 2, bcnf.size());
		for (AttributeSet as : bcnf) {
			System.out.println(as);
		}

	}

	@Test
	public void test4BCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("d"));
		dep.addAttribute(new Attribute("b"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		ind.addAttribute(new Attribute("e"));
		dep.addAttribute(new Attribute("a"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		assertEquals("Incorrect number of tables", 3, bcnf.size());
		System.out.println("test4");
		for (AttributeSet as : bcnf) {
			System.out.println(as);
		}
		System.out.println("\n");

	}

//	@Test
	public void test5BCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("g"));
		attrs.addAttribute(new Attribute("h"));
		attrs.addAttribute(new Attribute("r"));
		attrs.addAttribute(new Attribute("s"));
		attrs.addAttribute(new Attribute("t"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		dep.addAttribute(new Attribute("t"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("g"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("h"));
		ind.addAttribute(new Attribute("r"));
		dep.addAttribute(new Attribute("c"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("h"));
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("r"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("h"));
		ind.addAttribute(new Attribute("t"));
		dep.addAttribute(new Attribute("r"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		assertEquals("Incorrect number of tables", 4, bcnf.size());
		System.out.println("test5");
		for (AttributeSet as : bcnf) {
			System.out.println(as);
		}
		System.out.println("\n");

	}

//	@Test
	public void test6BCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("g"));
		attrs.addAttribute(new Attribute("h"));
		attrs.addAttribute(new Attribute("l"));
		attrs.addAttribute(new Attribute("n"));
		attrs.addAttribute(new Attribute("p"));
		attrs.addAttribute(new Attribute("r"));
		attrs.addAttribute(new Attribute("s"));
		attrs.addAttribute(new Attribute("t"));
		attrs.addAttribute(new Attribute("u"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		dep.addAttribute(new Attribute("t"));
		dep.addAttribute(new Attribute("u"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("n"));
		dep.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("p"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("t"));
		dep.addAttribute(new Attribute("l"));
		dep.addAttribute(new Attribute("d"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("g"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("g"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("h"));
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("r"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("h"));
		ind.addAttribute(new Attribute("t"));
		dep.addAttribute(new Attribute("r"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		assertEquals("Incorrect number of tables", 6, bcnf.size());
		System.out.println("test6");
		for (AttributeSet as : bcnf) {
			System.out.println(as);
		}
		System.out.println("\n");

	}

	@Test
	public void test7BCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));
		attrs.addAttribute(new Attribute("g"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("c"));
		ind.addAttribute(new Attribute("d"));
		dep.addAttribute(new Attribute("b"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("b"));
		ind.addAttribute(new Attribute("e"));
		dep.addAttribute(new Attribute("a"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		assertEquals("Incorrect number of tables", 3, bcnf.size());
		System.out.println("test7");
		for (AttributeSet as : bcnf) {
			System.out.println(as);
		}
		System.out.println("\n");

	}

	@Test
	public void testComplexBCNF() {
		// construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));
		attrs.addAttribute(new Attribute("f"));
		attrs.addAttribute(new Attribute("g"));
		attrs.addAttribute(new Attribute("h"));
		attrs.addAttribute(new Attribute("i"));
		attrs.addAttribute(new Attribute("j"));
		attrs.addAttribute(new Attribute("k"));
		attrs.addAttribute(new Attribute("l"));
		attrs.addAttribute(new Attribute("m"));

		// create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("b"));
		dep.addAttribute(new Attribute("c"));
		dep.addAttribute(new Attribute("d"));
		dep.addAttribute(new Attribute("e"));

		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("e"));
		dep.addAttribute(new Attribute("f"));
		dep.addAttribute(new Attribute("g"));
		dep.addAttribute(new Attribute("h"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("i"));
		dep.addAttribute(new Attribute("j"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		ind.addAttribute(new Attribute("i"));
		dep.addAttribute(new Attribute("k"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		ind = new AttributeSet();
		dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		ind.addAttribute(new Attribute("l"));
		dep.addAttribute(new Attribute("m"));
		fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		// run client code
		Set<AttributeSet> bcnf = BCNF.decompose(attrs, fds);

		// verify output
		assertEquals("Incorrect number of tables", 6, bcnf.size());

	}
}