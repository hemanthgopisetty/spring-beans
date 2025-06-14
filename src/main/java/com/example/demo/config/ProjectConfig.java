package com.example.demo.config;

import com.example.demo.parrot.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//to configure the spring context
@Configuration
@ComponentScan(basePackageClasses ={com.example.demo.DemoApplication.class})
public class ProjectConfig {

    //Bean name will be the method name
    //marking this as primary so that
    //works well in ambiguity
    @Bean
    @Primary
    Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Green Parrot");
        return p;
    }
    //Bean annotation to add the parrot context to the spring
    @Bean
    //bean name will be the method name
    Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Red Parrot");
        return p;
    }

    @Bean
        //bean name will be the method name
    Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Blue Parrot");
        return p;
    }

    @Bean
        //bean name will be the method name
    Parrot parrot3() {
        Parrot p = new Parrot();
        p.setName("White Parrot");
        return p;
    }

    @Bean("Yellow")
        //bean name will be the argument name
    Parrot parrot4() {
        Parrot p = new Parrot();
        p.setName("Yellow Parrot");
        return p;
    }

    //   We can add any object to the context
//    @Bean
//    String hello() {
//        return "Hello";
//    }
//
//    @Bean
//    Integer ten() {
//        return 10;
//    }
}


/*
 * Configuration class is a special class in spring applications
 * we use to instruct the spring actions
 * like create beans and enable functionality
 * this class is to define spring related configurations
 *
 * we should define a class with configuration annotation to make class configure spring
 *
 *
 * By adding bean annotation to the method  we instruct
 * the spring to add this return value
 * particular object as bean in the spring context in the initialization
 *
 * put verb's in method name best practice of java
 *
 * we can add any object to the spring context
 *
 * ComponentScan() is empty it will scan package of configuration package class and all subclasses
 * To make Spring find Lion via @ComponentScan,
 * you need to tell it to scan a broader base package
 * that contains both your config and lion packages.
 *
 * The most common and effective way is to specify the root application package:
 * in spring boot also the same thing happens
 * we import the package in the main file
 * then we will scan the main file or whole packages and subclasses
 * basePackages is there
 * basePackageClasses is also there
 * @ComponentScan(basePackages = "com.example.demo")
 * @ComponentScan(basePackageClasses ={com.example.demo.DemoApplication.class})scan in the main for clarity
 * basePackageClass is the best and in spring boot we use the same
 * */
