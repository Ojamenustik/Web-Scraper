public  class Attack {

    private String year;
    private String monthDay;
    private String type;
    private String dead;
    private String injured;
    private String location;
    private String details;
    private String perpetrator;


    public Attack(String year, String monthDay, String type, String dead, String injured, String location, String details, String perpetrator) {
        this.year = year;
        this.monthDay = monthDay;
        this.type = type;
        this.dead = dead;
        this.injured = injured;
        this.location = location;
        this.details = details;
        this.perpetrator = perpetrator;
    }

    public Attack(String monthDay) {
        this.monthDay = monthDay;
    }


    public String getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(String monthDay) {
        this.monthDay = monthDay;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
