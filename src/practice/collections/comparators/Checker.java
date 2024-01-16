package practice.collections.comparators;

import java.util.Comparator;

class Checker implements Comparator<Player> {

    /*
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.score == o2.score)
            return o1.name.compareTo(o2.name);
        else return o1.score < o2.score ? 1 : -1;
    }

     */

    @Override
    public int compare(Player o1, Player o2) {
        return (o1.score == o2.score) ? o1.name.compareTo(o2.name) : (o1.score < o2.score ? 1 : -1);
    }
}
