package commands;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;

import data.*;

import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'update'. Updates the information about selected marine.
 */
public class SortCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public SortCommand(CollectionManager collectionManager) {
        super("sort", "отсортировать коллекцию в естественном порядке");
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
            collectionManager.sortCollection();
            Console.println("Коллекция успешно отсортирована!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }  {}
        return false;
    }

}