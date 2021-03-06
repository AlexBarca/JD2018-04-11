package by.it.lanevich.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner;
    private Map<String, Double> goods= new HashMap<>();
    private Map<String, Double> goodBasket= new HashMap<>();
    private static Semaphore chooseGoodsBuyers=new Semaphore(20);

    private void goodsPut(){
        goods.put("Продукт1", 7.65);
        goods.put("Продукт2", 6.94);
        goods.put("Продукт3", 5.45);
        goods.put("Продукт4", 4.90);
        goods.put("Продукт5", 3.40);
        goods.put("Продукт6", 2.85);
        goods.put("Продукт7", 1.90);

    }

    Buyer(int number) {

        super("Покупатель №" + number);
        pensioner=(number%4==0);
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goOut();
    }
    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {

        try {
            chooseGoodsBuyers.acquire();
            int timeout = Util.rnd(500, 2000, pensioner ? 1.5 : 1.0);
            Util.sleep(timeout);
            int count= Util.rnd(1,4);
            goodsPut();
            for (int i = 0; i < count; i++) {
                int index= Util.rnd(0,goods.size()-1);
                for (String good:goods.keySet()) {
                    if(index==0) {

                        Double goodPrice=goods.get(good);
                        putGoodsToBacket(good,goodPrice);
                        break;
                    }
                    index--;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            chooseGoodsBuyers.release();
        }
    }
    @Override
    public void goToQueue() {
        BuyerQueue.addToQueue(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200, pensioner ? 1.5 : 1.0);
        Util.sleep(timeout);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket(String good,Double goodPrice) {
        int timeout = Util.rnd(100, 200, pensioner ? 1.5 : 1.0);
        Util.sleep(timeout);
        goodBasket.put(good,goodPrice);
        System.out.println(this+" положил в корзину "+good+", цена "+goodPrice);
    }
    public double totalCheck(){
        double check=0;
        for (double price:goodBasket.values()) {
            check=check+price;
        }
        return check;
    }
}
