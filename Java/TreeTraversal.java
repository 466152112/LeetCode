// Summary for all the tree traversal, recursive and iterative

// iterative, use stack push root, pop root, push right and left
preorder(node)
  if node == null then return
  visit(node)
  preorder(node.left) 
  preorder(node.right)

// iterative, use stack push to very left node, check the right null or not, set the right to new root, find the left  
inorder(node)
  if node == null then return
  inorder(node.left)
  visit(node)
  inorder(node.right)

// iterative, use stack push root, pop root, push left and right, collection reverse  
postorder(node)
  if node == null then return
  postorder(node.left)
  postorder(node.right)
  visit(node)

// if you want every level in different array, you need to use the size of the queue  
levelorder(root)
  q = empty queue
  q.enqueue(root)
  while not q.empty do
    node := q.dequeue()
    visit(node)
    if node.left ≠ null then
      q.enqueue(node.left)
    if node.right ≠ null then
      q.enqueue(node.right)
