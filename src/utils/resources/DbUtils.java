package utils.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DbUtils {
    public static String getPredicate(List<String> predicate) {
        if (predicate.isEmpty()) {
            return "";
        }
        return String.join(" AND ", predicate);
    }

    public static String getJoins(Map<String, String> joins) {

        if (joins.isEmpty()) {
            return "";
        }
        List<String> joinStr = new ArrayList<>();
        Set<Map.Entry<String, String>> entity = joins.entrySet();
        for (Map.Entry<String, String> ent : entity) {
            joinStr.add(String.format("JOIN %s ON %s", ent.getKey(), ent.getValue()));
        }
        return String.join(" ", joinStr);
    }
}