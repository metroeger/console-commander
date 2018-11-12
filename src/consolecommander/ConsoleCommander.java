package consolecommander;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import comparators.FileNameComparator;
import comparators.SizeComparator;

public class ConsoleCommander {

    public static String format(String name, int size, boolean isD) {
        String space = " ";
        int length = size - name.length();
        if (isD) {
            name = name + "]";
        }
        for (int i = 0; i < length; i++) {
            name += space;
        }
        return name;
    }

    public static File getRoot(File root, int num) {
        File[] files = root.listFiles();
        int counter = 1;
        File temp = null;
        String str;
        boolean isParent = false;

        if (num == 0) {
            try {
                temp = new File(root.getAbsolutePath());
                str = temp.getParent();
                isParent = temp.exists();
                if (isParent) {
                    root = new File(str);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    str = Integer.toString(counter) + files[i].getAbsolutePath();
                    counter++;
                    if (str.startsWith(Integer.toString(num))) {
                        root = files[i];
                    }
                }
            }
        }
        return root;
    }

    public static void display(File root) {
        File[] files = root.listFiles();
        Arrays.sort(files, new FileNameComparator());
        //Arrays.sort(files, new SizeComparator());
        
        int counter = 1;
        int counterLength = 0;

        for (File f : files) {
            if (f.isDirectory()) {
                counterLength = Integer.toString(counter).length();
                System.out.println(counter + " [" + format(f.getName(), 80 - counterLength, true) + "<DIR>");
                counter++;
            } else {
                System.out.println(format(f.getName(), 80, false) + f.length());
            }
        }
    }

    public static void main(String[] args) {
        File root = new File("c:\\");
        int num;

        do {
            display(root);
            
            Scanner input = new Scanner(System.in);
            System.out.print("If you wanna get in to a library, type it's number: ");
            num = input.nextInt();
            root =  getRoot(root, num);

        } while (root != null);

        System.out.println("no more");
        
    }

}
