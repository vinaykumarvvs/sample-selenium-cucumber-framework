package events;

import listeners.ResizeListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResizeEventHandler implements ResizeListener {

    private String filepath = System.getProperty("user.dir") + "/src/test/resources/Dimensions.txt";

    public ResizeEventHandler() {
        deleteFileIfExists(filepath);
    }

    @Override
    public void editorHasBeenResized(int resizeCounter, String width, String height) {
        String fileContent = "Resize number " + resizeCounter + ":\n" +
                "height - " + width + " px ; width - " + height + " px\n";

        try {
            FileWriter fileWriter = new FileWriter(filepath, true);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFileIfExists(String filePath) {
        File f = new File(filePath);
        if (f.exists())
            f.delete();
    }
}
