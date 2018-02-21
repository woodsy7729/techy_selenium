package UnUsed;

import java.io.*;
public class DeliveryLog {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            // APPEND MODE SET HERE
            //test if file is present- if present proceed, else create file
            File filethere = new File("C:\\Users\\woods\\IdeaProjects\\hello_world\\src\\Log");
            boolean exists = filethere.exists();
            if (exists == true){
                System.out.println(filethere.length() );
                bw = new BufferedWriter(new FileWriter(filethere, true));
                if (filethere.length() < 10){
                    String header = "Item,Quantity,UnitPrice,Date,Status";
                    bw.write(header);
                    bw.newLine();
                    bw.flush();
                }
                else{


                    bw.newLine();
                    bw.flush();
                }


            }
            else {

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {                       // always close the file
            if (bw != null) try {
                bw.close();
            } catch (IOException ioe2) {
                // just ignore it
            }
        }
    }
}


/*

try {
            File file = new File("test1.txt");
            FileWriter fileWriter = new FileWriter(file);
            String price = "50";
            String header = "Item,Quantity,UnitPrice,Date,Status";
            fileWriter.write(header);
            fileWriter.write("a test");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 */