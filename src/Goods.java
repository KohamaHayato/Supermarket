public enum Goods{
    //商品リスト
    Goods0(0,"",0,null){
        @Override
        public void printProduct(){}
    },
    Goods1(1,"リンゴ",100,GoodsType.fruit),
    Goods2(2,"みかん",40,GoodsType.fruit),
    Goods3(3,"ぶどう",150,GoodsType.fruit),
    Goods4(4,"のり弁",350,GoodsType.bento),
    Goods5(5,"しゃけ弁",400,GoodsType.bento),
    Goods6(6,"タバコ",420,GoodsType.cigarette){
        @Override
        public int getTaxIncludedPrice(int numOfGood){
            return getPrice() * numOfGood;
        }
    }
    ,
    Goods7(7,"メンソールタバコ",440,GoodsType.cigarette){
        @Override
        public int getTaxIncludedPrice(int numOfGood){
            return getPrice() * numOfGood;
        }
    },
    Goods8(8,"ライター",100,GoodsType.lighter),
    Goods9(9,"お茶",80,GoodsType.drink),
    Goods10(10,"コーヒー",100,GoodsType.drink);

    //フィールド名宣言
    private int productId;
    private String productName;
    private int price;
    private GoodsType type;

    //コンストラクタ
    Goods(int productId, String productName, int price,GoodsType type){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.type = type;
    }

    public void printProduct(){
        System.out.println("No." + productId + "　商品名：" + productName + " 値段：" + price + "円");
    }

    //ゲッターの宣言
    public int getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public int getPrice(){
        return price;
    }
    public int getTypeId(){
        return type.getId();
    }

    public int getTaxIncludedPrice(int numOfGood){
        return (int)(price * Shopping.tax * numOfGood);
    }
}