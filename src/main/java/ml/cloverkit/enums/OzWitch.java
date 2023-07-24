package ml.cloverkit.enums;

public enum OzWitch {
    // 实例必须在方法之前定义
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked With of the East, wearer of the Ruby Slippers, crushed by Drothy's house"),
    SOUTH("Good bny inference, but missing");

    private String description;

    // 构造函数的访问全县必须是包级或 private:
    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
