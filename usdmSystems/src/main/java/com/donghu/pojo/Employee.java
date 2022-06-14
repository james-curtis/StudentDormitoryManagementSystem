package com.donghu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName Employee
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String ename;
    private String etelephone;
    private String eposition;
    private Integer bid;

    @TableField(exist = false)
    private String EBname;
}
