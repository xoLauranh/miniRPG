import java.util.ArrayList;

public class Warrior extends Hero {

    public Warrior(String name){
        super(name,60,null,new Armor());
        this.typeCombattant="warrior";
    }

    public void attack(Combattant ennemie)
    {
        ennemie.setPv(ennemie.getPv()-getDegatDeBase());
        System.out.println(this.name + " a infligé " + getDegatDeBase() + " dégats à " + ennemie.getName());
    }

    public String afficher()
    {
        return this.getName() + "(" + this.getTypeCombattant() + "," + this.getPv() + " PV)";
    }
    @Override
    public void defend() {
        if (this.getNourriture().quantite > 0)
            this.getNourriture().manger(this);
    }
}
