package comparators;

import java.io.File;
import java.util.Comparator;
import consolecommander.ConsoleCommander;

public class FileNameComparator implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
       
        if (o1.isDirectory()) {
            if (o2.isDirectory()) {
                return o1.compareTo(o2);
            } else {
                return -1;
            }
        } else {
            if (o2.isDirectory()) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }
    }
}
