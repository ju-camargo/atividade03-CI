import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.zip.*;

public class MavenWrapperDownloader {
    public static void main(String[] args) throws Exception {
        System.out.println("Downloading Maven...");
        URL website = new URL("https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.8.6/apache-maven-3.8.6-bin.zip");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("maven.zip");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        unzip("maven.zip", "maven");
        System.out.println("Done.");
    }
    static void unzip(String zipFilePath, String destDir) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();
        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry entry = zis.getNextEntry();
        while (entry != null) {
            String filePath = destDir + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zis, filePath);
            } else {
                File dir2 = new File(filePath);
                dir2.mkdirs();
            }
            zis.closeEntry();
            entry = zis.getNextEntry();
        }
        zis.close();
        fis.close();
    }
    private static void extractFile(ZipInputStream zis, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read;
        while ((read = zis.read(bytesIn)) != -1) bos.write(bytesIn, 0, read);
        bos.close();
    }
}