package pr1.a11;

import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	public void checkStack(AbstractStack stack, String sollState) {
		Scanner in = new Scanner(sollState);
		PrintWriter out = new PrintWriter(System.out, true);
		String lastElement = null;

		while (in.hasNext()) {
			lastElement = in.next();
		}
		out.printf("Sollstate: %20s ; lastToken (soll / ist): %20s %20s \n",
				sollState, lastElement, stack.peek());
		Assert.assertEquals(lastElement, stack.peek());
		in.close();
	}

	public void pushTestSimple(AbstractStack stack, String element,
			String sollState) {
		Assert.assertEquals(element, stack.push(element));
		checkStack(stack, sollState);
	}

	public void popTestSimple(AbstractStack stack, String element,
			String sollState) {
		Assert.assertEquals(element, stack.pop());
		checkStack(stack, sollState);
	}

	public void testSingleStack(AbstractStack stack) {
		pushTestSimple(stack, "ONE", "ONE");
		pushTestSimple(stack, "TWO", "ONE TWO");
		pushTestSimple(stack, "THREE", "ONE TWO THREE");
		popTestSimple(stack, "THREE", "ONE TWO");
		popTestSimple(stack, "TWO", "ONE");
		popTestSimple(stack, "ONE", "");
	}

	@Test
	public void testStackX() {
		testSingleStack(new Stack(3));
		testSingleStack(new ListStack(3));
	}
}
