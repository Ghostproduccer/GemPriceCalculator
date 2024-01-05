package GemspriceCalculator;

class VirtualGem extends Gem {
    private Resource resource;
    private Gem gem;

    public VirtualGem(String name, String description, double cost, ResourceType type, Resource resource, Gem gem) {
        super(name, description, cost, type);
        this.resource = resource;
        this.gem = gem;
    }

    public Resource getResource() {
        return resource;
    }

    public Gem getGem() {
        return gem;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
