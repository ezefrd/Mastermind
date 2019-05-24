package business.pegs;

import java.util.ArrayList;
import java.util.HashMap;

public class PegsFactory {

    HashMap<String, Class> pegsAvailables;

    public PegsFactory(){
        pegsAvailables = new HashMap<String, Class>();
        pegsAvailables.put("red", Red.class);
        pegsAvailables.put("blue", Blue.class);
        pegsAvailables.put("green", Green.class);
        pegsAvailables.put("yellow", Yellow.class);
        pegsAvailables.put("pink", Pink.class);

    }

    public Pegs createPegs(ArrayList<String> codeMakerPegs)
            throws IllegalAccessException, InstantiationException {
        ArrayList<Peg> pegs = new ArrayList<>();

        for(String pegKey : codeMakerPegs){
            pegs.add((Peg) pegsAvailables.getOrDefault(pegKey, UnknownColor.class).newInstance());
        }

        return new Pegs(pegs);
    }
}
