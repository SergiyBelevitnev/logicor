package base;

public class Items {
    String assetReference;
    String assetName;
    String town;
    String country;
    Boolean isdisplayed;

    public Items(String assetReference, String assetName, String town, String country, Boolean isdisplayed) {
        this.assetReference = assetReference;
        this.assetName = assetName;
        this.town = town;
        this.country = country;
        this.isdisplayed = isdisplayed;
    }

    public String getAssetReference() {
        return assetReference;
    }

    public void setAssetReference(String assetReference) {
        this.assetReference = assetReference;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getIsdisplayed() {
        return isdisplayed;
    }

    public void setIsdisplayed(Boolean isdisplayed) {
        this.isdisplayed = isdisplayed;
    }

    @Override
    public String toString() {
        return "Items{" +
                "assetReference='" + assetReference + '\'' +
                ", assetName='" + assetName + '\'' +
                ", town='" + town + '\'' +
                ", country='" + country + '\'' +
                ", isdisplayed=" + isdisplayed +
                '}';
    }
}
