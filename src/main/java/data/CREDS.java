package data;

import static base.BaseTest.getEnvironment;

public enum CREDS {KEY("name","pass","name1","pass1");

    private String adminName;
    private String adminPass;
    private String drupalName;
    private String drupalPass;

    CREDS(String adminName, String adminPass, String drupalName, String drupalPass) {

        switch (getEnvironment()) {
            case "PROD": {
                this.adminName = "adminNameProd";
                this.adminPass= "adminPassProd";
                this.drupalName= "drupalNameProd";
                this.drupalPass= "drupalPassProd";
                break;
            }
            case "PROD_2": {
                this.adminName = "adminNameProd-2";
                this.adminPass= "adminPassProd-2";
                this.drupalName= "drupalName-2";
                this.drupalPass= "drupalPassProd-2";
                break;
            }
            case "TEST": {
                this.adminName = "qa@logicor.eu";
                this.adminPass= "vcVC9eVvX3Ebk";
                this.drupalName= "qa@logicor.eu";
                this.drupalPass= "vc<V&C@9eVvX3Ebk";

                break;
            }
        }
    }

    public String ADMINNAME() { return adminName; }

    public String ADMINPASSWORD() {return adminPass;}

    public String DRUPALNAME() {return drupalName;}

    public String DRUPALPASSWORD() {return drupalPass;}
}
