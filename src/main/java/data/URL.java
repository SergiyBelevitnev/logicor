package data;

import static base.BaseTest.getEnvironment;

public enum URL {

    ADMIN("3-8-87-222"),
    CLIENT("35-178-97-148");

    private String address;

    URL(String address) {
        switch (getEnvironment()) {
            case "PROD": {
                this.address = "http://eb2-" + address+".eu-west-2.compute.amazonaws.com";
                break;
            }
            case "PROD_2": {
                this.address = "https://" + address+".eu-west-2.compute.amazonaws.com";
                break;
            }
            case "TEST": {
                this.address = "http://ec2-" +address+ ".eu-west-2.compute.amazonaws.com";
                break;
            }
        }
    }

    public String toString() {
        return address;
    }
}
