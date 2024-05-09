# Airline-collections

Crea un proyecto maven y configura Lombok. 

## Modelo

Crea la siguiente estructura de clases para gestionar un aerolínea:
- Nombre de la aerolínea 
- Vuelos indexados por número de vuelo. Por cada vuelo:
  - flightNumber (entero)
  - origin 
  - destination 
  - flightDate 
  - Pasajeros ordenados por número de asiento. Por cada pasajero:
    - nif 
    - seatNumber 
    - luggages: listado de equipaje del pasajero. Por cada equipaje:
      - id 
      - description 
- Listado de clientes. Por cada cliente:
  - nif 
  - name 
  - surname

### Comparators

Crea dos Comparator<Passenger>:
- Ordena por nif 
- Ordena por seatNumber

## Métodos

Implementa los siguientes métodos en Airline:
- Dado un número de vuelo, devuelve los pasajeros del vuelo. 
- Dado un número de vuelo, devuelve los clientes que son pasajeros en el vuelo. 
- Dado unos apellidos (String), devuelve la lista de clientes que tengan ese apellido. 
- Dado un número de vuelo y un nif, devuelve el asiento del pasajero. Si no existe el vuelo o el pasajero, devuelve null. 
- Dado un número de vuelo, un nif y un luggage, añade el luggage a ese pasajero. En caso de que no exista el vuelo o el pasajero, muestra en pantalla un mensaje de error explicativo. 
- Dado un nif, devuelve los vuelos en los que ese cliente es pasajero.