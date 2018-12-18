package base;

public class PropertyData {

    private final String AssetName;
    private final String Town;
    private final String AssetDescription;
    private final Integer YearAvailableFrom;
    private final Double HeightMax;
    private final Integer CarParkingSpacesTotal;
    private final Integer LoadingDocksTotal;
    private final Double VacantSpaceSquareFeet;
    private final Double VacantSpaceSquareMetres;
    private final Double TotalSpaceVacantSqft;
    private final Double TotalVacantSquareMetres;
    private final Double OfficeTotalVacantSquareFeet;
    private final Double OfficeTotalVacantSquareMetres;
    private final String Country;
    private final String Longitude;
    private final String Latitude;


    public static class Builder {

        private  String AssetName;
        private  String Town;
        private  String AssetDescription;
        private  Integer YearAvailableFrom;
        private  Double HeightMax;
        private  Integer CarParkingSpacesTotal;
        private Integer LoadingDocksTotal;
        private  Double VacantSpaceSquareFeet;
        private  Double VacantSpaceSquareMetres;
        private  Double TotalSpaceVacantSqft;
        private  Double TotalVacantSquareMetres;
        private  Double OfficeTotalVacantSquareFeet;
        private  Double OfficeTotalVacantSquareMetres;
        private  String Country;
        private  String Longitude;
        private  String Latitude;

        public Builder(String AssetName, String Town, String AssetDescription, Integer YearAvailableFrom, Double HeightMax, Integer CarParkingSpacesTotal, Integer LoadingDocksTotal, Double VacantSpaceSquareFeet, Double VacantSpaceSquareMetres, Double TotalSpaceVacantSqft, Double TotalVacantSquareMetres, Double OfficeTotalVacantSquareFeet, Double OfficeTotalVacantSquareMetres, String Country, String Longitude, String Latitude) {
            this.AssetName = AssetName;
            this.Town = Town;
            this.AssetDescription = AssetDescription;
            this.YearAvailableFrom = YearAvailableFrom;
            this.HeightMax = HeightMax;
            this.CarParkingSpacesTotal = CarParkingSpacesTotal;
            this.LoadingDocksTotal = LoadingDocksTotal;

            this.VacantSpaceSquareFeet = VacantSpaceSquareFeet;
            this.VacantSpaceSquareMetres = VacantSpaceSquareMetres;
            this.TotalSpaceVacantSqft = TotalSpaceVacantSqft;
            this.TotalVacantSquareMetres = TotalVacantSquareMetres;
            this.OfficeTotalVacantSquareFeet = OfficeTotalVacantSquareFeet;
            this.OfficeTotalVacantSquareMetres = OfficeTotalVacantSquareMetres;
            this.Country = Country;
            this.Longitude = Longitude;
            this.Latitude = Latitude;
        }
        public PropertyData build() {return new PropertyData(this);}
    }

    private PropertyData(Builder builder) {
        AssetName = builder.AssetName;
        Town = builder.Town;
        AssetDescription = builder.AssetDescription;
        YearAvailableFrom = builder.YearAvailableFrom;
        HeightMax = builder.HeightMax;
        CarParkingSpacesTotal = builder.CarParkingSpacesTotal;
        LoadingDocksTotal = builder.LoadingDocksTotal;

        VacantSpaceSquareMetres = builder.VacantSpaceSquareMetres;
        VacantSpaceSquareFeet = builder.VacantSpaceSquareFeet;
        TotalSpaceVacantSqft =builder.TotalSpaceVacantSqft;
        TotalVacantSquareMetres=builder.TotalVacantSquareMetres;
        OfficeTotalVacantSquareFeet=builder.OfficeTotalVacantSquareFeet;
        OfficeTotalVacantSquareMetres=builder.OfficeTotalVacantSquareMetres;
        Country=builder.Country;
        Longitude=builder.Longitude;
        Latitude =builder.Latitude;

    }

    public String getAssetName() {
        return AssetName;
    }

    public String getTown() {
        return Town;
    }

    public String getAssetDescription() {
        return AssetDescription;
    }

    public Integer getYearAvailableFrom() {
        return YearAvailableFrom;
    }

    public Double getHeightMax() {
        return HeightMax;
    }

    public Integer getCarPparkingSpacesTotal() {
        return CarParkingSpacesTotal;
    }

    public Integer getLoadingDocksTotal() {
        return LoadingDocksTotal;
    }



    public Double getVacantSpaceSquareFeet() {
        return VacantSpaceSquareFeet;
    }

    public Double getVacantSpaceSquareMetres() {
        return VacantSpaceSquareMetres;
    }

    public Double getTotalSpaceVacantSqft() {
        return TotalSpaceVacantSqft;
    }

    public Double getTotalVacantSquareMetres() {
        return TotalVacantSquareMetres;
    }

    public Double getOfficeTotalVacantSquareFeet() {
        return OfficeTotalVacantSquareFeet;
    }

    public Double getOfficeTotalVacantSquareMetres() {
        return OfficeTotalVacantSquareMetres;
    }

    public String getCountry() {
        return Country;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getLatitude() {
        return Latitude;
    }
}
