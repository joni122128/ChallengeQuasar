# Challenge MercadoLibre Fuego de Quasar

Han Solo ha sido recientemente nombrado General de la Alianza
Rebelde y busca dar un gran golpe contra el Imperio Galáctico para
reavivar la llama de la resistencia.
El servicio de inteligencia rebelde ha detectado un llamado de auxilio de
una nave portacarga imperial a la deriva en un campo de asteroides. El
manifiesto de la nave es ultra clasificado, pero se rumorea que
transporta raciones y armamento para una legión entera.

Como jefe de comunicaciones rebelde, tu misión es crear un programa en Java que retorne
la fuente y contenido del mensaje de auxilio. Para esto, cuentas con tres satélites que te
permitirán triangular la posición, ¡pero cuidado! el mensaje puede no llegar completo a cada
satélite debido al campo de asteroides frente a la nave.

Posición de los satélites actualmente en servicio:

● Kenobi: [-500, -200]

● Skywalker: [100, -100]

● Sato: [500, 100]

## Prerrequisitos (Local)

- Apache Maven: https://maven.apache.org/download.cgi
- JDK 11: https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html

## Dependencias
- org.springframework.boot
- com.lemmingapex.trilateration

## Nivel 1
- URL : http://cryptic-saga-286422.rj.r.appspot.com/topsecret

- Enviar por método POST el siguiente payload:
```
{
  "satellites":
  [
    {
      "name": "kenobi",
      "distance": 100.0,
      "message": ["este", "", "", "mensaje", "secreto"]
    },
    {
      "name": "skywalker",
      "distance": 115.5,
      "message": ["", "es", "", "", "secreto"]
    },
    {
      "name": "sato",
      "distance": 142.7,
      "message": ["", "es", "un", "", ""]
    }
  ]
}

```

## Nivel 2
- URL: http://cryptic-saga-286422.rj.r.appspot.com/topsecret_split/{satellite_name}
- Método: POST

## Nivel 3
- Método: GET
- URL: http://cryptic-saga-286422.rj.r.appspot.com/topsecret_split

