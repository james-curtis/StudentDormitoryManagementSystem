package com.donghu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @ClassName Build
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String bname;

    //    private List<Housemaster> BEmpName;
    @TableField(value = "BEmpName")
    private String BEmpName;
//    @TableField(exist = false,typeHandler = JacksonTypeHandler.class)
//    private List<Employee> BEmpName;
//

}
