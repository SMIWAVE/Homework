public class AppData {
    private String[] header = new String[]{"Value 1", "Value 2", "Value 3"};
    private int[][] data = new int[][]{
            {100, 200, 123},
            {300, 400, 500}
    };

    public String[] getHeader(){
        return header;
    }

    public int[][] getData(){
        return data;
    }
}


