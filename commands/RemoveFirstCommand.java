package commands;

import data.Worker;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import exceptions.CollectionEmptyException;
import utility.CollectionManager;
import utility.Console;

/**
 * Command 'remove_first'. Removes the first element.
 */
public class RemoveFirstCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager collectionManager) {
        super("remove_first", "удалить первый элемент из коллекции ");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionEmptyException();
            Worker workerToRemove = collectionManager.getFirst();
            if (workerToRemove == null) throw new WorkerNotFoundException();
            collectionManager.removeFromCollection(workerToRemove);
            Console.println("Работник успешно удален!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (WorkerNotFoundException exception) {
            Console.printerror("Работника с таким ID в коллекции нет!");
        }
        return false;
    }
}
