package dev.zevolution.springdistributedjobjobrunr.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "dev.zevolution")
public class HexagonalTest {

    @ArchTest
    public static final ArchRule layersValidator = Architectures.layeredArchitecture()
            .layer("Internal").definedBy("..internal..")
            .layer("Adapter").definedBy("..adapter..")
            .layer("Entities").definedBy("..internal.entities..")
            .layer("Interactors").definedBy("..internal.interactors..")
            .layer("Repositories").definedBy("..internal.repositories..")
            .layer("Datasources").definedBy("..adapter.datasources..")
            .layer("TransportLayers").definedBy("..adapter.transportlayers..")
            .layer("Configs").definedBy("..bootstrap..")
            .layer("Exceptions").definedBy("..bootstrap.exceptions..")

            .whereLayer("Interactors").mayOnlyBeAccessedByLayers("TransportLayers", "Configs")
            .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Interactors", "Datasources", "Configs")
            .whereLayer("Datasources").mayOnlyBeAccessedByLayers("Configs")
            .whereLayer("TransportLayers").mayOnlyBeAccessedByLayers("Configs")
            .whereLayer("Exceptions").mayOnlyBeAccessedByLayers("Internal", "Adapter", "Configs");

    @ArchTest
    public static final ArchRule noConfigUsesValidator = ArchRuleDefinition.classes()
            .that().resideInAnyPackage("..internal..", "..adapter..")
            .should().onlyDependOnClassesThat()
            .resideOutsideOfPackage("..bootstrap");

}
