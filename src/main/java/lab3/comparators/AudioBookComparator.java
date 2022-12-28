package lab3.comparators;

import lab1.models.AudioBook;

import java.util.Comparator;

public class AudioBookComparator implements Comparator<AudioBook> {
    @Override
    public int compare(AudioBook o1, AudioBook o2) {
        int titleComp = o1.getTitle().compareTo(o2.getTitle());

        if(titleComp == 0){
            String firstAuthorFullName = o1.getAuthor().getName() + ' ' + o1.getAuthor().getSurname();
            String secondAuthorFullName = o2.getAuthor().getName() + ' ' + o2.getAuthor().getSurname();

            return firstAuthorFullName.compareTo(secondAuthorFullName);
        }

        return titleComp;
    }
}
