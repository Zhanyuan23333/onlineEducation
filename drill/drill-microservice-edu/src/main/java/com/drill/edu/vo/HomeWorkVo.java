package com.drill.edu.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class HomeWorkVo {

    private String homTitle;

    private String homDescr;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date homStime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date homEtime;

    private Integer homCouId;
}
