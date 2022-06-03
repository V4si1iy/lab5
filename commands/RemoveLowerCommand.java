package commands;

import java.time.LocalDateTime;

import data.Worker;
import exceptions.CollectionEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'remove_lower'. Removes elements lower than user entered.
 */
public class RemoveLowerCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public RemoveLowerCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
        this.workerAsker = workerAsker;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionEmptyException();
            Worker marineToFind = new Worker(
                    collectionManager.generateNextId(),
                    workerAsker.askName(),
                    workerAsker.askCoordinates(),
                    LocalDateTime.now(),
                    workerAsker.askSalary(),
                    workerAsker.askPosition(),
                    workerAsker.askStatus(),
                    workerAsker.askOrganization()

            );
            Worker marineFromCollection = collectionManager.getByValue(marineToFind);
            if (marineFromCollection == null) throw new WorkerNotFoundException();
            collectionManager.removeLower(marineFromCollection);
            Console.println("Работники успешно удалены!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (WorkerNotFoundException exception) {
            Console.printerror("Работников с такими характеристиками в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}