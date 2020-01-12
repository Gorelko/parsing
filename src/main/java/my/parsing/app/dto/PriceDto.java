package my.parsing.app.dto;

import java.io.Serializable;

public class PriceDto implements Serializable {

    private String brend;
    private String article_brend1;
    private String brend2;
    private String article_brend2;
    private String description_art;
    private String count_dirty;
    private String price_dirty;
    private String stock;
    private String date_swap;
    private String idCross;

    public PriceDto(String brend, String article_brend1, String brend2, String article_brend2, String description_art, String count_dirty, String price_dirty, String stock, String date_swap, String idCross) {
        this.brend = brend;
        this.article_brend1 = article_brend1;
        this.brend2 = brend2;
        this.article_brend2 = article_brend2;
        this.description_art = description_art;
        this.count_dirty = count_dirty;
        this.price_dirty = price_dirty;
        this.stock = stock;
        this.date_swap = date_swap;
        this.idCross = idCross;
    }


    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getArticle_brend1() {
        return article_brend1;
    }

    public void setArticle_brend1(String article_brend1) {
        this.article_brend1 = article_brend1;
    }

    public String getBrend2() {
        return brend2;
    }

    public void setBrend2(String brend2) {
        this.brend2 = brend2;
    }

    public String getArticle_brend2() {
        return article_brend2;
    }

    public void setArticle_brend2(String article_brend2) {
        this.article_brend2 = article_brend2;
    }

    public String getDescription_art() {
        return description_art;
    }

    public void setDescription_art(String description_art) {
        this.description_art = description_art;
    }

    public String getCount_dirty() {
        return count_dirty;
    }

    public void setCount_dirty(String count_dirty) {
        this.count_dirty = count_dirty;
    }

    public String getPrice_dirty() {
        return price_dirty;
    }

    public void setPrice_dirty(String price_dirty) {
        this.price_dirty = price_dirty;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDate_swap() {
        return date_swap;
    }

    public void setDate_swap(String date_swap) {
        this.date_swap = date_swap;
    }

    public String getIdCross() {
        return idCross;
    }

    public void setIdCross(String idCross) {
        this.idCross = idCross;
    }
}
