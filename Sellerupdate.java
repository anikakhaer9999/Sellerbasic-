
import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Sellerupdate {
    public static void main(String[] args) {
        new frame1();
    }
}


class frame1 extends JFrame {
     public frame1() {
        setSize(300, 380);
        setTitle("E-GramDaily");
        setResizable(false);
        setLayout(new CardLayout());

       // JButton jB1 = new JButton("Buyer");
        JButton jB2 = new JButton("Seller");
        jB2.setForeground(Color.blue);
        JLabel jL1 = new JLabel("Welcome to ");
        JLabel jLabel = new JLabel("E-GramDaily");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        Font font = jLabel.getFont();
        float size = font.getSize() + 30.0f;
        jLabel.setFont(font.deriveFont(size));
         jLabel.setForeground(Color.gray);


        JLabel jL2 = new JLabel("Help Center"); // link of manual
        jL2.setHorizontalAlignment(jL2.CENTER);
        Font font1 = jL2.getFont();
        float size1 = font1.getSize() + 9.0f;
        jL2.setFont(font.deriveFont(size1));

        JButton jButtonhelp = new JButton("Click Here");
         jButtonhelp.setForeground(Color.red);
        jButtonhelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Helpframe();
            }
        });

        JLabel jL3 = new JLabel("Login Now As");
        jL3.setHorizontalAlignment(JLabel.CENTER);
        Font font2 = jL2.getFont();
        float size2 = font2.getSize() + 9.0f;
        jL3.setFont(font.deriveFont(size2));

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 350);

        jPanel.add(jL1);
        jPanel.add(jLabel);
        jPanel.add(jL2);
        jPanel.add(jButtonhelp);
        jPanel.add(jL3);

        jB2.setBounds(90, 60, 100, 50);

        jPanel.add(jB2);
        jB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginasSeller();
            }
        });
        add(jPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //new LoginasBuyer();
    }


} //clear


class Helpframe extends JFrame {

    public Helpframe() {
        setSize(500, 300);
        setTitle("E-GramDaily Help Center");
        setResizable(false);
        setLayout(new CardLayout());

        JButton jB1 = new JButton("Main Menu");
        JTextArea jTextArea = new JTextArea("Welcome to E-GramDaily ,to continue as a seller please follow the given rules -\n" +
                "1) The number you are using to sign up make sure its Registered\n" +
                "2)Do not share your pin to anyone \n" +
                "3)Give the authentic details to the buyer .\n" +
                "4)Delivery Charge depends on location.\n" +
                "\n"+
                "Contact Options \n" +
                "Contact us via email - egram24@gmail.com\n" +
                "Contact us via Phone - 01918888888" +
                "Thank you for choosing us");
        jTextArea.setEditable(false);
        JLabel jLabel = new JLabel("Rules and Policies");

        JButton jB2 = new JButton("Seller Login");
        JPanel jPanel = new JPanel();
        jPanel.setSize(500, 280);

        jB1.setBounds(90, 60, 100, 50);
        jB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new frame1();
            }
        });
        jB2.setBounds(90, 60, 100, 50);


        jB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginasSeller();
            }
        });

        jPanel.add(jLabel);
        jPanel.add(jTextArea);
        jPanel.add(jB2);
        jPanel.add(jB1);

        add(jPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
} //clear

class LoginasSeller extends JFrame {
    public JTextField name1, location, pin, mobileno, picture;
    public JButton register, login;

