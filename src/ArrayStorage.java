import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = {new Resume("first"), new Resume("second"), new Resume("third")};

    void clear() {
        storage = Arrays.stream(storage).filter(resume -> resume != null).toArray(Resume[]::new);
    }

    void save(Resume r) {
        storage = Arrays.copyOf(storage, storage.length + 1);
        storage[storage.length - 1] = r;
    }

    Resume get(String uuid) {
        return Arrays.stream(storage).filter(resume -> uuid.equals(resume.toString())).findAny().orElse(null);
    }

    void delete(String uuid) {
        storage = Arrays.stream(storage).filter(resume -> !uuid.equals(resume.toString())).toArray(Resume[]::new);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return storage.length;
    }
}
