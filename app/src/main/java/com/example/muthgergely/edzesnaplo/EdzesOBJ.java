package com.example.muthgergely.edzesnaplo;
/**
 * Created by muthgergely on 2017. 02. 25.
 * Edzés objektum, ami egy edzés napló adatait tartalmazza
 */


public class EdzesOBJ implements java.io.Serializable{
    private String datum="", edzes_tip="", verseny_tip="";
    private String vesszo_szam="0", pontszam="0";
    private double loves_jo=0, loves_elfogadhato=0, loves_rossz=0;
    private String mentalis_feladat="", mentalis_eredmeny="", mentalis_allapot_elotte="", mentalis_allapot_utana="";
    private String fizikalis_allapot_elotte="", fizikalis_allapot_utana="", cel="", elertem="";
    private String jegyzetek="", eszrevetel="", feladat="", edzoi_komment="";

    // csak egy üres objektum allokálása
    public EdzesOBJ()
    {
        new EdzesOBJ(datum, edzes_tip, verseny_tip, vesszo_szam, pontszam, loves_jo, loves_elfogadhato, loves_rossz,mentalis_feladat,mentalis_eredmeny, mentalis_allapot_elotte, mentalis_allapot_utana,fizikalis_allapot_elotte, fizikalis_allapot_utana, cel, elertem, jegyzetek, eszrevetel, feladat, edzoi_komment);
    }
    // cobjektum létrehozása meglévő adatokból
    public EdzesOBJ(String datum, String edzes_tip, String verseny_tip, String vesszo_szam, String pontszam, double loves_jo, double loves_elfogadhato, double loves_rossz,String mentalis_feladat,String mentalis_eredmeny, String mentalis_allapot_elotte, String mentalis_allapot_utana,String fizikalis_allapot_elotte, String fizikalis_allapot_utana, String cel, String elertem, String jegyzetek, String eszrevetel, String feladat, String edzoi_komment)
    {
        this.datum = datum;
        this.edzes_tip=edzes_tip;
        this.verseny_tip=verseny_tip;
        this.vesszo_szam=vesszo_szam;
        this.pontszam=pontszam;
        this.loves_jo=loves_jo;
        this.loves_elfogadhato=loves_elfogadhato;
        this.loves_rossz=loves_rossz;
        this.mentalis_feladat=mentalis_feladat;
        this.mentalis_eredmeny=mentalis_eredmeny;
        this.mentalis_allapot_elotte=mentalis_allapot_elotte;
        this.mentalis_allapot_utana=mentalis_allapot_utana;
        this.fizikalis_allapot_elotte=fizikalis_allapot_elotte;
        this.fizikalis_allapot_utana=fizikalis_allapot_utana;
        this.cel=cel;
        this.elertem=elertem;
        this.jegyzetek=jegyzetek;
        this.eszrevetel=eszrevetel;
        this.feladat=feladat;
        this.edzoi_komment=edzoi_komment;
    }

    // edzésnapló elemeinek beállítása, olvasási függvényei
    public String getdatum() {
        return datum;
    }
    public void setdatum(String datum) {
        this.datum = datum;
    }

    public String getedzes_tip() {
        return edzes_tip;
    }
    public void setedzes_tip(String edzes_tip) {
        this.edzes_tip = edzes_tip;
    }

    public String getverseny_tip() {
        return verseny_tip;
    }
    public void setverseny_tip(String verseny_tip) {
        this.verseny_tip = verseny_tip;
    }

    public String getvesszo_szam() {
        return vesszo_szam;
    }
    public void setvesszo_szam(String vesszo_szam) {
        this.vesszo_szam = vesszo_szam;
    }

    public String getpontszam() {
        return pontszam;
    }
    public void setpontszam(String pontszam) {
        this.pontszam = pontszam;
    }

    public double getloves_jo() {
        return loves_jo;
    }
    public void setloves_jo(double loves_jo) {
        this.loves_jo = loves_jo;
    }

    public double getloves_elfogadhato() {
        return loves_elfogadhato;
    }
    public void setloves_elfogadhato(double loves_elfogadhato) {
        this.loves_elfogadhato = loves_elfogadhato;
    }

    public double getloves_rossz() {
        return loves_rossz;
    }
    public void setloves_rossz(double loves_rossz) {
        this.loves_rossz = loves_rossz;
    }

    public String getmentalis_feladat() {
        return mentalis_feladat;
    }
    public void setmentalis_feladat(String mentalis_feladat) {
        this.mentalis_feladat = mentalis_feladat;
    }

    public String getmentalis_eredmeny() {
        return mentalis_eredmeny;
    }
    public void setmentalis_eredmeny(String mentalis_eredmeny) {
        this.mentalis_eredmeny = mentalis_eredmeny;
    }

    public String getmentalis_allapot_elotte() {
        return mentalis_allapot_elotte;
    }
    public void setmentalis_allapot_elotte(String mentalis_allapot_elotte) {
        this.mentalis_allapot_elotte = mentalis_allapot_elotte;
    }

    public String getmentalis_allapot_utana() {
        return mentalis_allapot_utana;
    }
    public void setmentalis_allapot_utana(String mentalis_allapot_utana) {
        this.mentalis_allapot_utana = mentalis_allapot_utana;
    }

    public String getfizikalis_allapot_elotte() {
        return fizikalis_allapot_elotte;
    }
    public void setfizikalis_allapot_elotte(String fizikalis_allapot_elotte) {
        this.fizikalis_allapot_elotte = fizikalis_allapot_elotte;
    }

    public String getfizikalis_allapot_utana() {
        return fizikalis_allapot_utana;
    }
    public void setfizikalis_allapot_utana(String fizikalis_allapot_utana) {
        this.fizikalis_allapot_utana = fizikalis_allapot_utana;
    }

    public String getcel() {
        return cel;
    }
    public void setcel(String cel) {
        this.cel = cel;
    }

    public String getelertem() {
        return elertem;
    }
    public void setelertem(String elertem) {
        this.elertem = elertem;
    }

    public String getjegyzetek() {
        return jegyzetek;
    }
    public void setjegyzetek(String jegyzetek) {
        this.jegyzetek = jegyzetek;
    }

    public String geteszrevetel() {
        return eszrevetel;
    }
    public void seteszrevetel(String eszrevetel) {
        this.eszrevetel = eszrevetel;
    }

    public String getfeladat() {
        return feladat;
    }
    public void setfeladat(String feladat) {
        this.feladat = feladat;
    }

    public String getedzoi_komment() {
        return edzoi_komment;
    }
    public void setedzoi_komment(String edzoi_komment) {
        this.edzoi_komment = edzoi_komment;
    }
}
