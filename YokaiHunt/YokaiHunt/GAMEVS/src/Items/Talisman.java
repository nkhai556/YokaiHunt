package Items;

import Entity.Player;

public class Talisman extends Item{
    
    public Talisman (){
        super.name = "Talisman warding off evil (increase Atk Spd)";
    }
    
    public void FX (Player player){
        player.setCD( player.getCD() - 1);
    }
}
