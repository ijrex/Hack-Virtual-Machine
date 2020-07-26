package commandlib.command.memorylocation;

public enum MemoryLocation {
  CONSTANT(null), LOCAL("R1"), ARGUMENT("R2"), THIS("R3"), THAT("R4"), TEMP("R5"), NULL(null);

  private final String value;

  private MemoryLocation(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static MemoryLocation getType(String str) {

    for (MemoryLocation location : MemoryLocation.values()) {
      if (location.name().equalsIgnoreCase(str))
        return location;
    }
    return MemoryLocation.NULL;
  }

  public static String getValueFromType(String line) {

    String arg = line.replace("@", "");

    MemoryLocation location = MemoryLocation.getType(arg);

    switch (location) {
      case LOCAL:
        return "@" + MemoryLocation.LOCAL.getValue();
      case ARGUMENT:
        return "@" + MemoryLocation.ARGUMENT.getValue();
      case THIS:
        return "@" + MemoryLocation.THIS.getValue();
      case THAT:
        return "@" + MemoryLocation.THAT.getValue();
      case TEMP:
        return "@" + MemoryLocation.TEMP.getValue();
      default:
        return line;
    }
  }
}