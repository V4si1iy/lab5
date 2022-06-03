package utility;

import java.util.NoSuchElementException;
import java.util.Scanner;

import data.*;

import exceptions.IncorrectInputInScriptException;
import exceptions.MustBeNotEmptyException;
import exceptions.NotInDeclaredLimitsException;
import start.App;

/**
 * Asks a user a marine's value.
 */
public class WorkerAsker {
    private final int MIN_X = -243;
    private final double MIN_SALARY= 0;
    private final long MIN_AnnualTurnover = 0;
    private final long MIN_Employees = 0;

    private Scanner userScanner;
    private boolean fileMode;

    public WorkerAsker(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    /**
     * Sets a scanner to scan user input.
     * @param userScanner Scanner to set.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets worker asker mode to 'File Mode'.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Sets worker asker mode to 'User Mode'.
     */
    public void setUserMode() {
        fileMode = false;
    }

    /**
     * Asks a user the worker's name.
     * @return worker's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */

    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }
    /**
     * Asks a user the worker's X coordinate.
     * @return worker's X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askX() throws IncorrectInputInScriptException {
        String strX;
        double x;
        while (true) {
            try {
                Console.println("Введите координату X:");
                Console.print(App.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Double.parseDouble(strX);
                if (x < MIN_X) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата X не может быть меньше " + MIN_X + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * Asks a user the Worker's Y coordinate.
     * @return worker's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askY() throws IncorrectInputInScriptException {
        String strY;
        double y;
        while (true) {
            try {
                Console.println("Введите координату Y:");
                Console.print(App.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Double.parseDouble(strY);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }

    /**
     * Asks a user the worker's coordinates.
     * @return Worker's coordinates.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Cordinates askCoordinates() throws IncorrectInputInScriptException {
        int x;
        double y;
        x = (int) askX();
        y = askY();
        return new Cordinates(x, y);
    }

    /**
     * Asks a user the worker's salary.
     * @return Worker's salary.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Long askSalary() throws IncorrectInputInScriptException {
        String strSalary;
        Long salary;
        while (true) {
            try {
                Console.println("Введите зарплату:");
                Console.print(App.PS2);
                strSalary = userScanner.nextLine().trim();
                if (fileMode) Console.println(strSalary);
                salary = Long.parseLong(strSalary);
                if (salary < MIN_SALARY) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Зарплата не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Зарплата должна быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Зарплата должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return salary;
    }

    /**
     * Asks a user the worker's position.
     * @return Worker's position.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Position askPosition() throws IncorrectInputInScriptException {
        String strPosition;
        Position post;
        while (true) {
            try {
                Console.println("Список профессий - " + Position.nameList());
                Console.println("Введите профессию:");
                Console.print(App.PS2);
                strPosition = userScanner.nextLine().trim();
                if (fileMode) Console.println(strPosition);
                post = Position.valueOf(strPosition.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Профессия не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Профессия нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return post;
    }

    /**
     * Asks a user the worker's status.
     * @return worker's status.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Status askStatus() throws IncorrectInputInScriptException {
        String strStatus;
        Status stat;
        while (true) {
            try {
                Console.println("Список статусов - " + Status.nameList());
                Console.println("Введите статус :");
                Console.print(App.PS2);
                strStatus = userScanner.nextLine().trim();
                if (fileMode) Console.println(strStatus);
                stat = Status.valueOf(strStatus.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Статус не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Статус нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return stat;
    }

    /**
     * Asks a user the Organization Type.
     * @return Organization Type.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public OrganizationType askOrganizationType() throws IncorrectInputInScriptException {
        String strOrganizationType;
        OrganizationType type;
        while (true) {
            try {
                Console.println("Список видов компаний - " + OrganizationType.nameList());
                Console.println("Введите вид компании:");
                Console.print(App.PS2);
                strOrganizationType = userScanner.nextLine().trim();
                if (fileMode) Console.println(strOrganizationType);
                type = OrganizationType.valueOf(strOrganizationType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Компания не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Компания в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Компания ошибка!");
                System.exit(0);
            }
        }
        return type;
    }

    /**
     * Asks a user the worker Organization's name.
     * @return Organization's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public String askOrganizationName() throws IncorrectInputInScriptException {
        String OrganizationName;
        while (true) {
            try {
                Console.println("Введите имя компании:");
                Console.print(App.PS2);
                OrganizationName = userScanner.nextLine().trim();
                if (fileMode) Console.println(OrganizationName);
                if (OrganizationName.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя компании не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя компании не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return OrganizationName;
    }

    /**
     * Asks a user the worker Organization's annual Turnover.
     * @return annual Turnover.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public int askAnnualTurnoverCount() throws IncorrectInputInScriptException {
        String strAnnualTurnover;
        double annualTurnover;
        while (true) {
            try {
                Console.println("Введите оборот компании > " + (MIN_AnnualTurnover) + ":");
                Console.print(App.PS2);
                strAnnualTurnover = userScanner.nextLine().trim();
                if (fileMode) Console.println(strAnnualTurnover);
                annualTurnover = Double.parseDouble(strAnnualTurnover);
                if (annualTurnover < MIN_AnnualTurnover) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Оборот не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Оборот должен быть больше " +MIN_AnnualTurnover + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Оборот должен быть представлен числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return (int)annualTurnover;
    }
    /**
     * Asks a user the worker Organization's number of employees.
     * @return number of employees.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Integer askemployeesCount() throws IncorrectInputInScriptException {
        String strEmployeesCount;
        Integer employeesCount;
        while (true) {
            try {
                Console.println("Введите количество работников компании > " + (MIN_Employees) + ":");
                Console.print(App.PS2);
                strEmployeesCount = userScanner.nextLine().trim();
                if (fileMode) Console.println(strEmployeesCount);
                employeesCount = Integer.parseInt(strEmployeesCount);
                if (employeesCount < MIN_Employees ) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Количество работников не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Количество работников должно быть положительным!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Количество работников должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return employeesCount;
    }



    /**
     * Asks a user the worker's Organization.
     * @return Worker's Organization.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public Organization askOrganization() throws IncorrectInputInScriptException {
        String name;
        int annualTurnover;
        Integer employeesCount;
        OrganizationType type;
        name = askOrganizationName();
        annualTurnover = askAnnualTurnoverCount();
        employeesCount = askemployeesCount();
        type=askOrganizationType();
        return new Organization(name, annualTurnover,employeesCount,type);
    }

    /**
     * Asks a user a question.
     * @return Answer (true/false).
     * @param question A question.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public boolean askQuestion(String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(App.PS2);
                answer = userScanner.nextLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }

    @Override
    public String toString() {
        return "WorkerAsker (вспомогательный класс для запросов пользователю)";
    }
}