import java.util.*;

public class BCNF {

  /**
   * Implement your algorithm here
   **/
  public static Set<AttributeSet> decompose(AttributeSet attributeSet,
                                            Set<FunctionalDependency> functionalDependencies) {
    return Collections.emptySet();
  }

  /**
   * Recommended helper method
   **/
  public static AttributeSet closure(AttributeSet attributeSet, Set<FunctionalDependency> functionalDependencies) {
	  // Data structure to store count[w->z] := |w|
	  HashMap<String, Integer> count = new HashMap<String, Integer>();
	  
	  // List[attr] = {w->z} for attr in w
	  HashMap<String, Set<FunctionalDependency>> list = new HashMap<String, Set<FunctionalDependency>>();
			  
	  // Initialization
	  for(FunctionalDependency fd : functionalDependencies) {
		  count.put(fd.toString(), fd.getIndependent().size());
		  Iterator<Attribute> indIterator = fd.getIndependent().iterator();
		  
		  while(indIterator.hasNext()) {
			  Attribute indAttr = indIterator.next();
			  
			  // Init key
			  if(!list.containsKey(indAttr.toString())) {
				  Set<FunctionalDependency> fdSet = new HashSet<FunctionalDependency>();
				  fdSet.add(fd);
				  
				  list.put(indAttr.toString(), fdSet);
			  } else {
				  list.get(indAttr.toString()).add(fd);
			  }
		  }
	  }
	  
	  AttributeSet newDep = new AttributeSet(attributeSet);
	  AttributeSet update = new AttributeSet(attributeSet);
	  
	  // Computation
	  while(update.size() != 0) {
		  Attribute attr = update.getAttributes().get(0);
		  update.getAttributes().remove(0);
		  
		  if(list.containsKey(attr.toString())) {
			  for(FunctionalDependency fd : list.get(attr.toString())) {
				  Integer updatedCount = count.get(fd.toString()) - 1;
				  count.put(fd.toString(), updatedCount);
				  
				  if(updatedCount == 0) {
					  AttributeSet add = new AttributeSet();
					  AttributeSet dep = fd.dependent();
					  
					  // add := Z - newDep
					  for(Attribute a : dep.getAttributes()) {
						  if(!newDep.contains(a)) {
							  add.addAttribute(a);
						  }
					  }
					  
					  // newDep := newDep V add
					  // update := update V add
					  for(Attribute a : add.getAttributes()) {
						  newDep.addAttribute(a);
						  update.addAttribute(a);
					  }
				  }
			  }
		  }
	  }
	  
	  return newDep;
  }
}
