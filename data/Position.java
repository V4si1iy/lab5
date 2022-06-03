package data;
/**
 * Enumeration with position in work  .
 */
public enum Position {
    DIRECTOR,
    HEAD_OF_DEPARTMENT,
    LEAD_DEVELOPER,
    CLEANER;

    /**
     * Generates a beautiful list of enum string values.
     * @return String with all enum values separated by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (Position post : values()) {
            nameList += post.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}
