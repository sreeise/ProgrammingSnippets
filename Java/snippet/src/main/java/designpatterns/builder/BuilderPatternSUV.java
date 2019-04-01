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
  private final Size size;

  private BuilderPatternSUV(Builder builder) {
    super(builder);
    size = builder.size;
  }

  public enum Size {
    MIDSIZE,
    STANDARD,
    FULLSIZE
  }

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
    protected Builder self() {
      return this;
    }
  }
}
