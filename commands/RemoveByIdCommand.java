package commands;

import data.Worker;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import exceptions.CollectionEmptyException;
import utility.CollectionManager;
import utility.Console;

/**
 * Command 'remove_by_id'. Removes the element by its ID.
 */
public class RemoveByIdCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
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
            Long id = Long.parseLong(argument);
            Worker workerToRemove = collectionManager.getById(id);
            if (workerToRemove == null) throw new WorkerNotFoundException();
            collectionManager.removeFromCollection(workerToRemove);
            Console.println("Солдат успешно удален!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (WorkerNotFoundException exception) {
            Console.printerror("Работника с таким ID в коллекции нет!");
        }
        return false;
    }
}
