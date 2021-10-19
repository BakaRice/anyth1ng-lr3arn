package com.ricemarch.accessannotation.annotation;

import com.ricemarch.accessannotation.aspect.RiceLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tanwentao
 * @since 2021/10/19
 */

@Service
@Slf4j
public class AspectService {

    @RiceLog("RICE-LOG-TEST")
    public void riceLog(String s) {
        for (int i = 0; i < 10; i++) {
            log.info("{}", s);
        }
    }
}
