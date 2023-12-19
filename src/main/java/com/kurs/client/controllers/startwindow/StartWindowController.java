package com.kurs.client.controllers.startwindow;

import com.kurs.client.Roles;
import com.kurs.client.controllers.startwindow.chef.ChefController;
import com.kurs.client.controllers.startwindow.guest.GuestController;
import com.kurs.client.controllers.startwindow.oguzok.OguzokController;
import com.kurs.client.elements.Boxes;

public class StartWindowController {
    public StartWindowController(Boxes boxes) {

        new GuestController(
                boxes.getButtons().getAsGuest(),
                Roles.GUEST);

        new ChefController(
                boxes.getButtons().getAsChef(),
                Roles.CHEF);

        new OguzokController(
                boxes.getButtons().getAsOguzok(),
                Roles.OGUZOK);

    }


}
