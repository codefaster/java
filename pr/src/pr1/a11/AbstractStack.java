package pr1.a11;

public abstract class AbstractStack {
	int size;

	public AbstractStack(int size) {
		this.size = 0;
	}

	public abstract Object pop();

	public abstract Object peek();

	public abstract Object push(Object o);

	public int getSize() {
		return size;
	}

}
