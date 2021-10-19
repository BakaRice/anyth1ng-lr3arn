// package com.ricemarch.accessannotation.annotation;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author tanwentao
//  * @since 2021/10/19
//  */
//
// @Component
// @PropertySource("classpath:values.properties")
// public class PriorityProvider {
//
//     private String priority;
//
//     @Autowired
//     public PriorityProvider(@Value("${priority:normal}") String priority) {
//         this.priority = priority;
//     }
//
//     // standard getter
// }