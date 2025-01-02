package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/org/example/Benchmark.xlsx";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // For pretty printing

        List<Rule> resultList = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(3);
            Row headerRow = sheet.getRow(0);
            String[] headers = new String[headerRow.getPhysicalNumberOfCells()];
            StringBuilder headerText = new StringBuilder();
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                headers[i] = headerRow.getCell(i).toString();
                headerText.append(headers[i]).append(", ");
            }

            String line;
//            sheet.getLastRowNum()
            for (int rowIndex = 3; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                int columnCount = headerRow.getPhysicalNumberOfCells();

                if (row != null) {
                    // Create a map to store column names and their corresponding cell values
                    Map<String, String> rowMap = new HashMap<>();

                    for (int j = 0; j < columnCount; j++) {
                        String columnName = headerRow.getCell(j).toString();
                        String cellValue = row.getCell(j) != null ? row.getCell(j).toString() : "";  // Avoid null pointer
                        rowMap.put(columnName, cellValue);
                    }

                    // Extract only the required fields and map them to ResultObject
                    RuleContext rulecontext = new RuleContext();

                    if (rowMap.get("Rule configuration") != null) {
                        rulecontext.setRuleCheckCategory(rowMap.get("Rule configuration"));
                    }
                    if (rowMap.get("Rule Check in") != null) {
                        rulecontext.setRuleCheckType(rowMap.get("Rule Check in"));
                    }
                    if (rowMap.get("conditions") != null) {
                        rulecontext.setCondition(rowMap.get("conditions"));
                    }
                    if (rowMap.get("result.pattern") != null) {
                        rulecontext.setResultPattern(rowMap.get("result.pattern"));
                    }


                    if ("any".equals(rowMap.get("occurence"))) {
//                        System.out.println(rowMap.get("occurence"));
                        rulecontext.setOccurence(-1);
                    }
                    rulecontext.setOperator(rowMap.get("operator"));

                    RuleControl ruleControl1 = new RuleControl();
                    RuleControl ruleControl2 = new RuleControl();

                    ExtractCISControlColumns Ciscontrolobject1 = new ExtractCISControlColumns(rowMap.get("CIS Controls1"));
                    ExtractCISControlColumns Ciscontrolobject2 = new ExtractCISControlColumns(rowMap.get("CIS Controls2"));

//                    System.out.println(Ciscontrolobject1);

                    ruleControl1.setRuleControlVersion(rowMap.get("CIS Safeguards 1 (v8)"));
                    ruleControl1.setRuleControlName(Ciscontrolobject1.getControl());
                    ruleControl1.setRuleControlDescription(Ciscontrolobject1.getDescription());

                    if(rowMap.get("CIS Safeguards 1 (v7)") != null){
                        ruleControl2.setRuleControlVersion(rowMap.get("CIS Safeguards 1 (v7)"));
                    }
                    ruleControl2.setRuleControlName(Ciscontrolobject2.getControl());
                    ruleControl2.setRuleControlDescription(Ciscontrolobject2.getDescription());

                    String igValue11 = rowMap.get("v8 IG1");
                    String igValue12 = rowMap.get("v8 IG2");
                    String igValue13 = rowMap.get("v8 IG3");
                    String igValue21 = rowMap.get("v7 IG1");
                    String igValue22 = rowMap.get("v7 IG2");
                    String igValue23 = rowMap.get("v7 IG3");

                    List<String> igList1 = collectStringsWithX(igValue11, igValue12, igValue13);
                    List<String> igList2 = collectStringsWithX(igValue21, igValue22, igValue23);

                    ruleControl1.setRuleControlIg(igList1);
                    ruleControl2.setRuleControlIg(igList2);

                    Rule result = new Rule();
                    result.setRuleContext(rulecontext);
                    result.setRuleControls(Arrays.asList(ruleControl1, ruleControl2));

                    if (rowMap.get("Title") != null) {
                        result.setRuleName(rowMap.get("Title"));
                    }
                    if (rowMap.get("Assessment Status") != null) {
                        result.setRuleCategory(rowMap.get("Assessment Status"));
                    }
                    if (rowMap.get("Remediation Procedure") != null) {
                        result.setRuleAutoRemediation(rowMap.get("Remediation Procedure"));
                    }
                    if (rowMap.get("Rationale Statement") != null) {
                        result.setRuleRationale(rowMap.get("Rationale Statement"));
                    }
                    if (rowMap.get("Description") != null) {
                        result.setRuleDescription(rowMap.get("Description"));
                    }
                    if (rowMap.get("Rule Severity") != null) {
                        result.setRuleSeverity(rowMap.get("Rule Severity"));
                    }
                    if (rowMap.get("Impact Statement") != null) {
                        result.setRuleImpact(rowMap.get("Impact Statement"));
                    }
                    if (rowMap.get("Default Value") != null) {
                        result.setRuleDefaultValue(rowMap.get("Default Value"));
                    }
                    if (rowMap.get("References") != null) {
                        result.setRuleReferences(rowMap.get("References"));
                    }

                    resultList.add(result);
                }
            }

//            resultList.forEach(System.out::println);
            File outputfile = new File("outputfile.json");
            objectMapper.writeValue(outputfile, resultList);
            System.out.println("JSON file created successfully: " + outputfile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error while reading the CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public  static List<String> collectStringsWithX(String ig1, String ig2, String ig3) {
        List<String> result = new ArrayList<>();

        if ("X".equals(ig1)) {
            result.add("ig1");
        }
        if ("X".equals(ig2)) {
            result.add("ig2");
        }
        if ("X".equals(ig3)) {
            result.add("ig3");
        }
        return result;
    }


}