package utility;

import java.time.LocalDateTime;
import java.util.*;

import data.Position;
import data.Worker;

import exceptions.CollectionEmptyException;

import javax.naming.Name;

/**
 * Operates the collection itself.
 */
public class CollectionManager {
    private ArrayList<Worker> workersCollection =  new ArrayList();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    /**
     * @return The collecton itself.
     */
    public ArrayList<Worker> getCollection() {
        return workersCollection;
    }

    /**
     * @return Last initialization time or null if there wasn't initialization.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Last save time or null if there wasn't saving.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * @return Name of the collection's type.
     */
    public String collectionType() {
        return workersCollection.getClass().getName();
    }

    /**
     * @return Size of the collection.
     */
    public int collectionSize() {
        return workersCollection.size();
    }

    /**
     * @return The first element of the collection or null if collection is empty.
     */
    public Worker getFirst() {
        if (workersCollection.isEmpty()) return null;
        return workersCollection.get(0);
    }

    /**
     * @param id ID of the worker.
     * @return A worker by his ID or null if worker isn't found.
     */
    public Worker getById(Long id) {
        for (Worker work : workersCollection) {
            if (work.getId().equals(id)) return work;
        }
        return null;
    }

    /**
     * @param workToFind A worker who's value will be found.
     * @return A worker by his value or null if worker isn't found.
     */
    public Worker getByValue(Worker workToFind) {
        for (Worker work : workersCollection) {
            if (work.equals(workToFind)) return work;
        }
        return null;
    }

    /**
     * @return Sum of all workers' salary or 0 if collection is empty.
     */
    public double getSumOfSalary() {
        double sumOfSalary = 0;
        for (Worker work : workersCollection) {
            sumOfSalary += work.getSalary();
        }
        return sumOfSalary;
    }

    /**
     * @return Count of worker greater than selected position.
     * @throws CollectionEmptyException If collection is empty.
     */
    public Long greaterPosition(Position postToCompare) throws CollectionEmptyException {
        if (workersCollection.isEmpty()) throw new CollectionEmptyException();

        Position greater = postToCompare;
        long countOfWorker=0;
        for (Worker work : workersCollection) {
            if (work.getPosition().compareTo(greater) > 0) {
                countOfWorker++;
            }
        }
        return countOfWorker;
    }



    /**
     * Adds a new worker to collection.
     * @param work A worker to add.
     */
    public void addToCollection(Worker work) {
        workersCollection.add(work);
    }

    /**
     * Removes a new worker to collection.
     * @param work A worker to remove.
     */
    public void removeFromCollection(Worker work) {
        workersCollection.remove(work);
    }

    /**
     * Remove workers lower than the selected one.
     * @param workerToCompare A worker to compare with.
     */
    public void removeLower(Worker workerToCompare) {
        workersCollection.removeIf(worker -> worker.compareTo(workerToCompare) < 0);
    }

    /**
     * Clears the collection.
     */
    public void clearCollection() {
        workersCollection.clear();
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     * @return Next ID.
     */
    public Long generateNextId() {

        if (workersCollection.isEmpty()) return 1L;
        return workersCollection.get(workersCollection.size()-1).getId() + 1;
    }

    /**
     * Saves the collection to file.
     */
    public void saveCollection() {
        fileManager.writeCollection(workersCollection);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Saves the collection to file.
     */
    public void sortCollection()
    {
        Collections.sort(workersCollection, Comparator.comparing(Worker::getStatus));
    }

    /**
     * Loads the collection from file.
     */
    private void loadCollection() {
        workersCollection = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (workersCollection.isEmpty()) return "Коллекция пуста!";

        String info = "";
        for (Worker work : workersCollection) {
            info += work;
            if (work != workersCollection.get(workersCollection.size()-1)) info += "\n\n";
        }
        return info;
    }
}