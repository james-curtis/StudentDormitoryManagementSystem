package com.donghu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Dormitory
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dormitory {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String dnum;
    @TableField(exist = false)
    private String DBname;


}
