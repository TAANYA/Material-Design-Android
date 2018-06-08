package com.example.tanya.material_design1;

public class Superheroes
{
    private String head;
    private String desc;
    private String url;

    public Superheroes(String head, String desc, String url) {
        this.head = head;
        this.desc = desc;
        this.url = url;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
