package GemspriceCalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceCalculatorTest {

    private static final double GEM_MAX_PRICE = 8000;
    private static final double GEM_MIN_PRICE = 7600;

    public static void main(String[] args) {
        // Create resources
        Resource resource1 = new Resource("Resource1", "Description1", 5000, ResourceType.TYPE1);
        Resource resource2 = new Resource("Resource2", "Description2", 6000, ResourceType.TYPE2);

        // Create gems
        Gem gem = new Gem("Gem1", "Special Gem", GEM_MIN_PRICE, ResourceType.TYPE3);
        Gem gem2 = new Gem("Gem2", "Special Gem 2", GEM_MAX_PRICE, ResourceType.TYPE1);

        // Generate VirtualGems
        VirtualGem[] vGemGeneration1 = PriceCalculator.generateVirtualGems(resource1, gem);
        VirtualGem[] vGemGeneration2 = PriceCalculator.generateVirtualGems(resource2, gem2);

        // add the generated gems to a list
        List<VirtualGem> virtualGems = new ArrayList<>();

        for (int i = 0; i < vGemGeneration1.length; i++) {
            virtualGems.add(vGemGeneration1[i]);
            virtualGems.add(vGemGeneration2[i]);
        }

        // Sort the list of resources by PvP in ascending order
         Collections.sort(virtualGems, Comparator.comparingDouble(VirtualGem::getCost));

        // Print the sorted VirtualGems
        System.out.println("-------------------------------------------------");
        System.out.println("Table of Resources with Gem (sorted by PvP):");
        System.out.println("-------------------------------------------------");

        for (VirtualGem virtualGem : virtualGems) {
            System.out.println(virtualGem.toString());
        }
    }
}
