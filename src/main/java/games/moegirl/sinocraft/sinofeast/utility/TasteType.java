package games.moegirl.sinocraft.sinofeast.utility;

public enum TasteType {
    SWEET("sweet", "Sweet", true),   // 甜
    SOUR("sour", "Sour", true),  // 酸
    BITTER("bitter", "Bitter", false),   // 苦
    SALTY("salty", "Salty", false),   // 苦
    SPICY("spicy", "Spicy", true),   // 辣
    PUNGENT("pungent", "Pungent", false),    // 辛
    NUMB("numb", "Numb", true),  // 麻
    GREASY("greasy", "Greasy",false),   // 腻
    USAMI("usami", "Usami", true),  // 鲜
    COOL("cool", "Cool", true),  // 凉
    TART("tart", "Tart", false), // 涩
    HOT("hot", "Hot", false), // 热
    MELLOW("mellow", "Mellow", true), // 醇
    ;

    private final String typeId;
    private final String nameValue;
    private final boolean positive;

    private TasteType(String id, String name, boolean isPositive) {
        typeId = id;
        nameValue = name;
        positive = isPositive;
    }

    public String getId() {
        return typeId;
    }

    public String getName() {
        return nameValue;
    }

    public double getMax() {
        return 10;
    }

    public double getDefault() {
        return 1;
    }

    public boolean isPositive() {
        return positive;
    }
}
