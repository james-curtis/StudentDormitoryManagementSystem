package com.donghu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName StudentInfo
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/14
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String snum;
    private String sname;
    private String sclass;
    private String sgrade;
    private String stelephone;
    private Integer did;
    @TableField(exist = false)
    private String dnum;
}
