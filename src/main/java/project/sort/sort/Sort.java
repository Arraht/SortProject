package project.sort.sort;

import java.util.ArrayList;

public interface Sort {
    void sortAll();

    void sortForCount(int count);

    ArrayList<?> createBySize(int size);
}