package utility;

import java.util.ArrayList;
import java.util.List;

import commands.Command;



/**
 * Operates the commands.
 */
public class CommandManager {
    private List<Command> commands = new ArrayList<>();
    private Command helpCommand;
    private Command infoCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command removeByIdCommand;
    private Command clearCommand;
    private Command saveCommand;
    private Command exitCommand;
    private Command executeScriptCommand;
    private Command removeFirstCommand;
    private Command removeLowerCommand;
    private Command sumOfSalaryCommand;
    private Command countGreaterThanPositionCommand;
    private Command sortCommand;



    public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command addCommand, Command updateCommand,
                          Command removeByIdCommand, Command saveCommand, Command exitCommand, Command executeScriptCommand,Command removeFirstCommand,
                          Command removeLowerCommand,Command sumOfSalaryCommand,Command clearCommand, Command countGreaterThanPositionCommand, Command sortCommand) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.removeFirstCommand=removeFirstCommand;
        this.sumOfSalaryCommand=sumOfSalaryCommand;
        this.clearCommand=clearCommand;
        this.countGreaterThanPositionCommand=countGreaterThanPositionCommand;
        this.sortCommand = sortCommand;

        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(addCommand);
        commands.add(updateCommand);
        commands.add(removeByIdCommand);
        commands.add(saveCommand);
        commands.add(exitCommand);
        commands.add(executeScriptCommand);
        commands.add(removeFirstCommand);
        commands.add(removeLowerCommand);
        commands.add(sumOfSalaryCommand);
        commands.add(countGreaterThanPositionCommand);
        commands.add(sortCommand);
    }



    /**
     * @return List of manager's commands.
     */
    public List<Command> getCommands() {
        return commands;
    }



    /**
     * Prints that command is not found.
     * @param command Comand, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }

    /**
     * Prints info about the all commands.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean add(String argument) {
        return addCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeFirst(String argument) {
        return removeFirstCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeLower(String argument) {
        return removeLowerCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean countGreaterThanPositionCommand(String argument) {return countGreaterThanPositionCommand.execute((argument));}

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean sumOfSalary(String argument) {
        return sumOfSalaryCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean sort(String argument) {
        return sortCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager (вспомогательный класс для работы с командами)";
    }
}