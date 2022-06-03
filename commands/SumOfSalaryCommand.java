package commands;

import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;

/**
 * Command 'sum_of_salary'. Prints the sum of salary of all workers.
 */
public class SumOfSalaryCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public SumOfSalaryCommand(CollectionManager collectionManager) {
        super("sum_of_salary", "вывести сумму значений поля salary для всех элементов коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            double sum_of_salary = collectionManager.getSumOfSalary();
            if (sum_of_salary == 0) throw new CollectionEmptyException();
            Console.println("Сумма зарплат всех рабочих: " + sum_of_salary);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}
