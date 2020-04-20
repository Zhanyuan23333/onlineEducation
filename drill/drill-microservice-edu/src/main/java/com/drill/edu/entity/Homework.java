package com.drill.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_homework")
@ApiModel(value="Homework对象", description="")
public class Homework implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "hom_id", type = IdType.AUTO)
    private Integer homId;

    private String homTitle;

    private String homDescr;

    private String homFile;

    private Integer isOnline;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date homStime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date homEtime;

    private Integer homCouId;


}
