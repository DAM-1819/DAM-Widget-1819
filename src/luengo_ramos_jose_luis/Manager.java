package luengo_ramos_jose_luis;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Manager {

    String[] day;
    LocalTime nextBoss;


    public Manager() {
        getBossesToday();
    }



    public LocalTime getNextBoss() {
        return nextBoss;
    }


    /**
     * Obtiene la lista de bosses de dia actual
     *
     */

    public void getBossesToday() {
        LocalDate localDate = LocalDate.now();
        switch (localDate.getDayOfWeek()) {
            case MONDAY:
                day = new String[]{"Kutum", "Karanda", "Kzarka", "Kzarka", "Nouver", "Kutum", "Nouver", "Kzarka"};
                break;
            case TUESDAY:
                day = new String[]{"Karanda", "Kutum", "Kzarka", "Kutum", "Offin", "Nouver", "Karanda", "Nouver-Kzarka"};
                break;
            case WEDNESDAY:
                day = new String[]{"Kutum", "Karanda", "Kzarka", "Karanda", "Maintenance", "Kzarka", "Kutum", "Karanda-Kzarka"};
                break;
            case THURSDAY:
                day = new String[]{"Nouver", "Kutum", "Nouver", "Kutum", "Nouver", "Kutum", "Offin", "Karanda"};
                break;
            case FRIDAY:
                day = new String[]{"Kzarka", "Nouver", "Karanda", "Kutum", "Karanda", "Nouver", "Kzarka", "Kutum-Kzarka"};
                break;
            case SATURDAY:
                day = new String[]{"Karanda", "Offin", "Nouver", "Kutum", "Nouver", "Quint-Muraka", "Karanda-Kzarka", "Conquest_War"};
                break;
            case SUNDAY:
                day = new String[]{"Kutum-Nouver", "Kzarka", "Kutum", "Nouver", "Kzarka", "Vell", "Karanda", "Nouver-Kzarka"};
                break;
        }
    }



    /**
     * Obtiene el nombre del boss esta activo.
     *
     * @return
     */

    public String getBossNow() {
        this.nextBoss = LocalTime.now();
        //TODO
        LocalTime localTime = LocalTime.now();
        if (localTime.isAfter(LocalTime.of(0, 15)) && localTime.isBefore(LocalTime.of(1, 59))) {
            this.nextBoss = LocalTime.of(2, 0);
            return day[0];
        } else if (localTime.isAfter(LocalTime.of(2, 0)) && localTime.isBefore(LocalTime.of(4, 59))) {
            this.nextBoss = LocalTime.of(5, 0);
            return day[1];
        } else if (localTime.isAfter(LocalTime.of(5, 0)) && localTime.isBefore(LocalTime.of(8, 59))) {
            this.nextBoss = LocalTime.of(9, 0);
            return day[2];
        } else if (localTime.isAfter(LocalTime.of(9, 0)) && localTime.isBefore(LocalTime.of(11, 59))) {
            this.nextBoss = LocalTime.of(12, 0);
            return day[3];
        } else if (localTime.isAfter(LocalTime.of(12, 0)) && localTime.isBefore(LocalTime.of(15, 59))) {
            this.nextBoss = LocalTime.of(16, 0);
            return day[4];
        } else if (localTime.isAfter(LocalTime.of(16, 0)) && localTime.isBefore(LocalTime.of(18, 59))) {
            this.nextBoss = LocalTime.of(19, 0);
            return day[5];
        } else if (localTime.isAfter(LocalTime.of(19, 0)) && localTime.isBefore(LocalTime.of(22, 14))) {
            this.nextBoss = LocalTime.of(22, 15);
            return day[6];
        } else if (localTime.isAfter(LocalTime.of(22, 15)) || localTime.isBefore(LocalTime.of(0, 14))) {
            this.nextBoss = LocalTime.of(0, 15);

            return day[7];
        }
        //TODO
        return "";
    }

    /**
     * Devuelve el icono correspondiente al bos
     * @return
     */
    public Icon getIconBoss() {
        String name = getBossNow();
        String path = "image/" + name + ".jpg";
        Icon icon = new ImageIcon(path);
        return icon;

    }


}
