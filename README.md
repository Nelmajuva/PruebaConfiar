# Prueba Técnica - Juan Camilo López Morales

## Instalación

1. Clona el repositorio:

```bash
$ git clone https://github.com/Nelmajuva/PruebaConfiar
```

2. Limpia el proyecto y luego compila:

```bash
$ ./mvnw clean
$ ./mvnw compile
```

3. Verifique que el archivo `application.properties` contenga las variables correctas para funcionar.

4. Corre la API realizada con SpringBoot.

La API estará disponible en el puerto y dirección IP proporcionada para su funcionamiento.

### EndPoints

```
  # GET Obtener clientes
  http://localhost:8080/Api/Client
```

```
  # POST Crear un nuevo cliente
  http://localhost:8080/Api/Client

  # JSON

  {
  	"identification": "1232343434",
  	"name": "Inversiones Camilo S.A.S."
  }
```

```
  # GET Obtener cuentas
  http://localhost:8080/Api/Account
```

```
  # POST Crear una nueva cuenta
  http://localhost:8080/Api/Account

  # JSON

  {
  	"clientId": "0256df5c-fe05-4c00-9e86-6af74675cee3",
  	"accountNumber": 1,
  	"availableBalance": 0.0
  }
```

```
  # GET Obtener transacciones de las cuentas
  http://localhost:8080/Api/AccountHistoric
```

```
  # POST Crear una nueva transacción para una cuenta
  http://localhost:8080/Api/AccountHistoric

  # JSON

  {
  	"accountId": "693c17f3-1e49-460d-abcc-9aa210a4bb17",
  	"amount": 110.0,
  	"typeHistoric": 0 # 1 es CRÉDITO, 0 es DÉBITO
  }
```

### Notas

¡Muchas gracias por la oportunidad de presentar este proyecto para el puesto en la cooperativa!

Espero que mis conocimientos y forma de trabajar sea de agrado para todos ustedes. :)

Por favor, contactarme al correo "camilopezm24734m@gmail.com" o a mi número de celular "+57 300 5442403" si requieren más
información.
