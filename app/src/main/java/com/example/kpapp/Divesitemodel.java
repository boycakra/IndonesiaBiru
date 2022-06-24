package com.example.kpapp;

public class Divesitemodel {
    private String labeltempat;
    private String namatempat;
    private String pictempat;
    public String pin;
    public String deskripsi;
    public Double longtitude;
    public Double latitude;

    public Divesitemodel(String labeltempat, String namatempat, String pictempat, String pin,String deskripsi, Double longtitude, Double latitude) {
        this.labeltempat = labeltempat;
        this.namatempat = namatempat;
        this.pictempat = pictempat;
        this.pin = pin;
        this.deskripsi = deskripsi;
        this.longtitude=longtitude;
        this.latitude=latitude;
    }
    public String getLabeltempat() {
        return labeltempat;
    }

    public void setLabeltempat(String labeltempat) {
        this.labeltempat = labeltempat;
    }

    public String getNamatempat() {
        return namatempat;
    }

    public void setNamatempat(String namatempat) {
        this.namatempat = namatempat;
    }

    public String getPictempat() {
        return pictempat;
    }

    public void setPictempat(String pictempat) {
        this.pictempat = pictempat;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public  String getDeskripsi(){ return  deskripsi;}

    public  void setDeskripsi(String deskripsi) {this.deskripsi = deskripsi;}

    public  Double getLongtitude(){return longtitude;}

    public void  setLongtitude(Double longtitude){this.longtitude=longtitude;}

    public  Double getLatitude(){return  latitude;}

    public void  setLatitude(Double latitude){this.latitude=latitude;}

    public Divesitemodel()
    {

    }


}
