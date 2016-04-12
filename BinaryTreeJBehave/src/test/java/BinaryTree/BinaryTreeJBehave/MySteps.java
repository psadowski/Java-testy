package BinaryTree.BinaryTreeJBehave;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps {

	BinaryTreeImpl impl;
	Node node = null;
	Node parent = null;
	Node root = null;
	Node focusNode = null;
	Node test = null;

	@BeforeScenario
	public void start() {
		impl = new BinaryTreeImpl();

	}

	@Given("a first node to tree,")
	public void givenAFirstNodeToTree() {
		impl.addNode(1, "first");

	}

	@When("added to tree it becomes root.")
	public void whenAddedToTreeItBecomesRoot() {
		assertThat(impl.root, is(not(equalTo(null))));
	}

	@Given("a second node to tree,")
	public void givenASecondNodeToTree() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
	}

	@When("added to tree it becomes left child.")
	public void whenAddedToTreeItBecomesLeftChild() {
		assertThat(impl.root.leftChild, is(not(equalTo(null))));
	}

	@Given("a third node to tree,")
	public void givenAThirdNodeToTree() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(3, "third");
	}

	@When("added to tree it becomes right child.")
	public void whenAddedToTreeItBecomesRightChild() {
		assertThat(impl.root.rightChild, is(not(equalTo(null))));
	}

	@When("finding root should become focusNode.")
	public void whenFindingRootShouldBecomeFocusNode() {
		assertThat(impl.root, is(equalTo(impl.findNode(1))));
	}

	@Given("a node different than root to find,")
	public void givenANodeDifferentThanRootToFind() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(3, "third");
	}

	@When("finding it, it should have different key than root.")
	public void whenFindingItItShouldHaveDifferentKeyThanRoot() {
		assertThat(impl.root.key, is(not(equalTo(impl.findNode(3).key))));
	}

	@Given("a node to find,")
	public void givenANodeToFind() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(3, "third");
	}

	@Given("a node to find which doesnt exsist in tree,")
	public void givenANodeToFindWhichDoesntExsistInTree() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(3, "third");
	}

	@When("finding it, it shhould return null.")
	public void whenFindingItItShhouldReturnNull() {
		assertThat(impl.findNode(9), is(equalTo(null)));
	}

	@Given("a node to find with lower key than focusNode,")
	public void givenANodteToFindWithLowerKeyThanFocusNode() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(6, "third");
		impl.addNode(7, "third");
		impl.addNode(5, "third");
		impl.addNode(8, "third");
		impl.addNode(9, "third");
	}

	@When("fining it, it should start finding in leftChild.")
	public void test() {
		assertThat(impl.findNode(0), is(not(equalTo(null))));
	}
}