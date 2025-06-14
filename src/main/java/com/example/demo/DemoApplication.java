package com.example.demo;


import com.example.demo.config.ProjectConfig;
import com.example.demo.lion.Lion;
import com.example.demo.parrot.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.demo.tiger.Tiger;

import java.util.function.Supplier;

public class DemoApplication {

    public static void main(String[] args) {
        //Spring Context
        //Configured by ProjectConfig class
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //Bean
        //Parrot Object
        Parrot parrot = context.getBean(Parrot.class);
        Parrot parrot1 = context.getBean("parrot1", Parrot.class);
        Parrot parrot2 = context.getBean("parrot2", Parrot.class);
        Parrot parrot3 = context.getBean("parrot3", Parrot.class);
        Parrot yellow = context.getBean("Yellow", Parrot.class);
        System.out.println(parrot.getName());
        System.out.println(parrot1.getName());
        System.out.println(parrot2.getName());
        System.out.println(parrot3.getName());
        System.out.println(yellow.getName());

        //Stereo Type
        Lion l = context.getBean(Lion.class);
        l.setName("Simba");
        System.out.println(l.getName());
        Lion l2 = context.getBean(Lion.class);
        System.out.println(l2.getName());

        //Programmatically
        Tiger tiger = new Tiger();
        tiger.setName("White Tiger");
        Supplier<Tiger> tigerSupplier = ()->tiger;

        context.registerBean("white",Tiger.class,tigerSupplier,bd -> bd.setPrimary(true));
        Tiger tigerContext = context.getBean("white", Tiger.class);
        System.out.println(tigerContext.getName());
//        String s = context.getBean(String.class);
//        Integer x = context.getBean(Integer.class);
    }

}
/*
 * We add instances known as beans to expect spring to manage
 * plug in functionalities offered by spring
 *
 * To add a bean we need spring context dependency in pom.xml
 *
 * We can add the bean in following ways
 *
 * 1.Bean Annotation
 *  Steps
 *     1 : Create a configuration class with configure annotation(to configure the spring context)
 *     2 : Create a method with bean annotation that return an object
 *     3 : add that config class in spring context created in main method
 * we can add any object to the spring context and getBack those context by class(Parrot.class..)
 * we can declare as many as of same type
 *
 * Adding more beans of same type
 * Parrot p = context.getBean(Parrot.class); this will cause ambiguity
 * to solve this ambiguity we need to call them by names
 *      Parrot parrot1 = context.getBean("parrot1",Parrot.class);
        Parrot parrot2 = context.getBean("parrot2",Parrot.class);
        Parrot parrot3 = context.getBean("parrot3",Parrot.class);
 * you can also mark a bean a primary when there are so many beans of same kind
 * 2.Stereo Type Annotation
 * Created a Lion Class
 * Add the notation above class
 * for which you need to have an instance in the spring context
 * when app creates the spring context ,spring creates an instance of this class
 * and add that into the spring context(memory of the app)
 *
 * we will still have configuration class for this approach
 * By Default spring doesn't search for stereotype annotations classes
 * spring gets to know about our instances only through config class
 * in same configuration class we should tell that class
 * to scan @Component Scan and find classes marked with component that makes a bean
 * we can use both approaches together
 *
 * Bean Vs StereoType
 * Using Bean you can add as many and configure the instance before it's creation
 * Using Stereo you will get control only when after the creation of instance
 *
 * If we want more beans then we can go or bean annotation
 * else we can do with stereo as this needs less code writing
 * We can;t add any object other than created in Stereo whereas in Bean we can perform the same
 * In stereo we will get control after it's creations
 * where as in Bean Before itself
 *
 *       Lion l = context.getBean(Lion.class);
        l.setName("Simba");
        System.out.println(l.getName());
        Lion l2 = context.getBean(Lion.class);
        System.out.println(l2.getName());
 *    Memory is same across the project we can use spring context anywhere in the app
 *    and set the values easily
 *
 * 3.Programmatically
 * Adding a new context instance directly by calling a method of the instance
 * custom way of adding beans
 * to the context
 * when bean annotation or stereotype annotation need not enough
 *
 * you need to register specific beans in the spring context
 * depending on the specific configuration
 * if(cond){
 *      registerBean(b)
 * }
 * else {
 *      registerBean(c)
 * }
 * suppose if i want to add the green parrot objects only
 *
 *
 * using registerBean Method to add specific objects instances to the spring context
 *
 * registerBean() function is from the AnnotationConfigApplicationContext
 * this method accepts
 * four parameters
 *  1.Name of the bean (if u don't want to provide ,pass null)
 *  2.Class of the bean (Parrot instance) then Parrot.class
 *  3.Instance of supplier(supplier needs to return a value of the instance we add to the context)
 *       Supplier is functional Interface
 *       java.util.functional
 *  4.VarArgs(properties like primary)
 *
 *
 *
 *
 *
 * */