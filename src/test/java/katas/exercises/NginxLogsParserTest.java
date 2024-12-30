package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NginxLogsParserTest {
    @Test
    void testParseLog() {
        // Test 1: Valid log entry
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        Map<String, String> parsedLog = NginxLogsParser.parseLog(logEntry);
        assertEquals("122.176.223.47", parsedLog.get("client_ip"), "Client IP should match");
        assertEquals("05/Feb/2024:08:29:40 +0000", parsedLog.get("date"), "Date should match");
        assertEquals("GET", parsedLog.get("http_method"), "HTTP method should match");
        assertEquals("/web-enabled/Enhanced-portal/bifurcated-forecast.js", parsedLog.get("path"), "Path should match");
        assertEquals("1.1", parsedLog.get("http_version"), "HTTP version should match");
        assertEquals("200", parsedLog.get("status"), "Status code should match");
        assertEquals("1684", parsedLog.get("response_bytes"), "Response bytes should match");
        assertEquals("Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00", parsedLog.get("user_agent"), "User Agent should match");

        // Test 2: Invalid log entry
        String invalidLog = "Invalid log entry that does not match the pattern";
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(invalidLog), "Invalid log format should throw exception");

        // Test 3: Empty log
        String emptyLog = "";
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(emptyLog), "Empty log should throw exception");

        // Test 4: Log with missing fields
        String logWithMissingFields = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] \"GET /web-enabled/Enhanced-portal HTTP/1.1\" 200 1684";
        assertThrows(IllegalArgumentException.class, () -> NginxLogsParser.parseLog(logWithMissingFields), "Log with missing fields should throw exception");

        // Test 5: Log with unexpected characters
        String logWithUnexpectedCharacters = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /unexpected?param=<script>alert(1)</script> HTTP/1.1\" 200 500 " +
                "\"-\" \"Browser/5.0\"";

        Map<String, String> parsedLogWithUnexpectedChars = NginxLogsParser.parseLog(logWithUnexpectedCharacters);
        assertEquals("122.176.223.47", parsedLogWithUnexpectedChars.get("client_ip"), "Client IP should match");
        assertEquals("05/Feb/2024:08:29:40 +0000", parsedLogWithUnexpectedChars.get("date"), "Date should match");
        assertEquals("GET", parsedLogWithUnexpectedChars.get("http_method"), "HTTP method should match");
        assertEquals("/unexpected?param=<script>alert(1)</script>", parsedLogWithUnexpectedChars.get("path"), "Path should match");
        assertEquals("1.1", parsedLogWithUnexpectedChars.get("http_version"), "HTTP version should match");
        assertEquals("200", parsedLogWithUnexpectedChars.get("status"), "Status code should match");
        assertEquals("500", parsedLogWithUnexpectedChars.get("response_bytes"), "Response bytes should match");
        assertEquals("Browser/5.0", parsedLogWithUnexpectedChars.get("user_agent"), "User Agent should match");
    }
}
