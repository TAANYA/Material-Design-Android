package com.example.tanya.material_design1;

public class List_recycler
{
    private String head;
    private String desc;
    private String imgUrl;


    public String getImgUrl() {
        return imgUrl;
    }

    public List_recycler(String head, String desc,String imgUrl)
    {
        this.head = head;
        this.desc = desc;
        this.imgUrl = imgUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
