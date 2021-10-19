package com.ricemarch.accessannotation.annotation;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author tanwentao
 * @since 2021/10/19
 */

@Service
@Slf4j
public class ValueService {

    public void logValue() {
        log.info("{}-->{}", "stringWithDefaultValue", JSON.toJSON(stringWithDefaultValue));
        log.info("{}-->{}", "stringWithBlankDefaultValue", JSON.toJSON(stringWithBlankDefaultValue));
        log.info("{}-->{}", "booleanWithDefaultValue", JSON.toJSON(booleanWithDefaultValue));
        log.info("{}-->{}", "intWithDefaultValue", JSON.toJSON(intWithDefaultValue));
        log.info("{}-->{}", "stringArrayWithDefaults", JSON.toJSON(stringArrayWithDefaults));
        log.info("{}-->{}", "intArrayWithDefaults", JSON.toJSON(intArrayWithDefaults));
        log.info("{}-->{}", "spelWithDefaultValue", JSON.toJSON(spelWithDefaultValue));
    }

    //string defaults
    @Value("${some.key1:my default value}")
    private String stringWithDefaultValue;

    @Value("${some.key2:}")
    private String stringWithBlankDefaultValue;

    //primitives
    @Value("${some.key3:true}")
    private boolean booleanWithDefaultValue;

    @Value("${some.key4:42}")
    private int intWithDefaultValue;

    //arrays
    @Value("${some.key5:one,two,three}")
    private String[] stringArrayWithDefaults;

    @Value("${some.key6:1,2,3}")
    private int[] intArrayWithDefaults;

    //using SpEL
    @Value("#{systemProperties['some.key7']?:'my default system property value'}")
    private String spelWithDefaultValue;


}
