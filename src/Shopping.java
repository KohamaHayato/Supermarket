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

  /*
  //商品番号を複数渡すと、個数1個として金額を合計する関数
  public int OnePrice(int... productId){
    int total = 0;
    for (int i:productId){
      total += goodsList[i].getPrice();
    }

    return total;
  }

  public int  computeTotalPrice(Order... orders){
    int total = 0;
    for (Order order : orders){
      total += order.getTotalAmount();
    }

    return total;
  }

  //消費税込みの合計金額の計算
  public int taxIncludedPrice(Order... orders){
    int total = 0;
    for (Order order : orders){
      total += order.getTotalTaxAmount();
    }
    return total;
  }

  //割引込みで消費税込みの合計金額の計算
  public int discountTaxIncludedPrice(Order... orders){
    int total = 0;
    for (Order order : orders){
      //Service service = new Service(order);
      service.allDiscount(order);
      total += order.getDiscountedTotalTaxAmount();
    }
    return total;
  }
  */

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