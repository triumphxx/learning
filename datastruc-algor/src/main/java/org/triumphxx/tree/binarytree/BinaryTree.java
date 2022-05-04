package org.triumphxx.tree.binarytree;

/**
 * @author:triumphxx
 * @Date:2021/1/12
 * @Time:上午11:39
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 定义一颗二叉树
 **/
public class BinaryTree {
    private StudentNode root;

    public void setRoot(StudentNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public StudentNode preSearch(int no) {
        if (this.root != null) {
            return this.root.preSearch(no);
        }
        return null;
    }

    //中序查找
    public StudentNode midSearch(int no) {
        if (this.root != null) {
            return this.root.midSearch(no);
        }
        return null;
    }

    //后序查找
    public StudentNode postSearch(int no) {
        if (this.root != null) {
            return this.root.postSearch(no);
        }
        return null;
    }

    public void delStudentNode1(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delStudentNode(no);
            }
        } else {
            System.out.println("二叉树为空，无法删除");
        }
    }

    public void delStudentNode2(int no) {
        if (this.root != null) {
            this.root.delStudentNode2(no);
        } else {
            System.out.println("二叉树为空，无法删除");
        }
    }
}
