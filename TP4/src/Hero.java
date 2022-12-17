import java.util.ArrayList;
import java.util.List;

abstract public class Hero extends Combattant {

    protected Food nourriture;
    Weapon weapon;
    int degatDeBase;
    int resistance;
    protected List<Consumable> consumables;
    Armor armor;
    protected Hero(String name, int degatDeBase, Weapon weapon, Armor armor){
        super(name);
        this.degatDeBase=degatDeBase;
        this.weapon= weapon;
        this.nourriture = new Food(1,"Mogu mogu");
        this.armor = new Armor();

    }

    public int getDegatDeBase()
    {
        return degatDeBase;
    }

    public abstract String afficher();

    public void setDegatDeBase(int degatDeBase)
    {
        this.degatDeBase=degatDeBase;
    }

    public Food getNourriture()
    {
        return nourriture;
    }

    public void ajouterNourriture()
    {
        this.nourriture.quantite=this.nourriture.quantite+1;
        System.out.println("1 nourriture a été ajouté à " + this.name);
    }


}
