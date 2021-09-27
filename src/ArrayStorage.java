import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int newResumeIndex = size();
        storage[newResumeIndex] = r;
    }

    Resume get(String uuid) {
        Resume[] filledStorage = getAll();
        return Arrays.stream(filledStorage).filter(resume -> uuid.equals(resume.toString())).findAny().orElse(null);
    }

    void delete(String uuid) {
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                for (int j = i; j < storageSize - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[storageSize - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] filledStorage = new Resume[size()];
        for (int i = 0; i < filledStorage.length; i++) {
            filledStorage[i] = storage[i];
        }

        return filledStorage;
    }

    int size() {
        int resumeCounter = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }

            resumeCounter++;
        }

        return resumeCounter;
    }
}
