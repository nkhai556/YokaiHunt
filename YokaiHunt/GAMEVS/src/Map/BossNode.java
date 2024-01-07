package Map;

import java.util.ArrayList;

import Game.EnemyManager;
import Gamestates.Gamestate;

public class BossNode extends MapNodes{
    

    EnemyManager EM;
    ArrayList<Integer> spawnPlan;


    public BossNode(char label, NodeType type, EnemyManager em) {
        super(label, type);
        this.EM = em;
        this.spawnPlan = new ArrayList<>();
    }
    @Override
    public void function (){
        planMaking();
        EM.setPlan(spawnPlan);
        EM.resetBullet();
        if (Gamestate.state != Gamestate.MENU){
            Gamestate.state = Gamestate.BOSS;
        }
    }
    
    private void planMaking (){
        spawnPlan.add(10);
    } 
}
