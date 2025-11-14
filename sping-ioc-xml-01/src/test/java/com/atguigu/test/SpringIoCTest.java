package com.atguigu.test;

import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_04.JavaBean2;
import com.atguigu.ioc_05.JavaBean;
import com.atguigu.ioc_05.JavaFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.attribute.HashAttributeSet;

public class SpringIoCTest {

    /*
    * 容器实例化,
    * */
    public void createIoC(){
//        方式1:实例化并且指定配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");

//        方法2：先创建ioc容器对象，再指定配置文件，再刷新！
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext();
        context1.setConfigLocation("spring-03.xml");
        context1.refresh();
    }


    /*
    * Bean对象读取
    * */
    @Test
     public void getBeanFromIoC(){
         //1.创建IoC容器
         ApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");

//        方法一：
         HappyComponent happyComponent = (HappyComponent) context.getBean("happyComponent");
         happyComponent.doWrok();

//         方法二：根据类型获取,
//          配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
//        根据id获取根据类型获取,但是要求,同类型(当前类,或者之类,或者接口的实现类)只能有一个对象交给IoC容器管理
         HappyComponent happyComponent1 = context.getBean( HappyComponent.class);
         happyComponent1.doWrok();

//         方法三：根据id和类型获取
         HappyComponent happyComponent2 = context.getBean("happyComponent", HappyComponent.class);
         happyComponent1.doWrok();

         /*根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof 指定的类型』的返回结果，
            只要返回的是true就可以认定为和类型匹配，能够获取到。*/

     }

     @Test
    public void test3(){
//        1.创建ioc容器，就会进行组件对象的实例化
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("spring-04.xml");

         JavaBean2 bean1 = context1.getBean(JavaBean2.class);
         JavaBean2 bean2 = context1.getBean(JavaBean2.class);
         System.out.println(bean1 == bean2);

//        2.正常结束ioc容器
         context1.close();
    }

    @Test
    public void test4(){
//        1.创建ioc容器，就会进行组件对象的实例化
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("spring-05.xml");

        com.atguigu.ioc_05.JavaBean javaBean = context1.getBean("javaBean1", JavaBean.class);
        System.out.println("javaBean" + javaBean);


        Object bean = context1.getBean("&javaBean1");
        System.out.println("bean" +bean);


//        2.正常结束ioc容器
        context1.close();
    }
}

