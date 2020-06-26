import java.util.*;

class Cart{
    //複数のオーダーを持てるようにする
    private Map<Integer,Order> orderList;
    private static final int appleDiscontNum = 3;
    private static final int appleDiscontRatio = 20;
    private static final int tenDiscountNum = 11;
    private static final int lighterDiscountNum = 10;
    private static final int bentoDiscountRatio = 20;

    public Cart(){
        orderList = new HashMap<>();
    }

    //MAPに追加するメソッド
    public void addMap(Order order){
        //orderListにすでに追加されている商品は数だけ増やす
        int id = order.getProductId();
        if(orderList.containsKey(id)){
            orderList.get(id).sumNumOfGoods(order.getNumOfGood());
        }
        else{
            orderList.put(id,order);
        }
    }

    //Mapからorderを削除するメソッド
    public Order removeMap(int id){
        return orderList.remove(id);
    }

    //Mapからorderを全削除するメソッド
    public void clearMap(){
        orderList.clear();
    }

    //Mapの検索
    public Order searchMap(int id){
        return orderList.get(id);
    }

    public void showCart(){

        System.out.println("\n-------カートの中身-------");
        for(Order order:orderList.values()){
            order.showOrder();
        }
        System.out.println("--------------------------");

    }

    public void showReceipt(){
        System.out.println("\n----------領収書----------");
        for(Order order:orderList.values()){
            order.showReceipt();
        }
        System.out.println("--------------------------");
    }
    //金額計算
    public int getTotalPrice(){
        int total = 0;
        for(Order order:orderList.values()){
            total += order.getDiscountedTotalTaxAmount();
        }
        return total;
    }

    public void allDiscount(){
        appleThreeDiscount();
        tenDiscount();
        lighterDiscount();
        drinkSetDiscount();
    }

    //リンゴ割引
    public void appleThreeDiscount(){
        Order order = searchMap(1);
        if(order != null){
            int div = order.getNumOfGood() / appleDiscontNum;
            order.setDiscount(div * appleDiscontRatio);
        }
    }

    //10個買ったら1個おまけ
    public void tenDiscount(){
        for(Order order:orderList.values()){
            int div = order.getNumOfGood() / tenDiscountNum;
            order.setDiscount(div * order.getGoodsPrice());
        }
    }

    public void lighterDiscount(){

        for(Order order:orderList.values()){
            if(order.checkGoodsType(3) && order.getNumOfGood() >= lighterDiscountNum)
            {
                if (searchMap(8) == null){
                    //カートに追加
                    //割引(ライター分priceを引く)
                    Order orderL = new Order(Goods.Goods8,1);
                    orderL.setDiscount(100);
                    orderList.put(8,orderL);
                }
                else{
                    //割引をする(おまけは1個っだけ)
                    searchMap(8).setDiscount(100);
                }

            }
        }
    }

    //弁当類と飲み物(お茶とコーヒー)をいっしょに買うと、20円引きになる。
    //弁当と飲み物が2個ずつだったら40円値引きに
    //弁当と飲みもの1ペアできたら値引き（弁当値引き）
    public void drinkSetDiscount(){
        //飲み物の数を数える
        int count = 0;

        for(Order order:orderList.values()){
            if(order.checkGoodsType(2)){
                count += order.getNumOfGood();
            }
        }
        //割引き
        for(Order order:orderList.values()){
            if(order.checkGoodsType(1)){
                if(count >= order.getNumOfGood()){
                    order.setDiscount(bentoDiscountRatio * order.getNumOfGood());
                    count -= order.getNumOfGood();
                } else{
                    order.setDiscount(bentoDiscountRatio * count);
                    count = 0;
                }
            }
        }
    }

}