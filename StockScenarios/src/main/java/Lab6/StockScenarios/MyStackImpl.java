package Lab6.StockScenarios;


import java.util.ArrayList;
import java.util.List;


public class MyStackImpl implements MyStack {
	private ArrayList<Integer> stack;
	
	public ArrayList<Integer> getStack() {
		return stack;
	}

	public void setStack(ArrayList<Integer> stack) {
		this.stack = stack;
	}

	public void MyPush(int val) {
		if(stack == null){
			throw new NullPointerException();
		} else {
			stack.add(val);
		}
	}

	public void MyPop() {
		if(stack == null){
			throw new NullPointerException();
		} else if(stack.size() == 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			stack.remove(stack.size() - 1);
		}
	}

	public boolean IsNull() {
		if(stack == null) {
			return true;
		} else {
			return false;

		}
	}

	public int MyTop() {
		if(stack == null){
			throw new NullPointerException();
		} else if(stack.size() == 0){
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return stack.get(stack.size() - 1);
		}
	}

}
