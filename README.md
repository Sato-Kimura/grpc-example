gatling-maven-plugin-demo
=========================

Simple showcase of a maven project using the gatling-maven-plugin.
* Config IDEA for working with Gatling: install Scala plugin
https://stackoverflow.com/questions/38973049/how-to-install-scala-plugin-for-intellij

* Executing tests using Maven plugin

        mvn gatling:test
    
    (automatically execute all scenarios)

    or

        mvn test -P
        
    (execute profile "all" defined in pom.xml)
