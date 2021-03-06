package by.it.tarasiuk.jd02_03;

class Util {
    private static final int kTime = 100;

    static int rnd(int start, int stop) {
        return start + ((int) (Math.random() * (stop - start + 1)));
    }

    static void sleep(int timeout) {
        try {
            Buyer.sleep(timeout / kTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
