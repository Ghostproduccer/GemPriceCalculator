package GemspriceCalculator;

public class PriceCalculator {

    // entiendo que el tax se refiere a que te cobran 20000 cada 120 ventas
    private static final double TAX_PER_SALE = 20000 / 120;

    private static final int RESOURCES_PER_GEM = 10;

    public static VirtualGem[] generateVirtualGems(Resource res, Gem gem) {
        VirtualGem[] virtualGems = new VirtualGem[RESOURCES_PER_GEM];
        double pvp = calculatePvP(res, gem);

        for (int i = 0; i < virtualGems.length; i++) {
            // supongo que el tipo de la virtualGem es igual al de la gema madre
            virtualGems[i] = new VirtualGem("virtualGem" + i + " from " + gem.getName(),
                    "generated from " + res.getName() + " and " + gem.getName(), pvp, gem.getType(), res, gem);
        }
        return virtualGems;
    }

    private static double calculatePvP(Resource res, Gem gem) {
        double pvp = (res.getCost() + gem.getCost()) / RESOURCES_PER_GEM + (RESOURCES_PER_GEM * TAX_PER_SALE);
        return pvp;
    }

}
