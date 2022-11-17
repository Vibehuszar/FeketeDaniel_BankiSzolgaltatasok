package hu.petrik.bankiszolgatatasok;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank();
        Tulajdonos t = new Tulajdonos("Gáspár Laci");
        System.out.printf("Számla tulajdonosának neve: %s\n", t.getNev());
        MegtakaritasiSzamla msz = new MegtakaritasiSzamla(t);
        System.out.printf("Számla aktuális egyenlege: %d\n",msz.aktualisEgyenleg);
        msz.befizet(10000);
        System.out.printf("Számla egyenlege befizetés után: %d\n",msz.aktualisEgyenleg);
        msz.kivesz(5000); //ha több a kivett érték akkor nem veszi ki
        System.out.printf("Számla egyenlege kivétel után: %d\n",msz.aktualisEgyenleg);
        HitelSzamla hsz = new HitelSzamla(t,120);
        System.out.printf("Hitelkeret: %d\n", hsz.getHitelKeret());
        hsz.kivesz(30); //ha több a kivett érték akkor nem veszi ki
        System.out.printf("Hitelkeret kivétel után: %d\n", hsz.getHitelKeret());

        Kartya k = new Kartya(t,msz,"12345678");
        System.out.printf("Kártyaszám: %s\n",k.getKartyaSzam());
        k.vasarlas(500); // ha nagyobb a vasarlasi ar mint ami a szamlan van nem engedi
        System.out.printf("Összeg vásárlás után: %d\n",msz.aktualisEgyenleg);

        System.out.printf("Számla egyenlege kamatjüóváírás előtt: %d\n",msz.aktualisEgyenleg);
        msz.kamatJovairas();
        System.out.printf("Számla egyenlege kamatjüóváírás után %d\n",msz.aktualisEgyenleg);
        //System.out.println(b.getLegnagyobbEgyenleguSzamla(t)); // nem jo valamiert


    }
}