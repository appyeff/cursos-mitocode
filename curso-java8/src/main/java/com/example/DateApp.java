package com.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateApp {

    public void verificar(int version) {
        LocalDate fecha1 = LocalDate.of(1991, 01, 21);
        LocalDate fecha2 = LocalDate.now();
        System.out.println(fecha1.isAfter(fecha2));
        System.out.println(fecha1.isBefore(fecha2));

        LocalTime tiempo1 = LocalTime.of(22, 30, 50);
        LocalTime tiempo2 = LocalTime.now();
        System.out.println(tiempo1.isAfter(tiempo2));
        System.out.println(tiempo1.isBefore(tiempo2));

        LocalDateTime fechaTiempo1 = LocalDateTime.of(1991, 1, 21, 22, 30, 50);
        LocalDateTime fechaTiempo2 = LocalDateTime.now();
        System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
        System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
    }

    public void medirTiempo(int version) throws InterruptedException {
        Instant ini = Instant.now();
        Thread.sleep(1000);
        Instant fin = Instant.now();
        System.out.println(Duration.between(ini, fin).toMillis());
    }

    public void periodoEntreFechas(int version) {
        LocalDate nacimiento = LocalDate.of(1991, 1, 21);
        LocalDate actual = LocalDate.now();

        Period periodo = Period.between(nacimiento, actual);
        System.out.println("Han transcurrido " + periodo.getYears() + " años y " + periodo.getMonths() + " meses y "
                + periodo.getDays() + " dias, desde " + nacimiento + " hasta " + actual);
    }

    public void convertir(int version) throws ParseException {
        if (version == 7) {
            String fecha = "21/01/1991";
            DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaConvertida = formateador.parse(fecha);
            System.out.println(fechaConvertida);

            Date fechaActual = Calendar.getInstance().getTime();
            formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String fechaCadena = formateador.format(fechaActual);
            System.out.println(fechaCadena);
        } else if(version == 8) {
            String fecha = "21/01/1991";
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
            System.out.println(fechaLocal);
            System.out.println(formateador.format(fechaLocal));

            formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
            System.out.println(formateador.format(fechaLocal));
        }
    }

    public static void main(String[] args) {
        DateApp app = new DateApp();
        try{
            // app.verificar(8);
            app.medirTiempo(8);
            app.periodoEntreFechas(8);
            app.convertir(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
