# Aglomerar

Aplicación de consola en Java (proyecto de estudios, 2011) para **aglomerar**
varios documentos XML en un solo documento y para **visualizar** documentos
XML.

## ¿Qué hace?

Al ejecutar `Aglomerar` se muestra un menú con dos opciones:

1. **Aglomerar documentos xml** — lee todos los archivos `.xml` de la
   carpeta de entrada y los combina en un único documento `aglomerado.xml`
   bajo la etiqueta raíz `<biblio>`. Usa el analizador DOM para importar la
   raíz de cada documento como hija de la nueva raíz.
2. **Visualizar documento xml** — muestra el contenido de un documento XML.

La carpeta de entrada se resuelve en este orden de preferencia:

1. `./archivosXML` (relativa al directorio de trabajo),
2. `classes/archivosXML` (la carpeta de ejemplo versionada en este
   repositorio).

Si no existe ninguna, el programa lo indica en lugar de fallar. El resultado
`aglomerado.xml` se escribe en el directorio de trabajo actual.

## Uso

```bash
cd Aglomerar
javac -d . src/*.java
java Aglomerar
```

Requisitos: JDK (código de Java 6/7, usa APIs DOM estándar).

## Estructura

- `src/Aglomerar.java` — menú principal de consola.
- `src/directorio.java` — lógica de aglomeración (DOM).
- `src/VisualizarLibro.java` — visualización de documentos XML.
- `classes/archivosXML/` — 5 documentos XML de ejemplo
  (`libroUno.xml` … `libroCinco.xml`).
- `Aglomerar.jcp`, `Aglomerar.jcu`, `Aglomerar.jcw` — archivos del proyecto
  original en JCreator.

## Licencia

GPLv3 — ver el archivo [LICENSE](LICENSE).
