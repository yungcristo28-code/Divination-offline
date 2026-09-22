package com.divination.crossing.apocalipse;

import java.util.ArrayList;
import java.util.Iterator;

public class DamageManager {


    private ArrayList<DamageText> damages;


    public DamageManager(){

        damages = new ArrayList<>();

    }



    public void addDamage(
            float x,
            float y,
            int value
    ){

        damages.add(
                new DamageText(
                        x,
                        y,
                        value
                )
        );

    }



    public void update(){

        Iterator<DamageText> iterator =
                damages.iterator();


        while(iterator.hasNext()){

            DamageText damage =
                    iterator.next();


            damage.update();


            if(!damage.isActive()){

                iterator.remove();

            }

        }

    }



    public ArrayList<DamageText> getDamages(){

        return damages;

    }



    public void clear(){

        damages.clear();

    }

}
