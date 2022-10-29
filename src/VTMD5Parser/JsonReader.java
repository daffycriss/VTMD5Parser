/*
 * @author Ντάφος Χρήστος
 */

// Class that stores generated MD5 Hash Values and corresponding Path in a List

package VTMD5Parser;

public class JsonReader {

    public int getNumPositives(String response) {
        String str = "\"category\": \"malicious\"";
        int index = 0, positives = 0;
        while (true) {
            index = response.indexOf(str, index);
            if (index != -1) {
                positives++;
                index += str.length();
            } else {
                break;
            }
        }
        return positives;
    }

    public int getNumUndetected(String response) {
        String str = "\"category\": \"undetected\"";
        int index = 0, undetected = 0;
        while (true) {
            index = response.indexOf(str, index);
            if (index != -1) {
                undetected++;
                index += str.length();
            } else {
                break;
            }
        }
        return undetected;
    }

    public int getNumTimeOut(String response) {
        String str = "\"category\": \"timeout\"";
        int index = 0, timeout = 0;
        while (true) {
            index = response.indexOf(str, index);
            if (index != -1) {
                timeout++;
                index += str.length();
            } else {
                break;
            }
        }
        return timeout;
    }
}
