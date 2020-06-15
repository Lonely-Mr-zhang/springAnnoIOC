package io.github.lonelyMrZhang.ui;

import io.github.lonelyMrZhang.dao.IAccountDao;
//import io.github.lonelyMrZhang.factory.BeanFactory;
import io.github.lonelyMrZhang.service.IAccountService;
import io.github.lonelyMrZhang.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.XMLConstants;

/**
 * @description: 模拟表现层，调用业务层
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 12:53 上午
 */
public class Client {

    public static void main(String[] args) {

        //1、获取核心容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2、根据id获取对象
//        IAccountService accountService = (IAccountService) ac.getBean("accountServiceImpl");
//        IAccountService accountService1 = (IAccountService) ac.getBean("accountService");
//        IAccountService accountService2 = (IAccountService) ac.getBean("accountService");
//        System.out.println(accountService1 == accountService2);

//        System.out.println(accountService);

         IAccountService accountService = (IAccountService) ac.getBean("accountService");
         ac.close();

    }
}
