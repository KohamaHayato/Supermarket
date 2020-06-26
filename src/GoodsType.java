public enum GoodsType{
    fruit(0),
    bento(1),
    drink(2),
    cigarette(3),
    lighter(4);

    private int id;
    GoodsType(int id){
        this.id =id;
    }

    //ゲッターの宣言
    public int getId(){
        return id;
    }
}