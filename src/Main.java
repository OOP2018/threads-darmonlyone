public class Main
{
    public static void main(String[] args) {
//        Counter acc = new Counter();
//        acc.add(50);
//        acc.add(-15);
//        System.out.println(acc.get());
//        acc.add(-34);
//        System.out.println(acc.get());

        double[] f = {0.015249, 0.016571, 0.017230, 0.014691 };
        double a = 0;
        for (double fs: f){

            a += fs;System.out.println(a);
        }
        System.out.println(a/4);
    }
}
