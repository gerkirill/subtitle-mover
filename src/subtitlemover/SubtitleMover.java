package subtitlemover;

public class SubtitleMover {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TimeInterval i =      new TimeInterval("02:34:02,437");
            TimeInterval addInt = new TimeInterval("00:01:59,000");
            // 02:34:02,437 + 00:01:59,000 = 02:36:01,437
            System.out.println(i + " + " + addInt + " = " + i.add(addInt));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
