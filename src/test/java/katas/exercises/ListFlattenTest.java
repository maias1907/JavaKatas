package katas.exercises;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListFlattenTest {
    @Test
    public void testListFlatten(){
        // Test case 1: Flatten a basic nested list (integers and lists)
        List<Object> nestedList1 = List.of(1, List.of(2, 3), List.of(4, List.of(5, 6)), 7);
        List<Integer> expected1 = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expected1, ListFlatten.flattenList(nestedList1));

        // Test case 2: Flatten a deeply nested list
        List<Object> nestedList2 = List.of(1, List.of(2, List.of(3, List.of(4, 5))));
        List<Integer> expected2 = List.of(1, 2, 3, 4, 5);
        assertEquals(expected2, ListFlatten.flattenList(nestedList2));

        // Test case 3: Flatten an empty list
        List<Object> nestedList3 = List.of();
        List<Integer> expected3 = List.of();
        assertEquals(expected3, ListFlatten.flattenList(nestedList3));

        // Test case 4: Flatten a list with only integers
        List<Object> nestedList4 = List.of(1, 2, 3, 4);
        List<Integer> expected4 = List.of(1, 2, 3, 4);
        assertEquals(expected4, ListFlatten.flattenList(nestedList4));

        // Test case 5: Flatten a list with an empty nested list
        List<Object> nestedList5 = List.of(1, List.of(), 2);
        List<Integer> expected5 = List.of(1, 2);
        assertEquals(expected5, ListFlatten.flattenList(nestedList5));

        // Test case 6: Flatten a list with only nested lists
        List<Object> nestedList6 = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> expected6 = List.of(1, 2, 3, 4);
        assertEquals(expected6, ListFlatten.flattenList(nestedList6));

        // Test case 7: Test with a null list (this will throw an exception, so it's handled differently)
        List<Object> nestedList7 = null;
        assertThrows(NullPointerException.class, () -> {
            ListFlatten.flattenList(nestedList7);
        });


    }
}
