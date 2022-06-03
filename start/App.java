package start;

import java.util.Scanner;

import commands.*;
import utility.*;




/**
 * Main application class. Creates all instances and runs the program.
 */
public class App {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            final String envVariable = "LABA";

            WorkerAsker workerAsker = new WorkerAsker(userScanner);
            FileManager fileManager = new FileManager(envVariable);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, workerAsker),
                    new UpdateCommand(collectionManager, workerAsker),
                    new RemoveByIdCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExitCommand(),
                    new ExecuteScriptCommand(),
                    new RemoveFirstCommand(collectionManager),
                    new RemoveLowerCommand(collectionManager,workerAsker),
                    new SumOfSalaryCommand(collectionManager),
                    new ClearCommand(collectionManager),
                    new CountGreaterThanPositionCommand(collectionManager),
                    new SortCommand(collectionManager)
            );


            Console console = new Console(commandManager, userScanner, workerAsker);

            console.interactiveMode();
        }
    }
}
