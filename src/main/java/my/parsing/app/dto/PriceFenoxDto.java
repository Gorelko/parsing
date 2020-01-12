package my.parsing.app.dto;

import java.io.Serializable;

public class PriceFenoxDto implements Serializable {

    private String idFenox;
    private String artFenox;
    private String groupFenox;
    private String descriptFenox;
    private String priceFenox;
    private String priceFenoxNew;


    public PriceFenoxDto(String idFenox, String artFenox, String groupFenox, String descriptFenox, String priceFenox, String priceFenoxNew) {
        this.idFenox = idFenox;
        this.artFenox = artFenox;
        this.groupFenox = groupFenox;
        this.descriptFenox = descriptFenox;
        this.priceFenox = priceFenox;
        this.priceFenoxNew = priceFenoxNew;
    }

    public String getIdFenox() {
        return idFenox;
    }

    public void setIdFenox(String idFenox) {
        this.idFenox = idFenox;
    }

    public String getArtFenox() {
        return artFenox;
    }

    public void setArtFenox(String artFenox) {
        this.artFenox = artFenox;
    }

    public String getGroupFenox() {
        return groupFenox;
    }

    public void setGroupFenox(String groupFenox) {
        this.groupFenox = groupFenox;
    }

    public String getDescriptFenox() {
        return descriptFenox;
    }

    public void setDescriptFenox(String descriptFenox) {
        this.descriptFenox = descriptFenox;
    }

    public String getPriceFenox() {
        return priceFenox;
    }

    public void setPriceFenox(String priceFenox) {
        this.priceFenox = priceFenox;
    }

    public String getPriceFenoxNew() {
        return priceFenoxNew;
    }

    public void setPriceFenoxNew(String priceFenoxNew) {
        this.priceFenoxNew = priceFenoxNew;
    }
}
