
1. 二叉搜索树

- 实现类：BST
- 测试类：BSTTest
- 二叉搜索树，或为空树，或具有以下性质：
  1. 每个结点都被一个唯一的key标识；
  2. 左子树(如果存在)上所有元素的关键码都小于根节点的关键码；
  3. 右子树(如果存在)上所有元素的关键码都大于根节点的关键码；
  4. 左子树和右子树也是二叉搜索树
- 在随机情况下，二叉搜索树搜索、插入、删除操作的时间为O(h), 平均时间代价为O(logn)。在搜索树高度较低时，操作会执行很快。然而，如果树
的高度较高时，这些操作可能并不比在链表上执行的快。

2. 红黑树

- 红黑树是一个二叉搜索树，在每个结点上增加了一个存储位来表示结点的颜色，可以是红色或黑色。通过对任何一条从跟
到叶子的简单路径上各个结点的颜色进行约束，红黑树确保没有一条路径会比其他路径长出2倍，因而是近似于平衡的。
- 红黑树特性描述：
    1. 每个子结点或是红色的，或是黑色的；
    2. 根结点是黑色的；
    3. 每个叶结点是黑色的；
    4. 如果一个结点是红色的，则它的两个子结点都是黑色的(没有两个连续的红色结点)；
    5. 对每个结点，从该结点到其所有后代叶结点的简单路径上，均包含相同数目的黑色结点。
- 结点属性：color, key, left, right, parent
- 引理： 一颗有n个内部结点的红黑树的高度至多为2lg(n+1)。
- 由引理可知，任何集合操作可在红黑树上在O(lgn)时间内执行。
- 插入、删除 // TODO 

3. //TODO 中序递归写一个




