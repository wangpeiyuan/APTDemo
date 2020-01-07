package com.wangpeiyuan.viewbinding_compiler;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by wangpeiyuan on 2020-01-07.
 */
public class AnnotatedClass {
    private TypeElement mClassElement;
    private Elements mElementUtils;
    private List<BindViewField> mFields;

    public AnnotatedClass(TypeElement classElement, Elements elementUtils) {
        mClassElement = classElement;
        mElementUtils = elementUtils;
        mFields = new ArrayList<>();
    }

    public String getFullClassName() {
        return mClassElement.getQualifiedName().toString();
    }

    public void addField(BindViewField bindViewField) {
        mFields.add(bindViewField);
    }

    public JavaFile generateFinder() {
        // method inject(final T host, Object source, Provider provider)
        MethodSpec.Builder injectMethodBuilder = MethodSpec.methodBuilder("inject")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mClassElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "source")
                .addParameter(TypeUtil.PROVIDER, "provider");

        // find views
        for (BindViewField field : mFields) {
            injectMethodBuilder.addStatement("host.$N = ($T)(provider.findView(source,$L))", field.getFieldName(),
                    ClassName.get(field.getFieldType()), field.getResId());
        }

        // generate whole class
        TypeSpec viewInjectorClass = TypeSpec.classBuilder(mClassElement.getSimpleName() + "_ViewBinding")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.VIEW_INJECTOR, TypeName.get(mClassElement.asType())))
                .addMethod(injectMethodBuilder.build())
                .build();

        String packageName = mElementUtils.getPackageOf(mClassElement).getQualifiedName().toString();

        return JavaFile.builder(packageName, viewInjectorClass).build();
    }
}
