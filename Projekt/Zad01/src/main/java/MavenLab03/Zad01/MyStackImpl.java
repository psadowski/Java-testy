package MavenLab03.Zad01;

import java.util.List;

public class MyStackImpl implements MyStack {
	private List<Integer> stack;
	
	public List<Integer> getStack() {
		return stack;
	}

	public void setStack(List<Integer> stack) {
		this.stack = stack;
	}

	public void MyPush(int val) {
			stack.add(val);
	}

	public void MyPop() {
		
	}

	public boolean IsNull() {
		if(stack == null) {
			return true;
		} else {
			return false;

		}
	}

	public int MyTop() {

	}

}
