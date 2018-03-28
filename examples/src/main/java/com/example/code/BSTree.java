package com.example.code;


/**
 * <p>描述：二叉查找树的java实现</p>
 * 作者： liujiyi<br>
 * 日期： 2018/3/28<br>
 */
public class BSTree<T extends Comparable<T>> {

    private BSTNode<T> mRoot; //根结点

    /**
     * 二叉树包含值 父结点 左结点 右结点
     *
     * @param <T>
     */
    private static class BSTNode<T extends Comparable<T>> {
        private T key;
        private BSTNode<T> parent;
        private BSTNode<T> left;
        private BSTNode<T> right;

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 插入结点
     *
     * @param key
     */
    public void insert(T key) {
        BSTNode<T> bstNode = new BSTNode<>(key, null, null, null);
        if (bstNode != null) {
            insert(this, bstNode);
        }
    }

    /**
     * 插入结点
     * 1、先确定该结点的父结点
     * 2、再确定该结点是父结点的左结点或右结点
     *
     * @param tbsTree
     * @param bstNode
     */
    private void insert(BSTree<T> tbsTree, BSTNode<T> bstNode) {
        int cmp = 0;
        BSTNode<T> parentNode = null;
        BSTNode<T> rootNode = tbsTree.mRoot;

        while (rootNode != null) {
            parentNode = rootNode;
            cmp = parentNode.key.compareTo(bstNode.key);
            if (cmp < 0) {
                rootNode = rootNode.right;
            } else {
                rootNode = rootNode.left;
            }
        }
        //1、先确定该结点的父结点
        bstNode.parent = parentNode;

        //2、再确定该结点是父结点的左结点或右结点
        if (parentNode == null) {
            tbsTree.mRoot = bstNode;
            return;
        }
        cmp = parentNode.key.compareTo(bstNode.key);
        if (cmp < 0) {
            parentNode.right = bstNode;
        } else {
            parentNode.left = bstNode;
        }
    }

    /**
     * 根据key查找结点
     *
     * @param key
     * @return
     */
    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * 递归查找结点
     *
     * @param node
     * @param key
     * @return
     */
    private BSTNode<T> search(BSTNode<T> node, T key) {
        if (node == null) {
            System.out.printf("%2d key not find..\n");
            return null;
        }

        int compareTo = node.key.compareTo(key);
        if (compareTo < 0) {
            return search(node.right, key);
        } else if (compareTo > 0) {
            return search(node.left, key);
        } else {
            System.out.printf("key is find.." + node.key + "==node.parent==" + (node.parent == null ? "null" : node.parent.key)
                    + "==node.left==" + (node.left == null ? "null" : node.left.key) + "==node.right==" + (node.right == null ? "null" : node.right.key));
            return node;
        }
    }

    /**
     * root为根结点的二叉树的最大结点
     */
    public BSTNode<T> max(BSTNode<T> root) {
        if (root == null) {
            return null;
        }
        BSTNode<T> node = root;
        while (node.right != null) {
            node = node.right;
        }
        System.out.printf("tree max = " + node.key + "\n");
        return node;
    }

    /**
     * root为根结点的二叉树的最小结点
     */
    public BSTNode<T> min(BSTNode<T> root) {
        if (root == null) {
            return null;
        }
        BSTNode<T> node = root;
        while (node.left != null) {
            node = node.left;
        }
        System.out.printf("tree min = " + node.key + "\n");
        return node;
    }

    /**
     * 节点的前驱：是该节点的左子树中的最大节点。
     *
     * @param node
     * @return
     */
    public BSTNode<T> predecessor(BSTNode<T> node) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (node.left != null) {
            return max(node.left);
        }

        //直到找到一个节点P，父节点Q 是 P 节点的右边孩子，那么P节点就是该节点的前驱节点。
        BSTNode<T> y = node.parent;
        while ((y != null) && (node == y.left)) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 节点的后继：是该节点的右子树中的最小节点。
     *
     * @param node
     * @return
     */
    public BSTNode<T> successor(BSTNode<T> node) {
        // 如果x存在右孩子，则"x的前驱结点"为 "以其右孩子为根的子树的最大结点"。
        if (node.right != null) {
            return max(node.right);
        }

        //直到找到一个节点P，父节点Q 是 P 节点的左边孩子，那么P节点就是该节点的后继节点。
        BSTNode<T> y = node.parent;
        while ((y != null) && (node == y.right)) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 删除结点
     *
     * @param key
     */
    public void remove(T key) {
        remove(this, search(mRoot, key));
    }

    /**
     * 删除结点
     *
     * @param
     * @param
     * @return
     */
    public void remove(BSTree<T> tree, BSTNode<T> node) {
//        1.被删除的节点是叶子节点
//        2.被删除的节点只有左孩子节点
//        3.被删除的节点只有右孩子节点
//        4.被删除的有两个孩子节点(后继结点顶替)
        if (node == null) {
            return;
        }
        BSTNode<T> x=null;
        BSTNode<T> y=null;

        if ((node.left == null) || (node.right == null) )
            y = node;
        else
            y = successor(node);

        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            tree.mRoot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != node)
            node.key = y.key;
        node = null;
    }

    /**
     * 打印二叉树
     */
    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }

    /**
     * 0，表示该节点是根节点;
     * -1，表示该节点是它的父结点的左孩子;
     * 1，表示该节点是它的父结点的右孩子。
     *
     * @param tree
     * @param key
     * @param direction
     */
    private void print(BSTNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) {
                // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            } else {
                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");
            }
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }
}
