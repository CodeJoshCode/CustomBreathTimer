package com.example.custombreath;

// should this class be immutable? Methinks
public class BreathSequence {

    // times for each breath phase
    private float inhale;
    private float inhale_hold;
    private float exhale;
    private float exhale_hold;

    // we will always need these arguments to form a breath sequence, doesn't need to be altered
    public BreathSequence(float inhale, float inhale_hold, float exhale, float exhale_hold){
        this.inhale = inhale;
        this.inhale_hold = inhale_hold;
        this.exhale = exhale;
        this.exhale_hold = exhale_hold;
    }

    public float getInhale() {
        return inhale;
    }

    public void setInhale(float inhale) {
        this.inhale = inhale;
    }

    public float getInhale_hold() {
        return inhale_hold;
    }

    public void setInhale_hold(float inhale_hold) {
        this.inhale_hold = inhale_hold;
    }

    public float getExhale() {
        return exhale;
    }

    public void setExhale(float exhale) {
        this.exhale = exhale;
    }

    public float getExhale_hold() {
        return exhale_hold;
    }

    public void setExhale_hold(float exhale_hold) {
        this.exhale_hold = exhale_hold;
    }
}
