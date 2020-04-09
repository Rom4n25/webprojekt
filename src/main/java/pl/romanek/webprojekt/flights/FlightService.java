
package pl.romanek.webprojekt.flights;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;


@Service
class FlightService {
    
    
            private ArrayList<String> depAirports;
            private ArrayList<String> depDates;
            private ArrayList<String> arrDates;
            private ArrayList<String> callsigns;

    
    
    public void checkFligt(String date, String time1, String time2, String airport) throws MalformedURLException, IOException{
    
            //zapisuje poczatkowa i koncowa date w takim formacie w stringu aby moc go przerobic na UNIX Time (liczony w sekundach od ktoregos tam roku)
            String from = date + " " + time1 + ":00.0";
            String to = date + " " + time2 + ":00.0";

            //przerabiam ww. stringi na longi w formacie UNIX
            long t1 = Timestamp.valueOf(from).getTime() / 1000;
            long t2 = Timestamp.valueOf(to).getTime() / 1000;

            //odwoluje sie do url gdzie zmiennymi sa nazwa lotniska oraz data poczatkowa i koncowa w formacie UNIX
            URL url = new URL("https://Romanek:malec235@opensky-network.org/api/flights/arrival?airport=" + airport + "&begin=" + t1 + "&end=" + t2 + "");

            //Tworze obiekt "mapper" z klasy ObjectMapper, dzieki ktoremu bede mogl odczytac strukture JSONA
            ObjectMapper mapper = new ObjectMapper();

            //Tworze obiekt "node" z klasy JsonNode, dzieki czemu moge odczytac strukture Jsona
            JsonNode node = mapper.readTree(url);


             depAirports= new ArrayList<>();
             depDates= new ArrayList<>();
             arrDates= new ArrayList<>();
             callsigns= new ArrayList<>();

            boolean flag = true;
            int i = 0;

            //nie wiem ile elementow ma drzewo Jsona wiec musze zrobic petle
            while (flag) {

                if (!node.has(i)) {
                    flag = false;
                } else {
                    //tworze odwolanie do obecnego elementu
                    JsonNode currentNode = node.get(i);
                    //pobieram dane, ktore mnie interesuja
                    long depTime = currentNode.get("firstSeen").asLong();
                    long arrTime = currentNode.get("lastSeen").asLong();
                    String calsign = currentNode.get("callsign").toString();
                    String depAirport = currentNode.get("estDepartureAirport").toString();

                    //przerabiam date z formatu UNIX na normalna
                    Instant FirstDate = Instant.ofEpochSecond(depTime);
                    Instant SecondDate = Instant.ofEpochSecond(arrTime);
                    Date depDate = Date.from(FirstDate);
                    Date arDate = Date.from(SecondDate);

                    String output = depAirport;
                    //String output = "From: " + depAirport +'\n'+"Aircraft: " + calsign +'\n'+ "Dep. Time: " + depDate +"\n"+"Arr. Time: " + arDate;

                    depAirports.add(output);
                    depDates.add(depDate.toString());
                    arrDates.add(arDate.toString());
                    callsigns.add(calsign);
                    i++;

                }
            }

        

    }

    public ArrayList<String> getDepAirports() {
        return depAirports;
    }

    public void setDepAirports(ArrayList<String> depAirports) {
        this.depAirports = depAirports;
    }

    public ArrayList<String> getDepDates() {
        return depDates;
    }

    public void setDepDates(ArrayList<String> depDates) {
        this.depDates = depDates;
    }

    public ArrayList<String> getArrDates() {
        return arrDates;
    }

    public void setArrDates(ArrayList<String> arrDates) {
        this.arrDates = arrDates;
    }

    public ArrayList<String> getCallsigns() {
        return callsigns;
    }

    public void setCallsigns(ArrayList<String> callsigns) {
        this.callsigns = callsigns;
    }
    
        
}
