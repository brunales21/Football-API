# API Documentation - PlayerController

## Endpoints

### 1. Obtener todos los jugadores

- **URL:** `/players`
- **Método HTTP:** `GET`
- **Descripción:** Obtiene una lista de todos los jugadores disponibles en el sistema.
- **Parámetros:**
  - Ninguno.
- **Códigos de estado HTTP:**
  - `200 OK` - Solicitud exitosa. Devuelve la lista de jugadores.
- **Respuesta:**
  - **Cuerpo de la respuesta:** Un array de objetos `PlayerData` que contiene la información de todos los jugadores.

```json
[
    {
        "id": 1,
        "name": "Player 1",
        "position": "Forward",
        "team": "Team A"
    },
    {
        "id": 2,
        "name": "Player 2",
        "position": "Midfielder",
        "team": "Team B"
    }
]


### 2. Obtener un jugador por ID

- **URL:** `/players/{id}`
- **Método HTTP:** `GET`
- **Descripción:** Obtiene los detalles de un jugador específico basado en su ID.
- **Parámetros:**
  - **Path Variable:**
    - `id` (Long) - El ID del jugador que se desea obtener.
- **Códigos de estado HTTP:**
  - `200 OK` - Solicitud exitosa. Devuelve los detalles del jugador.
  - `404 Not Found` - No se encontró un jugador con el ID proporcionado.
- **Respuesta:**
  - **Cuerpo de la respuesta:** Un objeto `PlayerData` que contiene la información del jugador.

```json
{
    "id": 1,
    "name": "Player 1",
    "position": "Forward",
    "team": "Team A"
}


### 3. Crear un nuevo jugador

- **URL:** `/players`
- **Método HTTP:** `POST`
- **Descripción:** Crea un nuevo jugador en el sistema.
- **Parámetros:**
  - **Cuerpo de la solicitud:**
    - Un objeto `PlayerData` con la información del nuevo jugador. Los campos pueden incluir:
      - `name` (String) - Nombre del jugador.
      - `position` (String) - Posición en la que juega el jugador.
      - `team` (String) - Nombre del equipo al que pertenece el jugador.
- **Códigos de estado HTTP:**
  - `200 OK` - Solicitud exitosa. Devuelve los detalles del jugador creado.
- **Respuesta:**
  - **Cuerpo de la respuesta:** Un objeto `PlayerData` que contiene la información del jugador creado.

```json
{
    "id": 3,
    "name": "Player 3",
    "position": "Defender",
    "team": "Team C"
}


### 4. Actualizar un jugador existente

- **URL:** `/players/{id}`
- **Método HTTP:** `PUT`
- **Descripción:** Actualiza la información de un jugador existente en el sistema.
- **Parámetros:**
  - **URL Path:**
    - `id` (Long) - El ID del jugador que se va a actualizar.
  - **Cuerpo de la solicitud:**
    - Un objeto `PlayerData` con los campos que se desean actualizar. Los campos pueden incluir:
      - `name` (String) - Nombre del jugador.
      - `position` (String) - Posición en la que juega el jugador.
      - `team` (String) - Nombre del equipo al que pertenece el jugador.
- **Códigos de estado HTTP:**
  - `200 OK` - Solicitud exitosa. Devuelve los detalles del jugador actualizado.
  - `404 Not Found` - No se encontró un jugador con el ID especificado.
- **Respuesta:**
  - **Cuerpo de la respuesta:** Un objeto `PlayerData` que contiene la información actualizada del jugador.

```json
{
    "id": 2,
    "name": "Updated Player",
    "position": "Midfielder",
    "team": "Updated Team"
}


### 5. Eliminar un jugador

- **URL:** `/players/{id}`
- **Método HTTP:** `DELETE`
- **Descripción:** Elimina un jugador del sistema utilizando su ID.
- **Parámetros:**
  - **URL Path:**
    - `id` (Long) - El ID del jugador que se desea eliminar.
- **Códigos de estado HTTP:**
  - `204 No Content` - Solicitud exitosa. El jugador ha sido eliminado.
  - `404 Not Found` - No se encontró un jugador con el ID especificado.
- **Respuesta:**
  - **Cuerpo de la respuesta:** Ninguno (sin contenido). La solicitud se considera exitosa si el estado es `204 No Content`.

```json
// No hay cuerpo de respuesta
