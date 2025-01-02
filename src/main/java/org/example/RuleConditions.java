package org.example;

public class RuleConditions {
    private String condition;
    private String resultPattern;
    private int occurence;
    private String operator;

    @Override
    public String toString() {
        return "ruleConditions{" +
                "condition='" + condition + '\'' +
                ", resultPattern='" + resultPattern + '\'' +
                ", occurence=" + occurence +
                ", operator='" + operator + '\'' +
                '}';
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getResultPattern() {
        return resultPattern;
    }

    public void setResultPattern(String resultPattern) {
        this.resultPattern = resultPattern;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
