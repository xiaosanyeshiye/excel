package com.mingyuanyun.ywy.excel;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class Protocol {

    /** 物业项目名称 **/
    @ExcelProperty(index = 0)
    private String projectName;

    /** 分期编码 **/
    @ExcelProperty(index = 1)
    private String periodCode;

    /** 分期名称 **/
    @ExcelProperty(index = 2)
    private String periodName;

    /** 分区编码 **/
    @ExcelProperty(index = 3)
    private String regionCode;

    /** 分区名称 **/
    @ExcelProperty(index = 4)
    private String regionName;

    /** 楼栋名称 **/
    @ExcelProperty(index = 5)
    private String buildingName;

    /** 楼栋编码 **/
    @ExcelProperty(index = 6)
    private String buildingCode;

    /** 单元编码 **/
    @ExcelProperty(index = 7)
    private String unitCode;

    /** 房屋简码 **/
    @ExcelProperty(index = 8)
    private String houseSimpleCode;

    /** 房号 **/
    @ExcelProperty(index = 9)
    private String houseNo;

    /** 楼层 **/
    @ExcelProperty(index = 10)
    private String floorNum;

    /** 房屋业态 **/
    @ExcelProperty(index = 11)
    private String houseType;

    /** 建筑面积 **/
    @ExcelProperty(index = 12)
    private String area;

    /** 电梯楼层 **/
    @ExcelProperty(index = 13)
    private String elevatorFloorNum;

    /** 业主名称 **/
    @ExcelProperty(index = 14)
    private String ownerName;

    /** 客户类型 **/
    @ExcelProperty(index = 15)
    private String customerType;

    /** 联系人 **/
    @ExcelProperty(index = 16)
    private String contacts;

    /** 手机号码 **/
    @ExcelProperty(index = 17)
    private String tel;

    /** 证件类型 **/
    @ExcelProperty(index = 18)
    private String cardType;

    /** 证件号码 **/
    @ExcelProperty(index = 19)
    private String cardNo;

    /** 入伙时间 **/
    @ExcelProperty(index = 20)
    private String joinDate;

    /***
     * 转换成写入对象列表
     * @param list 列表
     * @return 写入对象列表
     */
    public static List<ProtocolWriter> convertToWriterList(List<Protocol> list, String replaceFlag) {
        List<ProtocolWriter> writerList = new ArrayList<>();
        // 前两行为表头
        for (int i = 2; i < list.size(); i++) {
            ProtocolWriter protocolWriter = Protocol.convertToWriter(list.get(i), replaceFlag);
            writerList.add(protocolWriter);
        }
        return writerList;
    }

    private static ProtocolWriter convertToWriter(Protocol protocol, String replaceFlag) {
        ProtocolWriter writer = new ProtocolWriter();
        writer.setProjectName(StrUtil.replace(protocol.getProjectName(), "CC", replaceFlag) );
        writer.setPeriodCode(protocol.getPeriodCode());
        writer.setPeriodName(protocol.getPeriodName());
        writer.setRegionCode(protocol.getRegionCode());
        writer.setRegionName(protocol.getRegionName());
        writer.setBuildingName(protocol.getBuildingName());
        writer.setBuildingCode(protocol.getBuildingCode());
        writer.setUnitCode(protocol.getUnitCode());
        writer.setHouseSimpleCode(protocol.getHouseSimpleCode());
        writer.setHouseNo(protocol.getHouseNo());
        writer.setFloorNum(protocol.getFloorNum());
        writer.setHouseType(protocol.getHouseType());
        writer.setArea(protocol.getArea());
        writer.setElevatorFloorNum(protocol.getElevatorFloorNum());
        writer.setOwnerName(protocol.getOwnerName());
        writer.setCustomerType(protocol.getCustomerType());
        writer.setContacts(protocol.getContacts());
        writer.setTel(protocol.getTel());
        writer.setCardType(protocol.getCardType());
        writer.setCardNo(protocol.getCardNo());
        writer.setJoinDate(protocol.getJoinDate());
        return writer;
    }
}
