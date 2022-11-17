package hu.petrik.bankiszolgatatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlaLista = new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        if (hitelKeret == 0){
            MegtakaritasiSzamla msz = new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(msz);
            return msz;
        }else{
            HitelSzamla hsz = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(hsz);
            return hsz;
        }
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos){
        int counter = 0;
        for (Szamla sz : szamlaLista){
            if (sz.getTulajdonos() == tulajdonos){
                counter += sz.getAktualisEgyenleg();
            }
        }
        return counter;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){

        int index = 0;
        int max = 0;

        for(int i = 0; i < szamlaLista.size(); i++){
            if (szamlaLista.get(i).aktualisEgyenleg > max){
                max = szamlaLista.get(i).aktualisEgyenleg;
                index = i;
            }
        }
        return szamlaLista.get(index);

    }

    public long getOsszhitelkeret(){
        int osszeg = 0;
        for (Szamla szamla : szamlaLista){
            if (szamla instanceof HitelSzamla){
                osszeg += ((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return osszeg;
    }

}
