package io.github.lonelyMrZhang.service.impl;

import io.github.lonelyMrZhang.dao.IAccountDao;
//import io.github.lonelyMrZhang.factory.BeanFactory;
import io.github.lonelyMrZhang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * xml配置
 * <bean id="accountService" class="io.github.lonelyMrZhang.service.impl.AccountServiceImpl"
 *          scope="" init-method="" destroy-method="">
 *          <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 用于创建对象的
 *      他们的作用就和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      @Component：
 *          作用：用于把当前类对象存入Spring容器中
 *          属性：
 *              value：用于指定bean的id，当我们不写时，它的默认值是当前类名，且首字母改小写
 *      @Controller：一般用在表现层
 *      @Service：一般用在业务层
 *      @Repository：一般用在持久层
 *      以上三个注解的作用和属性与Component一模一样，他们三个是Spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 * 用于注入数据的
 *      他们的作用就和在xml文件中的bean标签中写一个<property>标签的作用是一样的
 *      @Autowired:
 *          作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配（包含向上转型），就可以注入成功，
 *如果IOC容器中没有任何bean的类型和要注入的变量类型匹配，则报错,如果有多个匹配，将使用属性名和容器中key进行匹配，如果没有匹配则报错。
 *          出现位置：可以是变量上，也可以是方法上
 *          细节：在使用注解注入时，set方法就不是必须的了
 *      @Qualifier ：
 *          作用：在按照类型注入的基础之上再按照名称注入，它在类成员注入时不能单独使用，但是在给方法参数注入时可以
 *          属性：
 *              value：用于指定注入bean的id
 *      @Resource：
 *          作用：直接按照bean的id注入，可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *      以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现，另外，集合类型的注入只能通过xml来实现。
 *      @Value:
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，它可以使用spring中的spel（el表达式），eg：${表达式}
 * 用于改变作用范围的
 *      他们的作用就和在bean标签中使用scope书香实现的功能是一样的
 *      @Scope:
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的值，常用取值：singleton prototype
 * 和生命周期相关 了解
 *      他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的
 *      @PreDestroy:
 *          作用：用于指定销毁方法
 *      @PostConstruct:
 *          作用：用于指定初始化方法
 * @description:
 * @author: lonely.mr.zhang
 * @date: 2020/6/12 12:44 上午
 */
@Component(value = "accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    private IAccountDao accountDao2;
//    @Autowired
//    @Qualifier(value = "accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    AccountServiceImpl(){
        System.out.println("创建对象了");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }

    public void saveAccount() {
//        accountDao2.saveAccount();
        accountDao.saveAccount();
    }
}
