package pl.romanek.webprojekt.currency;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Currency {

    private String date;
    private float USD;
    private float PLN;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getUSD() {
        return USD;
    }

    public void setUSD(float USD) {
        this.USD = USD;
    }

    public float getPLN() {
        return PLN;
    }

    public void setPLN(float PLN) {
        this.PLN = PLN;
    }

    public String printDate(){

        return this.date;
    }

    public String printUSD(){

        return Float.toString(this.getUSD());
    }

    public String printPLN(){

        return Float.toString(this.getPLN());
    }
}