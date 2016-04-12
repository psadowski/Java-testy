Scenario: BinaryTree AddNode
Given a first node to tree,
When added to tree it becomes root.

Given a third node to tree,
When added to tree it becomes right child.

Given a second node to tree,
When added to tree it becomes left child.

Given a node to find,
When finding root should become focusNode.

Given a node different than root to find,
When finding it, it should have different key than root.


Given a node to find which doesnt exsist in tree,
When finding it, it shhould return null.

Given a node to find with lower key than focusNode,
When fining it, it should start finding in leftChild.