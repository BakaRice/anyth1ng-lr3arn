// package com.ricemarch.accessannotation.annotation;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.stereotype.Component;
//
// import java.util.ArrayList;
// import java.util.List;
//
// /**
//  * @author tanwentao
//  * @since 2021/10/19
//  */
//
// @Component
// @PropertySource("classpath:values.properties")
// public class CollectionProvider {
//
//     private List<String> values = new ArrayList<>();
//
//     @Autowired
//     public void setValues(@Value("#{'${listOfValues}'.split(',')}") List<String> values) {
//         this.values.addAll(values);
//     }
//
//     // standard getter
// }