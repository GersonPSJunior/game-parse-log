package br.com.testepratico.enext.parsegame.domain.enums;

public enum TypeDeath {
    MOD_UNKNOWN(0, "MOD_UNKNOWN"),
    MOD_SHOTGUN(1, "MOD_SHOTGUN"),
    MOD_GAUNTLET(2, "MOD_GAUNTLET"),
    MOD_MACHINEGUN(3, "MOD_MACHINEGUN"),
    MOD_GRENADE(4, "MOD_GRENADE"),
    MOD_GRENADE_SPLASH(5, "MOD_GRENADE_SPLASH"),
    MOD_ROCKET(6, "MOD_ROCKET"),
    MOD_ROCKET_SPLASH(7,"MOD_ROCKET_SPLASH"),
    MOD_PLASMA(8,"MOD_PLASMA"),
    MOD_PLASMA_SPLASH(9,"MOD_PLASMA_SPLASH"),
    MOD_RAILGUN(10,"MOD_RAILGUN"),
    MOD_LIGHTNING(11,"MOD_LIGHTNING"),
    MOD_BFG(12,"MOD_BFG"),
    MOD_BFG_SPLASH(13,"MOD_BFG_SPLASH"),
    MOD_WATER(14,"MOD_WATER"),
    MOD_SLIME(15,"MOD_SLIME"),
    MOD_LAVA(16,"MOD_LAVA"),
    MOD_CRUSH(17,"MOD_CRUSH"),
    MOD_TELEFRAG(18,"MOD_TELEFRAG"),
    MOD_FALLING(19, "MOD_FALLING"),
    MOD_SUICIDE(20,"MOD_SUICIDE"),
    MOD_TARGET_LASER(21,"MOD_TARGET_LASER"),
    MOD_TRIGGER_HURT(22, "MOD_TRIGGER_HURT"),
    MISSIONPACK(23,"MISSIONPACK"),
    MOD_NAIL(24,"MOD_NAIL"),
    MOD_CHAINGUN(25,"MOD_CHAINGUN"),
    MOD_PROXIMITY_MINE(26,"MOD_PROXIMITY_MINE"),
    MOD_KAMIKAZE(27,"MOD_KAMIKAZE"),
    MOD_JUICED(28,"MOD_JUICED"),
    MOD_GRAPPLE(29,"MOD_GRAPPLE");

    private int cod;
    private String descricao;

    private TypeDeath(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TypeDeath toEnum(Integer cod) {
        if(cod == null)
            return null;

        for(TypeDeath x : TypeDeath.values()) {
            if(cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Id inválido: "+ cod);
    }
}
