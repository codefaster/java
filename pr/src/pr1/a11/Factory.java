package pr1.a11;

public class Factory {

	public static Stack createArrayOverflow(int stackSize, int pushs) {
		Stack testStack = new Stack(stackSize);
		for (int i = 0; i < pushs; i++) {
			Object testObject = new String("TestObjectNumber" + i);
			testStack.push(testObject);
		}
		return testStack;
	}

	public static ListStack createListOverflow(int stackSize, int pushs) {
		ListStack testStack = new ListStack(stackSize);
		for (int i = 0; i < pushs; i++) {
			Object testObject = new String("TestObjectNumber" + i);
			testStack.push(testObject);
		}
		return testStack;
	}

	public static Object createArrayUnderrun(int stackSize, int pops) {
		Stack testStack = new Stack(stackSize);
		Object lastPop = 0;
		for (int i = 0; i < pops; i++) {
			lastPop = testStack.pop();
		}
		return lastPop;
	}

	public static Object createListUnderrun(int stackSize, int pops) {
		ListStack testStack = new ListStack(stackSize);
		Object lastPop = 0;
		for (int i = 0; i < pops; i++) {
			lastPop = testStack.pop();
		}
		return lastPop;
	}
}
