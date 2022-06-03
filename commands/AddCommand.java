package commands;

import java.time.LocalDateTime;

import data.Worker;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'add'. Adds a new element to collection.
 */
public class AddCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public AddCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("add {element}", "добавить новый элемент в коллекцию");
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
            collectionManager.addToCollection(new Worker(
                    collectionManager.generateNextId(),
                    workerAsker.askName(),
                    workerAsker.askCoordinates(),
                    LocalDateTime.now(),
                    workerAsker.askSalary(),
                    workerAsker.askPosition(),
                    workerAsker.askStatus(),
                    workerAsker.askOrganization()

            ));
            Console.println("Работник успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}