    public LoginasSeller() {
        File file = new File("Register.txt");
        setSize(400, 600);
        setTitle(" Seller Login System");
        setResizable(false);
        JPanel jPanel = new JPanel();
        JButton mainmenu = new JButton("Main Menu");
        mainmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame1 frame1 = new frame1();
            }
        });
        JTextArea j = new JTextArea(15, 35);
        JLabel jLabel = new JLabel("Name");
        JLabel jLabel1 = new JLabel("Location");
        JLabel jLabel2 = new JLabel("Mobile no");
        JLabel pinlabel = new JLabel("pin no");
        JLabel jLabel3 = new JLabel("Picture");
        name1 = new JTextField(35);
        location = new JTextField(35);
        mobileno = new JTextField(35);
        pin = new JTextField(35);
        picture = new JTextField(35);
        jPanel.add(jLabel);
        jPanel.add(name1);
        jPanel.add(jLabel1);
        jPanel.add(location);
        jPanel.add(jLabel2);
        jPanel.add(mobileno);
        jPanel.add(pinlabel);
        jPanel.add(pin);
        jPanel.add(jLabel3);
        jPanel.add(picture);

        register = new JButton("Register");
        register.setBounds(90, 60, 100, 50);
        jPanel.add(register);


        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = name1.getText();
                String p = location.getText();
                String f = mobileno.getText();
                String w = pin.getText();
                //not sure img ki diye new dekha lagbe
                try {
                    FileWriter fileWriter = new FileWriter(file, true);
                    fileWriter.append(p + " " + f + " " + n + " " + w + " " + "\n");
                    } catch (FileNotFoundException a) {
                    } catch (IOException a) {
                    }
                    name1.setText(null);
                    location.setText(null);
                    mobileno.setText(null);
                    pin.setText(null);
                    picture.setText(null);
                }
            });
            JLabel jLabel5 = new JLabel("  Already have an Account? Log in.  ");
            jPanel.add(jLabel5);
            JTextField jTextField = new JTextField(27);
            jPanel.add(jTextField);
            JLabel jLabel4 = new JLabel("Mobile No");
            jPanel.add(jLabel4);

            JTextField jTextField1 = new JTextField(27);
            jPanel.add(jTextField1);
            JLabel jLabel6 = new JLabel("Pin");
            jPanel.add(jLabel6);
            login = new JButton("Login");
            login.setBounds(90, 60, 100, 50);
            JLabel jLabel7 = new JLabel();
            jPanel.add(jLabel7);
            jPanel.add(login);
            JTextArea ja = new JTextArea(10, 10);
            jPanel.add(ja);
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Sellerafterlogin sellerafterlogin = new Sellerafterlogin();

                    String x = jTextField.getText();
                    String y = jTextField1.getText();
                    try {
                        File w = new File("Register.txt");

                        Scanner s = new Scanner(w); //pin disi

                        // String c = s.toString();
                        while (s.hasNextLine()) {
                            String s2 = s.nextLine();
                            String s3[] = s2.split(" "); //
                            System.out.println(s3[1]);
                            System.out.println(s3[3]);
                            if (x.equals(s3[1]) && y.equals(s3[3])) { //
                                ja.setText("Login Successful");
//                            dispose();
//                            Sellerafterlogin sellerafterlogin = new Sellerafterlogin();
                            } else {
                                ja.setText("Login Unsuccessful");
                            }
                        }
                        s.close();
                    } catch (Exception e1) {
                    }
                    jTextField.setText(null);
                    jTextField1.setText(null);   ////// next frame e join hobe both after login and register sellerproduct update frame
                }
            });


            add(jPanel);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}  // clear

//class seller {
//        String name, location, productname, price, mobileno;
//        File file = new File("Data.txt");
//        File tempFile = new File("Updates.txt");
//
//        void Add(String Data) {
//            try {
//                FileWriter fileWriter = new FileWriter(file, true);
//                fileWriter.append(Data + "\n");
//                fileWriter.close();
//
//            } catch (IOException e) {
//
//            }
//        }
//
//        void Remove(String r) {
//            try {
//                Scanner scanner = new Scanner(file);
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
//
//                while (scanner.hasNextLine()) {
//                    String k;
//                    k = scanner.nextLine();
//                    if (!(k.contains(r))) {
//                        bufferedWriter.write(k + "\n");
//                        bufferedWriter.flush();
//                    }
//
//                }
//                scanner.close();
//                bufferedWriter.close();
//                file.delete();
//                tempFile.renameTo(file);
//            } catch (IOException e) {
//
//            }
//        }
//
//        void Update(String u) {
//            String[] strings = u.split(" ");
//            Remove(strings[0]);
//            Add(u);
//        }
//}

