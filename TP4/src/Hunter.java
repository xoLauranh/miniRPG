import java.util.ArrayList;

public class Hunter extends Hero {

    int nombreDeFleche;
    public Hunter(String name)
    {
        super(name,80,new Weapon(1,0,"Arc"),new Armor());
        this.nombreDeFleche = 2;
        this.typeCombattant = "hunter";
    }

    public int getNombreDeFleche() {
        return nombreDeFleche;
    }

    public void attack(Combattant ennemie)
    {
        if (this.getNombreDeFleche()>0)
        {
            ennemie.setPv(ennemie.getPv() - getDegatDeBase());
            this.nombreDeFleche= this.nombreDeFleche - 1;
            System.out.println(this.name + " a infligé " + getDegatDeBase() + " dégats à " + ennemie.getName() + ", il vous reste " + this.getNombreDeFleche() + " flêches ");
        }
        else
        {
            System.out.println(" ! Vous n'avez plus assez de flêches !");
        }
    }

    public String afficher()
    {
        return this.getName() + "(" + this.getTypeCombattant() + "," + this.getPv() + " PV, " + this.nombreDeFleche + " flêche(s))";
    }

    public void ajouterFleche()
    {
        this.nombreDeFleche = this.nombreDeFleche+1;
        System.out.println("1 flêche a été ajoutée à " + this.getName());
    }
    @Override
    public void defend() {
        if (this.getNourriture().quantite > 0)
            this.getNourriture().manger(this);
    }
}
