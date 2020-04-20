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
@TableName("edu_stu_hom")
@ApiModel(value="StuHom对象", description="")
public class StuHom implements Serializable {

    private static final long serialVersionUID=1L;


    private Integer userId;

    private Integer homId;

    private Date uHFtime;

    private Float uHScore;

    private String uHFile;

}
