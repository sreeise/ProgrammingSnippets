package designpatterns.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class BuilderPattern {

  public enum Engine { V4, V6, V8 }
  private final Set<Engine> engines;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Engine> engines = EnumSet.noneOf(Engine.class);

    public T addEngine(Engine engine) {
      engines.add(Objects.requireNonNull(engine));
      return self();
    }

    abstract BuilderPattern build();

    protected abstract T self();
  }

  BuilderPattern(Builder<?> builder) {
    engines = builder.engines.clone();
  }
}