package pr1.a11;

import java.io.PrintWriter;

public class StackTestOld {
	public static void main(String[] args) {
		// Test using Stack Object ( Array )
		toOut("$ARRAY STACK$");
		Stack arrayTestStack = new Stack(2);
		pushAndPeek(arrayTestStack, "Testus");
		pushAndPeek(arrayTestStack, "Testus2");
		toOut();
		drawStack(arrayTestStack);
		toOut();
		toOut("### OVERFLOW TEST ###");
		toOut("Initalized Stack for 3 Objects.");
		Stack arrayTestStack2 = Factory.createArrayOverflow(3, 5);
		toOut("Pushed 5 TestObjects. Stack now contains "
				+ arrayTestStack2.getSize() + " objects.");
		drawStack(arrayTestStack2);
		toOut("### /END OVERFLOW TEST ###");
		toOut();
		toOut("### UNDERRUN TEST ###");
		toOut("Simulating underrun, Stacksize 5, Poppping 8 times. Returning value: >>");
		// Return last Object pushed, if possible.
		toOut(Factory.createArrayUnderrun(5, 8));
		toOut("### /END UNDERRUN TEST ###");
		toOut();
		toOut("$LIST STACK$");
		// Test using ListStack Object ( Linked List )
		ListStack listTestStack = new ListStack(2);
		pushAndPeek(listTestStack, "Testus");
		pushAndPeek(listTestStack, "Testus2");
		toOut();
		drawStack(listTestStack);
		toOut();
		toOut("### OVERFLOW TEST ###");
		toOut("Initalized Stack for 3 Objects.");
		// ListStack ist dynamisch. Overflow nicht herbeizuf??hren.
		ListStack listTestStack2 = Factory.createListOverflow(3, 50);
		toOut("Pushed 50 TestObjects. Stack now contains "
				+ listTestStack2.getSize() + " objects.");
		// drawStack(listTestStack2);
		toOut("### /END OVERFLOW TEST ###");
		toOut();
		toOut("### UNDERRUN TEST ###");
		toOut("Simulating underrun, Stacksize 5, Poppping 8 times. Returning value: >>");
		// Return last Object pushed, if possible.
		toOut(Factory.createListUnderrun(5, 8));
		toOut("### /END UNDERRUN TEST ###");
	}

	public static void drawStack(Stack inputStack) {
		Stack tempStack = inputStack;
		toOut("xxxx STACK VISUALIZED xxxx");
		while (tempStack.getSize() > 0) {
			toOut("+-" + tempStack.peek() + "---+");
			tempStack.pop();
		}
	}

	public static void drawStack(ListStack inputStack) {
		ListStack tempStack = inputStack;
		toOut("xxxx STACK VISUALIZED xxxx");
		while (tempStack.getSize() > 0) {
			toOut("+-" + tempStack.peek() + "---+");
			tempStack.pop();
		}
	}

	public static void pushAndPeek(Stack inputStack, String inputString) {
		toOut("++++++++++");
		toOut("--> Pushing StringObject '" + inputStack.push(inputString)
				+ "'. Starting on IndexNo: "
				+ Integer.toString(inputStack.getSize() - 1));
		toOut("#-> Peeking returns: '" + inputStack.peek() + "'");
		toOut("## (using getSize) Stack at Size "
				+ Integer.toString(inputStack.getSize()));
	}

	public static void pushAndPeek(ListStack inputStack, String inputString) {
		toOut("++++++++++");
		toOut("--> Pushing StringObject '" + inputStack.push(inputString)
				+ "'. Starting on IndexNo: "
				+ Integer.toString(inputStack.getSize() - 1));
		toOut("#-> Peeking returns: '" + inputStack.peek() + "'");
		toOut("## (using getSize) Stack at Size "
				+ Integer.toString(inputStack.getSize()));
	}

	public static void toOut() {
		PrintWriter out = new PrintWriter(System.out, true);
		toOut("", out);
	}

	public static void toOut(String input) {
		PrintWriter out = new PrintWriter(System.out, true);
		toOut(input, out);
	}

	public static void toOut(Object input) {
		PrintWriter out = new PrintWriter(System.out, true);
		toOut(input, out);
	}

	public static void toOut(Object inputDoIt, PrintWriter outDoIt) {
		outDoIt.println(inputDoIt);
	}

	public static void toOut(String inputDoIt, PrintWriter outDoIt) {
		outDoIt.println(inputDoIt);
	}
}
