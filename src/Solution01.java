import llm.*;
import slack.Slack;

import java.util.logging.Level;


public class Solution01 {
    public static void main(String[] args) {
        LLM llm = new LLM();
        llm.setLoggerLevel(Level.SEVERE);
        String prompt = System.getenv("GEMINI_PROMPT");
        String result = llm.callAPI(LLM.LLMModel.GEMINI_2_0_FLASH, """
                {
                  "contents": [
                    {
                      "role": "user",
                      "parts": [
                        {
                          "text": "%s"
                        }
                      ]
                    }
                  ],
                }
                """.formatted(prompt));
        System.out.println(result.split("\"text\": ")[1].split("}")[0].replace("\\n", " ").replace("\"", "").trim());




        // 과제
        Slack slack = new Slack();
    }
}






