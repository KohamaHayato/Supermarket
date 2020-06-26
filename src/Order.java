public class Order{
    private Goods good;
    private int numOfGood;
    private int discount;

    Order(Goods good, int numOfGood){
        this.good = good;
        this.numOfGood = numOfGood;
        this.discount = 0;
    }

    //税抜き合計
    public int getTotalAmount(){
        return good.getPrice() * numOfGood;
    }

    //税込価格合計
    public int getTotalTaxAmount(){
        return good.getTaxIncludedPrice(numOfGood);
    }

    //割引込み
    public int getDiscountedTotalTaxAmount(){
        if(checkGoodsType(3)){
            return (int)((getTotalAmount() - discount));
        }

        return (int)((getTotalAmount() - discount) * Shopping.tax);
    }

    //リンゴ判定
    public boolean checkGoods(int id){
        return id == good.getProductId();
    }

    //type判定
    public boolean checkGoodsType(int id){
        return id == good.getTypeId();
    }

    public void setDiscount(int discount){
        if(discount > this.discount){
            this.discount = discount;
        }
    }

    //NumOfGoodが増えた時に更新
    public void sumNumOfGoods(int numOfGood){
        this.numOfGood += numOfGood;
    }


    //ゲッター
    public int getDiscount(){
        return discount;
    }

    public int getNumOfGood(){
        return numOfGood;
    }

    public int getGoodsPrice(){
        return good.getPrice();
    }

    public int getProductId(){
        return good.getProductId();
    }

    public String getProductName(){
        return good.getProductName();
    }

    public void showOrder(){
        System.out.println("商品名：" + good.getProductName() + "　個数：" + numOfGood);
    }

    public void showReceipt(){
        //最終的な買い物の金額を表示
        System.out.println("商品名：" + good.getProductName() + "　個数：" + numOfGood+"  値引額："+discount);
    }
}