package com.qfedu.rain.pojo;

public class Info {
    private Long id;
    private String area;
    private String maxrainfall;
    private  String minrainfall;
    private String raintime;
    private Long sid;

    private Station station;


    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", maxrainfall='" + maxrainfall + '\'' +
                ", minrainfall='" + minrainfall + '\'' +
                ", raintime='" + raintime + '\'' +
                ", sid=" + sid +
                ", station=" + station +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Info setId(Long id) {
        this.id = id;
        return this;
    }

    public String getArea() {
        return area;
    }

    public Info setArea(String area) {
        this.area = area;
        return this;
    }

    public String getMaxrainfall() {
        return maxrainfall;
    }

    public Info setMaxrainfall(String maxrainfall) {
        this.maxrainfall = maxrainfall;
        return this;
    }

    public String getMinrainfall() {
        return minrainfall;
    }

    public Info setMinrainfall(String minrainfall) {
        this.minrainfall = minrainfall;
        return this;
    }

    public String getRaintime() {
        return raintime;
    }

    public Info setRaintime(String raintime) {
        this.raintime = raintime;
        return this;
    }

    public Long getSid() {
        return sid;
    }

    public Info setSid(Long sid) {
        this.sid = sid;
        return this;
    }

    public Station getStation() {
        return station;
    }

    public Info setStation(Station station) {
        this.station = station;
        return this;
    }
}
