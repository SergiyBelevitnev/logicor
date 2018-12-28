package data;

import base.Reporter;

import java.util.List;

public class WorkWithCollectionAdminProp {

    int countFrance=0;
    int countPoland=0;
    int countSpain=0;
    int countUK=0;
    int countItaly=0;

    public int getCountSmallUK() {
        return countSmallUK;
    }

    public Integer getCountSmallFrance() {
        return countSmallFrance;
    }

    public int getCountSmallGermany() {
        return countSmallGermany;
    }

    public int getCountSmallItaly() {
        return countSmallItaly;
    }

    public int getCountSmallPoland() {
        return countSmallPoland;
    }

    public int getCountSmallSpain() {
        return countSmallSpain;
    }

    public int getCountSmallNederlands() {
        return countSmallNederlands;
    }

    int countFinland=0;
    int countHungary=0;
    int countRomania=0;
    int countGermany=0;
    int countPortugal=0;
    int countCzechRepublic = 0;

    int countSmallUK=0;
    int countSmallFrance=0;
    int countSmallGermany=0;
    int countSmallItaly=0;
    int countSmallPoland=0;
    int countSmallSpain=0;
    int countSmallNederlands=0;



    public WorkWithCollectionAdminProp(List<Items> itemlist) {
        this.countSmallUK=countSmallUK;
        this.countSmallFrance=countSmallFrance;
        this.countSmallGermany=countSmallGermany;
        this.countSmallItaly=countSmallItaly;
        this.countSmallPoland=countSmallPoland;
        this.countSmallSpain=countSmallSpain;
        this.countSmallNederlands=countSmallNederlands;




        this.countFrance = countFrance;
        this.countPoland = countPoland;
        this.countSpain = countSpain;
        this.countUK = countUK;
        this.countItaly = countItaly;
        this.countFinland = countFinland;
        this.countHungary = countHungary;
        this.countRomania = countRomania;
        this.countGermany = countGermany;
        this.countPortugal = countPortugal;
        this.countCzechRepublic = countCzechRepublic;

        for (int i = 1; i < itemlist.size(); i++) {
            String s = itemlist.get(i).getCountry();
            switch (s) {
                case "France": if (itemlist.get(i).isdisplayed=true){
                     if ((itemlist.get(i).space>500)){
                    countFrance++;}
                else {countSmallFrance++;}}
                    break;
                case "Poland":if (itemlist.get(i).isdisplayed=true){
                    if ((itemlist.get(i).space>500)){
                    countPoland++;}
                    else {countSmallPoland++;}}
                    break;
                case "Spain":if (itemlist.get(i).isdisplayed=true){
                    if ((itemlist.get(i).space>500)){
                    countSpain++;}
                    else {countSmallSpain++;}}
                    break;
                case "UK":if (itemlist.get(i).isdisplayed=true){
                    if ((itemlist.get(i).space>500)){
                    countUK++;}
                    else {countSmallUK++;}}
                    break;
                case "Italy":if (itemlist.get(i).isdisplayed=true){
                    if ((itemlist.get(i).space>500)){
                    countItaly++;}
                    else {countSmallItaly++;}}
                    break;
                case "Finland":if (itemlist.get(i).isdisplayed=true){
                    countFinland++;}
                    break;
                case "Hungary":if (itemlist.get(i).isdisplayed=true){
                    countHungary++;}
                    break;
                case "Romania":if (itemlist.get(i).isdisplayed=true){
                    countRomania++;
                   }
                    break;
                case "Germany":if (itemlist.get(i).isdisplayed=true){
                    if ((itemlist.get(i).space>500)){
                    countGermany++;}
                    else {countSmallGermany++;}}
                    break;
                case "Portugal":if (itemlist.get(i).isdisplayed=true){
                    countPortugal++;}
                   break;
                case "Czech Republic":if (itemlist.get(i).isdisplayed=true){
                    countCzechRepublic++;}
                    break;

            }

        }
        Reporter.log("Large assets in France " + countFrance);
        Reporter.log("Large assets in Poland " + countPoland);
        Reporter.log("Large assets in Spain " + countSpain);
        Reporter.log("Large assets in UK " + countUK);
        Reporter.log("Large assets in Italy "+ countItaly);
        Reporter.log("Large assets in Germany " + countGermany);
        Reporter.log("Assets in Finland " + countFinland);
        Reporter.log("Assets in Hungary " + countHungary);
        Reporter.log("Assets in Romania " + countRomania);
        Reporter.log("Assets in Portugal " + countPortugal);
        Reporter.log("Assets in Czech Republic " + countCzechRepublic);
        Reporter.log("Small assets in France " + countSmallFrance);
        Reporter.log("Small assets in Poland " + countSmallPoland);
        Reporter.log("Small assets in Spain " + countSmallSpain);
        Reporter.log("Small assets in UK " + countSmallUK);
        Reporter.log("Small assets in Italy "+ countSmallItaly);
        Reporter.log("Small assets in Germany " + countSmallGermany);





    }

    public Integer getCountFrance() {
        return countFrance;
    }

    public Integer getCountPoland() {
        return countPoland;
    }

    public Integer getCountSpain() {
        return countSpain;
    }

    public Integer getCountUK() {
        return countUK;
    }

    public Integer getCountItaly() {
        return countItaly;
    }

    public int getCountFinland() {
        return countFinland;
    }

    public int getCountHungary() {
        return countHungary;
    }

    public int getCountRomania() {
        return countRomania;
    }

    public Integer getCountGermany() {
        return countGermany;
    }

    public int getCountPortugal() {
        return countPortugal;
    }

    public int getCountCzechRepublic() {
        return countCzechRepublic;
    }
}

