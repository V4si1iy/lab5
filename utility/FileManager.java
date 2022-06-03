package utility;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import data.Worker;

/**
 * Operates the file for saving/loading collection.
 */
public class FileManager<export> {
    private Gson gson = new Gson();
    private String envVariable;

    public FileManager(String envVariable) {
        this.envVariable = envVariable;
    }

    /**
     * Writes collection to a file.
     * @param collection Collection to write.
     */
    public void writeCollection(Collection<?> collection) {
        if (System.getenv(envVariable) != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv(envVariable)))) {
                collectionFileWriter.write(gson.toJson(collection));
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }

    /**
     * Reads collection from a file.
     * @return Readed collection.
     */


    public ArrayList<Worker> readCollection() {
        if (System.getenv(envVariable) != null) {
            try (Scanner collectionFileScanner = new Scanner(new File(System.getenv(envVariable)))) {
                ArrayList<Worker> collection;
                Type collectionType = new TypeToken<ArrayList<Worker>>(){}.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                Console.println("Коллекция успешна загружена!");
                return collection;
            } catch (FileNotFoundException exception) {
                Console.printerror("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                Console.printerror("Загрузочный файл пуст!");
            } catch (JsonParseException | NullPointerException exception) {
                Console.printerror("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
        return new ArrayList<Worker>();
    }

    @Override
    public String toString() {
        String string = "FileManager (класс для работы с загрузочным файлом)";
        return string;
    }
}
