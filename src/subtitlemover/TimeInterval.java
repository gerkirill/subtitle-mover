package subtitlemover;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс представляет временной интервал
 */
public class TimeInterval {
    // часы
    private int hours = 0;
    // минуты
    private int minutes = 0;
    // секунды
    private int seconds = 0;
    // миллисекунды
    private int milliseconds = 0;
    
    /**
     * Конструктор для создания объекта из строки вида "01:34:02,437"
     */
    public TimeInterval(String interval) throws Exception {
        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}),(\\d{3})$");
        Matcher m = pattern.matcher(interval);
        if (!m.find()) {
            throw new Exception("Unexpected time interval format");
        }
        hours = Integer.parseInt(m.group(1));
        minutes = Integer.parseInt(m.group(2));
        seconds = Integer.parseInt(m.group(3));
        milliseconds = Integer.parseInt(m.group(4));
    }
    
    /**
     * Конструктор для создания объекта из целого знначения - количества миллисекунд
     * в интервале.
     */
    public TimeInterval(Integer msInterval) {
        hours = msInterval / (60*60*1000);
        int remaining = msInterval - hours * (60*60*1000);
        minutes = remaining / (60*1000);
        remaining = remaining - minutes * (60*1000);
        seconds = remaining / 1000;
        milliseconds = remaining - seconds * 1000;
    }
    
    /**
     * Возвращает количество миллисекунд в интервале
     * @return 
     */
    public int toMilliseconds() {
        return hours*60*60*1000 + minutes*60*1000 + seconds*1000 + milliseconds;
    }
    
    /**
     * Прибавляет к этому интервалу другой и возвращает результат
     */
    public TimeInterval add(TimeInterval i) {
        int currentMs = toMilliseconds();
        int addMs = i.toMilliseconds();
        return new TimeInterval(currentMs + addMs);
    }
    
    /**
     * Конвертирует интервал обратно в строку
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d,%03d", hours, minutes, seconds, milliseconds);
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    public int getSeconds() {
        return this.seconds;
    }
    
    public int getMilliseconds() {
        return milliseconds;
    }
}
