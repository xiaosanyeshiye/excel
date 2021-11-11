package com.mingyuanyun.ywy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ProtocolWriter {

    @ExcelProperty({"主标题", "物业项目名称"})
    private String projectName;

    @ExcelProperty({"主标题", "分期编码"})
    private String periodCode;

    @ExcelProperty({"主标题", "分期名称"})
    private String periodName;

    @ExcelProperty({"主标题", "分区编码"})
    private String regionCode;

    @ExcelProperty({"主标题", "分区名称"})
    private String regionName;

    @ExcelProperty({"主标题", "楼栋名称"})
    private String buildingName;

    @ExcelProperty({"主标题", "楼栋编码"})
    private String buildingCode;

    @ExcelProperty({"主标题", "单元编码"})
    private String unitCode;

    @ExcelProperty({"主标题", "房屋简码"})
    private String houseSimpleCode;

    @ExcelProperty({"主标题", "房号"})
    private String houseNo;

    @ExcelProperty({"主标题", "楼层"})
    private String floorNum;

    @ExcelProperty({"主标题", "房屋业态"})
    private String houseType;

    @ExcelProperty({"主标题", "建筑面积"})
    private String area;

    @ExcelProperty({"主标题", "电梯楼层"})
    private String elevatorFloorNum;

    @ExcelProperty({"主标题", "业主名称"})
    private String ownerName;

    @ExcelProperty({"主标题", "客户类型"})
    private String customerType;

    @ExcelProperty({"主标题", "联系人"})
    private String contacts;

    @ExcelProperty({"主标题", "手机号码"})
    private String tel;

    @ExcelProperty({"主标题", "证件类型"})
    private String cardType;

    @ExcelProperty({"主标题", "证件号码"})
    private String cardNo;

    @ExcelProperty({"主标题", "入伙时间"})
    private String joinDate;
}
