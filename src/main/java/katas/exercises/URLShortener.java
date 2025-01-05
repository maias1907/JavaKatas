package katas.exercises;

import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    /**
     * A URL Shortener is a service that converts a long URL into a shorter, more manageable URL.
     * Implement a simple URL shortener system with the following functionality:
     *
     *  - Convert a long URL into a short URL.
     *  - Retrieve the original long URL from a given short URL.
     *  - The system should handle the cases where multiple long URLs may share the same short URL, such as through hash collisions (you can assume no collisions for simplicity in this exercise).
     *  - The class should use a hash map to store the mapping between short and long URLs.
     *  - The short URL should be a base62 string (characters A-Z, a-z, 0-9).
     */

    private Map<String, String> urlMap;
    private static final String BASE_URL = "http://short.ly/";

    /**
     * Constructor to initialize the URL shortener system.
     */
    public URLShortener() {
        urlMap = new HashMap<>();
    }

    /**
     * Shortens the provided long URL.
     *
     * @param longUrl the long URL to shorten
     * @return the shortened URL
     */
    public String shorten(String longUrl) {
        // Implement logic to shorten the URL
        return null;
    }

    /**
     * Retrieves the original long URL from the shortened URL.
     *
     * @param shortUrl the shortened URL
     * @return the original long URL
     */
    public String retrieve(String shortUrl) {
        return urlMap.get(shortUrl); // Implement logic to retrieve long URL
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl = shortener.shorten(longUrl);

        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Original URL: " + shortener.retrieve(shortUrl));
    }
}

