public class Food extends Consumable
{
    int vieRendue=30;
    public Food(int quantite, String nomDeLitem)
    {
        super(quantite, 1,nomDeLitem);
    }

    public boolean manger(Hero hero)
    {
        boolean flag = false;
        if(hero.getPv()<100) {
            hero.setPv(hero.getPv() + vieRendue);
            this.quantite=this.quantite-1;
            flag = true;
            if(hero.getPv()>100)
                hero.setPv(100);
        }
        else System.out.println(hero.getName() + " a déjà toute sa vie...");
        return flag;
    }

    public void augEff() {
        vieRendue=vieRendue+20;
        System.out.println("La nourriture vous ajoute 20 pV de plus !");
    }
}
