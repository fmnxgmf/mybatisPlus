package cn.fmnx.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.Date;

/**
 * @program: mybatisPlus
 * @description: user实体类对象
 * @author: guojing
 * @create: 2019-08-09 17:55
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String  email;
    //@TableField(el = "66",value = "version",fill = FieldFill.INSERT_UPDATE,update = "%s+1")
    @TableField(el = "66")
    private String version;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE,update = "now()")
    private String updateTime;

}
