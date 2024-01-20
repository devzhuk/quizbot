plugins {
    id 'org.jetbrains.kotlin.jvm' version '1.9.22'
    id 'org.liquibase.gradle' version '2.0.1' // Версия плагина Liquibase Gradle
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.jetbrains.kotlin:kotlin-stdlib'
    implementation 'org.postgresql:postgresql:42.7.0'
}

liquibase {
    activities {
        main {
            changeLogFile '/resources/db/migration/initDB.xml' // Путь к вашему Liquibase-скрипту
            url 'jdbc:postgresql://localhost:5432/postgres'
            username ''
            password ''
            driver 'org.postgresql.Driver'
        }
    }
}

// Создайте задачу Gradle для запуска Liquibase
task runLiquibase(type: org.liquibase.gradle.LiquibaseTask) {
    dependsOn assemble
    doLast {
        liquibase {
            activities {
                main {
                    changeLogFile '/resources/db/migration/initDB.xml' // Путь к вашему Liquibase-скрипту
                    url 'jdbc:postgresql://localhost:5432/postgres'
                    username ''
                    password ''
                    driver 'org.postgresql.Driver'
                }
            }
        }.run('update')
    }
}
