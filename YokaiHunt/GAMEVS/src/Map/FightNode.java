package Map;

import java.util.*;

import Game.EnemyManager;
import Gamestates.Gamestate;

public class FightNode extends MapNodes{
    EnemyManager EM;
    ArrayList<Integer> spawnPlan;
    Random R;


    public FightNode(char label, NodeType type, EnemyManager em) {
        super(label, type);
        this.EM = em;
        this.spawnPlan = new ArrayList<>();
        this.R = new Random();
    }
    @Override
    public void function (){
        planMaking();
        EM.setPlan(spawnPlan);
        if (Gamestate.state != Gamestate.MENU){
            Gamestate.state = Gamestate.PLAYING;
        }
    }
    
    private void planMaking (){
        for(int i = 0; i < 10; i++)
        spawnPlan.add(R.nextInt((4 - 0) + 1) + 0);
    } 
    
}
