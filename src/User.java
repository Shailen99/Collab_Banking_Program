
     import java.io.BufferedWriter;
     import java.io.File;
     import java.io.FileWriter;
     import java.nio.file.Files;
     import java.nio.file.Paths;
     import java.time.LocalDateTime;
     import java.time.format.DateTimeFormatter;
     import java.util.List;
     import java.util.*;
     import java.text.*;

     public class User {
     String loc;
     static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
     static LocalDateTime now = LocalDateTime.now();

     User(String user) {
     this.loc = user;
     }

     void changeBal(float amount) {
     try {
          DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Calendar cal = Calendar.getInstance();
          File tempFile = new File("data" + File.separator + "tempFile.txt");
     BufferedWriter writer = new BufferedWriter(new FileWriter("data" + File.separator + "tempFile.txt"));
     List<String> lines = Files.readAllLines(Paths.get("data" + File.separator + this.loc + ".txt"));
     float newBal = Float.parseFloat((String)lines.get(2)) + amount;

     for(int i = 0; i < lines.size(); ++i) {
     if (i == 2) {
     writer.write(newBal + "\n");
     } else {
     writer.write((String)lines.get(i) + "\n");
     }
     }

     writer.write("(" + dateFormat.format(cal) + ")_" + amount + "\n");
     writer.flush();
     writer.close();
     (new File("data" + File.separator + this.loc + ".txt")).delete();
     tempFile.renameTo(new File("data" + File.separator + this.loc + ".txt"));
     tempFile.delete();
     } catch (Exception var7) {
     ;
     }

     }

     float getBal() {
     try {
     return Float.parseFloat((String)Files.readAllLines(Paths.get("data" + File.separator + this.loc + ".txt")).get(2));
     } catch (Exception var2) {
     return 0.0F;
     }
     }

     /*@Shailen
     * This finds the value of the USER ID and returns it
     * */
     String getID()
     {
     try{
     List<String> lines = Files.readAllLines(Paths.get("data" + File.separator + this.loc + ".txt"));
     String ID = lines.get(1);
     return ID;
     }
     catch (Exception var2) {
     return "Error";
     }
     }

     }