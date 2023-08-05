import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.security.interfaces.RSAPublicKey;

public class Main {
    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) {
//checking existing of directory
        Path path = Paths.get("src/main/resources/input");
        boolean pathExists =
                Files.exists(path,
                        new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
        System.out.println(pathExists );
// creating of new directory

        Path path2 = Paths.get("src/main/resources/subdir2");

        try {
            Path newDir = Files.createDirectory(path2);
        } catch(FileAlreadyExistsException e){
            System.out.println( "the directory already exists.");
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
//copy of files from one directory to another
        Path sourcePath      = Paths.get("src/main/resources");
        Path destinationPath = Paths.get("src/newDirectory");

        try {
            Files.copy(sourcePath, destinationPath);
        } catch(FileAlreadyExistsException e) {
            System.out.println("что-то не так" );
        } catch (IOException e) {
            //something else went wrong
            e.printStackTrace();
        }
//deleting of file
        Path path3 = Paths.get("src/main/resources/NeedTobeDeleted");

        try {
            Files.delete(path3);
        } catch (IOException e) {
            //deleting file failed
            e.printStackTrace();
        }
    }
    BufferedReader reader = new BufferedReader(new FileReader("main.resources/input.txt"));
   /* public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }*/


}