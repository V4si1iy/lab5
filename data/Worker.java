package data;

import java.time.LocalDateTime;
/**
 * Main character. Is stored in the collection.
 */
public class Worker {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Cordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long salary; //Поле не может быть null, Значение поля должно быть больше 0
    private Position position; //Поле не может быть null
    private Status status; //Поле может быть null
    private Organization organization; //Поле может быть null

    public Worker(Long id, String name, Cordinates coordinates, LocalDateTime creationDate, Long salary, Position position,Status status, Organization organization){
        this.id=id;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=creationDate;
        this.salary=salary;
        this.position=position;
        this.status=status;
        this.organization=organization;
    }

    /**
     * @return ID of the worker.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return Name of the worker.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Coordinates of the worker.
     */
    public Cordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return Creation date of the marine.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return Amount of salary.
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * @return Position of the worker.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return Status of the worker.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @return All about organization.
     */
    public Organization getOrganization() {
        return organization;
    }


    public int compareTo(Worker workObj) {
        return id.compareTo(workObj.getId());
    }

    @Override
    public String toString() {
        String info = "";
        info += "Рабочий №" + id;
        info += "\n Имя: " + name;
        info += "\n Местоположение: " + coordinates;
        info += " (добавлен " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Зарплата: " + salary;
        info += "\n Должность: " + position;
        info += "\n Статус: " + status;
        info += "\n Организация: " + organization;
        return info;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + coordinates.hashCode() + salary.hashCode() + position.hashCode() + status.hashCode() + organization.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Worker) {
            Worker workObj = (Worker) obj;
            return name.equals(workObj.getName()) && coordinates.equals(workObj.getCoordinates()) &&
                    (salary == workObj.getSalary()) && position.equals(workObj.getPosition()) && status.equals(workObj.getStatus()) && organization.equals(workObj.getOrganization());
        }
        return false;
    }
}
