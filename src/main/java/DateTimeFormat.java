import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.time.format.DateTimeFormatter;

/**
 * Helps to convert date and time to a standard format.
 */
class DateTimeFormat {

    private String date;
    private String time;

    public DateTimeFormat(String message) {
        String[] line = message.split(" ");

        date = dateFormat(line[0]);
        time = timeFormat(line[1]);
    }

    public String toString() {
        return date + " " + time;
    }

    /**
     * Returns standard format of the date.
     *
     * @param date Date of task
     * @return newDate Updated format of date of task
     */
    public String dateFormat(String date) {
        //date will be in the form 2/12/2019
        int day = Integer.parseInt(date.substring(0, date.indexOf("/")));
        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern("d/MM/yyyy").toFormatter();

        LocalDate parsedDate = LocalDate.parse(date, format);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d'" + getDayNumberSuffix(day) + " of " + "'MMMM yyyy");

        //new date will be in the form 2nd of December 2019
        String newDate = dtf.format(parsedDate);

        return newDate;
    }

    /**
     * Returns standard format of the time.
     *
     * @param time Time of task
     * @return newTime Updated format of time of task
     */
    public String timeFormat(String time) {
        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern("HHmm").toFormatter();

        LocalTime parsedTime = LocalTime.parse(time,format);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mma");

        String newTime = dtf.format(parsedTime);

        return newTime;
    }

    /**
     * Returns the suffix after the day in the date of the task.
     *
     * @param day Day of task
     * @return suffix Suffix of the day
     */

    private String getDayNumberSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }


}
