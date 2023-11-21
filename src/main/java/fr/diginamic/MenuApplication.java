package fr.diginamic;

import fr.diginamic.menu.MenuOptions;
import fr.diginamic.menu.exception.ApplicationException;
import org.json.JSONObject;

public class MenuApplication {
    public static void main(String[] args) throws Exception {
        try {
            MenuOptions.display();
        } catch (Exception exception) {
            if (exception instanceof ApplicationException) {
                //noinspection CallToPrintStackTrace
                exception.printStackTrace();
            } else {
                throw exception;
            }
        }
    }
}
