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
	
	@AfterScenario
	public void end() {
		impl = null;
	}

	@Given("a first node to tree,")
	public void givenAFirstNodeToTree() {
		impl.addNode(1, "first");

	}

	@Then("added to tree it becomes root.")
	public void ThenAddedToTreeItBecomesRoot() {
		assertThat(impl.root, is(not(equalTo(null))));
	}

	@Given("a second node to tree,")
	public void givenASecondNodeToTree() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
	}

	@Then("added to tree it becomes left child.")
	public void ThenAddedToTreeItBecomesLeftChild() {
		assertThat(impl.root.leftChild, is(not(equalTo(null))));
	}

	@Given("a third node to tree,")
	public void givenAThirdNodeToTree() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(3, "third");
	}

	@Then("added to tree it becomes right child.")
	public void ThenAddedToTreeItBecomesRightChild() {
		assertThat(impl.root.rightChild, is(not(equalTo(null))));
	}

	@Then("finding root should become focusNode.")
	public void ThenFindingRootShouldBecomeFocusNode() {
		assertThat(impl.root, is(equalTo(impl.findNode(1))));
	}

	@Given("a node different than root to find,")
	public void givenANodeDifferentThanRootToFind() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(3, "third");
	}

	@Then("finding it, it should have different key than root.")
	public void ThenFindingItItShouldHaveDifferentKeyThanRoot() {
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

	@Then("finding it, it shhould return null.")
	public void ThenFindingItItShhouldReturnNull() {
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

	@Then("fining it, it should start finding in leftChild.")
	public void test() {
		assertThat(impl.findNode(0), is(not(equalTo(null))));
	}
	
	@Given("a node to delete from tree,")
	public void usuwanie() {
		impl.addNode(1, "first");
		impl.addNode(0, "second");
		impl.addNode(6, "third");
		impl.addNode(7, "third");
		impl.addNode(5, "third");
		impl.addNode(8, "third");
		impl.addNode(9, "third");
	}
	@Given("a node to delete from tree, which doesnt exsist in,")
	public void usuwanie2(){
		impl.addNode(50, "first");
		impl.addNode(25, "second");
		impl.addNode(15, "third");
		impl.addNode(30, "third");
		impl.addNode(75, "third");
		impl.addNode(85, "third");
	}
	@Then("deleting it, remove method should return true.")
	public void verify(){
		assertThat(impl.remove(9), is(equalTo(true)));
		
	}
	@Then("deleting it, remove method should return false.")
	public void verify2(){
		assertThat(impl.remove(11), is(equalTo(false)));
	}
	@Then("deleting it, we shouldnt find it in tree with findNode method.")
	public void verify3(){
		impl.remove(25);
		assertThat(impl.findNode(25),is(equalTo(null)));
	}
	@Given("a root to delete from tree,")
	public void rootDelete(){
		impl.addNode(0, "root");
	}
	@Then("deleting it, we should find null tree.")
	public void verify4(){
		impl.remove(0);
		assertThat(impl.root, is(equalTo(null)));
	}
	@Given("a left node with no child to delete,")
	public void delete(){
		impl.addNode(2, "root");
		impl.addNode(1, "left");
		impl.addNode(3, "right");
	}
	@Then("deleting it, we should get true from method.")
	public void verify5(){
		impl.remove(1);
		assertThat(impl.root.leftChild, is(equalTo(null)));
	}
	@Given("a left node with no right child,")
	public void delete1(){
		impl.addNode(2, "root");
		impl.addNode(1, "left");
		impl.addNode(3, "right");
		impl.addNode(4, "child");
	}
	@Then("deleting it should be deleted.")
	public void verify6(){
		assertThat(impl.remove(3), is(equalTo(true)));
	}
	@Given("a node with children to delete,")
	public void delete3(){
		impl.addNode(2, "root");
		impl.addNode(1, "left");
		impl.addNode(3, "right");
		impl.addNode(4, "child");
	}
	@Then("deleting it should make replecament.")
	public void verify7(){
		assertThat(impl.remove(2), is(equalTo(true)));
	}
	@Given("a right node with no child to delete,")
	public void delete1231(){
		impl.addNode(2, "root");
		impl.addNode(1, "left");
		impl.addNode(10, "right");
		impl.addNode(0, "root");
		impl.addNode(6, "root");
	}
	@Then("deleting it, we should get replacement.")
	public void verify11(){
		assertThat(impl.remove(10), is(equalTo(true)));
	}
	@Then("deleting it, we should get replacement2.")
	public void verify12(){
		assertThat(impl.remove(10), is(equalTo(true)));
		assertThat(impl.remove(6), is(equalTo(true)));
		assertThat(impl.remove(2), is(equalTo(true)));
	}
	@Then("deleting it, we should get replacement3.")
	public void verify13(){
		assertThat(impl.remove(1), is(equalTo(true)));
	}
	@Given("a root node with no left child,")
	public void delete112231(){
		impl.addNode(2, "root");
		impl.addNode(10, "right");
		impl.addNode(6, "root");
	}
	@Then("deleting it, we should get replacement4.")
	public void verify14(){
		assertThat(impl.remove(2), is(equalTo(true)));
	}
	@Given("a left node with no left child,")
	public void delete11212231(){
		impl.addNode(2, "root");
		impl.addNode(1, "left");
		impl.addNode(10, "right");
		impl.addNode(0, "root");
		impl.addNode(6, "root");
	}
	@Then("deleting it, we should get replacement5.")
	public void verify15(){
		assertThat(impl.remove(0), is(equalTo(true)));
		assertThat(impl.remove(1), is(equalTo(true)));
		assertThat(impl.remove(2), is(equalTo(true)));
	}
}
