import java.util.ArrayList;
import java.util.Collections;

public class Basket {
    ArrayList<Integer> books;
    ArrayList<Integer> books2;
    double BOOK_PRICE = 8.0;
    Double[] DISCOUNTS_5 = {0.0, 1.0, 0.95, 0.9, 0.8, 0.75};
    Double[] DISCOUNTS_4 = {0.0, 1.0, 0.95, 0.9, 0.8};


    public Basket(Integer ...i){
        books = new ArrayList<>();
        Collections.addAll(books, i);

        books2 = new ArrayList<>();
        if(i.length == 5){
            books2.add(i[0]);
            books2.add(i[1]);
            books2.add(i[2]);
            books2.add(i[3] + i[4]);
        }else{
            Collections.addAll(books2, i);
        }
    }

    public Double price() {
        return Math.min(priceWithDiscounts(DISCOUNTS_5, books), priceWithDiscounts(DISCOUNTS_4, books2));
    }

    private Double priceWithDiscounts(Double[] discounts, ArrayList<Integer> basket) {
        Double total = 0.0;

        while(count(basket) > 0){
            total += priceOfSet(discounts, basket.size());
            removeSetOfBooks(basket);
            basket = compact(basket);
        }

        return total;
    }

    private ArrayList<Integer> compact(ArrayList<Integer> bs) {
        ArrayList<Integer> ret = new ArrayList<>();
        for(Integer i: bs){
            if(i > 0){
                ret.add(i);
            }
        }

        return ret;
    }

    private void removeSetOfBooks(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > 0){
                list.set(i, list.get(i) - 1);
            }
        }
    }

    private int count(ArrayList<Integer> books) {
        int sum = 0;
        for(int i : books){
            sum += i;
        }
        return sum;
    }

    private Double priceOfSet(Double[] discounts, int size) {
        return size * BOOK_PRICE * discounts[size];
    }
}
