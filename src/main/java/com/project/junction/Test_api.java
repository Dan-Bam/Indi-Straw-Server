package com.project.junction;

import com.project.junction.dto.Dto;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Controller
public class Test_api {

    @PostMapping("translte/{from}/{to}")
    @ResponseBody
    public String testServiceApi(@PathVariable("from") String from, @PathVariable("to") String to, @RequestBody Dto dto) throws Exception {

        StringBuilder result = new StringBuilder();

        try {
            HashMap<String, String> map = new HashMap();
            map.put("Text", dto.getText());
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(map);

            URL url = new URL("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&from="+ from +"&to=" + to); // 호출할 외부 API 를 입력한다.

            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // header에 데이터 통신 방법을 지정한다.
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Ocp-Apim-Subscription-Region", "eastus");
            conn.setRequestProperty("Ocp-Apim-Subscription-Key", "f0b0a912c7a04200b35c7e4a21f6956b");

            // Post인 경우 데이터를 OutputStream으로 넘겨 주겠다는 설정
            conn.setDoOutput(true);
//
            // Request body message에 전송
            OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
            os.write(jsonArray.toString());
            os.flush();

            // 응답
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                result.append(returnLine+"\n\r");
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}