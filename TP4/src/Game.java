import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Game {


    int nbJoueur;
    protected List<Hero> heroList = new ArrayList<>();
    protected List<Enemy> enemyList = new ArrayList<>();

    protected List<Combattant> combattantList = new ArrayList<>();

    int nbCombats;
    int round;
    Combattant Joueur;
    Combattant attaquant;
    // fonction pour choisir son nombre de joueur et le type de combattant

    public Game() {
        this.nbCombats = 5;
    }

    public void playGame() {
        System.out.println("Bienvenue dans Mini RPG Lite 3000, tout au long de cet aventure vous vous batterez contre une horde d'ennemis appelés Channel's minion. Si vous parvenez à vaincre les ennemis durant les 4 premiers round, vous vous combatterez contre le BIG boss final." +
                "Il existe 4 différents types de héros que vous pourrez choisir, à vous de découvrir leurs atouts et leurs points faibles. Bonne chance !");
        choosePlayer();
        createEnemy(nbJoueur);
        selectRandCombattant();
        partie();
    }

    public void choosePlayer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("choisissez un nombre de joueur");

        nbJoueur = scanner.nextInt();
        System.out.println("choisissez vos types de héro");

// là tous les types de joueurs sont normalement ajoutés dans une liste selon le nombre de joueurs selectionnés
        int i = 0;
        while (i < nbJoueur) {

            System.out.println("Selectionnez le type de hero de votre choix entre : healer, hunter, mage, warrior");
            Scanner scanner2 = new Scanner(System.in);
            String typeJoueur = scanner2.nextLine();


            switch (typeJoueur) {

                case "healer":
                    // peut-être choisir le nom etc du joueur;
                    System.out.println("Choisissez un nom pour votre healer :");
                    String healerName = scanner2.nextLine();
                    Healer healer1 = new Healer(healerName);
                    heroList.add(healer1);
                    i++;
                    break;

                case "hunter":
                    System.out.println("Choisissez un nom pour votre hunter :");
                    String hunterName = scanner2.nextLine();
                    Hunter hunter1 = new Hunter(hunterName);
                    heroList.add(hunter1);
                    i++;
                    break;
                case "mage":
                    System.out.println("Choisissez un nom pour votre mage :");
                    String mageName = scanner2.nextLine();
                    Mage mage1 = new Mage(mageName);
                    heroList.add(mage1);
                    i++;
                    break;
                case "warrior":
                    System.out.println("Choisissez un nom pour votre warrior :");
                    String warriorName = scanner2.nextLine();
                    Warrior warrior1 = new Warrior(warriorName);
                    heroList.add(warrior1);
                    i++;
                    break;
                default:
                    System.out.println("\n !!! Choix incorrect !!! \n");
                    break;

            }

        }

        combattantList.addAll(heroList);

        System.out.println("\n Votre armée est constituée de " + nbJoueur + " héros : ");

        for (Hero heros : heroList) {
            System.out.println(heros.getName() + "(" + heros.getTypeCombattant() + ")");
        }

    }

    // create ennemies

    public void createEnemy(int nbjoueur) {


        for (int a = 0; a <= nbjoueur; a++) {

            Enemy enemy = new Enemy();
            enemyList.add(enemy);

        }
        combattantList.addAll(enemyList);
    }


    public void selectRandCombattant() {
        Random rand = new Random();
        int commence = rand.nextInt(2);
        switch (commence)
        {
            case 0 :
            {
                int index = rand.nextInt(enemyList.size());
                Joueur = enemyList.get(index);
                String typeJoueur = Joueur.getName();
                System.out.println("\n \nLe premier à attaquer est " + typeJoueur);
                break;
            }
            case 1 :
            {
                System.out.println("\n \nLe premier à attaquer est un héro");
                Joueur = heroList.get(0);
                break;
            }

        }
    }

    public void partie()
    {
        Enemy enemyf = new Enemy();
        //1 er combat
        combat();
        if (alldead(heroList))
        {
            System.out.println("Fin de la partie");
            return ;
        }

        recompense();

        createEnemy(heroList.size());
        enemyf.augmenterDegat();

        //2 eme combat
        combat();

        if (alldead(heroList))
        {
            System.out.println("Fin de la partie");
            return ;
        }

        recompense();
        enemyf.augmenterPv();
        createEnemy(heroList.size());

        //3 eme combat
        combat();
        if (alldead(heroList))
        {
            System.out.println("Fin de la partie");
            return ;
        }

        recompense();

        createEnemy(heroList.size());
        enemyf.augmenterDegat();

        //4 eme combat
        combat();

        if (alldead(heroList))
        {
            System.out.println("Fin de la partie");
            return ;
        }

        recompense();

        createEnemy(heroList.size());
        enemyf.augmenterDegat();

        //Combat boss
        enemyf.augmenterPv();
        enemyf.augmenterPv();
        enemyf.augmenterPv();
        enemyf.augmenterPv();
        enemyf.augmenterDegat();
        enemyf.augmenterDegat();
        enemyf.augmenterDegat();
        combatboss();
        combat();

        if (alldead(heroList))
        {
            System.out.println("Fin de la partie");
            return ;
        }

        System.out.println("Vous avez vaincu le boss !");


    }

    public boolean alldead(List<Hero> heros)
    {
        boolean flag = true;
        if (heros != null)
        {
            for (int i = 0 ; i< heros.size(); i++)
                if (heros.get(i).getPv()>0)
                    flag = false;

        }
        return flag;
    }

    public void recompense() {
        Enemy enemyf = new Enemy();
        Potion potionf = new Potion();
        Food foodf = new Food(1,"Mogu mogu");
        Healer healerf = new Healer(".");
        System.out.println("Bravo vous avez remporté cette bataille ! Vous pouvez maintenant choisir :" +
                "1 • augmenter les dégâts;\n" +
                "2 • améliorer la resistance aux attaques;\n" +
                "3 • augmenter l’efficacité de la potion et de la nourriture ;\n" +
                "4 • ajouter des potions et de la nourriture ;\n" +
                "5 • ajouter des flèches (pour le Hunter)" +
                "6 • améliorer l’efficacité du soin des healer \n");
        Scanner scanner = new Scanner(System.in);
        int choixRecompense = scanner.nextInt();

        switch (choixRecompense)
        {
            case 1:
            {
                for (Hero heros : heroList)
                {
                    heros.setDegatDeBase(heros.getDegatDeBase()+1);
                }
                break;
            }
            case 2:
            {
                enemyf.augmenterResistance();
                break;
            }

            case 3:
            {
                potionf.augEff();
                foodf.augEff();
                break;
            }

            case 4:
            {
                for (Hero hero:heroList)
                {
                    hero.ajouterNourriture();
                    if (hero instanceof Spellcaster)
                        ((Spellcaster) hero).ajouterPotion();
                }
                break;
            }

            case 5: {
                for (Hero hero : heroList) {
                    if (hero instanceof Hunter)
                        ((Hunter) hero).ajouterFleche();
                }
                break;
            }

            case 6: {
                healerf.ameliorerSoin();
                break;
            }

            default: recompense();


        }
    }
    public void combat()
    {

        while (Joueur.getPv() > 0 || attaquant.getPv() > 0) {
            //attaquant = héro, joueur = ennemie

            if (Joueur.getTypeCombattant() == "enemy")
            {
                // L'ennemie attaque au hasard un hero

                Random rand = new Random();
                int attaqueIndex = rand.nextInt(heroList.size());
                attaquant = heroList.get(attaqueIndex);
                Joueur.attack(attaquant);
                if (Joueur.getPv() <= 0)
                {
                    enemyList.remove(Joueur);
                }
                // pour faire tourner la boucle on met le hero en joueur
                Joueur = attaquant;

            }

            else {
                //on a joueur = hero on veut joueur = ennemie, attaquant = héro

                // choix du hero

                System.out.println("\nQui choisissez-vous pour se battre face à l'ennemie ? \nVotre armée est consituée de : ");
                int d = 0;
                for (Hero heros : heroList) {
                    d++;
                    System.out.println(d + "." + heros.afficher());
                }
                System.out.println("\n tapez le numéro du héro correspondant");
                Scanner scanner3 = new Scanner(System.in);
                int pLH = scanner3.nextInt();

                if( 0<pLH && pLH<=heroList.size())
                {
                    attaquant = heroList.get(pLH - 1);
                    System.out.println(attaquant.getName() + " va attaquer");

                    Random rand = new Random();
                    int enemyIndex = rand.nextInt(enemyList.size());
                    Joueur = enemyList.get(enemyIndex);
                    // méthode choix de l'attaque/défense du hero sur l'ennemie

                    System.out.println("\nVoulez vous : \n1.Attaquer  \n2.Prendre une potion/vous soigner");
                    int attackOuDefense = 0;
                    while (attackOuDefense !=1 || attackOuDefense !=2)
                        attackOuDefense = scanner3.nextInt();
                    switch (attackOuDefense)
                    {
                        case 1 : {
                            System.out.println("\nQui voulez-vous attaquer? \nVoici la liste des ennemis : ");
                            int n = 0;
                            for (Enemy enemy : enemyList) {
                                n++;
                                System.out.println(d + "." + enemy.getName() + "(ennemi, " + enemy.getPv() + "Pv)");
                            }
                            int ennemiChoisi = 0;
                            while (!(ennemiChoisi>0 && ennemiChoisi<=enemyList.size()))
                                ennemiChoisi=scanner3.nextInt();
                            attaquant.attack(enemyList.get(ennemiChoisi-1));
                            break;
                        }
                        case 2 : {
                            attaquant.defend();
                        }
                    }
                }
                else // bug si on tape autre chose qu'un int...
                {

                    System.out.println("\n !!! Votre choix est erroné, veuillez choisir un hero de votre armée !!!\n");
                }

            }





        }


    }
    public void combatboss()
    {
        Enemy boss = new Enemy("Boss");
        enemyList.add(boss);
    }
}








