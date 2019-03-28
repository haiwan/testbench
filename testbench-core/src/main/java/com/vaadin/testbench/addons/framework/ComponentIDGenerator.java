package com.vaadin.testbench.addons.framework;

import static com.vaadin.testbench.addons.framework.GenericIDGenerator.genericID;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 */
public interface ComponentIDGenerator {

  static Function<String, String> caption() {
    return (id) -> id + "." + "caption";
  }

  static Function<String, String> placeholder() {
    return (id) -> id + "." + "placeholder";
  }


  static Function<Class, BiFunction<Class, String, String>> typedComponentIDGenerator() {
    return (clazz) -> (uiClass , label) -> genericID().apply(uiClass , clazz , label);
  }

}