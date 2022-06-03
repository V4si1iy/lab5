package data;
/**
 * Enumeration with status of worker.
 */
public enum Status {
    FIRED,
    HIRED,
    RECOMMENDED_FOR_PROMOTION,
    PROBATION;
    /**
     * Generates a beautiful list of enum string values.
     * @return String with all enum values separated by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (Status statusType : values()) {
            nameList += statusType.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
