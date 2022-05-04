package org.triumphxx.keyword.fin;

/**
 * @author:triumphxx
 * @Date:2021/4/11
 * @Time:5:22 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 测试final修饰的变量不能被修改，就在类本身
 * 而言，final修饰的属性是没有set方法的,非final修饰的属性是
 * 有set方法的，侧面反映了final修饰的属性是不允许修改的。
 **/

public class FinalVariable {

    private final String name = "triumphxx";

    private final int age = 18;

    private String sex;

    private FinalVariable() {
    }

    /**
     * 匿名内部类实现单例
     */
    private static class FinalVariableHolder {
        private static final FinalVariable INSTANCE = new FinalVariable();
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static FinalVariable getInstance() {
        return FinalVariableHolder.INSTANCE;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
