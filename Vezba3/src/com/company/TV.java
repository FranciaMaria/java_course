package com.company;

public class TV {

    private boolean turnedOn;
    private int currentChannel = 1;
    private int previousChannel = 1;
    private int soundVolume = 10;

    public boolean isTurnedOn() {
        return this.turnedOn;
    }

    public void setTurnedOn(boolean turnedOn){
        this.turnedOn = turnedOn;
    }

    public int getCurrentChannel() {
        if (!this.turnedOn) {
            return this.currentChannel = 0;
        } else {
            return this.currentChannel;
        }
    }

    public void setCurrentChannel(int currentChannel) {
        if (this.turnedOn) {
            this.currentChannel = currentChannel;
        }
    }

    public int getPreviousChannel() {
        return this.previousChannel;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void incrementSoundVolume() {

        if (this.turnedOn) {
            if (this.soundVolume < 50) {
                this.soundVolume++;
            } else {
                System.out.println("Sound volume is at max");
            }
        }
    }

    public void decrementSoundVolume() {

        if (this.turnedOn) {
            if (this.soundVolume > 0) {
                this.soundVolume--;
            } else {
                System.out.println("Sound volume is at min");
            }
        }
    }

    public void incrementCurrentChannel() {

        this.previousChannel = this.currentChannel;

        if (this.turnedOn) {
            if (this.currentChannel < 100) {
                this.currentChannel++;
            } else {
                // this.currentChannel = 100;
                System.out.println("Current channel volume is at max");
            }
        }
    }

    public void decrementCurrentChannel() {

        this.previousChannel = this.currentChannel;

        if (this.turnedOn) {

            if (this.currentChannel > 1) {
                this.currentChannel--;
            } else {
                // this.currentChannel = currentChannel;
                System.out.println("Current channel volume is at min");
            }
        }

    }

    public void swapLastChannels() {

        int channelSwapper = this.currentChannel;
        this.currentChannel = this.previousChannel;
        this.previousChannel = channelSwapper;

    }
}
