package com.donghu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Inout
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Accessregistration {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String identity;
    private String time;
    private String bname;
}
