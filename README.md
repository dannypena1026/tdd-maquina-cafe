# Máquina de Café — TDD y GitHub Actions

Proyecto académico basado en la práctica de **Test Driven Development (TDD)** de una máquina dispensadora de café.

**Estudiante:** Danny Peña Adames  
**Matrícula:** 2025-1124

## Descripción

La máquina permite preparar café en tres presentaciones:

| Tamaño | Cantidad de café |
|---|---:|
| Pequeño | 3 oz |
| Mediano | 5 oz |
| Grande | 7 oz |

El usuario puede seleccionar la cantidad de vasos y las cucharadas de azúcar por vaso. Antes de preparar el café se verifica la disponibilidad de vasos, café y azúcar. Si falta algún insumo, el sistema devuelve un mensaje y evita descontar los demás recursos.

## Tecnologías

- Java 17
- Maven
- JUnit 4
- Git y GitHub
- GitHub Actions

## Estructura

- `src/main/java/com/itla/maquinacafe/`: clases `Vaso`, `Cafetera`, `Azucarero`, `MaquinaDeCafe` y aplicación de consola `Main`.
- `src/test/java/com/itla/maquinacafe/`: pruebas unitarias y de funcionamiento.
- `.github/workflows/ci-pipeline.yml`: compilación y pruebas automáticas.

## Compilar y ejecutar las pruebas

```bash
mvn clean verify
```

## Ejecutar la máquina de café

```bash
mvn package
java -jar target/tdd-maquina-cafe-1.0.0.jar
```

## Flujo de CI/CD

El workflow **CI Pipeline** se ejecuta automáticamente al hacer `push` o crear/actualizar un `pull request`.

1. Clona el repositorio.
2. Prepara Java 17.
3. Compila y ejecuta las pruebas con Maven.
4. Cuando se hace `push` a `main` y las pruebas pasan, empaqueta el programa y publica el archivo JAR como artefacto descargable del workflow.

La última fase es una **entrega automatizada del artefacto**, no un despliegue a un servidor de producción.

## Ramas de desarrollo

- `main`: versión estable.
- `develop`: integración de cambios.
- `feature/nueva-funcionalidad`: cambios desarrollados mediante pull request.

## Resultado esperado

En la pestaña **Actions** de GitHub debe aparecer una ejecución de **CI Pipeline** en verde, con los trabajos `Compilar y ejecutar pruebas TDD` y, para cambios integrados a `main`, `Generar artefacto de entrega`.
Integracion continua con GitHub Actions
