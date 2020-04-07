package pl.romanek.webprojekt.game;

import org.springframework.stereotype.Component;

@Component
public class Weapon {
    private String weapontype;

    public String getWeapontype() {
        return weapontype;
    }

    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }
}
