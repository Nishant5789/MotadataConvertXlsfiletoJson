package org.example;
import java.util.List;

public class Rule {
    private static long counter = 10000000000001L;
    private long id = 0L;
    private String ruleName;
    private String ruleCategory;
    private RuleContext ruleContext;
    private String ruleAutoRemediation;
    private String ruleDescription;
    private String ruleSeverity;
    private List<String> ruleTags;
    private String ruleRationale;
    private String ruleImpact;
    private String ruleDefaultValue;
    private String ruleReferences;
    private List<RuleControl> ruleControls;

    public Rule() {
        this.id = counter++;
    }

    public long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleCategory() {
        return ruleCategory;
    }

    public void setRuleCategory(String ruleCategory) {
        this.ruleCategory = ruleCategory;
    }

    public RuleContext getRuleContext() {
        return ruleContext;
    }

    public void setRuleContext(RuleContext ruleContext) {
        this.ruleContext = ruleContext;
    }

    public String getRuleAutoRemediation() {
        return ruleAutoRemediation;
    }

    public void setRuleAutoRemediation(String ruleAutoRemediation) {
        this.ruleAutoRemediation = ruleAutoRemediation;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public String getRuleSeverity() {
        return ruleSeverity;
    }

    public void setRuleSeverity(String ruleSeverity) {
        this.ruleSeverity = ruleSeverity;
    }

    public List<String> getRuleTags() {
        return ruleTags;
    }

    public void setRuleTags(List<String> ruleTags) {
        this.ruleTags = ruleTags;
    }

    public String getRuleRationale() {
        return ruleRationale;
    }

    public void setRuleRationale(String ruleRationale) {
        this.ruleRationale = ruleRationale;
    }

    public String getRuleImpact() {
        return ruleImpact;
    }

    public void setRuleImpact(String ruleImpact) {
        this.ruleImpact = ruleImpact;
    }

    public String getRuleDefaultValue() {
        return ruleDefaultValue;
    }

    public void setRuleDefaultValue(String ruleDefaultValue) {
        this.ruleDefaultValue = ruleDefaultValue;
    }

    public String getRuleReferences() {
        return ruleReferences;
    }

    public void setRuleReferences(String ruleReferences) {
        this.ruleReferences = ruleReferences;
    }

    public List<RuleControl> getRuleControls() {
        return ruleControls;
    }

    public void setRuleControls(List<RuleControl> ruleControls) {
        this.ruleControls = ruleControls;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleName='" + ruleName + '\'' +
                ", ruleCategory='" + ruleCategory + '\'' +
                ", ruleContext=" + ruleContext +
                ", ruleAutoRemediation='" + ruleAutoRemediation + '\'' +
                ", ruleDescription='" + ruleDescription + '\'' +
                ", ruleSeverity='" + ruleSeverity + '\'' +
                ", ruleTags=" + ruleTags +
                ", ruleRationale='" + ruleRationale + '\'' +
                ", ruleImpact='" + ruleImpact + '\'' +
                ", ruleDefaultValue='" + ruleDefaultValue + '\'' +
                ", ruleReferences='" + ruleReferences + '\'' +
                ", ruleControls=" + ruleControls +
                '}';
    }
}
