
import org.junit.jupiter.api.Test;

import java.io.File;

public class Main {
    @Test
    public static void main(String args[]) {


        String url = null, storage = null, name = null;
        for (int i = 0; i < 6; i++) {
            if (args[i].equals("-l")) {
                url = args[++i];
                System.out.println("URL: " + url);
            }

            if (args[i].equals("-p")) {
                storage = args[++i];
                System.out.println("Place:  " + storage);

            }
            if (args[i].equals("-n")) {
                name = args[++i];
                System.out.println("Name:  " + name);
            }

        }


        if (new NET(new File(storage + name), url, -1).load()) {
            System.out.println("Status:  File Downloaded!");
        } else {
            System.out.println("Status:  NOT downloaded");
        }
    }

}
