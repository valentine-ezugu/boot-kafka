import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionNumberComapatorTest {

    VersionNumberComparator v = new VersionNumberComparator();

    @Test
    public void test () {
        int compare = v.compare("15.0", "15");
        assertEquals(0, compare);
    }
}
