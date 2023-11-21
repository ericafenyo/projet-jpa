package fr.diginamic.annotation;

import java.util.Objects;

public final class AnnotatedClassInfo {
    private final Class<?> interfaceType;
    private final Class<?> implementationClass;

    public AnnotatedClassInfo(Class<?> interfaceType, Class<?> implementationClass) {
        this.interfaceType = interfaceType;
        this.implementationClass = implementationClass;
    }

    public Class<?> interfaceType() { return interfaceType; }

    public Class<?> implementationClass() { return implementationClass; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AnnotatedClassInfo) obj;
        return Objects.equals(this.interfaceType, that.interfaceType) &&
                Objects.equals(this.implementationClass, that.implementationClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interfaceType, implementationClass);
    }

    @Override
    public String toString() {
        return "AnnotatedClassInfo[" +
                "interfaceType=" + interfaceType + ", " +
                "implementationClass=" + implementationClass + ']';
    }
}
