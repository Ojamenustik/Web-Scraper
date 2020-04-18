public  class Attack {

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDeadPerpetrator() {
        return deadPerpetrator;
    }

    public String getInjuredPerpetrator() {
        return injuredPerpetrator;
    }

    private String year;
    private String month;
    private String day;
    private String type;
    private String dead;
    private String deadPerpetrator;
    private String injured;
    private String injuredPerpetrator;
    private String country;
    private String city;
    private String details;
    private String perpetrator;


    public Attack(String year, String month, String day, String type, String dead, String deadPerpetrator, String injured, String injuredPerpetrator, String country, String city, String details, String perpetrator) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.type = type;
        this.dead = dead;
        this.deadPerpetrator = deadPerpetrator;
        this.injured = injured;
        this.injuredPerpetrator = injuredPerpetrator;
        this.country= country;
        this.city = city;
        this.details = details;
        this.perpetrator = perpetrator;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getInjured() {
        return injured;
    }

    public void setInjured(String injured) {
        this.injured = injured;
    }

        public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPerpetrator() {
        return perpetrator;
    }

    public void setPerpetrator(String perpetrator) {
        this.perpetrator = perpetrator;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
