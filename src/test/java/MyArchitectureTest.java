import com.sofka.usecase.CreateEmployeeUseCase;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

 class MyArchitectureTest {
    @Test
     void validateUseCaseName() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.sofka");

        ArchRule rule = classes()
                .that().belongToAnyOf(CreateEmployeeUseCase.class)
                        .should().haveNameMatching(".*UseCase");

        rule.check(importedClasses);
    }

    @Test
    void validateUseCaseCall(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.sofka");

        ArchRule rule = classes()
                .that().belongToAnyOf(CreateEmployeeUseCase.class)
                .should().onlyBeAccessed().byAnyPackage("..application..", "..usecase..");

        rule.check(importedClasses);
    }
}
