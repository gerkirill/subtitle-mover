package subtitlemover;

import java.io.*;
import java.util.ArrayList;

class SrtFile {

    private ArrayList<Subtitle> subtitles;

    public SrtFile(String file) throws IOException, Exception {
        subtitles = new ArrayList<Subtitle>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        String subtitle = "";
        int counter = 0;
        while ((line = reader.readLine()) != null)
        {
            counter++;
            subtitle += (line + "\n");
            if (counter == 4) {
                counter = 0;
                subtitles.add(new Subtitle(subtitle));
                subtitle = "";
            }
        }
    }

    public void write(String file) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        for(Subtitle subtitle: subtitles) {
            writer.println(subtitle.toString());
        }
        writer.close();
    }

}
