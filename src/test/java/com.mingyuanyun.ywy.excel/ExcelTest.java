package com.mingyuanyun.ywy.excel;

import com.alibaba.excel.EasyExcel;
import com.mingyuanyun.ywy.excel.container.ExcelApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ExcelApplication.class)
@RunWith(SpringRunner.class)
public class ExcelTest {

    @Test
    public void excelGen() {
        String fileName = "C:\\Users\\Mloong\\Desktop\\数据导入模板_客户协议_项目A.xlsx";
        EasyExcel.read(fileName, Protocol.class, new ProtocolExcelListener()).sheet().headRowNumber(2).doRead();
    }
}
