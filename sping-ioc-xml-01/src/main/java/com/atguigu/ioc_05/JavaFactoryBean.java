package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;

public class JavaFactoryBean implements FactoryBean<JavaBean> {

    @Override
    public JavaBean getObject() throws Exception {
        JavaBean javaBean = new JavaBean();
        javaBean.setName("王二");
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {

        return JavaBean.class;
    }
}
