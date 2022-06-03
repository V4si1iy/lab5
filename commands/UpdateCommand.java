package commands;

import java.time.LocalDateTime;

import data.*;

import exceptions.CollectionEmptyException;
import exceptions.IncorrectInputInScriptException;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utility.CollectionManager;
import utility.Console;
import utility.WorkerAsker;

/**
 * Command 'update'. Updates the information about selected marine.
 */
public class UpdateCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public UpdateCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
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
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionEmptyException();

            Long id = Long.parseLong(argument);
            Worker oldWorker = collectionManager.getById(id);
            if (oldWorker == null) throw new WorkerNotFoundException();
            String name = oldWorker.getName();
            Cordinates coordinates = oldWorker.getCoordinates();
            LocalDateTime creationDate = oldWorker.getCreationDate();
            Long salary = oldWorker.getSalary();
            Position post = oldWorker.getPosition();
            Status status = oldWorker.getStatus();
            Organization organization = oldWorker.getOrganization();


            collectionManager.removeFromCollection(oldWorker);

            if (workerAsker.askQuestion("Хотите изменить имя работника?")) name = workerAsker.askName();
            if (workerAsker.askQuestion("Хотите изменить координаты работника?")) coordinates = workerAsker.askCoordinates();
            if (workerAsker.askQuestion("Хотите изменить здоровье работника?")) salary = workerAsker.askSalary();
            if (workerAsker.askQuestion("Хотите изменить должность работника?")) post = workerAsker.askPosition();
            if (workerAsker.askQuestion("Хотите изменить статус работника?")) status = workerAsker.askStatus();
            if (workerAsker.askQuestion("Хотите изменить организацию работника?")) organization = workerAsker.askOrganization();


            collectionManager.addToCollection(new Worker(
                    id,
                    name,
                    coordinates,
                    creationDate,
                    salary,
                    post,
                    status,
                    organization

            ));
            Console.println("Работник успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (WorkerNotFoundException exception) {
            Console.printerror("Солдата с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}