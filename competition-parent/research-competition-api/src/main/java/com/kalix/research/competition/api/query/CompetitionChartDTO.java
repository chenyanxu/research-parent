package com.kalix.research.competition.api.query;

/**
 * Created by zangyanming on 2017/9/13.
 */
public class CompetitionChartDTO {
    private String label;
    private Integer cnt;
    private Float percentage;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}