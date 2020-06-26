import java.util.*;

class Main {
    public static void main(String[] args){
        //商品リストの表示
        Goods[] list = Goods.values();
        System.out.println("商品リスト");
        for(Goods li:list){
            li.printProduct();
        }

        Shopping shopping = new Shopping();

        // 操作画面作成
        StringBuilder sbMain = new StringBuilder();
        sbMain.append("--------------------------\n");
        sbMain.append("メニュー画面\n");
        sbMain.append("リスト表示：１\n");
        sbMain.append("カートに追加：２\n");
        sbMain.append("カートの中身表示：３\n");
        sbMain.append("商品の削除：４\n");
        sbMain.append("商品の全削除：５\n");
        sbMain.append("決済：６\n");
        sbMain.append("終了：７\n");
        sbMain.append("--------------------------\n");
        sbMain.append("番号を入力してください：");

        //入力するメソッド
        Scanner sc1 = new Scanner(System.in);
        int cmd, id, num;
        while(true){
            //メニュー画面出力
            System.out.print(sbMain.toString());
            //例外処理
            try{
                cmd = sc1.nextInt();
                switch(cmd){
                    case 1:
                        System.out.println("商品リスト");
                        for(Goods li:list){
                            li.printProduct();
                        }
                        break;
                    case 2:
                        // カート追加メニュー出力
                        System.out.print("商品ID: ");
                        id = sc1.nextInt();
                        System.out.print("個数: ");
                        num = sc1.nextInt();
                        shopping.addCart(id,num);

                        break;
                    case 3:
                        shopping.showCart();
                        break;
                    case 4:
                        System.out.print("商品ID: ");
                        id = sc1.nextInt();
                        shopping.removeCart(id);

                        break;
                    case 5:
                        shopping.clearCart();
                        System.out.println("全削除されました。");
                        break;
                    case 6:
                        int price = shopping.totalPrice();
                        shopping.showReceipt();
                        System.out.println("お会計は"+price+"円です。\n");

                        shopping.clearCart();
                        System.out.println("【デモ用】カートを初期化します\n");
                        break;
                    case 7:
                        System.out.println("終了します。");
                        return;
                    default:
                        System.out.println(cmd+":対応してません。");

                }
            }
            catch(InputMismatchException e){
                System.out.println("数字を入力してください");
                sc1.next();
                continue;

            }

        }
    }
}