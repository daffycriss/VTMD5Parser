/*
 * @author Ντάφος Χρήστος
 */

// Class that generates Scan Report from VT.com using API V3

package VTMD5Parser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MyMain {

    public static void getAVScan(String testFile) throws Exception {

        int positives;
        int undetected;
        int timeout;
        int total;
        String results;
        String responseBody = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.virustotal.com/api/v3/files/" + testFile)
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("x-apikey", "f2620a9f1634e132cac79a999437d822c136fd499132d5ecaec4c24461fb13af")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            responseBody = response.body().string();
            //System.out.println(responseBody);
            JsonReader jsonReader = new JsonReader();
            positives = jsonReader.getNumPositives(responseBody);
            undetected = jsonReader.getNumUndetected(responseBody);
            timeout = jsonReader.getNumTimeOut(responseBody);
            total = positives + undetected + timeout;
            results = "Results: " + positives + "/" + total;
            // System.out.println(results);
            HyperlinkDemo hyperlinkDemo = new HyperlinkDemo(positives, results, testFile);
            hyperlinkDemo.setVisible(true);

        } catch (Exception ab) {
            System.out.println("Response Error : " + ab.getMessage());
        }
    }
}

class HyperlinkDemo extends JFrame {
    private final String text = "See VirusTotal.com Report";
    private final JLabel hyperlink = new JLabel(text);

    public HyperlinkDemo(int pos, String vtResults, String md5) throws HeadlessException {
        super();
        setTitle("VirusTotal.com Results");
        JLabel label1 = new JLabel("VTResults");
        JLabel label2 = new JLabel("Comments");
        label1.setText(vtResults);
        Font font1 = label1.getFont().deriveFont(Font.BOLD, 24f);
        Font font2 = label1.getFont().deriveFont(Font.BOLD, 18f);
        label1.setFont(font1);
        label2.setFont(font2);
        hyperlink.setFont(font2);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        setLayout(new FlowLayout());
        getContentPane().add(label1, gbc);
        getContentPane().add(hyperlink, gbc);
        getContentPane().add(label2, gbc);
        setSize(400, 180);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (pos != 0) {
            label2.setForeground(Color.RED.darker());
            label2.setText("Indicators Found!!!");
        } else {
            label2.setForeground(Color.BLUE);
            label2.setText("No Indicators Found.");
        }

        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hyperlink.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.virustotal.com/gui/file/" + md5));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }
        });
    }
}
