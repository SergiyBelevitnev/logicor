package base;

public class EnquiryData  {

    private final String FirstName;
    private final String LastName;
    private final String Email;
    private final String PhoneNumber;
    private final String Message;


    public static class Builder {

        private  String FirstName;
        private  String LastName;
        private  String Email;
        private  String PhoneNumber;
        private  String Message;

        public Builder(String FirstName,
                String LastName,
                String Email,
                String PhoneNumber,
                String Message){
            this.FirstName=FirstName;
            this.LastName=LastName;
            this.Email=Email;
            this.PhoneNumber=PhoneNumber;
            this.Message=Message;
        }

        public EnquiryData build(){ return new EnquiryData(this);}
        }
        private EnquiryData(Builder builder){
        FirstName=builder.FirstName;
        LastName=builder.LastName;
        Email=builder.Email;
        PhoneNumber=builder.PhoneNumber;
        Message=builder.Message;
        }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getMessage() {
        return Message;
    }
}
