package com.example.demo.lion;

import org.springframework.stereotype.Component;

//This annotation makes this class  into the Bean
@Component
public class Lion {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
 * @PostConstruct
 * public void init(){
 *     this.name="Simba";
 * }
 * setting spring instance state post its creation
 */