package com.iss.po;


public class Books {

    private String bid;
    private String bname;
    private String author;
    private double price;
    private double currPrice;
    private double discount;
    private String press;
    private String publishtime;
    private long edition;
    private long pageNum;
    private long wordNum;
    private String printtime;
    private long booksize;
    private String paper;
    private String cid;
    private String imageW;
    private String imageB;
    private long orderBy;


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }


    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(double currPrice) {
        this.currPrice = currPrice;
    }


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }


    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }


    public long getEdition() {
        return edition;
    }

    public void setEdition(long edition) {
        this.edition = edition;
    }


    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }


    public long getWordNum() {
        return wordNum;
    }

    public void setWordNum(long wordNum) {
        this.wordNum = wordNum;
    }


    public String getPrinttime() {
        return printtime;
    }

    public void setPrinttime(String printtime) {
        this.printtime = printtime;
    }


    public long getBooksize() {
        return booksize;
    }

    public void setBooksize(long booksize) {
        this.booksize = booksize;
    }


    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }


    public String getImageW() {
        return imageW;
    }

    public void setImageW(String imageW) {
        this.imageW = imageW;
    }


    public String getImageB() {
        return imageB;
    }

    public void setImageB(String imageB) {
        this.imageB = imageB;
    }


    public long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(long orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", currPrice=" + currPrice +
                ", discount=" + discount +
                ", press='" + press + '\'' +
                ", publishtime='" + publishtime + '\'' +
                ", edition=" + edition +
                ", pageNum=" + pageNum +
                ", wordNum=" + wordNum +
                ", printtime='" + printtime + '\'' +
                ", booksize=" + booksize +
                ", paper='" + paper + '\'' +
                ", cid='" + cid + '\'' +
                ", imageW='" + imageW + '\'' +
                ", imageB='" + imageB + '\'' +
                ", orderBy=" + orderBy +
                '}';
    }
}
