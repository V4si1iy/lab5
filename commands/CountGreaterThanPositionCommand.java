package commands;

import data.Position;
import data.Worker;
import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'count_greater_than_position'. Filters the collection by weapon type.
 */
public class CountGreaterThanPositionCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public CountGreaterThanPositionCommand(CollectionManager collectionManager) {
        super("count_greater_than_position <positionType>", "вывести количество элементов, значение поля position которых больше заданного");
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
            if (collectionManager.collectionSize() == 0) throw new CollectionEmptyException();
            Position post = Position.valueOf(argument.toUpperCase());
            Long greatered = collectionManager.greaterPosition(post);
            Console.println(greatered);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return true;

    }
}