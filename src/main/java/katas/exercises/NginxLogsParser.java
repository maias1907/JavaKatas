package katas.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NginxLogsParser {

    /**
     * Parses a single Nginx access log entry into a structured map.
     *
     * The log format is:
     * 122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] "GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1" 200 1684 "-" "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00"
     *
     * The parsed log data should be returned as a map:
     * {
     *   "client_ip": "122.176.223.47",
     *   "date": "05/Feb/2024:08:29:40 +0000",
     *   "http_method": "GET",
     *   "path": "/web-enabled/Enhanced-portal/bifurcated-forecast.js",
     *   "http_version": "1.1",
     *   "status": "200",
     *   "response_bytes": "1684",
     *   "user_agent": "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00"
     * }
     *
     * Hint: Use regex
     *
     * @param log the Nginx log string
     * @return a map containing parsed log data
     * @throws IllegalArgumentException if the log format is invalid
     */
    public static Map<String, String> parseLog(String log) {
        Map<String, String> parsedData = new HashMap<>();
        return parsedData;
    }

    public static void main(String[] args) {
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        Map<String, String> parsedLog = parseLog(logEntry);
        System.out.println("Parsed log data: " + parsedLog);
    }
}
