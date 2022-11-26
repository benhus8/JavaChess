
public class AttackOnFieldResponse {

    private final Boolean possibility;

    private final int firstParameterAttackingChessman;

    private final int secondParameterAttackingChessman;


    public AttackOnFieldResponse(boolean possibility, int firstParameterAttackingChessman, int secondParameterAttackingChessman) {
        this.possibility = possibility;
        this.firstParameterAttackingChessman = firstParameterAttackingChessman;
        this.secondParameterAttackingChessman = secondParameterAttackingChessman;

    }

    public Boolean getPossibility() {
        return possibility;
    }
    public int getFirstParameterAttackingChessman(){
        return firstParameterAttackingChessman;
    }
    public int getSecondParameterAttackingChessman(){
        return secondParameterAttackingChessman;
    }

}

