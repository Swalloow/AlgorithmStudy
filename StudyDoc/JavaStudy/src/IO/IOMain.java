package IO;

import java.io.*;

public class IOMain {

    void testFile() {
        String path = "";
        try {
            byte readBuffer[] = new byte[10240];
            FileInputStream fis = new FileInputStream(path);
//			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//			LineNumberReader lnr = new LineNumberReader(br);
////			LineNumberReader lnr = new LineNumberReader(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
//			while(true) {
//				String str = lnr.readLine();
//				if(str==null)
//					break;
//				System.out.println(str);
//			}

            ByteArrayOutputStream baos = new ByteArrayOutputStream(102400);
            while(true) {
                int nRead = fis.read(readBuffer);
                if(nRead == -1)
                    break;
                baos.write(readBuffer, 0, nRead);
            }
            fis.read(readBuffer);
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}