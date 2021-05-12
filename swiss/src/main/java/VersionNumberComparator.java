import java.util.Arrays;
import java.util.Comparator;

public class VersionNumberComparator implements Comparator<String> {

    // "14.4.2" > 13.13.13

    @Override
    public int compare(String version1, String version2) {

        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        Integer[] array1 = Arrays.stream(version1Array).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] array2 = Arrays.stream(version2Array).map(Integer::parseInt).toArray(Integer[]::new);
        int idx = 0;
        while (idx < array1.length || idx < array2.length) {
            if (idx < array1.length && idx < array2.length) {
                if (array1[idx] > array2[idx]) {
                    return 1;
                } else if (array1[idx] < array2[idx]) {
                    return -1;
                }
            }
            idx++;
        }
        return 0;
    }
}
