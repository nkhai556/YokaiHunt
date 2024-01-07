package Map;


import java.util.*;

import Game.EnemyManager;
import Gamestates.Shop;


public class GameMap {
    static Random R = new Random();
    private HashMap<MapNodes,ArrayList<MapPaths>> map;
    private MapNodes current;
    private EnemyManager EM;
    private Shop shop;

public GameMap (EnemyManager EM, Shop shop){
    map = new HashMap<>();
    this.EM = EM;
    this.shop = shop;
    generate();
    current = getStartNode();
    
}

private void generate (){
    int code = 66;
    MapNodes a = new FightNode((char) 65, NodeType.START,EM);
    MapNodes k = new BossNode((char) 75, NodeType.BOSS, EM);
    map.putIfAbsent(a,new ArrayList<MapPaths>());
    map.putIfAbsent(k,new ArrayList<MapPaths>());
    for (int i = 0; i < 9; i++){
        map.putIfAbsent(randomNode((char) code), new ArrayList<MapPaths>());
        code ++;
    }

    ArrayList <MapNodes> tempList = new ArrayList<>();
    for (Map.Entry<MapNodes,ArrayList<MapPaths>> entry : this.map.entrySet() ) {
            if (entry.getKey().equals(a) != true && entry.getKey().equals(k) != true){
                tempList.add(entry.getKey());
            }
        }
        int up = 6;
        int low = 3;
        for (int n = 0; n < tempList.size()-3; n++){
            int noEdge = R.nextInt(4-1)+1;            
            ArrayList<Integer> picked = new ArrayList<Integer>();
            while (noEdge > 0){
                int eNode = R.nextInt(up-low)+low;
                boolean flag = true;
                for (int m = 0; m < picked.size(); m++){
                    if (eNode == picked.get(m)){
                        flag = false;
                        break;
                    }
                }
                if (flag != false){
                this.map.get(tempList.get(n)).add(new MapPaths (tempList.get(n),tempList.get(eNode)));
                picked.add(eNode);
                noEdge--;
                }
            }
            picked.clear();
            if (n == 2){
                up = 9;
                low = 6;
            }
        }
    for (int i = 0; i < 6; i ++){
        if (i >= 3){
            map.get(tempList.get(i+3)).add(new MapPaths(tempList.get(i+3), k));
        }
        else map.get(a).add(new MapPaths(a, tempList.get(i)));
    }


    for (Map.Entry<MapNodes, ArrayList<MapPaths>> entry : this.map.entrySet() ) {
            System.out.print (entry.getKey().getLabel() + ": ");
            for(int n = 0; n < entry.getValue().size(); n++){
                System.out.print("> " + entry.getValue().get(n).end.getLabel() + " ");
            }
            System.out.println("");
        }


}

private MapNodes randomNode (char label) {
    NodeType type = randomNodeType();
    switch (type){
        case BATTLE:
            return new FightNode (label,type,EM);
        case BOSS:
            
        case EVENT:
            break;
        case SHOP:
            return new ShopNode(label,type,shop);
        case START:
            break;
        default:
            
            break;
    }
    return new MapNodes(label, type);
}

private static NodeType randomNodeType() {
    NodeType[] type = NodeType.values();
    for (int i = 0; i < type.length; i++){
        if (type[i] == NodeType.BOSS || type[i] == NodeType.START){
            type[i] = NodeType.BATTLE;
        }
        if (type[i] == NodeType.EVENT){
            type[i] = NodeType.SHOP;
        }
    }
    return type[R.nextInt(type.length)];
}

private MapNodes getStartNode  (){
    MapNodes temp = null;
    for (MapNodes key : map.keySet()){
        if (key.getType() == NodeType.START){
            temp = key;
        }
    }
    return temp;
}

public MapNodes getCurrentNode (){
    return current;
}
public void setCurrentNode(MapNodes node){
    current = node;
}

public ArrayList<MapPaths> getPathList (MapNodes node){
    return map.get(node);
}

public void mapReset (){
    map.clear();
    generate();
    current = getStartNode();
    current.function();
}
}