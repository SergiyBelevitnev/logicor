package base;

public class EnumsClass {
    public enum UrlUrl {
        PROD("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com"),
        ADMIN("https://www.guru99.com/parameterization-using-xml-and-dataproviders-selenium.html");
        private String _urlUrl;
        private UrlUrl(String urlUrl) {
            _urlUrl = urlUrl;
        }
        public String getValue() {
            return _urlUrl;
        }

    }
}
