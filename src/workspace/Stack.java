package workspace;

/**
 * @author Mark Robinson
 * @param <E>
 *            Generic type of Stack
 */
public class Stack<E> {

	private int DEFAULT_LENGTH = 5;
	private int index = 0;
	private E[] stack;

	/**
	 * Creates a new stack to manipulate
	 */
	public Stack() {
		stack = (E[]) (new Object[DEFAULT_LENGTH]);
	}

	/**
	 * Returns the top element of the stack without removing it
	 * 
	 * @return The top element of the stack
	 */
	public E peek() {
		if (index > 0) {
			return stack[index - 1];
		}
		return null;
	}

	/**
	 * Adds an element to the stack
	 * 
	 * @param i
	 *            Adds i to the stack
	 */
	public void push(E i) {

		stack[index] = i;
		index++;
		if (index >= stack.length) {
			manipSize();
		}
	}

	/**
	 * 
	 * @return Returns the last element in the stack. If there are no elements,
	 *         returns null
	 * 
	 */
	public E pop() {
		if (index > 0) {
			index--;
			return stack[index];
		}
		return null;
	}

	/**
	 * Copies the stack to resize the array with a temporary array which becomes
	 * stack
	 */
	public void manipSize() {
		E[] tempstack = (E[]) (new Object[index * 2]);
		System.arraycopy(stack, 0, tempstack, 0, stack.length);
		stack = tempstack;
	}

	/**
	 * Sets stack equal to a new array with a default length
	 */
	public void clear() {
		index = 0;
		E[] tempstack = (E[]) (new Object[DEFAULT_LENGTH]);
		stack = tempstack;
	}

	/**
	 * Checks if Stack is empty
	 * 
	 * @return Tells if stack size is 0
	 */
	public boolean isEmpty() {
		return (index <= 0);
	}
}