import java.util.Scanner;

public class Mage extends Spellcaster
{
    public Mage(String name)
    {
        super(name,5,60);

        this.typeCombattant = "mage";
    }

    protected void attack(Combattant ennemie)
    {
        if (this.getMana()>0)
        {
            ennemie.setPv(ennemie.getPv()-getDegatDeBase());
            this.setMana(this.getMana()-1);
            System.out.println("Vous avez infligé " + getDegatDeBase() + " dégats à" + ennemie + "il vous reste " + this.getMana() + " fluid oz de mana" );
        }
        else
        {
            System.out.println(" ! vous n'avez plus assez de mana !");
        }

    }

    public String afficher()
    {
        return this.getName() + "(" + this.getTypeCombattant() + "," + this.getPv() + " PV, " + this.getMana() + " fluid oz de mana)";
    }

    @Override
    protected void defend() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous :\n1.Manger\n2.Prendre une potion");
        int choix = 0;
        while (!(choix == 1 || choix == 2))
            choix = scanner.nextInt();
            switch (choix) {
                case 1: {
                    if (this.getNourriture().quantite > 0)
                        this.getNourriture().manger(this);
                    break;
                }

                case 2: {
                    if (this.potion.quantite > 0)
                        this.potion.utilisePotion(this);
                    break;
                }

            }
    }
}
