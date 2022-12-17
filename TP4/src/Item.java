public abstract class Item {
    String nomDeLitem;
    int quantite;
    int nbrUtilisation;


    public Item(int quantite, int nbrUtilisation, String nomDeLitem)
    {
        this.quantite = quantite;
        this.nbrUtilisation = nbrUtilisation;
        this.nomDeLitem = nomDeLitem;
    }


    public void setNbrUtilisation(int nbrUtilisation) {
        this.nbrUtilisation = nbrUtilisation;
    }

    public int getNbrUtilisation(){return nbrUtilisation;}

    public String getNomDeLitem() {return nomDeLitem;}

    public int getQuantite(){return quantite;}

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setNomDeLitem(String nomDeLitem) {
            this.nomDeLitem = nomDeLitem;
        }
}
