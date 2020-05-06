package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TV tv1 = new TV();
        TV tv2 = new TV();

        tv1.setTurnedOn(true);

        System.out.println(tv1.isTurnedOn());
        System.out.println(tv2.isTurnedOn());

        tv1.setCurrentChannel(10);
        tv1.incrementCurrentChannel();

        System.out.println("Current Channel " + tv1.getCurrentChannel());
        System.out.println("Previous Channel " + tv1.getPreviousChannel());

        tv1.swapLastChannels();
        System.out.println("Current Channel after swap " + tv1.getCurrentChannel());
        System.out.println("Previous Channel after swap " + tv1.getPreviousChannel());

        tv2.setTurnedOn(true);

        int i = tv2.getSoundVolume();

        while(i <= 50) {
            System.out.println("Current sound volume " + tv2.getSoundVolume());
            tv2.incrementSoundVolume();
            i++;
        }

        System.out.println("Volumne for TV1 " + tv1.getSoundVolume());
        System.out.println("Volumne for TV2 " + tv2.getSoundVolume());



    }
};


