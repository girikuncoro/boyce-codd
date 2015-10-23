import java.util.Iterator;

/**
 * Represents a functional dependency, namely the dependent attributes
 * are determined by the independent set.
 *
 * Is mostly just an Immutable tuple with named fields.
 **/
public class FunctionalDependency {

	private final AttributeSet _independentAttributeSet;
	private final AttributeSet _dependentAttributeSet;
	//this FD represents independentSet -> dependentSet

	public FunctionalDependency(AttributeSet ind, AttributeSet dep) {
		_independentAttributeSet = new AttributeSet(ind);
		_dependentAttributeSet = new AttributeSet(dep);
	}

	public AttributeSet independent() {
		return new AttributeSet(_independentAttributeSet);
	}

	public AttributeSet dependent() {
		return new AttributeSet(_dependentAttributeSet);
	}

	public AttributeSet getIndependent() {
		return _independentAttributeSet;
	}

	public AttributeSet getDependent() {
		return _dependentAttributeSet;
	}

	public String toString() {
		String result = "";
		Iterator<Attribute> indIterator = _independentAttributeSet.iterator();
		Iterator<Attribute> depIterator = _dependentAttributeSet.iterator();
		
		while(indIterator.hasNext()) {
			result += indIterator.next();
		}
		
		result += ".";
		
		while(depIterator.hasNext()) {
			result += depIterator.next();
		}
		
		return result;
	}
}
