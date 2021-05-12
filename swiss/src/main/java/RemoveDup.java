import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDup {



    public static <E> List<E> removeDuplicates(List<E> list) {
        Set<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

}
