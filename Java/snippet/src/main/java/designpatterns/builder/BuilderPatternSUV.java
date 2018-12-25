package designpatterns.builder;

import java.util.Objects;

/*
Using abstract class BuilderPattern a Ford SUV builder pattern would look like:

    BuilderPatternSUV fordEscape = new BuilderPatternSUV.Builder(Size.MIDSIZE)
          .addEngine(Engine.V6)
          .build();

    BuilderPatternSUV fordExpedition = new BuilderPatternSUV.Builder(Size.FULLSIZE)
          .addEngine(Engine.V8)
          .build();
 */

public class BuilderPatternSUV extends BuilderPattern {
  public enum Size { MIDSIZE, STANDARD, FULLSIZE }
  private final Size size;

  public static class Builder extends BuilderPattern.Builder<Builder> {
    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    public BuilderPatternSUV build() {
      return new BuilderPatternSUV(this);
    }

    @Override
    protected Builder self() { return this; }
  }

  private BuilderPatternSUV(Builder builder) {
    super(builder);
    size = builder.size;
  }
}
