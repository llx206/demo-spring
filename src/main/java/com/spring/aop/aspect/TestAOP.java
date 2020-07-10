package com.spring.aop.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/appContext.xml");
        PersonService personService = appContext.getBean(PersonService.class);
        String personName = "test zhangsan........";
        personService.addPerson(personName);
        //personService.deletePerson(personName);
        //personService.editPerson(personName);
    }
}
