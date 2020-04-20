package com.drill.edu.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseVo {

    private String userName1;

    private String userName2;

    private Integer userId1;
    private Integer userId2;

    private Integer comId;
    private Date creatime;

    private String resDescr;
}
