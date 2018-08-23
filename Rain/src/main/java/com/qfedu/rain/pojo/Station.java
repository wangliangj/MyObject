package com.qfedu.rain.pojo;

import java.util.List;

public class Station {
    private Long id;
    private String name;

    private List<Info> infos;

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", infos=" + infos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Station setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Station setName(String name) {
        this.name = name;
        return this;
    }

    public List<Info> getInfos() {
        return infos;
    }

    public Station setInfos(List<Info> infos) {
        this.infos = infos;
        return this;
    }
}
