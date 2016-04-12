Scenario: BinaryTree AddNode
Given a first node to tree,
When added to tree it becomes root.
Scenario: BinaryTree AddNode2
Given a third node to tree,
When added to tree it becomes right child.
Scenario: BinaryTree AddNode3
Given a second node to tree,
When added to tree it becomes left child.
Scenario: BinaryTree Find1
Given a node to find,
When finding root should become focusNode.
Scenario: BinaryTree Find2
Given a node different than root to find,
When finding it, it should have different key than root.
Scenario: BinaryTree Find3
Given a node to find which doesnt exsist in tree,
When finding it, it shhould return null.
Scenario: BinaryTree Find4
Given a node to find with lower key than focusNode,
When fining it, it should start finding in leftChild.
Scenario: BinaryTree Delete1
Given a node to delete from tree, which doesnt exsist in,
When deleting it, remove method should return false.
Scenario: BinaryTree Delete2
Given a node to delete from tree,
When deleting it, remove method should return true.
Scenario: BinaryTree Delete3
Given a node to delete from tree,
When deleting it, we shouldnt find it in tree with findNode method.
Scenario: BinaryTree Delete4
Given a root to delete from tree,
When deleting it, we should find null tree.
Scenario: BinaryTree Delete5
Given a left node with no right child,
When deleting it should be deleted.
Scenario: BinaryTree Delete6
Given a node with children to delete,
When deleting it should make replecament.
Scenario: BinaryTree Delete7
Given a left node with no child to delete,
When deleting it, we should get true from method.
Scenario: BinaryTree Delete8
Given a right node with no child to delete,
When deleting it, we should get replacement.
Scenario: BinaryTree Delete9
Given a right node with no child to delete,
When deleting it, we should get replacement2.
Scenario: BinaryTree Delete10
Given a right node with no child to delete,
When deleting it, we should get replacement3.
Scenario: BinaryTree Delete11
Given a root node with no left child,
When deleting it, we should get replacement4.
Scenario: BinaryTree Delete11
Given a left node with no left child,
When deleting it, we should get replacement5.