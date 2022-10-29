/*
 * @author Ντάφος Χρήστος
 */

// Class that stores generated MD5 Hash Values and corresponding Path in a List

package VTMD5Parser;

import java.util.ArrayList;

public class PathListMD5 {

    ArrayList<String[]> pathListMD5 = new ArrayList<>();

    public void addPath(String[] results) {
        pathListMD5.add(results);
    }

    public ArrayList<String[]> getPathList() {
        return pathListMD5;
    }
}
