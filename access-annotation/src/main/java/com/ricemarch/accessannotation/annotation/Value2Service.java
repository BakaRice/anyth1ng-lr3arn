// package com.ricemarch.accessannotation.annotation;
//
//
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
//
// import java.util.List;
// import java.util.Map;
//
// /**
//  * @author tanwentao
//  * @since 2021/10/19
//  */
// @Service
// @Slf4j
// public class Value2Service {
//
//     @Value("string value")
//     private String stringValue;
//
//     @Value("${value.from.file}")
//     private String valueFromFile;
//
//     @Value("${systemValue}")
//     private String systemValue;
//
//     @Value("${unknown.param:some default}")
//     private String someDefault;
//
//     @Value("${priority}")
//     private String prioritySystemProperty;
//
//     @Value("${listOfValues}")
//     private String[] valuesArray;
//
//     /**
//      * SpEL
//      */
//
//     // 如果 priority 没有定义 -> null
//     @Value("#{systemProperties['priority']}")
//     private String spelValue;
//
//     @Value("#{systemProperties['unknown'] ?: 'some default'}")
//     private String spelSomeDefault;
//
//     @Value("#{someBean.someValue}")
//     private Integer someBeanValue;
//
//     //List
//     @Value("#{'${listOfValues}'.split(',')}")
//     private List<String> valuesList;
//
//     //Map
//     @Value("#{${valuesMap}}")
//     private Map<String, Integer> valuesMap;
//
//     @Value("#{${valuesMap}.key1}")
//     private Integer valuesMapKey1;
//
//     //如果不确定key是否存在，选择一种安全写的表达式，当找不到对应key时不会抛出异常，只会设置值为空
//     @Value("#{${valuesMap}['unknownKey']}")
//     private Integer unknownMapKey;
//
//     @Value("#{${unknownMap : {key1: '1', key2: '2'}}}")
//     private Map<String, Integer> unknownMap;
//
//     //不存在时可以进行默认值的设置
//     @Value("#{${valuesMap}['unknownKey'] ?: 5}")
//     private Integer unknownMapKeyWithDefaultValue;
//
//     @Value("#{${valuesMap}.?[value>'1']}")
//     private Map<String, Integer> valuesMapFiltered;
//
//     @Value("#{systemProperties}")
//     private Map<String, String> systemPropertiesMap;
//
// }
