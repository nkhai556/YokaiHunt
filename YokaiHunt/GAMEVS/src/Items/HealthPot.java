package Items;

import Entity.Player;

public class HealthPot extends Item {
    
    public HealthPot (){
        super.name = "Health Potion";
    }

    public void FX (Player player){
        player.setHP(Player.getHP() + 1);
    }
}
