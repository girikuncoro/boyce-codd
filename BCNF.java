import java.util.*;

public class BCNF {

  /**
   * Implement your algorithm here
   * @param attributeSet
   * @param functionalDependencies
   * @return set of attribute set
   **/
  public static Set<AttributeSet> decompose(AttributeSet attributeSet,
                                            Set<FunctionalDependency> functionalDependencies) {
	  Set<AttributeSet> result = new HashSet<AttributeSet>();
	  
	  // Pick subset set of attributes X from the relation
	  Set<AttributeSet> powerSet = getPowerset(attributeSet);
	  
	  
	  // Find X+ (closure)
	  
	  
	  
	  return Collections.emptySet();
  }

  /**
   * Recommended helper method
   * @param attributeSet
   * @param functionalDependencies
   * @return newDependency (new attribute set of dependency)
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
					  
					  // newDep := newDep UNION add
					  // update := update UNION add
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
  
  /**
   * Helper function to get powerset of the given attributeSet
   * e.g. powerset of {1,2,3} is {{},{2},{3},{2,3},{1,2},{1,3},{1,2,3},{1}}
   * @param attributeSet
   * @return powerSet
   */
  public static Set<AttributeSet> getPowerset(AttributeSet attributeSet) {
	  Set<AttributeSet> sets = new HashSet<AttributeSet>();
	  
	  if(attributeSet.size() == 0) {
		  sets.add(new AttributeSet(attributeSet));
		  return sets;
	  }
	  
	  List<Attribute> list = new ArrayList<Attribute>(attributeSet.getAttributes());
	  Attribute head = list.get(0);
	  AttributeSet rest = new AttributeSet(list.subList(1, list.size()));
	  
	  for(AttributeSet set : getPowerset(rest)) {
		  AttributeSet newSet = new AttributeSet();
		  newSet.addAttribute(head);
		  newSet.addAllAttribute(set);
		  sets.add(newSet);
		  sets.add(set);
	  }

	  return sets;
  }
  
}
