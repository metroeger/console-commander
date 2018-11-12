package comparators;

import java.io.File;
import java.util.Comparator;
import consolecommander.ConsoleCommander;

public class SizeComparator implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        long l = o2.length()-o1.length();
        int i = (int) l;
        if (o1.isDirectory()) {
            if (o2.isDirectory()){
                return o1.compareTo(o2);
            }else{
                return -1;
            }            
        }else{
            if (o2.isDirectory()){
                return 1;
            }
            else
                if (o1.length()-o2.length()==0){
                  return o1.compareTo(o2);
                }
                return i;
        }
    }
}
