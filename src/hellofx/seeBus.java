/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class seeBus {
    int fare, seat;
    String service,source,dest, atime, dtime;
    LocalDate date;
    //LocalTime dtime, atime;

    seeBus(int parseInt, String string, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getFare() {
        return fare;
    }

    public int getSeat() {
        return seat;
    }

    public String getService() {
        return service;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getaTime() {
        return atime;
    }
    public String getdTime() {
        return dtime;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setaTime(String atime) {
        this.atime = atime;
    }
    public void setdTime(String dtime) {
        this.dtime = dtime;
    }

    

    public seeBus(int fare, String service, String atime, String dtime) {
        this.fare = fare;
        //this.seat = seat;
        this.service = service;
        //this.source = source;
        //this.dest = dest;
        //this.date = date;
        this.atime = atime;
        this.dtime = dtime;
    }
    
    
}