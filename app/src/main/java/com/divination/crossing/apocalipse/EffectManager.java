package com.divination.crossing.apocalipse;

import java.util.ArrayList;
import java.util.Iterator;

public class EffectManager {

    private ArrayList<Effect> effects;


    public EffectManager(){

        effects = new ArrayList<>();

    }


    // Criar novo efeito

    public void addEffect(
            float x,
            float y,
            int duration,
            String type
    ){

        effects.add(
                new Effect(
                        x,
                        y,
                        duration,
                        type
                )
        );
    }



    // Atualizar efeitos ativos

    public void update(){

        Iterator<Effect> iterator =
                effects.iterator();


        while(iterator.hasNext()){

            Effect effect =
                    iterator.next();


            effect.update();


            if(!effect.isActive()){

                iterator.remove();

            }
        }
    }



    public ArrayList<Effect> getEffects(){

        return effects;

    }



    public void clear(){

        effects.clear();

    }
}
