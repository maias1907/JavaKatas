package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import katas.exercises.SemanticVersionComparator;
import org.junit.jupiter.api.Test;

public class SemanticVersionComparatorTest {

    @Test
    void testCompareVersions() {
        // Equal versions
        assertEquals(0, SemanticVersionComparator.compareVersions("1.0.0", "1.0.0"), "Equal versions should return 0");
        assertEquals(0, SemanticVersionComparator.compareVersions("2.3.4", "2.3.4"), "Equal versions should return 0");

        // Version1 greater
        assertEquals(1, SemanticVersionComparator.compareVersions("2.0.0", "1.9.9"), "Version1 > Version2 (MAJOR difference)");
        assertEquals(1, SemanticVersionComparator.compareVersions("1.2.0", "1.1.9"), "Version1 > Version2 (MINOR difference)");
        assertEquals(1, SemanticVersionComparator.compareVersions("1.0.1", "1.0.0"), "Version1 > Version2 (PATCH difference)");

        // Version2 greater
        assertEquals(-1, SemanticVersionComparator.compareVersions("1.0.0", "2.0.0"), "Version1 < Version2 (MAJOR difference)");
        assertEquals(-1, SemanticVersionComparator.compareVersions("1.1.9", "1.2.0"), "Version1 < Version2 (MINOR difference)");
        assertEquals(-1, SemanticVersionComparator.compareVersions("1.0.0", "1.0.1"), "Version1 < Version2 (PATCH difference)");

        // Different lengths
        assertEquals(0, SemanticVersionComparator.compareVersions("1.0.0", "1.0"), "Versions with missing PATCH should be equal");
        assertEquals(1, SemanticVersionComparator.compareVersions("1.1.0", "1.0"), "Version1 > Version2 (MINOR difference)");
        assertEquals(-1, SemanticVersionComparator.compareVersions("1.0", "1.0.1"), "Version1 < Version2 (PATCH difference)");

        // Leading zeros
        assertEquals(0, SemanticVersionComparator.compareVersions("01.01.01", "1.1.1"), "Leading zeros should be ignored");
        assertEquals(1, SemanticVersionComparator.compareVersions("1.02.0", "1.1.9"), "Version1 > Version2 (MINOR difference)");
        assertEquals(0, SemanticVersionComparator.compareVersions("1.0.01", "1.0.1"), "Versions with leading zeros in PATCH should be equal");

        // Invalid inputs
        assertThrows(NumberFormatException.class, () -> SemanticVersionComparator.compareVersions("1.a.0", "1.0.0"), "Invalid inputs should throw exception");
        assertThrows(NumberFormatException.class, () -> SemanticVersionComparator.compareVersions("1..0", "1.0.0"), "Invalid inputs should throw exception");
    }
}
