package org.example;
public class RuleContext {
    private String ruleCheckCategory;
    private String ruleCheckType;
    private String condition;
    private String resultPattern;
    private int occurence;
    private String operator;

    @Override
    public String toString() {
        return "RuleContext{" +
                "ruleCheckCategory='" + ruleCheckCategory + '\'' +
                ", ruleCheckType='" + ruleCheckType + '\'' +
                ", condition='" + condition + '\'' +
                ", resultPattern='" + resultPattern + '\'' +
                ", occurrence=" + occurence +
                ", operator='" + operator + '\'' +
                '}';
    }

    public String getRuleCheckCategory() {
        return ruleCheckCategory;
    }

    public void setRuleCheckCategory(String ruleCheckCategory) {
        this.ruleCheckCategory = ruleCheckCategory;
    }

    public String getRuleCheckType() {
        return ruleCheckType;
    }

    public void setRuleCheckType(String ruleCheckType) {
        this.ruleCheckType = ruleCheckType;
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


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }
}