//class Sellerupdates {
//    public void update(){
//        try {
//            Scanner readA = new Scanner();
//            bufferedWriter.write("A\n");
//            while (readA.hasNextLine()) {
//                String line = readA.nextLine();
//                bufferedWriter.write(line + "\n");
//                bufferedWriter.flush();
//            }
//            bufferedWriter.write("<efo>\n");
//
//            Scanner readB = new Scanner(B);
//            bufferedWriter.write("B\n");
//            while (readB.hasNextLine()) {
//                String line = readB.nextLine();
//                bufferedWriter.write(line + "\n");
//                bufferedWriter.flush();
//            }
//            writer.write("<efo>\n");
//
//            Scanner readC = new Scanner(C);
//            writer.write("C\n");
//            while (readC.hasNextLine()) {
//                String line = readC.nextLine();
//                writer.write(line + "\n");
//                writer.flush();
//            }
//            writer.write("<efo>\n");
//        }
//        catch (IOException e){
//
//        }
//    }
//
//}



class Sellerafterlogin extends JFrame {

    InputStreamReader inputStreamReader;
    Scanner scanner;
    OutputStreamWriter outputStreamWriter;
    BufferedWriter bufferedWriter;

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            System.out.println("Started");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                scanner = new Scanner(inputStreamReader);
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            }
        }catch (IOException e) {

        }
    }

    File fileFISH = new File("Fisheries.txt");
    File file1MEAT = new File("Meat.txt");
    File file2VEG = new File("Vegetables.txt");
    File file3FRUIT = new File("Fruit.txt");
    File file4MOSHLA = new File("Moshla.txt");
    File file5LG = new File("LocalGood.txt");
    File file6TRAD = new File("Traditional.txt");

    public void update(){
        try {
            Scanner fish = new Scanner(fileFISH);
            bufferedWriter.write("Fisheries\n");
            bufferedWriter.flush();
            while (fish.hasNextLine()) {
                String line = fish.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();


            Scanner meat = new Scanner(file1MEAT);
            bufferedWriter.write("Meat\n");
            bufferedWriter.flush();
            while (meat.hasNextLine()) {
                String line = meat.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();

            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();


            Scanner veg = new Scanner(file2VEG);
            bufferedWriter.write("Vegetables\n");
            bufferedWriter.flush();
            while (veg.hasNextLine()) {
                String line = veg.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();


            Scanner fruit = new Scanner(file3FRUIT);
            bufferedWriter.write("Fruit\n");
            bufferedWriter.flush();
            while (fruit.hasNextLine()) {
                String line = fruit.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();



            Scanner moshla = new Scanner(file4MOSHLA);
            bufferedWriter.write("Moshla\n");
            bufferedWriter.flush();
            while (moshla.hasNextLine()) {
                String line = moshla.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();


            Scanner localgood = new Scanner(file5LG);
            bufferedWriter.write("Localgood\n");
            bufferedWriter.flush();
            while (localgood.hasNextLine()) {
                String line = localgood.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();


            Scanner trad = new Scanner(file6TRAD);
            bufferedWriter.write("Traditional\n");
            bufferedWriter.flush();
            bufferedWriter.flush();
            while (trad.hasNextLine()) {
                String line = trad.nextLine();
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("<efo>\n");
            bufferedWriter.flush();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void writetofile(File file, String s){
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(s + "\n");
            writer.flush();

        } catch (IOException d) {
            d.printStackTrace();
        }
    }

    public Sellerafterlogin() {
        setSize(485, 950);
        setTitle("E-GramDaily : Seller Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(440, 1300));
        jPanel2.setLayout(new FlowLayout());
        setResizable(false);

        JScrollPane jScrollPane = new JScrollPane(jPanel2);

        JButton jButton1fisheries = new JButton(" Fisheries Section Update");
        jButton1fisheries.setPreferredSize(new Dimension(450,25));
        JButton jButton2meat = new JButton("Meat Section Update");
        jButton2meat.setPreferredSize(new Dimension(450,25));
        JButton jButton3veg = new JButton("Vegetables Section Update");
        jButton3veg.setPreferredSize(new Dimension(450,25));
        JButton jButton4fruit = new JButton("Fruits Section Update");
        jButton4fruit.setPreferredSize(new Dimension(450,25));
        JButton jButton5moshla = new JButton("Moshla Section Update");
        jButton5moshla.setPreferredSize(new Dimension(450,25));
        JButton jButton6local = new JButton("Local Good Update");
        jButton6local.setPreferredSize(new Dimension(450,25));
        JButton jButton7trad = new JButton("Traditional Goods Update");
        jButton7trad.setPreferredSize(new Dimension(450,25));
        JButton mainmenu = new JButton("Main Menu");
       // JButton shopnowjbutton = new JButton("Shop Now");  //buyer login //ei button e chap dilei product code e jabe jekhane code onujai calculating method hobe

        Thread t1 = new Thread() {
            @Override
            public void run() {
                startServer();
//                try {
//                    String line = scanner.nextLine();
//                    System.out.println(line);
//                    if (line.equals("Update")) {
//                        update();
//                    }
//                }
//                catch (Exception e){
//                    System.out.println(e.getMessage());
//                }

         }
   };
        t1.start();

       JButton jButtonupdate = new JButton("See Updates");
      jButtonupdate.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

              update();
          }
      });




        mainmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame1 frame1 = new frame1();
            }
        });
         jPanel2.add(jButtonupdate);

        JLabel jLabel = new JLabel("Kacha Bazar");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setForeground(Color.blue);
        Font font = jLabel.getFont();
        float size = font.getSize() + 15.0f;
        jLabel.setFont(font.deriveFont(size));

        JLabel jLabel2 = new JLabel("Dry Items");
        jLabel2.setForeground(Color.blue);
        jLabel2.setHorizontalAlignment(JLabel.CENTER);
        Font font1 = jLabel2.getFont();
        float size1 = font1.getSize() + 20.0f;
        jLabel2.setFont(font1.deriveFont(size1));

        JLabel jLabel3 = new JLabel("( Pick your desired Options from Here- The Dry Item Section )");

        JLabel jLabel1 = new JLabel("( Pick your desired Options from the Kacha Bazar Section)");


       // JTextArea fisheriesTA = new JTextArea(5, 41);
        JLabel namefishtf1 = new JLabel("Name");
        JTextField namefisheriesTF1 =new JTextField(35);
        JLabel mobilefishlftf2 = new JLabel("Mobile No");
        JTextField mobilefisheriesTF2 =new JTextField(35);
        JLabel productnamejLabelftf3 = new JLabel("Product Name");
        JTextField productnamefisheriesTF3 =new JTextField(35);
        JLabel productpricejLabelftf4 = new JLabel("Product Price");
        JTextField P8 =new JTextField(35);
        JLabel P9 = new JLabel("Location");
        JTextField P10 =new JTextField(35);




       // JTextArea meatTA = new JTextArea(5, 41);
        JLabel jLabelmtf1 = new JLabel("Name");
        JTextField mwatTF1 =new JTextField(35);
        JLabel jLabelmtf2 = new JLabel("Mobile No");
        JTextField mwatTF2 =new JTextField(35);
        JLabel jLabelmtf3 = new JLabel("Product Name");
        JTextField meatTF3 =new JTextField(35);
        JLabel jLabelmtf4 = new JLabel("Product Price");
        JTextField mwatTF4 =new JTextField(35);
        JLabel jLabelmtf5 = new JLabel("Location");
        JTextField mwatTF5 =new JTextField(35);




       // JTextArea vegTA = new JTextArea(5, 41);
        JLabel vegtf1 = new JLabel("Name");
        JTextField vegTF1 =new JTextField(35);
        JLabel vegtf2 = new JLabel("Mobile No");
        JTextField vegTF2 =new JTextField(35);
        JLabel vegtf3 = new JLabel("Product Name");
        JTextField vegTF3 =new JTextField(35);
        JLabel vegtf4 = new JLabel("Product Price");
        JTextField vegTF4 =new JTextField(35);
        JLabel vegtf5 = new JLabel("Location");
        JTextField vegTF5 =new JTextField(35);


       // JTextArea fruitTA = new JTextArea(5, 41);
        JLabel namefruit = new JLabel("Name");
        JTextField namefruTF1 =new JTextField(35);
        JLabel mobilefruit = new JLabel("Mobile No");
        JTextField mobilefruTF2 =new JTextField(35);
        JLabel productnamefruit = new JLabel("Product Name");
        JTextField productnamefryTF3 =new JTextField(35);
        JLabel productpricefruit = new JLabel("Product Price");
        JTextField productpricefruTF4 =new JTextField(35);
        JLabel locationfruit = new JLabel("Location");
        JTextField locationfruTF5 =new JTextField(35);


        //JTextArea moshlaTA = new JTextArea(5, 41);
        JLabel moshlaL1 = new JLabel("Name");
        JTextField moshla2 =new JTextField(35);
        JLabel moshla3 = new JLabel("Mobile No");
        JTextField moshla4 =new JTextField(35);
        JLabel moshla5 = new JLabel("Product Name");
        JTextField moshla6 =new JTextField(35);
        JLabel moshla7 = new JLabel("Product Price");
        JTextField moshlka8 =new JTextField(35);
        JLabel moshla9 = new JLabel("Location");
        JTextField moshla10 =new JTextField(35);

        //JTextArea localTA = new JTextArea(5, 41);
        JLabel LG1 = new JLabel("Name");
        JTextField LG2 =new JTextField(35);
        JLabel LG3 = new JLabel("Mobile No");
        JTextField LG4 =new JTextField(35);
        JLabel LG5 = new JLabel("Product Name");
        JTextField LG6 =new JTextField(35);
        JLabel LG7 = new JLabel("Product Price");
        JTextField LG8 =new JTextField(35);
        JLabel LG9 = new JLabel("Location");
        JTextField LG10 =new JTextField(35);

       // JTextArea tradTA = new JTextArea(5, 41);
        JLabel T1 = new JLabel("Name");
        JTextField T2 =new JTextField(35);
        JLabel T3 = new JLabel("Mobile No");
        JTextField T4 =new JTextField(35);
        JLabel T5= new JLabel("Product Name");
        JTextField T6 =new JTextField(35);
        JLabel T7 = new JLabel("Product Price");
        JTextField T8 =new JTextField(35);
        JLabel T9 = new JLabel("Location");
        JTextField T10 =new JTextField(35);



        jButton1fisheries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line = namefisheriesTF1.getText() + ", " + mobilefisheriesTF2.getText() + ", " + productnamefisheriesTF3.getText() + ", " + P8.getText() + ", " + P10.getText() + "\n";
//                writetofile(fileFISH, fisheriesTA);
                writetofile(fileFISH, line);

            }
        });
        jButton2meat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String line2 = mwatTF1.getText() + ", " + mwatTF2.getText() + ", " +meatTF3.getText()  + ", " + mwatTF4.getText() + ", " + mwatTF5.getText() + "\n";
//
               // writetofile(file1MEAT , meatTA);
                writetofile(file1MEAT , line2);

            }
        });

        jButton3veg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String line3 = vegTF1.getText() + ", " + vegTF2.getText() + ", " + vegTF3.getText() + ", " + vegTF4.getText() + ", " + vegTF5.getText() + "\n";
               // writetofile(file2VEG , vegTA);
                writetofile(file2VEG,line3);

            }
        });

        jButton4fruit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String line4 =  namefruTF1.getText() + ", " + mobilefruTF2.getText() + ", " + productnamefryTF3.getText() + ", " + productpricefruTF4.getText() + ", " + locationfruTF5.getText() + "\n";
                //writetofile(file3FRUIT,fruitTA);
              writetofile(file3FRUIT ,line4);
            }
        });

        jButton5moshla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line5 =  moshla2.getText() + ", " + moshla4.getText() + ", " + moshla6.getText() + ", " + moshlka8.getText() + ", " + moshla10.getText() + "\n";
              //  writetofile(file4MOSHLA , moshlaTA);
                writetofile(file4MOSHLA ,line5);

            }
        });

        jButton6local.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line6 =  LG2.getText() + ", " + LG4.getText() + ", " + LG6.getText() + ", " + LG8.getText() + ", " + LG10.getText() + "\n";
               // writetofile(file5LG , localTA);
                writetofile(file5LG ,line6);



            }
        });

        jButton7trad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line7 =  LG2.getText() + ", " + LG4.getText() + ", " + LG6.getText() + ", " + LG8.getText() + ", " + LG10.getText() + "\n";
               // writetofile(file6TRAD , tradTA);
                writetofile(file5LG ,line7);


            }
        });

        jPanel2.add(jLabel);
        jPanel2.add(jLabel1);
        jPanel2.add(jButton1fisheries);
       // jPanel2.add(fisheriesTA);
        jPanel2.add(namefishtf1);
        jPanel2.add(namefisheriesTF1);
        jPanel2.add(mobilefishlftf2);
        jPanel2.add(mobilefisheriesTF2);
        jPanel2.add(productnamejLabelftf3);
        jPanel2.add(productnamefisheriesTF3);
        jPanel2.add(productpricejLabelftf4);
        jPanel2.add(P8);
        jPanel2.add(P9);
        jPanel2.add(P10);

        jPanel2.add(jButton2meat);
        jPanel2.add(jLabelmtf1);
        jPanel2.add(mwatTF1);
        jPanel2.add(jLabelmtf2);
        jPanel2.add(mwatTF2);
        jPanel2.add(jLabelmtf3);
        jPanel2.add(meatTF3);
        jPanel2.add(jLabelmtf4);
        jPanel2.add(mwatTF4);
        jPanel2.add(jLabelmtf5);
        jPanel2.add(mwatTF5);
        // jPanel2.add(meatTA);

        jPanel2.add(jButton3veg);
        jPanel2.add(vegtf1);
        jPanel2.add(vegTF1);
        jPanel2.add(vegtf2);
        jPanel2.add(vegTF2);
        jPanel2.add(vegtf3);
        jPanel2.add(vegTF3);
        jPanel2.add(vegtf4);
        jPanel2.add(vegTF4);
        jPanel2.add(vegtf5);
        jPanel2.add(vegTF5);
        // jPanel2.add(vegTA);


        jPanel2.add(jButton4fruit);
      //  jPanel2.add(fruitTA);

        jPanel2.add(namefruit);
        jPanel2.add(namefruTF1);
        jPanel2.add(mobilefruit);
        jPanel2.add(mobilefruTF2);
        jPanel2.add(productnamefruit);
        jPanel2.add(productnamefryTF3);
        jPanel2.add(productpricefruit);
        jPanel2.add(productpricefruTF4);
        jPanel2.add(locationfruit);
        jPanel2.add(locationfruTF5);



        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.add(jButton5moshla);
        jPanel2.add(moshlaL1);
        jPanel2.add(moshla2);
        jPanel2.add(moshla3);
        jPanel2.add(moshla4);
        jPanel2.add(moshla5);
        jPanel2.add(moshla6);
        jPanel2.add(moshla7);
        jPanel2.add(moshlka8);
        jPanel2.add(moshla9);
        jPanel2.add(moshla10);




       // jPanel2.add(moshlaTA);
        jPanel2.add(jButton6local);

        jPanel2.add(LG1);
        jPanel2.add(LG2);
        jPanel2.add(LG3);
        jPanel2.add(LG4);
        jPanel2.add(LG5);
        jPanel2.add(LG6);
        jPanel2.add(LG7);
        jPanel2.add(LG8);
        jPanel2.add(LG9);
        jPanel2.add(LG10);






        //  jPanel2.add(localTA);
        jPanel2.add(jButton7trad);
        jPanel2.add(T1);
        jPanel2.add(T2);
        jPanel2.add(T3);
        jPanel2.add(T4);
        jPanel2.add(T5);
        jPanel2.add(T6);
        jPanel2.add(T7);
        jPanel2.add(T8);
        jPanel2.add(T9);
        jPanel2.add(T10);


       // jPanel2.add(tradTA);
        jPanel2.add(mainmenu);

        add(jScrollPane);
        setVisible(true);
    }
}









