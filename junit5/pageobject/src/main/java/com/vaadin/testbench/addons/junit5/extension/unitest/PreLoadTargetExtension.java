package com.vaadin.testbench.addons.junit5.extension.unitest;

import static com.vaadin.testbench.addons.junit5.extension.unitest.PageObjectFunctions.PAGE_OBJECT_NAVIGATION_TARGET;
import static com.vaadin.testbench.addons.junit5.extension.unitest.PageObjectFunctions.PAGE_OBJECT_PRELOAD;
import static com.vaadin.testbench.addons.junit5.extensions.ExtensionFunctions.storeMethodPlain;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.vaadin.dependencies.core.logger.HasLogger;

public class PreLoadTargetExtension implements BeforeEachCallback, HasLogger {

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    context.getTestMethod()
           .ifPresent(m -> {
             final WebUnitTest annotation = m.getAnnotation(WebUnitTest.class);
             if (annotation != null) {
               final boolean preLoad = annotation.preLoad();
               storeMethodPlain().apply(context).put(PAGE_OBJECT_PRELOAD , preLoad);
               final String target = annotation.navigateAsString();
               if (target != null && ! target.isEmpty()) {
                 storeMethodPlain().apply(context).put(PAGE_OBJECT_NAVIGATION_TARGET , target);
               }
             }
           });
  }
}