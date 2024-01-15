public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(){
        super();
    }

    public MyArrayDataException(String line) {
        super(line);
    }
}
