package com.mingyuanyun.ywy.excel;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ProtocolExcelListener extends AnalysisEventListener<Protocol> {

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 1000;
    List<Protocol> list = new ArrayList<>(BATCH_COUNT);
    private static final int FILE_NUM = 2;

    @Override
    public void invoke(Protocol protocol, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSONUtil.toJsonStr(protocol));
        list.add(protocol);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData(){
        log.info("{}条数据, 开始写入excel.", list.size());
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "AA");
        map.put(1, "BB");
        for (int i = 0; i < FILE_NUM; i++) {
            String fileName = "C:\\Users\\Mloong\\Desktop\\" + "数据导入模板_客户协议_项目A_" + map.get(i) + ".xlsx";
            ExcelWriter excelWriter = EasyExcel.write(fileName, ProtocolWriter.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("协议").build();
            List<ProtocolWriter> data = Protocol.convertToWriterList(list, map.get(i));
            excelWriter.write(data, writeSheet);
            excelWriter.finish();
        }
    }
}
