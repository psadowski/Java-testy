package MavenLab03.Zad01;

import java.util.List;

public class MyStackImpl implements MyStack {
	private List<Integer> stack;
	
	public void MyPush(int val) {
		stack.add(val);
	}

	public void MyPop() {
		// TODO Auto-generated method stub

	}

	public boolean IsNull() {
		// TODO Auto-generated method stub
		return false;
	}

	public int MyTop() {
		// TODO Auto-generated method stub
		return 0;
	}

}
