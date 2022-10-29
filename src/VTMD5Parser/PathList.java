/*
 * @author Ντάφος Χρήστος
 */

// Class that stores checked file Paths in a List

package VTMD5Parser;

import java.util.ArrayList;

public class PathList {

    ArrayList<String> pathList = new ArrayList<>();

    public void addPath(String line) {
        pathList.add(line);
    }

    public ArrayList<String> getPathList() {
        return pathList;
    }
}
