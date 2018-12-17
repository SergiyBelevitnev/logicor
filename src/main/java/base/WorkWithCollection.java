package base;

import java.util.List;

public class WorkWithCollection {

    int countFrance=0;
    int countPoland=0;
    int countSpain=0;
    int countUK=0;
    int countItaly=0;
    int countFinland=0;
    int countHungary=0;
    int countRomania=0;
    int countGermany=0;
    int countPortugal=0;
    int countCzechRepublic = 0;

    public WorkWithCollection(List<Items> itemlist) {
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
                case "France": if (itemlist.get(i).isdisplayed)
                    countFrance++;
                    break;
                case "Poland":
                    countPoland++;
                    break;
                case "Spain":
                    countSpain++;
                    break;
                case "UK":
                    countUK++;
                    break;
                case "Italy":
                    countItaly++;
                    break;
                case "Finland":
                    countFinland++;
                    break;
                case "Hungary":
                    countHungary++;
                    break;
                case "Romania":
                    countRomania++;
                    break;
                case "Germany":
                    countGermany++;
                    break;
                case "Portugal":
                    countPortugal++;
                    break;
                case "Czech Republic":
                    countCzechRepublic++;
                    break;

            }

        }
        System.out.println("ldkrhjlrsjgt;s;tkw;tkw;jktwj    " + countFrance);
        System.out.println("gjdkljg;dsrkgt;ler   " + countPoland);
        System.out.println("gjdkljg;dsrkgt;ler   " + countSpain);
        System.out.println("gjdkljg;dsrkgt;ler   " + countUK);
        System.out.println("gjdkljg;dsrkgt;ler   " + countItaly);

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

    public int getCountGermany() {
        return countGermany;
    }

    public int getCountPortugal() {
        return countPortugal;
    }

    public int getCountCzechRepublic() {
        return countCzechRepublic;
    }
}

