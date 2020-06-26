public class Shopping {

    public static Goods[] goodsList;
    public static final double tax = 1.08;  //消費税
    //private Service service;
    private Cart cart;

    //コンストラクタ
    Shopping(){
        goodsList = Goods.values();
        //service = new Service();
        cart = new Cart();
    }

    public int totalPrice(){
        //int total = 0;
        cart.allDiscount();
        int total = cart.getTotalPrice();
        return total;
    }

    //Cartの追加
    public void addCart(int id, int num){
        if(0<id && id<goodsList.length ){
            if(num >0){
                Order order = new Order(goodsList[id], num);
                cart.addMap(order);
                System.out.println("カートに追加されました。");
            }
            else{
                System.out.println("個数は1以上を指定してください。");
            }
        }
        else{
            System.out.println("該当する商品は存在しません。");
        }
    }

    //Cartの削除
    public void removeCart(int id){
        Order order = cart.removeMap(id);
        if(order != null){
            System.out.println(order.getProductName() + "を削除しました。");
        }
        else{
            System.out.println("削除できませんでした。");
        }
    }

    //Cart全削除

    public void clearCart(){
        cart.clearMap();
    }

    public void showCart(){
        cart.showCart();
    }
    public void showReceipt(){
        cart.showReceipt();
    }

}