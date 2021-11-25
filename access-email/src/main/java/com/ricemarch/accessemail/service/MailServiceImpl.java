package com.ricemarch.accessemail.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ricemarch.accessemail.dto.SalesTrackingReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tanwentao
 * @since 2021/10/31
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.info}")
    private String mailInfo;

    @Override
    public void sendSalesTrackingReport(Date date) throws MessagingException {

        //meta data
        //邮件收件人
        String StDailyTos = "ricemarch@foxmail.com";
        //邮件抄送人
        String StDailyCcs = "";
        //邮件发送人
        String StSenderEmail = "ricemarch@foxmail.com";
        //邮件主题
        String StTheme = "[test]销售追踪报表";
        //邮件内容html
        String emailHtmlContent = "销售追踪报表内容详见附件";
        //附件待用构造数据
        List<SalesTrackingReportDTO> salesTrackingReportDTOList = new ArrayList<>();
        salesTrackingReportDTOList = JSON.parseArray("[ { \"storeName\": \"xlp测试\", \"storeId\": 1365, \"month\": \"2021-10-10 18:30:02\", \"monthStr\": \"10\", \"preBusinessCategoryName\": \"测试2112wq11\", \"preBusinessCategoryCode\": \"c1\", \"businessCategoryCode\": \"c11\", \"businessCategoryName\": \"测试111112111s\", \"goodsCount\": 1, \"carCount\": 1, \"turnover\": 5000, \"grossProfit\": 5000 }, { \"storeName\": \"xlp测试\", \"storeId\": 1365, \"month\": \"2021-01-09 17:56:26\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA001\", \"businessCategoryName\": null, \"goodsCount\": 15, \"carCount\": 12, \"turnover\": 101116389, \"grossProfit\": 101116389.000000 }, { \"storeName\": \"xlp测试\", \"storeId\": 1365, \"month\": \"2021-01-09 17:56:26\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA003\", \"businessCategoryName\": null, \"goodsCount\": 10, \"carCount\": 9, \"turnover\": 76120, \"grossProfit\": 76120 }, { \"storeName\": \"xlp测试\", \"storeId\": 1365, \"month\": \"2021-01-13 15:04:56\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA004\", \"businessCategoryName\": null, \"goodsCount\": 8, \"carCount\": 6, \"turnover\": 660, \"grossProfit\": 660 }, { \"storeName\": \"xlp测试\", \"storeId\": 1365, \"month\": \"2021-01-13 14:07:10\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA005\", \"businessCategoryName\": null, \"goodsCount\": 32, \"carCount\": 1, \"turnover\": 56658900, \"grossProfit\": 56658900 }, { \"storeName\": \"xlp测试\", \"storeId\": 1365, \"month\": \"2021-01-05 18:33:40\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA013\", \"businessCategoryName\": null, \"goodsCount\": 58, \"carCount\": 21, \"turnover\": 261790, \"grossProfit\": 261790 }, { \"storeName\": \"汽配龙门店\", \"storeId\": 1521, \"month\": \"2021-01-05 18:28:11\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"BY\", \"businessCategoryName\": null, \"goodsCount\": 3, \"carCount\": 2, \"turnover\": 12200, \"grossProfit\": 12200 }, { \"storeName\": \"汽配龙门店\", \"storeId\": 1521, \"month\": \"2021-01-27 15:47:57\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"string\", \"businessCategoryName\": null, \"goodsCount\": 2, \"carCount\": 2, \"turnover\": 150004598, \"grossProfit\": 150004598.000000 }, { \"storeName\": \"汽配龙门店\", \"storeId\": 1521, \"month\": \"2021-01-29 16:30:02\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA001\", \"businessCategoryName\": null, \"goodsCount\": 15, \"carCount\": 5, \"turnover\": 125100, \"grossProfit\": 122678.76 }, { \"storeName\": \"汽配龙门店\", \"storeId\": 1521, \"month\": \"2021-01-27 15:20:19\", \"monthStr\": \"01\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA002\", \"businessCategoryName\": null, \"goodsCount\": 9, \"carCount\": 3, \"turnover\": 138300, \"grossProfit\": 138292.32 }, { \"storeName\": \"途虎养车工场店（莲花路店）\", \"storeId\": 97278, \"month\": \"2021-10-25 17:57:32\", \"monthStr\": \"10\", \"preBusinessCategoryName\": \"测试2112wq11\", \"preBusinessCategoryCode\": \"c1\", \"businessCategoryCode\": \"c11\", \"businessCategoryName\": \"测试111112111s\", \"goodsCount\": 1, \"carCount\": 1, \"turnover\": 16200, \"grossProfit\": 16200 }, { \"storeName\": \"途虎养车工场店（莲花路店）\", \"storeId\": 97278, \"month\": \"2021-10-25 17:57:32\", \"monthStr\": \"10\", \"preBusinessCategoryName\": \"类目5\", \"preBusinessCategoryCode\": \"SCBOSS000SC008\", \"businessCategoryCode\": \"SCBOSS0000032\", \"businessCategoryName\": \"试试1\", \"goodsCount\": 1, \"carCount\": 1, \"turnover\": 5000, \"grossProfit\": 5000 }, { \"storeName\": \"途虎养车工场店（莲花路店）\", \"storeId\": 97278, \"month\": \"2021-09-03 09:12:42\", \"monthStr\": \"09\", \"preBusinessCategoryName\": \"编辑类目二\", \"preBusinessCategoryCode\": \"SCBOSS000SC001\", \"businessCategoryCode\": \"SCBOSS000SC007\", \"businessCategoryName\": \"类目二1\", \"goodsCount\": 4, \"carCount\": 2, \"turnover\": 0, \"grossProfit\": -123 }, { \"storeName\": \"途虎养车工场店（莲花路店）\", \"storeId\": 97278, \"month\": \"2021-10-25 17:57:32\", \"monthStr\": \"10\", \"preBusinessCategoryName\": \"类目323\", \"preBusinessCategoryCode\": \"SCBOSS000SC009\", \"businessCategoryCode\": \"SCBOSS000SC011\", \"businessCategoryName\": \"类目651\", \"goodsCount\": 2, \"carCount\": 2, \"turnover\": 85400, \"grossProfit\": 85400 }, { \"storeName\": \"途虎养车工场店（莲花路店）\", \"storeId\": 97278, \"month\": \"2021-10-25 17:57:32\", \"monthStr\": \"10\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA002\", \"businessCategoryName\": null, \"goodsCount\": 1, \"carCount\": 1, \"turnover\": 28400, \"grossProfit\": 28400 }, { \"storeName\": \"途虎养车工场店（莲花路店）\", \"storeId\": 97278, \"month\": \"2021-09-02 16:30:31\", \"monthStr\": \"09\", \"preBusinessCategoryName\": null, \"preBusinessCategoryCode\": \"qt\", \"businessCategoryCode\": \"YWA003\", \"businessCategoryName\": null, \"goodsCount\": 7, \"carCount\": 4, \"turnover\": 10000, \"grossProfit\": 9956 }, { \"storeName\": \"同步蓝虎测试门店\", \"storeId\": 97368, \"month\": \"2021-03-23 15:22:10\", \"monthStr\": \"03\", \"preBusinessCategoryName\": \"其他\", \"preBusinessCategoryCode\": \"FCBOSS0000016\", \"businessCategoryCode\": \"YWA001\", \"businessCategoryName\": null, \"goodsCount\": 2, \"carCount\": 2, \"turnover\": 2000, \"grossProfit\": 2000 }, { \"storeName\": \"同步蓝虎测试门店\", \"storeId\": 97368, \"month\": \"2021-10-13 18:02:49\", \"monthStr\": \"10\", \"preBusinessCategoryName\": null, \"preBusinessCategoryCode\": \"qt\", \"businessCategoryCode\": \"YWA002\", \"businessCategoryName\": null, \"goodsCount\": 1, \"carCount\": 1, \"turnover\": 1000, \"grossProfit\": 1000 } ]", SalesTrackingReportDTO.class);
        //附件前缀
        String attachmentPrefix = "销售追踪报表";

        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        String dateStr2 = sdf2.format(date);
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //收件人
        String[] tos = StDailyTos.split(",");
        //抄送人
        String[] ccs = StDailyCcs.split(",");
        if (tos == null || tos.length < 1) {
            throw new MessagingException("请设置收件人");
            // throw new StoreSaasReportException("请设置收件人");
        }
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        helper.setTo(tos);
        if (StringUtils.hasLength(StDailyCcs) && ccs != null && ccs.length > 0) {
            helper.setCc(ccs);
        }
        helper.setFrom(StSenderEmail);
        helper.setSubject(StTheme + dateStr2);

        //设置邮件内容
        helper.setText(emailHtmlContent, true);
        //发邮件
        try {
            InputStream in = null;
            HSSFWorkbook workbook = buildSalesTrackingExcel(salesTrackingReportDTOList, dateStr);
            //临时缓冲区
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //创建临时文件
            workbook.write(out);
            byte[] bookByteAry = out.toByteArray();
            in = new ByteArrayInputStream(bookByteAry);

            //添加附件
            helper.addAttachment(MimeUtility.encodeWord(attachmentPrefix + sdf.format(date) + ".xls", "utf-8", "B"), new ByteArrayResource(IOUtils.toByteArray(in)));

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("发送邮件时发生异常了！", e);
        }
    }

    private HSSFWorkbook buildSalesTrackingExcel(List<SalesTrackingReportDTO> salesTrackingReportDTOList, String dateStr) {
        //表头数据
        String[] header = {"门店名称", "月份", "一级业务分类", "二级业务分类", "台次", "车辆数", "营业额", "毛利"};
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet("销售追踪报表");
        //设置表格列宽度为10个字节
        sheet.setDefaultColumnWidth(10);
        //创建标题的显示样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //创建第一行表头
        HSSFRow headrow = sheet.createRow(0);

        //遍历添加表头
        //"门店名称","月份","一级业务分类","二级业务分类","台次","车辆数","营业额","毛利"
        for (int i = 0; i < header.length; i++) {
            //创建一个单元格
            HSSFCell cell = headrow.createCell(i);
            //创建一个内容对象
            HSSFRichTextString text = new HSSFRichTextString(header[i]);
            //将内容对象的文字内容写入到单元格中
            cell.setCellValue(text);
            cell.setCellStyle(headerStyle);
        }

        DecimalFormat df1 = new DecimalFormat("0.00");
        for (int i = 0; i < salesTrackingReportDTOList.size(); i++) {
            SalesTrackingReportDTO currItem = salesTrackingReportDTOList.get(i);
            //创建一行
            HSSFRow currRow = sheet.createRow(i + 1);
            //第一列 门店名称
            String storeName = currItem.getStoreName();
            currRow.createCell(0).setCellValue(storeName);
            //第二列 月份
            String monthStr = currItem.getMonthStr();
            currRow.createCell(1).setCellValue(monthStr);
            //第三列 一级业务分类
            String preBusinessCategoryName = currItem.getPreBusinessCategoryName();
            currRow.createCell(2).setCellValue(preBusinessCategoryName);
            //第四列 二级业务分类
            String businessCategoryName = currItem.getBusinessCategoryName();
            currRow.createCell(3).setCellValue(businessCategoryName);
            //第五列 台次
            Integer goodsCount = currItem.getGoodsCount();
            currRow.createCell(4).setCellValue(goodsCount);
            //第六列 车辆数
            Integer carCount = currItem.getCarCount();
            currRow.createCell(5).setCellValue(carCount);
            //第七列 营业额
            BigDecimal turnover = currItem.getTurnover();
            if (turnover != null) {
                currRow.createCell(6).setCellValue(df1.format(turnover));
            } else {
                currRow.createCell(6).setCellValue("");
            }
            //第八列 毛利
            BigDecimal grossProfit = currItem.getGrossProfit();
            if (grossProfit != null) {
                currRow.createCell(7).setCellValue(df1.format(grossProfit));
            } else {
                currRow.createCell(7).setCellValue("");
            }

        }

        return workbook;
    }
}
