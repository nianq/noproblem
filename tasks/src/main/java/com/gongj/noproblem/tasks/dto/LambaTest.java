package com.gongj.noproblem.tasks.dto;

/**
 * @program: noproblem
 * @description:
 * @author: gongj
 * @Description: TODO
 * @create: 2020-05-31 12:31
 **/
public class LambaTest {
    //3、静态内部类  减少类的创建
    static class like2 implements ILike{

        @Override
        public void lamdba() {
            System.out.println("test2=========>lamdba2");
        }
    }
    public static void main(String[] args) {
        ILike like = new like();
        like.lamdba();


        like = new like2();
        like.lamdba();


        //4、局部内部类
        class like3 implements ILike{

            @Override
            public void lamdba() {
                System.out.println("test3=========>lamdba3");
            }
        }

        like = new like3();
        like.lamdba();


        //匿名内部类  没有类名称 必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lamdba() {
                System.out.println("test4=========>lamdba4");

            }
        };
        like.lamdba();


        like = () ->  System.out.println("test5=========>lamdba5");
        if(1==1){
            System.out.println("成功");
        };
    }
}


// 1、定义一个接口
interface ILike {
    void lamdba();
}

//2 实现类
class like implements ILike{

    @Override
    public void lamdba() {
        System.out.println("test=========>lamdba");
    }
}