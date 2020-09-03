package commandlib.command.memorylocation;

public enum MemoryLocation {
  CONSTANT(null), LOCAL("LCL"), ARGUMENT("ARG"), THIS("THIS"), THAT("THAT"), TEMP("R5"), POINTER(THIS.getValue()),
  STATIC(null), NULL(null);

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

    if (location != MemoryLocation.NULL) {
      return "@" + location.getValue();
    }

    return line;
  }
}