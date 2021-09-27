import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int storageSize = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
        storageSize = 0;
    }

    void save(Resume r) {
        storage[storageSize] = r;
        storageSize++;
    }

    Resume get(String uuid) {
        return Arrays.stream(storage).limit(storageSize).filter(resume -> uuid.equals(resume.toString())).findAny().orElse(null);
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                for (int j = i; j < storageSize - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[storageSize - 1] = null;
                storageSize--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] filledStorage = new Resume[storageSize];
        for (int i = 0; i < filledStorage.length; i++) {
            filledStorage[i] = storage[i];
        }

        return filledStorage;
    }

    int size() {
       return storageSize;
    }
}
