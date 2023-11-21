package fr.diginamic.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("fr.diginamic.annotation.Provides")
public class ProvidesAnnotationProcessor extends AbstractProcessor {
    private final List<AnnotatedClassInfo> annotatedClasses = new ArrayList<>();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println(annotations);
        return false;
    }

    public void generateCode(List<AnnotatedClassInfo> infos) {
        StringBuilder builder = new StringBuilder();

        // Generate package and imports
        builder.append("package your.package.name;\n\n");
        builder.append("import javax.persistence.EntityManager;\n");
        builder.append("import javax.persistence.EntityManagerFactory;\n");
        builder.append("import javax.persistence.Persistence;\n\n");
        builder.append("public class ServiceLoader {\n");

        // Add comments
        builder.append("/**\n");
        builder.append("* Loads an implementation of the specified service interface.\n");
        builder.append("*\n");
        builder.append("@param service The service interface class.\n");
        builder.append("@param <T>     The type of the service interface.\n");
        builder.append("@return An instance implementing the service interface, or null if no implementation is found.\n");
        builder.append("*/\n");

        // Generate load() method
        builder.append("\tpublic static <T> T load(Class<T> service) {\n");
        for (AnnotatedClassInfo info : infos) {
            // Generate other source codes
            return;
        }

        String code = builder.toString();
        System.out.println(code);
    }
}
