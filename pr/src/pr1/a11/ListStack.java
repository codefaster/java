package pr1.a11;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ListStack extends AbstractStack {
	LinkedList<Object> stack;

	public ListStack(int size) {
		super(size);
		stack = new LinkedList<Object>();
	}

	public Object push(Object o) {
		stack.push(o);
		size++;
		return o;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		size--;
		return stack.pop();
	}

	public Object peek() {
		if (stack.size() == 0 ) {
			return null;
		} else {
			return stack.peek();
		}
	}
}
