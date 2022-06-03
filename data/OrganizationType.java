package data;
/**
 * Enumeration of organisations.
 */
public enum OrganizationType {
    PUBLIC,
    GOVERNMENT,
    TRUST;
    /**
     * Generates a beautiful list of enum string values.
     * @return String with all enum values separated by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (OrganizationType organized : values()) {
            nameList += organized.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
