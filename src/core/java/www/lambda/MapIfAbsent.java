package core.java.www.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class MapIfAbsent {
    public static void main(String[] args) {


        Map<Long, List<Long>> longListMap = new HashMap<>();
        List<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(1L);
        longs.add(1L);
        longs.add(1L);
        longListMap.put(1L, longs);
        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree(1L, 4L));
        trees.add(new Tree(2L, 5L));
        trees.add(new Tree(3L, 6L));
        trees.add(new Tree(3L, 7L));
        for(Tree i: trees){
            longListMap.computeIfAbsent(i.getId(),aLong -> new ArrayList()).add(i.getPayment());
        }


        System.out.println(longListMap);
    }
}

class Tree{
    long id;
    Long payment;

    public Tree(long id, Long payment) {
        this.id = id;
        this.payment = payment;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}