package workspace;

/**
 * An RPN calculator with methods to calculate equations
 * 
 * @author Mark Robinson
 */
public class RPNCalc {
	Stack<Double> stack = new Stack<Double>();

	/**
	 * Calls pop twice, takes last two elements and attempts to add them
	 * together
	 * 
	 * @return The top most element of the stack after computation
	 */
	public double add() {
		double a1 = specialPop();
		double a2 = specialPop();
		stack.push(a1 + a2);
		return stack.peek();
	}

	/**
	 * Calls pop twice, takes last two elements and attempts to subtract them
	 * 
	 * @return The top most element of the stack after computation
	 */
	public double subtract() {
		double a1 = specialPop();
		double a2 = specialPop();
		stack.push(a2 - a1);
		return stack.peek();
	}

	/**
	 * Calls pop twice, takes last two elements and attempts to multiply them
	 * together
	 * 
	 * @return The top most element of the stack after computation
	 */
	public double multiply() {
		double a1 = specialPop();
		double a2 = specialPop();
		stack.push(a1 * a2);
		return stack.peek();
	}

	/**
	 * Calls pop twice, takes last two elements and attempts to divide them
	 * 
	 * @return The top most element of the stack after computation
	 */
	public double divide() {
		double a1 = specialPop();
		double a2 = specialPop();
		stack.push(a2 / a1);
		return stack.peek();
	}

	/**
	 * Calls push
	 * 
	 * @param n
	 *            The argument that push is called with, will be added to the
	 *            stack
	 */
	public void enter(double n) {
		stack.push(n);
	}

	/**
	 * Clears the stack
	 */
	public void clear() {
		stack.clear();
	}

	/**
	 * Anticipates when stack index-1 returns null
	 * 
	 * @return Returns 0 if stack is empty. If not, calls stack.pop()
	 */
	private double specialPop() {

		if (stack.peek() == null) {
			return 0;
		}

		return stack.pop();
	}
}
