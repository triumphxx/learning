package org.triumphxx.tree.binarytree;

/**
 * @author:triumphxx
 * @Date:2021/1/12
 * @Time:上午11:42
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 学生数据树节点
 **/

public class StudentNode {
    /**
     * 学号
     */
    private int no;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 左子节点
     */
    private StudentNode left;
    /**
     * 右子节点
     */
    private StudentNode right;

    public StudentNode() {
    }

    public StudentNode(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentNode getLeft() {
        return left;
    }

    public void setLeft(StudentNode left) {
        this.left = left;
    }

    public StudentNode getRight() {
        return right;
    }

    public void setRight(StudentNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //前序遍历的方法
    public void preOrder() {
        System.out.println(this); //先输出父结点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {

        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public StudentNode preSearch(int no) {
        //若当前节点满庄镇 直接返回
        System.out.println("进入前序查找");
        if (this.no == no) {
            return this;
        }
        //否则递归查询左子树
        StudentNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //否则递归查询右子树
        if (this.right != null) {
            resNode = this.right.preSearch(no);

        }
        return resNode;
    }

    //中序查找
    public StudentNode midSearch(int no) {

        //否则递归查询左子树
        StudentNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        //若当前节点满庄镇 直接返回
        if (this.no == no) {
            return this;
        }
        //否则递归查询右子树
        if (this.right != null) {
            resNode = this.right.midSearch(no);

        }
        return resNode;
    }

    //后序查找
    public StudentNode postSearch(int no) {
        //否则递归查询左子树
        StudentNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //否则递归查询右子树
        if (this.right != null) {
            resNode = this.right.postSearch(no);

        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找");
        //若当前节点满庄镇 直接返回
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //删除节点
    public void delStudentNode(int no) {
        //1.如果删除的节点是叶子节点，则删除该节点
        //2.如果删除的节点是非叶子节点，则删除该子树
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delStudentNode(no);
        }
        if (this.right != null) {
            this.right.delStudentNode(no);
        }
    }

    //删除节点
    public void delStudentNode2(int no) {
        //1.如果删除的节点是叶子节点，则删除该节点
        //2.如果删除的节点是非叶子节点，则将该节点的左子节点上移
        //定义一个辅助节点
        StudentNode temp = new StudentNode();

        if (this.left != null && this.left.no == no) {
            //若存在左叶子节点
            if (this.left.left != null) {
                if (this.left.right != null) {
                    temp = this.left.right;
                }
                // 将叶子节点 赋予 父节点
                this.left = this.left.left;
                this.right = temp;
                //将左叶子节点 置空
                this.left.left = null;
                return;
            }
        }
        if (this.right != null && this.right.no == no) {
            //判断该节点的左右节点的是否存在 若存在 将左节点上移
            if (this.right.right != null) {
                if (this.right.left != null) {
                    temp = this.right.left;
                }
                this.right = this.left;
                this.left = temp;
                this.right.left = null;
                return;
            }
        }
        if (this.left != null) {
            this.left.delStudentNode(no);
        }
        if (this.right != null) {
            this.right.delStudentNode(no);
        }
    }
}
