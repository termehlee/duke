import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.time.format.DateTimeFormatter;

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

    public String timeFormat(String time) {
        DateTimeFormatter format = new DateTimeFormatterBuilder().appendPattern("HHmm").toFormatter();

        LocalTime parsedTime = LocalTime.parse(time,format);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mma");

        String newTime = dtf.format(parsedTime);

        return newTime;
    }

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
