package org.example;

import java.util.List;
public class RuleControl {
    private String ruleControlVersion;
    private String ruleControlName;
    private String ruleControlDescription;
    private List<String> ruleControlIg;

    @Override
    public String toString() {
        return "RuleControl{" +
                "ruleControlVersion='" + ruleControlVersion + '\'' +
                ", ruleControlName='" + ruleControlName + '\'' +
                ", ruleControlDescription='" + ruleControlDescription + '\'' +
                ", ruleControlIg=" + ruleControlIg +
                '}';
    }

    public String getRuleControlVersion() {
        return ruleControlVersion;
    }

    public void setRuleControlVersion(String ruleControlVersion) {
        this.ruleControlVersion = ruleControlVersion;
    }

    public String getRuleControlName() {
        return ruleControlName;
    }

    public void setRuleControlName(String ruleControlName) {
        this.ruleControlName = ruleControlName;
    }

    public String getRuleControlDescription() {
        return ruleControlDescription;
    }

    public void setRuleControlDescription(String ruleControlDescription) {
        this.ruleControlDescription = ruleControlDescription;
    }

    public List<String> getRuleControlIg() {
        return ruleControlIg;
    }

    public void setRuleControlIg(List<String> ruleControlIg) {
        this.ruleControlIg = ruleControlIg;
    }
}
