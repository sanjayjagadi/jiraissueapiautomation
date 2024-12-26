package com.qa.services;



import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestPayload {
    private String summary;
    private String description;
    private String issueTypeName;
    private List<String> labels;


    
    public static String toJson(RequestPayload payload) {
        // Handle null or empty labels list
        String labelsJson = (payload.getLabels() == null || payload.getLabels().isEmpty())
                ? ""
                : String.join("\", \"", payload.getLabels());

        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\"key\": \"QA\"},\n" +
                "        \"summary\": \"" + payload.getSummary() + "\",\n" +
                "        \"description\": \"" + payload.getDescription() + "\",\n" +
                "        \"issuetype\": {\"name\": \"" + payload.getIssueTypeName() + "\"},\n" +
                "        \"labels\": [" + (labelsJson.isEmpty() ? "" : "\"" + labelsJson + "\"") + "]\n" +
                "    }\n" +
                "}";
    }
}

