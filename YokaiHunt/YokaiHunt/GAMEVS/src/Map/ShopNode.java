package Map;

import java.util.*;

import Gamestates.Gamestate;
import Gamestates.Shop;

public class ShopNode extends MapNodes{

    private ArrayList<Integer> ItemList;
    private Random R;

    private Shop shop;

    public ShopNode(char label, NodeType type, Shop shop) {
        super(label, type);
        this.shop = shop;
        ItemList = new ArrayList<>();
        this.R = new Random();
        
    }

    public void function (){
        generateList();
        shop.setList(ItemList);
        
        Gamestate.state = Gamestate.SHOP;
    }
    
    private void generateList(){
        for (int i = 0; i < 5; i++){
            ItemList.add(R.nextInt(3 - 0)+ 0);
        }
    }
}
