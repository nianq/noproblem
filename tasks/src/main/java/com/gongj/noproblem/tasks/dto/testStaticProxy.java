package com.gongj.noproblem.tasks.dto;

/**
 * @program: noproblem
 * @description:   真实对象和代理对象都要实现同一个接口   代理对象要代理真实对象
 * @author: gongj
 * @Description: TODO
 * @create: 2020-05-31 12:05
 **/
public class testStaticProxy {
    public static void main(String[] args) {
        Wedding wedding = new Wedding(new Me());
        wedding.HapprMarry();
    }
}

interface Marry{
    void HapprMarry();
}

//真实角色
class Me implements Marry{

    @Override
    public void HapprMarry() {
        System.out.println("结婚啦====》");
    }
}


//代理角色
class Wedding implements Marry{

    private Marry target;

    public Wedding(Marry target) {
        this.target = target;
    }

    @Override
    public void HapprMarry() {
               before();
               this.target.HapprMarry();
               after();
    }

   public void before(){
         System.out.println("在结婚之前给你布置场景");
    }

    public void after() {
           System.out.println("结婚之后收拾卫生");
    }
}