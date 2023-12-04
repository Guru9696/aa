import java.io.*;

class LowercaseInputStream extends FilterInputStream {
    protected LowercaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c != -1) {
            // Convert uppercase to lowercase if it's an uppercase letter
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
        }
        return c;
    }
}

public class uptolow {
    public static void main(String[] args) {
        try {
            String text = "Hello, World!";
            byte[] data = text.getBytes();

            // Create an input stream from the byte array
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

            // Wrap the input stream with our decorator
            LowercaseInputStream lowercaseInputStream = new LowercaseInputStream(inputStream);

            int character;
            while ((character = lowercaseInputStream.read()) != -1) {
                System.out.print((char) character);
            }

            lowercaseInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

