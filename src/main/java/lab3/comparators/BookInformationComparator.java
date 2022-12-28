package lab3.comparators;

import lab1.models.BookInformation;

import java.util.Comparator;

public class BookInformationComparator implements Comparator<BookInformation> {
    @Override
    public int compare(BookInformation o1, BookInformation o2) {
        return o1.getInfo().compareTo(o2.getInfo());
    }
}
