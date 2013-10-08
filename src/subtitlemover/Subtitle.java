package subtitlemover;

class Subtitle {
    private Integer id;
    private TimeInterval startTime;
    private TimeInterval endTime;
    private String text;

    Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    TimeInterval getStartTime() {
        return startTime;
    }

    void setStartTime(TimeInterval startTime) {
        this.startTime = startTime;
    }

    TimeInterval getEndTime() {
        return endTime;
    }

    void setEndTime(TimeInterval endTime) {
        this.endTime = endTime;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    public Subtitle(Integer id, TimeInterval startTime, TimeInterval endTime, String text) {
        createFromParts(id, startTime, endTime, text);
    }
    public Subtitle(String content) throws Exception {
        Integer id;
        TimeInterval startTime;
        TimeInterval endTime;
        String text;

        // or String lines[] ???
        String[] lines = content.split("\\r?\\n");
        id = Integer.parseInt(lines[0]);
        text = lines[2];
        String[] timeLineParts = lines[1].split(" --> ");
        startTime = new TimeInterval(timeLineParts[0]);
        endTime = new TimeInterval(timeLineParts[1]);

        createFromParts(id, startTime, endTime, text);
    }

    @Override
    public String toString() {
        return String.format("%s\n%s --> %s\n%s\n", id, startTime, endTime, text);
    }

    private void createFromParts(Integer id, TimeInterval startTime, TimeInterval endTime, String text) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = text;
    }
}
