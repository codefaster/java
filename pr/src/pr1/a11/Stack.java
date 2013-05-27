package pr1.a11;

public class Stack extends AbstractStack {
	Object[] stack;
	boolean overflow;
	boolean underflow;

	public Stack(int size) {
		super(size);
		stack = new Object[size];
		overflow = false;
		underflow = false;
	}

	public Stack(Stack stack) {
		this(stack.size);
	}

	public Object push(Object o) {
		overflow = size >= this.stack.length;
		if (!overflow) {
			this.stack[size++] = o;
		}
		return o;
	}

	public Object pop() {
		underflow = size == 0;
		if (!underflow) {
			return stack[--size]; // Return Popped object + Decrement.
		} else {
			return -1;
		}
	}

	public Object peek() {
		if (super.size==0) {
			return null;
		} else {
			return stack[size - 1];
		}
	}

}