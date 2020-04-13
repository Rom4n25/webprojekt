
package pl.romanek.webprojekt.flights;

import javax.validation.constraints.NotBlank;

public class Flight {
    
    @NotBlank(message= "{NotBlank.Flight.validation}")
    private String date;
    @NotBlank(message= "{NotBlank.Flight.validation}")
    private String time1;
    @NotBlank(message= "{NotBlank.Flight.validation}")
    private String time2;
    private String airport;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
    
    
    
    
}
