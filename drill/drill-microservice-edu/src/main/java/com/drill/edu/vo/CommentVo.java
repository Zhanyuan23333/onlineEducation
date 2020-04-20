package com.drill.edu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {
    private Integer userId;
    private String userName;
    private Date creatime;
    private String comDescr;
    private Integer comId;
}
