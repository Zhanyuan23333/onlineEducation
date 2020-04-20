package com.drill.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("edu_material")
@ApiModel(value="Material对象", description="")
public class Material implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "mat_id", type = IdType.AUTO)
    private Integer matId;

    private String matName;

    private String matDescr;

    private String matFile;

    private Integer matChaId;


}
