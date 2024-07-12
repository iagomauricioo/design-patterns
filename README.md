
# Design Patterns com Java

Readme criado baseado no vídeo "DOMINE DESIGN PATTERNS com JAVA" da criadora de conteúdo Fernanda Kipper.

## Link | 🔗
- [Link do vídeo no youtube (clique aqui)](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)


### Introdução

#### O que são design patterns?

Basicamente são soluções comprovadas para problemas comuns de design de software.

#### Tipos de design pattern:
1. Criacional
2. Estrutural
3. Organizacional

### Builder Pattern

Tipo: criacional

#### Conceito

Facilita a criação de objetos complexos. Você consegue criar várias representações do mesmo tipo de objeto.



## Uso/Exemplos

```java
public class Car {
    private String engine;
    private String wheels;
    private String color;
    private Boolean airConditioner;
    private Boolean eletricWindow;
    private Integer doorQnt;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
    }

    public static class Builder {
        private String engine;
        private String wheels;
        private String color;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(String wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
// Uso do Builder
Car car = new Car.Builder()
    .setEngine("V8")
    .setWheels("18 inch")
    .setColor("Red")
    .build();


// Ou, usando Lombok
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Car {
    private String engine;
    private String wheels;
    private String color;
}
```

