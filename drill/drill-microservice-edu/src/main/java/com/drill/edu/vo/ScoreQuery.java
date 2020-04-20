package com.drill.edu.vo;

import lombok.Data;

@Data
public class ScoreQuery {
    private String userName;
    private Integer courId;
    private Integer lowScore;
    private Integer highScore;
}
