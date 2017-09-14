package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void isAnyNull() throws Exception {
        // Contains some Null objects
        assertHasNull("abc", null);
        assertHasNull("abc", 1, null);
        assertHasNull("abc", 1, null, 2, null, 3, null, null);

        // No Null object
        assertHasNoNull("abc");
        assertHasNoNull("abc", 1);
        assertHasNoNull("abc", 1, 2, "def");
        assertHasNoNull("abc", 1, 2, "def");

        // Empty
        assertHasNoNull();
    }

    private void assertHasNull(Object... objects)   { assertTrue(Utils.isAnyNull(objects)); };

    private void assertHasNoNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); };

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
