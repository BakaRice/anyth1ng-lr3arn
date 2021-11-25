package com.ricemarch.accessemail.service;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * @author tanwentao
 * @since 2021/10/31
 */

public interface MailService {

    //发送销售追踪报表（MTD,T+1)
    void sendSalesTrackingReport(Date date) throws MessagingException;

}
