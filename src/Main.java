import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
            AppData info = new AppData();
            String[] header = info.getHeader();
            writer.write(String.join(";", header));

            int[][] data = info.getData();
            for (int[] row : data) {
                String[] rowData = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    rowData[i] = String.valueOf(row[i]);
                }
                writer.newLine();
                writer.write(String.join(";", rowData));
            }
            writer.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.csv"));
            String line;
                while((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}