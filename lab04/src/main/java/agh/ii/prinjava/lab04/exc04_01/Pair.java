package agh.ii.prinjava.lab04.exc04_01;

public class Pair<F,S> implements Cloneable {
    private F fst;
    private S snd;

    public Pair(F fst, S snd){
        this.fst = fst;
        this.snd = snd;
    }

    public void setFst(F fst) {
        this.fst = fst;
    }

    public void setSnd(S snd) {
        this.snd = snd;
    }

    public F getFst(){
        return fst;
    }

    public S getSnd(){
        return snd;
    }

    @Override
    public String toString(){
        return "fst : " + fst + "snd : " + snd;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // même référence
        if (obj == null || getClass() != obj.getClass()) return false;

        Pair<?, ?> other = (Pair<?, ?>) obj;

        return java.util.Objects.equals(fst, other.fst) &&
                java.util.Objects.equals(snd, other.snd);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fst, snd);
    }

    @Override
    public Pair<F, S> clone() {
        try {
            return (Pair<F, S>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // ne devrait jamais arriver
        }
    }

}
