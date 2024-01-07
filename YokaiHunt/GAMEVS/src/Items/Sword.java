package Items;

import Entity.Player;

public class Sword extends Item {
    
    public Sword (){
        super.name = "Sword (increase DMG)";
    }

    public void FC (Player player){
        player.setDmg(player.getDmg() + 1);
    }
}
