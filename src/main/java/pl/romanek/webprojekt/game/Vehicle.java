package pl.romanek.webprojekt.game;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String vehicletype;

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }
}


