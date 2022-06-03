package data;

public class Organization {
    private String fullName; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
    private int annualTurnover; //Значение поля должно быть больше 0
    private Integer employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null

    public Organization(String fullName, int annualTurnover, Integer employeesCount, OrganizationType type){
        this.fullName=fullName;
        this.annualTurnover=annualTurnover;
        this.employeesCount=employeesCount;
        this.type=type;
    }

    /**
     * @return Name of the organization.
     */
    public String getName() {
        return fullName;
    }

    /**
     * @return Number of money in year.
     */
    public int getAnnualTurnover() {
        return annualTurnover;
    }

    /**
     * @return Number of employees.
     */
    public Integer getEmployeesCount() {
        return employeesCount;
    }

    /**
     * @return Type of organization.
     */
    public OrganizationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return fullName + " (" + annualTurnover + " в год, " + employeesCount + " рабочих, " + type + ")";
    }

    @Override
    public int hashCode() {
        return fullName.hashCode() + annualTurnover + employeesCount + type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Organization) {
            Organization organizationObj = (Organization) obj;
            return fullName.equals(organizationObj.getName()) && (annualTurnover == organizationObj.getAnnualTurnover()) && (employeesCount == organizationObj.getEmployeesCount()) && type.equals(organizationObj.getType());
        }
        return false;
    }
}

