/*
 * @author Ντάφος Χρήστος
 */

// Class that runs operational procedures on GUI

package GuiDesign;

import VTMD5Parser.MyMain;
import VTMD5Parser.PathList;
import VTMD5Parser.PathListMD5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Panel extends javax.swing.JFrame {

    private static final String REGQUERY_UTIL = "reg query ";
    private static final String REGSTR_TOKEN1 = "REG_SZ";
    private static final String REGSTR_TOKEN2 = "REG_DWORD";
    private static final String CURRENT_BUILD = REGQUERY_UTIL +
            "\"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\"" +
            " /v CurrentBuildNumber";
    private static final String CURRENT_VERSION = REGQUERY_UTIL +
            "\"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\"" +
            " /v UBR";

    JFileChooser chooser;
    private String updatePath = "";
    JFileChooser chooserDoc;
    private String updateDocPath = "";

    public Panel() {
        initComponents();
        Line();
        Welcome();
        Details1();
        Details2();
        Details3();
        Details4();
        runTests.setEnabled(false);
        documentsPathFinder.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Details1 = new javax.swing.JLabel();
        Welcome = new javax.swing.JLabel();
        Line = new javax.swing.JLabel();
        Details2 = new javax.swing.JLabel();
        Details3 = new javax.swing.JLabel();
        Details4 = new javax.swing.JLabel();
        Details5 = new javax.swing.JLabel();
        autoRunPathFinder = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        runTests = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        documentsPathFinder = new java.awt.Button();
        Details6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MD5 Parser (VirusTotal API) v.1.0");

        Details1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Welcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Details2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Details3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Details4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Details5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Details5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        autoRunPathFinder.setActionCommand("newgame");
        autoRunPathFinder.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        autoRunPathFinder.setLabel("Autoruns Folder Path");
        autoRunPathFinder.setName(""); // NOI18N
        autoRunPathFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoRunPathFinderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1019, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 13, Short.MAX_VALUE)
        );

        runTests.setActionCommand("newgame");
        runTests.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        runTests.setLabel("Start Checks");
        runTests.setName(""); // NOI18N
        runTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runTestsActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setHorizontalScrollBar(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "MD5 Hash", "Path"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        documentsPathFinder.setActionCommand("newgame2");
        documentsPathFinder.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        documentsPathFinder.setLabel("User's Home Folder Path");
        documentsPathFinder.setName(""); // NOI18N
        documentsPathFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentsPathFinderActionPerformed(evt);
            }
        });

        Details6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Details6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(autoRunPathFinder, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Details5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Line, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Details3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Details4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Details1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Details2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(316, 316, 316)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(documentsPathFinder, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                                        .addComponent(runTests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addComponent(Details6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(Details1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Details2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Details3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Details4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(autoRunPathFinder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(Details5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(documentsPathFinder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(Details6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(runTests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>

    private void autoRunPathFinderActionPerformed(java.awt.event.ActionEvent evt) {

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);

        //
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Details5.setText("Selected Directory: " + chooser.getSelectedFile().getAbsolutePath());
            updatePath = chooser.getSelectedFile().getAbsolutePath();
            // System.out.println(updatePath);
            runTests.setEnabled(false);
            documentsPathFinder.setEnabled(true);
        } else {
            Details5.setText("No Directory Selected.");
            runTests.setEnabled(false);
        }
    }

    private void runTestsActionPerformed(java.awt.event.ActionEvent evt) {

        jTable1.clearSelection();

        PathList pathList = new PathList();
        PathListMD5 pathListMD5 = new PathListMD5();
        infoBox("This PC runs: \n" + getOSVersionBuild() + "\nPress OK to proceed, and wait a few seconds...", "OS Version");
        // System.out.println("This PC runs " + getOSVersionBuild());
        // System.out.println();

        String newpathAutoruns = updatePath.replaceAll("/", "\\\\");
        String newDocPath = updateDocPath.replaceAll("/", "\\\\");

        // Populate list from autorunsc program
        try {
            Runtime runtimeA = Runtime.getRuntime();

            // check Processor Architecture

            if (System.getProperty("os.arch").equals("amd64")) {
                Process processA = runtimeA.exec("cmd.exe /c " + newpathAutoruns + "autorunsc64 -a * -ct");
                processA.getOutputStream().close();
                InputStream inputStreamA = processA.getInputStream();
                InputStreamReader inputStreamReaderA = new InputStreamReader(inputStreamA, StandardCharsets.UTF_16);
                BufferedReader bufferedReaderA = new BufferedReader(inputStreamReaderA);
                String lineA;
                while ((lineA = bufferedReaderA.readLine()) != null) {
                    String[] resA = lineA.split("\t", 0);
                    for (int i = 0; i < resA.length; i++) {
                        if (i == 8 && !resA[i].equals("Image Path") && !resA[i].equals(""))
                            pathList.addPath(resA[i]);
                    }
                }
            } else if (System.getProperty("os.arch").equals("x86")) {
                Process processA = runtimeA.exec("cmd.exe /c " + newpathAutoruns + "autorunsc -a * -ct");
                processA.getOutputStream().close();
                InputStream inputStreamA = processA.getInputStream();
                InputStreamReader inputStreamReaderA = new InputStreamReader(inputStreamA, StandardCharsets.UTF_16);
                BufferedReader bufferedReaderA = new BufferedReader(inputStreamReaderA);
                String lineA;
                while ((lineA = bufferedReaderA.readLine()) != null) {
                    String[] resA = lineA.split("\t", 0);
                    for (int i = 0; i < resA.length; i++) {
                        if (i == 8 && !resA[i].equals("Image Path") && !resA[i].equals(""))
                            pathList.addPath(resA[i]);
                    }
                }
            }
        } catch (IOException e) {
            // System.err.println("Autorunsc program parsing Error: " + e.getMessage());
        }

        // Populate list from c:/Windows Folder
        try {
            Runtime runtimeB = Runtime.getRuntime();

            Process processB = runtimeB.exec("cmd.exe /c cd \\Windows && dir /B /ON");
            processB.getOutputStream().close();
            InputStream inputStreamB = processB.getInputStream();
            InputStreamReader inputStreamReaderB = new InputStreamReader(inputStreamB, StandardCharsets.UTF_8);
            BufferedReader bufferedReaderB = new BufferedReader(inputStreamReaderB);
            String line;
            while ((line = bufferedReaderB.readLine()) != null) {
                if (line.endsWith(".exe") || line.endsWith(".dll"))
                    pathList.addPath("c:\\Windows\\" + line);
            }
        } catch (IOException e) {
            // System.err.println("C:Windows Folder parsing Error: " + e.getMessage());
        }


        // Populate list from Users Temp Folder
        java.nio.file.Path path = Paths.get(newDocPath + "\\AppData\\Local\\Temp\\");
        List<java.nio.file.Path> paths = null;
        try {
            paths = listFiles(path);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).toString().endsWith(".exe") ||
                    paths.get(i).toString().endsWith(".dll") ||
                    paths.get(i).toString().endsWith(".db") ||
                    paths.get(i).toString().endsWith(".sqlite") ||
                    paths.get(i).toString().endsWith(".sig") ||
                    paths.get(i).toString().endsWith(".manifest") ||
                    paths.get(i).toString().endsWith(".mui") ||
                    paths.get(i).toString().endsWith(".dat") ||
                    paths.get(i).toString().endsWith(".cab") ||
                    paths.get(i).toString().endsWith(".log"))
                pathList.addPath(paths.get(i).toString());
        }

        // Populate list from System Temp Folder
        java.nio.file.Path pathWin = Paths.get("C:\\Windows\\Temp\\");
        List<java.nio.file.Path> pathsWin = null;
        try {
            pathsWin = listFilesWin(pathWin);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < pathsWin.size(); i++) {
            if (pathsWin.get(i).toString().endsWith(".exe") ||
                    pathsWin.get(i).toString().endsWith(".dll") ||
                    pathsWin.get(i).toString().endsWith(".db") ||
                    pathsWin.get(i).toString().endsWith(".sqlite") ||
                    pathsWin.get(i).toString().endsWith(".sig") ||
                    pathsWin.get(i).toString().endsWith(".manifest") ||
                    pathsWin.get(i).toString().endsWith(".mui") ||
                    pathsWin.get(i).toString().endsWith(".dat") ||
                    pathsWin.get(i).toString().endsWith(".cab") ||
                    paths.get(i).toString().endsWith(".log"))
                pathList.addPath(pathsWin.get(i).toString());
        }

        for (int i = 0; i < pathList.getPathList().size(); i++) {

            // create a file object referencing any file from
            // the system of which checksum is to be generated
            File file = new File(pathList.getPathList().get(i));

            // instantiate a MessageDigest Object by passing
            // string "MD5" this means that this object will use
            // MD5 hashing algorithm to generate the checksum
            MessageDigest mdigest = null;
            try {
                mdigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Get the checksum
            try {
                String checksum = checksum(mdigest, file);
                // print out the checksum
                // System.out.println(checksum);
                // System.out.println("MD5: " + checksum + " - File Path: " + file);
                String[] resMD5 = new String[2];
                resMD5[0] = checksum;
                resMD5[1] = file.toString();
                pathListMD5.addPath(resMD5);
            } catch (Exception e) {
                // System.out.println("Parsing Error 2: " + e.getMessage());
            }
        }

        // Print Hash data and Paths in Terminal
        /*
        for (int i = 0; i < pathListMD5.getPathList().size(); i++) {
            System.out.println("MD5: " + pathListMD5.getPathList().get(i)[0] +
                    " - File Path: " + pathListMD5.getPathList().get(i)[1]);
        } */

        Object[] columnNames = {"MD5 Hashes", "Paths"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        MyMain scan = new MyMain();

        for (int i = 0; i < pathListMD5.getPathList().size(); i++) {
            Object[] o = new Object[3];
            o[0] = pathListMD5.getPathList().get(i)[0];
            o[1] = pathListMD5.getPathList().get(i)[1];
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem menuVTChecker = new JMenuItem("Check on VT.com");
            popupMenu.add(menuVTChecker);
            menuVTChecker.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    try {
                        scan.getAVScan(pathListMD5.getPathList().get(jTable1.getSelectedRow())[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            jTable1.setComponentPopupMenu(popupMenu);
            jTable1.addMouseListener(new TableMouseListener(jTable1));
            model.addRow(o);
        }
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getWidth();
        jTable1.setEnabled(false);
        double md5Width = jTable1.getWidth() * 0.25;
        double pathWidth = jTable1.getWidth() * 0.73;
        jTable1.getColumnModel().getColumn(0).setPreferredWidth((int) md5Width);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth((int) pathWidth);

        /*
        try {
            scan.getAVScan("d0b22cfa9bfb7635a5b5d4c46b515257");
        } catch (Exception et) {
            System.out.println("Error getting Scan report: " + et.getMessage());
        } */
    }

    private void documentsPathFinderActionPerformed(java.awt.event.ActionEvent evt) {
        chooserDoc = new JFileChooser();
        chooserDoc.setCurrentDirectory(new java.io.File("."));
        chooserDoc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooserDoc.setAcceptAllFileFilterUsed(false);

        //
        if (chooserDoc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Details6.setText("Selected Directory: " + chooserDoc.getSelectedFile().getAbsolutePath());
            updateDocPath = chooserDoc.getSelectedFile().getAbsolutePath();
            // System.out.println(updateDocPath);
            runTests.setEnabled(true);
        } else {
            Details6.setText("No Directory Selected.");
            runTests.setEnabled(false);
        }
    }

    public class TableMouseListener extends MouseAdapter {

        private JTable jTable;

        public TableMouseListener(JTable table) {
            this.jTable = jTable1;
        }

        @Override
        public void mousePressed(MouseEvent event) {
            // selects the row at which point the mouse is clicked
            Point point = event.getPoint();
            int currentRow = jTable.rowAtPoint(point);
            jTable.setRowSelectionInterval(currentRow, currentRow);
        }
    }

    // this method return the complete  hash of the file
    // passed
    private static String checksum(MessageDigest digest, File file) throws IOException {
        // Get file input stream for reading the file
        // content
        FileInputStream fis = new FileInputStream(file);

        // Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        // read the data from file and update that data in
        // the message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }

        // close the input stream
        fis.close();

        // store the bytes returned by the digest() method
        byte[] bytes = digest.digest();

        // this array of bytes has bytes in decimal format
        // so we need to convert it into hexadecimal format

        // for this we create an object of StringBuilder
        // since it allows us to update the string i.e. its
        // mutable
        StringBuilder sb = new StringBuilder();

        // loop through the bytes array
        for (int i = 0; i < bytes.length; i++) {

            // the following line converts the decimal into
            // hexadecimal format and appends that to the
            // StringBuilder object
            sb.append(Integer
                    .toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }

        // finally we return the complete hash
        return sb.toString();
    }

    public static String getOSVersionBuild() {

        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        String version = System.getProperty("os.version");

        try {
            Process process1 = Runtime.getRuntime().exec(CURRENT_BUILD);
            Process process2 = Runtime.getRuntime().exec(CURRENT_VERSION);
            StreamReader reader1 = new StreamReader(process1.getInputStream());
            StreamReader reader2 = new StreamReader(process2.getInputStream());

            reader1.start();
            process1.waitFor();
            reader1.join();

            reader2.start();
            process2.waitFor();
            reader2.join();

            String result1 = reader1.getResult();
            int p1 = result1.indexOf(REGSTR_TOKEN1);
            String p1Final = result1.substring(p1 + REGSTR_TOKEN1.length()).trim();

            String result2 = reader2.getResult();
            int p2 = result2.indexOf(REGSTR_TOKEN2);
            String removeTwo = (result2.substring(p2 + REGSTR_TOKEN2.length()).trim()).substring(2);
            int p2Final = Integer.parseInt(removeTwo, 16);

            if (p1 == -1 && p2 == -1)
                return null;

            return "Operating System: " + os +
                    "\nArchitecture: " + arch +
                    "\nVersion: " + version +
                    "\nOS Current Build : " + (p1Final + "." + p2Final);

        } catch (Exception e) {
            return null;
        }
    }

    static class StreamReader extends Thread {
        private final InputStream is;
        private final StringWriter sw;

        StreamReader(InputStream is) {
            this.is = is;
            sw = new StringWriter();
        }

        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1)
                    sw.write(c);
            } catch (IOException e) {
                System.out.println("Thread error!");
            }
        }

        String getResult() {
            return sw.toString();
        }
    }

    public static List<java.nio.file.Path> listFiles(java.nio.file.Path path) throws IOException {

        List<java.nio.file.Path> result = null;
        try (Stream<java.nio.file.Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (Exception ab) {
            // System.out.println("listFiles Creation Error " + ab.getMessage());
        }
        return result;
    }

    public static List<java.nio.file.Path> listFilesWin(java.nio.file.Path path) throws IOException {

        List<java.nio.file.Path> result = null;
        try (Stream<java.nio.file.Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (Exception ae) {
            System.out.println("listFilesWin Creation Error " + ae.getMessage());
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel Details1;
    private javax.swing.JLabel Details2;
    private javax.swing.JLabel Details3;
    private javax.swing.JLabel Details4;
    private javax.swing.JLabel Details5;
    private javax.swing.JLabel Details6;
    private javax.swing.JLabel Line;
    private javax.swing.JLabel Welcome;
    private java.awt.Button autoRunPathFinder;
    private java.awt.Button documentsPathFinder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Button runTests;
    // End of variables declaration

    public void Line() {                                    // Μέθοδος εμφάνισης γραμμής στο GUI
        Line.setText(String.valueOf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------"));
    }

    public void Welcome() {                                 // Μέθοδος εμφάνισης μηνύματος
        Welcome.setText(String.valueOf("VirusTotal MD5 checker."));
    }

    public void Details1() {                                // Μέθοδος εμφάνισης μηνύματος
        Details1.setText(String.valueOf("Results of SysInternals Autoruns.exe"));
    }

    public void Details2() {                                // Μέθοδος εμφάνισης μηνύματος
        Details2.setText(String.valueOf("Windows' Folder Programs"));
    }

    public void Details3() {                                // Μέθοδος εμφάνισης μηνύματος
        Details3.setText(String.valueOf("Windows' and User's Temp Folders."));
    }

    public void Details4() {                                // Μέθοδος εμφάνισης μηνύματος
        Details4.setText(String.valueOf("The software creates MD5 Hashes of gathered programs and uploads them to VT."));
    }
}
