package tables;

import java.util.List;
import java.util.Map;

public interface Itable<T> {
    List<T> list(List<String> predicate, Map<String, String> joinPredicates);
}
